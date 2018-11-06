package app.tasks;

import app.entities.Employee;

import javax.persistence.EntityManager;
import java.util.List;

public class P05_EmployeesFromDepartment {
    private final EntityManager entityManager;

    public P05_EmployeesFromDepartment(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void employeesFromDepartment() {
        List<Employee> employees = entityManager
                .createQuery("FROM Employee AS e WHERE e.department.name = 'Research and Development' " +
                        "ORDER BY e.salary ASC, e.id ASC", Employee.class)
                .getResultList();

        for (Employee employee : employees) {
            System.out.println(String.format("%s %s from %s - $%.2f",
                    employee.getFirstName(),
                    employee.getLastName(),
                    employee.getDepartment(),
                    employee.getSalary()));
        }
    }
}
