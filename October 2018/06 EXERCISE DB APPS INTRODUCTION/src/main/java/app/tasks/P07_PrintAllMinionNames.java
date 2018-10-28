package app.tasks;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.Deque;

public class P07_PrintAllMinionNames implements Runnable{

    private Connection connection;

    public P07_PrintAllMinionNames(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void run() {
        try {
            printMinionNames();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void printMinionNames() throws SQLException {
        String query = "SELECT name FROM minions";
        PreparedStatement preparedStatement = this.connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();

        Deque<String> minionNames = new ArrayDeque<String>();

        while (resultSet.next()){
            String minionName = resultSet.getString(1);
            minionNames.addLast(minionName);
        }

        for (int i = 0; i < minionNames.size(); i++) {
            if (i % 2 == 0){
                System.out.println(minionNames.removeFirst());
            } else {
                System.out.println(minionNames.removeLast());
            }
        }
    }
}
