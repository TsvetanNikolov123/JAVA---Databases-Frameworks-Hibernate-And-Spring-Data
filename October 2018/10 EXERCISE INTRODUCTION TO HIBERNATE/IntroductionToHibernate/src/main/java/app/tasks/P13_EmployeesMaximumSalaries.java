package app.tasks;

import javax.persistence.EntityManager;
import java.lang.reflect.Field;
import java.util.List;

public class P13_EmployeesMaximumSalaries {
    private final EntityManager entityManager;

    public P13_EmployeesMaximumSalaries(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void employeesMaximumSalaries() {
        List<Object[]> result = entityManager
                .createQuery("SELECT e.department.name, MAX(e.salary)" +
                        "FROM Employee AS e " +
                        "GROUP BY e.department.id " +
                        "HAVING MAX(e.salary) NOT BETWEEN 30000 AND 70000", Object[].class)
                .getResultList();

        for (Object[] object : result) {
            System.out.println(object[0] + " - " + object[1]);
        }
    }
}
