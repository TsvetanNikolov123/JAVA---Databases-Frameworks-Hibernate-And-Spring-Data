package app.tasks;

import app.entities.Employee;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Scanner;

public class P12_FindEmployeesByFirstName {
    private final EntityManager entityManager;
    private Scanner scanner = new Scanner(System.in);

    public P12_FindEmployeesByFirstName(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void findEmployeesByFirstName(){
        System.out.print("Enter pattern: ");
        String searchedPattern = scanner.nextLine();

        List<Employee> employees = entityManager
                .createQuery("SELECT e FROM Employee AS e WHERE e.firstName LIKE :pattern",Employee.class)
                .setParameter("pattern", searchedPattern + "%")
                .getResultList();

        for (Employee employee : employees) {
            System.out.println(String.format("%s %s - %s - ($%.2f)",
                    employee.getFirstName(),
                    employee.getLastName(),
                    employee.getJobTitle(),
                    employee.getSalary()));
        }
    }
}
