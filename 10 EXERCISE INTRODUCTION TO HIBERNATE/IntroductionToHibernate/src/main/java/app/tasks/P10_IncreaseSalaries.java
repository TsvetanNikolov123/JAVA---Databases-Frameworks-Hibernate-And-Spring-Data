package app.tasks;

import app.entities.Employee;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

public class P10_IncreaseSalaries {
    private final EntityManager entityManager;

    public P10_IncreaseSalaries(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void increaseSalaries() {
        List<Employee> employees = entityManager
                .createQuery("SELECT e FROM Employee AS e WHERE e.department.name IN " +
                        "('Engineering', 'Tool Design', 'Marketing', 'Information Services') ORDER BY e.id ASC", Employee.class)
                .getResultList();

        for (Employee employee : employees) {
            employee.setSalary(employee.getSalary().multiply(new BigDecimal(1.12)));
        }

        StringBuilder sb = new StringBuilder();

        for (Employee employee : employees) {
            sb.append(String.format("%s %s ($%.2f)",
                    employee.getFirstName(),
                    employee.getLastName(),
                    employee.getSalary()));
            sb.append(System.lineSeparator());
        }

        System.out.println(sb.toString());
    }
}
