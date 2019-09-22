package app.tasks;

import app.entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.Scanner;

public class P03_ContainsEmployee {

    private final EntityManager entityManager;

    Scanner scanner = new Scanner(System.in);

    public P03_ContainsEmployee(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void containsEmployee() {
        System.out.print("Enter searched name: ");
        String name = scanner.nextLine().trim();


        try {
            Employee employee = this.entityManager
                    .createQuery("FROM Employee WHERE concat(first_name, ' ' , last_name) = :name", Employee.class)
                    .setParameter("name", name)
                    .getSingleResult();

            System.out.println("Yes");
        } catch (NoResultException nre) {
            System.out.println("No");
        }
    }
}
