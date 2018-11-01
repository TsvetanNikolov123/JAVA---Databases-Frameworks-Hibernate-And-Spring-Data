package app;

import app.entities.User;
import app.orm.Connector;
import app.orm.EntityManager;
import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws SQLException, IllegalAccessException, InstantiationException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter username: ");
        String username = scanner.nextLine().trim();
        System.out.print("Enter password: ");
        String password = scanner.nextLine().trim();
        System.out.print("Enter database name: ");
        String db = scanner.nextLine().trim();

        Connector connector = new Connector();
        connector.createConnection(username, password, db);
        EntityManager entityManager = new EntityManager(connector.getConnection());

        User user = new User("FirstUser", 20, new Date());
        entityManager.persist(user);

    }
}
