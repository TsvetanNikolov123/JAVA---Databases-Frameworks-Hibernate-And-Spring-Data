package app.tasks;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class P03_GetMinionNames implements Runnable {

    private Connection connection;

    public P03_GetMinionNames(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        int givenVillainId = Integer.parseInt(scanner.nextLine());

        try {
            this.getVillainName(givenVillainId);
            this.getMinionNames(givenVillainId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void getVillainName(int givenVillainId) throws SQLException {
        String query = "SELECT v.name\n" +
                "FROM villains AS v\n" +
                "WHERE v.id = ?;";

        PreparedStatement preparedStatement =
                this.connection.prepareStatement(query);
        preparedStatement.setInt(1, givenVillainId);

        ResultSet resultSet = preparedStatement.executeQuery();

        if (!resultSet.first()) {
            System.out.println("No villain with ID " + givenVillainId + " exists in the database.");
            System.exit(0);
        } else {
            System.out.printf("Villain: %s%n", resultSet.getString("name"));
        }
    }

    private void getMinionNames(int givenVillainId) throws SQLException {
        String query = "SELECT m.name, m.age\n" +
                "FROM minions AS m\n" +
                "       JOIN minions_villains AS mv ON m.id = mv.minion_id\n" +
                "       JOIN villains AS v on mv.villain_id = v.id\n" +
                "WHERE v.id = ?;";

        PreparedStatement preparedStatement =
                this.connection.prepareStatement(query);
        preparedStatement.setInt(1, givenVillainId);

        ResultSet resultSet = preparedStatement.executeQuery();

        for (int i = 1; resultSet.next(); i++) {
            System.out.printf("%d. %s %s%n",
                    i,
                    resultSet.getString("name"),
                    resultSet.getString("age"));
        }
    }
}
