import entities.Employee;
import entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class p07_GetEmployeeWithProject {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int employeeId = Integer.parseInt(reader.readLine());

        EntityManagerFactory managerFactory =
                Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = managerFactory.createEntityManager();

        em.getTransaction().begin();

        Employee found = (Employee) em
                .createQuery("SELECT e FROM Employee AS e WHERE e.id = ?")
                .setParameter(0, employeeId)
                .getSingleResult();

        Set<Project> employeesProjects = found.getProjects()
                .stream()
                .sorted(Comparator.comparing(Project::getName))
                .collect(Collectors.toSet());

        System.out.printf("%s %s - %s%n",
                found.getFirstName(),
                found.getLastName(),
                found.getJobTitle());

        for (Project employeeProject : employeesProjects) {
            System.out.printf("\t%s%n", employeeProject.getName());
        }

        em.getTransaction().commit();
    }
}
