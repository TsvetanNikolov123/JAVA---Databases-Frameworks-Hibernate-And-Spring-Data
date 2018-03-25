import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class p05_EmployeesFromDepartment {
    public static void main(String[] args) {
        EntityManagerFactory managerFactory =
                Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = managerFactory.createEntityManager();

        em.getTransaction().begin();

        List<Employee> result = em.
                createQuery("SELECT e FROM Employee AS e " +
                        "WHERE e.department.name = 'Research and Development' " +
                        "order by  e.salary ASC, e.id ASC")
                .getResultList();

        for (Employee employee : result) {
            System.out.printf("%s %s from %s - $%.2f%n",
                    employee.getFirstName(),
                    employee.getLastName(),
                    employee.getDepartment().getName(),
                    employee.getSalary());
        }
        em.getTransaction().commit();
    }
}
