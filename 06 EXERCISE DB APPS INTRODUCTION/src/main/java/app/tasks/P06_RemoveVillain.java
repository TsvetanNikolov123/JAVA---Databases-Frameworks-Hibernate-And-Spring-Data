package app.tasks;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class P06_RemoveVillain implements Runnable {

    private Connection connection;

    public P06_RemoveVillain(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void run() {
        try {
            removeVillain();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void removeVillain() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        int villainId = Integer.parseInt(scanner.nextLine());

        String countMinionsQuery = "SELECT count(*) AS minion_count\n" +
                "FROM minions_villains\n" +
                "WHERE villain_id = ?";

        PreparedStatement preparedStatement = this.connection.prepareStatement(countMinionsQuery);
        preparedStatement.setInt(1, villainId);
        ResultSet resultSet = preparedStatement.executeQuery();

        int minionReleasedCount = 0;

        if (resultSet.next()) {
            minionReleasedCount = resultSet.getInt("minion_count");
        }

        String getVillainNameQuery = "SELECT v.name FROM villains AS v WHERE v.id = ?";

        preparedStatement = this.connection.prepareStatement(getVillainNameQuery);
        preparedStatement.setInt(1, villainId);
        resultSet = preparedStatement.executeQuery();

        String villainName = null;

        if (resultSet.next()) {
            villainName = resultSet.getString(1);
        }

        String deleteFromMapTableQuery = "DELETE FROM minions_villains WHERE villain_id = " + villainId;
        preparedStatement.execute(deleteFromMapTableQuery);

        String deleteFromVillainTable = "DELETE FROM villains WHERE id = " + villainId;
        preparedStatement.execute(deleteFromVillainTable);

        if (villainName == null) {
            System.out.println("No such villain was found");
            return;
        }

        System.out.println(String.format("%s was deleted", villainName));
        System.out.println(minionReleasedCount == 1 ? "1 minion released" :
                String.format("%d minions released", minionReleasedCount));
    }
}
