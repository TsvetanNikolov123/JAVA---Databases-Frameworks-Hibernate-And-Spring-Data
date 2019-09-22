package p01_AccsessDatabaseViaSimpleJavaAppDemo;

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
                DriverManager.getConnection("jdbc:mysql://localhost:3306/soft_uni", props);

        PreparedStatement stmt =
                connection.prepareStatement("SELECT first_name, last_name FROM employees WHERE salary > ?");

        String salary = scanner.nextLine();
        stmt.setDouble(1,Double.parseDouble(salary));

        ResultSet rs = stmt.executeQuery();

        while (rs.next()){
            System.out.println(rs.getString("first_name") + " " + rs.getString("last_name"));
        }
    }
}
