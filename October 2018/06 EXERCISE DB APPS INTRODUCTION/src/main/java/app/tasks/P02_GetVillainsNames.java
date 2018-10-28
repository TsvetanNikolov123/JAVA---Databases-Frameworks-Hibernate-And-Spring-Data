package app.tasks;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class P02_GetVillainsNames implements Runnable {

    private Connection connection;

    public P02_GetVillainsNames(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void run() {
        try {
            this.getVillainsNames();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void getVillainsNames() throws SQLException {
        String query =  "SELECT v.name, count(v2.minion_id) AS minion_count\n" +
                "FROM villains AS v\n" +
                "       JOIN minions_villains v2 on v.id = v2.villain_id\n" +
                "GROUP BY v.id\n" +
                "HAVING count(v2.minion_id) > ?\n" +
                "ORDER BY count(v2.minion_id) DESC;";

        PreparedStatement preparedStatement = this.connection.prepareStatement(query);
        preparedStatement.setInt(1, 3);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){
            System.out.println(String.format("%s %d",
                    resultSet.getString("name"),
                    resultSet.getInt("minion_count")));
        }
    }
}
