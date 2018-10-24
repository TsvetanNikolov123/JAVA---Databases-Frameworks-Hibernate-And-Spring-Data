package entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.List;

public class p09_IncreaseSalaries {
    public static void main(String[] args) {
        EntityManagerFactory managerFactory =
                Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = managerFactory.createEntityManager();

        em.getTransaction().begin();

        List<Employee> found = em
                .createQuery("SELECT e FROM Employee AS e " +
                        "WHERE e.department.name IN ('Engineering', 'Tool Design', 'Marketing', 'Information Services')")
                .getResultList();

        for (Employee employee : found) {
            BigDecimal increasedSalary = employee
                    .getSalary()
                    .multiply(BigDecimal.valueOf(1.2));
            employee.setSalary(increasedSalary);
        }

        em.getTransaction().commit();

        for (Employee employee : found) {
            System.out.printf("%s %s ($%.2f)%n",
                    employee.getFirstName(),
                    employee.getLastName(),
                    employee.getSalary());
        }
    }
}
