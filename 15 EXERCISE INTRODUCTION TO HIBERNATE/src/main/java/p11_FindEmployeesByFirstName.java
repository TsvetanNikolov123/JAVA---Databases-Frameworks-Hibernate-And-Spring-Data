import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class p11_FindEmployeesByFirstName {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        EntityManagerFactory managerFactory =
                Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = managerFactory.createEntityManager();

        String hqlQuery = "SELECT e FROM Employee AS e WHERE e.firstName LIKE '" + input + "%'";
        Query query = em.createQuery(hqlQuery);
        List<Employee> employees = query.getResultList();

        employees.forEach(e -> {
            System.out.println(String.format("%s %s - %s - ($%.2f)",
                    e.getFirstName(), e.getLastName(), e.getJobTitle(), e.getSalary()));
        });

        em.close();
        managerFactory.close();
    }
}
