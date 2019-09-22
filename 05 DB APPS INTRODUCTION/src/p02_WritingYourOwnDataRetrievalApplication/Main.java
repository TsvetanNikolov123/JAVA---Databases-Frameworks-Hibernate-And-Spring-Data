package p02_WritingYourOwnDataRetrievalApplication;

import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        String user = "root";
        String password = "1234";

        Properties props = new Properties();
        props.setProperty("user", user);
        props.setProperty("password", password);

        Connection connection =
                DriverManager.getConnection("jdbc:mysql://localhost:3306/diablo", props);

        PreparedStatement stmt =
                connection.prepareStatement("SELECT user_name, first_name, last_name, count(diablo.users_games.user_id) AS count \n" +
                        "FROM diablo.users\n" +
                        "join diablo.users_games\n" +
                        "on users.id = users_games.user_id\n" +
                        "WHERE user_name LIKE ? \n" +
                        "group by user_id;");

        String userName = scanner.nextLine();
        stmt.setString(1,userName);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()){
            System.out.println(rs.getString("user_name")
                            + " " + rs.getString("first_name")
                            + " " + rs.getString("last_name")
                            + " " + rs.getString("count"));
        } else {
            System.out.println("No such user exists");
        }
    }
}
