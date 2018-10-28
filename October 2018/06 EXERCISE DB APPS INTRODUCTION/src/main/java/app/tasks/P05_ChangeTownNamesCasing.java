package app.tasks;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class P05_ChangeTownNamesCasing implements Runnable {

    private Connection connection;

    public P05_ChangeTownNamesCasing(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void run() {
        try {
            townNamesToUppercase();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void townNamesToUppercase() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        String countryName = scanner.nextLine();

        String query = String.format(
                "SELECT name FROM towns WHERE country = '%s'", countryName);
        PreparedStatement statement = this.connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();

        List<String> townNamesToUpper = new LinkedList<String>();

        while (resultSet.next()) {
            String townName = resultSet.getString("name");
            townNamesToUpper.add(townName.toUpperCase());
        }

        updateTownNames(countryName);

        sb.append(townNamesToUpper.isEmpty() ? "No town names were affected." :
                String.format("%d town names were affected.\n%s\n", townNamesToUpper.size(), townNamesToUpper));

        System.out.println(sb.toString());
    }

    private void updateTownNames(String countryName) throws SQLException {
        String query = String.format("UPDATE towns SET name = UPPER(name) WHERE country = '%s'", countryName);
        PreparedStatement preparedStatement = this.connection.prepareStatement(query);
        preparedStatement.execute();
    }
}
