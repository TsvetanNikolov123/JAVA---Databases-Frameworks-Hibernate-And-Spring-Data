package app.tasks;

import app.entities.Employee;
import app.entities.Project;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P08_GetEmployeeWithProject {
    private final EntityManager entityManager;
    private Scanner scanner = new Scanner(System.in);

    public P08_GetEmployeeWithProject(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void getEmployeeWithProject() {
        System.out.print("Enter ID: ");
        int employeeId = Integer.parseInt(scanner.nextLine());

        Employee employee = entityManager
                .createQuery("SELECT e FROM Employee AS e WHERE e.id = :employeeId", Employee.class)
                .setParameter("employeeId", employeeId)
                .getSingleResult();

        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%s %s - %s",
                employee.getFirstName(),
                employee.getLastName(),
                employee.getJobTitle()));

        sb.append(System.lineSeparator());

        List<Project> employeeProjects = new ArrayList<>(employee.getProjects());
        employeeProjects.stream()
                .sorted((p1, p2) -> p1.getName().compareTo(p2.getName()))
                .forEach(p -> sb.append(String.format("     %s%n", p.getName())));

        System.out.println(sb.toString());
    }
}
