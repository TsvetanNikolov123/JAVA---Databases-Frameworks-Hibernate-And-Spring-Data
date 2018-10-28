package app.tasks;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class P04_AddMinion implements Runnable {

    private Connection connection;

    public P04_AddMinion(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void run() {
        try {
            this.addMinion();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void addMinion() throws SQLException {
        Scanner scanner = new Scanner(System.in);

        String[] minionParams = scanner.nextLine().split("\\s+");
        String[] villainParams = scanner.nextLine().split("\\s+");

        String minionName = minionParams[1];
        int minionAge = Integer.parseInt(minionParams[2]);
        String townName = minionParams[3];
        String villainName = villainParams[1];

        if (!this.checksIfEntityExists(townName, "towns")) {
            this.insertTown(townName);
        }

        if (!this.checksIfEntityExists(villainName, "villains")) {
            this.insertVillain(villainName);
        }

        int townId = this.getEntityId(townName, "towns");
        this.insertMinion(minionName, minionAge, townId);
        System.out.println(String.format("Successfully added %s to be minion of %s.", minionName, villainName));
    }

    private boolean checksIfEntityExists(String name, String tableName) throws SQLException {
        String query = "SELECT * FROM " + tableName + " WHERE name = ?";

        PreparedStatement preparedStatement =
                this.connection.prepareStatement(query);
        preparedStatement.setString(1, name);

        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            return true;
        }
        return false;
    }

    private void insertTown(String townName) throws SQLException {
        String query = "INSERT INTO towns(name, country) VALUES('" + townName + "', NULL)";
        PreparedStatement preparedStatement = this.connection.prepareStatement(query);
        preparedStatement.execute();

        System.out.println(String.format("Town %s was added to the database.", townName));
    }

    private void insertVillain(String villainName) throws SQLException {
        String query = String.format
                ("INSERT INTO villains(name, evilness_factor) VALUES('%s', 'evil')", villainName);
        PreparedStatement preparedStatement = this.connection.prepareStatement(query);
        preparedStatement.execute();

        System.out.println(String.format("Villain %s was added to the database.", villainName));
    }

    private int getEntityId(String name, String tableName) throws SQLException {
        String query = String.format("SELECT id FROM %s WHERE name = '%s'", tableName, name);
        PreparedStatement preparedStatement = this.connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return resultSet.getInt(1);
    }

    private void insertMinion(String minionName, int age, int townId) throws SQLException {
        String query =
                String.format("INSERT INTO minions(name, age, town_id) VALUES('%s', %d, %d)", minionName, age, townId);

        PreparedStatement preparedStatement = this.connection.prepareStatement(query);
        preparedStatement.execute();

    }
}
