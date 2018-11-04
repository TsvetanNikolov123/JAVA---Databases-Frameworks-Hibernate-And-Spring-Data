package app.tasks;

import app.entities.Employee;

import javax.persistence.EntityManager;
import java.util.List;

public class P04_EmployeesWithSalaryOver50000 {
    private final EntityManager entityManager;

    public P04_EmployeesWithSalaryOver50000(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void EmployeesWithSalaryOver50000() {
        List<Employee> employees = entityManager
                .createQuery("FROM Employee WHERE salary > 50000", Employee.class)
                .getResultList();

        for (Employee employee : employees) {
            System.out.println(employee.getFirstName());
        }
    }
}
