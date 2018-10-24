import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class p12_EmployeesMaximumSalaries {
    public static void main(String[] args) {
        EntityManagerFactory managerFactory =
                Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = managerFactory.createEntityManager();

        em.getTransaction().begin();
        List<Employee> found = em
                .createQuery("SELECT e FROM Employee AS e " +
                        "WHERE e.salary = (select max(em.salary) from Employee em " +
                        "where em.department.name = e.department.name) " +
                        "AND (e.salary < 30000 OR e.salary > 70000)" +
                        "GROUP BY e.department.name")
                .getResultList();

        for (Employee employee : found) {
            System.out.printf("%s - %.2f%n",
                    employee.getDepartment().getName(),
                    employee.getSalary());
        }

        em.getTransaction().commit();
    }
}
