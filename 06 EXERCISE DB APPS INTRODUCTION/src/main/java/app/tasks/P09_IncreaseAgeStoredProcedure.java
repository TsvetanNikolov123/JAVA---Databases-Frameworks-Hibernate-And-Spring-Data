package app.tasks;

import java.sql.*;
import java.util.Scanner;

public class P09_IncreaseAgeStoredProcedure implements Runnable {

    private Connection connection;

    public P09_IncreaseAgeStoredProcedure(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void run() {
        try {
            increaseAgeWithStoredProcedure();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void increaseAgeWithStoredProcedure() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        int minionId = Integer.parseInt(scanner.nextLine());

        String procedure = "Call usp_increase_minion_age(?)";
        CallableStatement callableStatement = connection.prepareCall(procedure);
        callableStatement.setInt(1,minionId);
        callableStatement.execute();

        printResult(minionId);
    }

    private void printResult(int minionId) throws SQLException {
        String query = "SELECT id, name, age FROM minions WHERE id = ?";
        PreparedStatement preparedStatement = this.connection.prepareStatement(query);
        preparedStatement.setInt(1, minionId);
        ResultSet resultSet = preparedStatement.executeQuery();

        if(resultSet.next()){
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            int age = resultSet.getInt(3);

            System.out.println(String.format("%d. %s %d", id, name, age));
        }
    }
}
