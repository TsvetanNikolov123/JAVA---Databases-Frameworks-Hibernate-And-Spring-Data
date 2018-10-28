package app.tasks;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;

public class P08_IncreaseMinionsAge implements Runnable{

    private Connection connection;

    public P08_IncreaseMinionsAge(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void run() {
        try {
            increaseMinionAge();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void increaseMinionAge() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        int[] listOfIDs = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        String query = String.format("UPDATE minions " +
                        "SET age = age + 1," +
                        "name = CONCAT(UPPER(LEFT(name, 1))," +
                        "SUBSTRING(name, 2)) " +
                        "WHERE id IN (%s);",
                Arrays.toString(listOfIDs).replaceAll("[\\[\\]]",""));

        PreparedStatement preparedStatement = this.connection.prepareStatement(query);
        preparedStatement.execute();

        printUpdatedMinions();
    }

    private void printUpdatedMinions() throws SQLException {
        String query = "SELECT name, age FROM minions";
        PreparedStatement preparedStatement = this.connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){
            String name = resultSet.getString(1);
            int age = resultSet.getInt(2);
            System.out.println(String.format("%s %d", name, age));
        }
    }
}
