import entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Set;

public class p08_FindLatest10Projects {
    public static void main(String[] args) {
        EntityManagerFactory managerFactory =
                Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = managerFactory.createEntityManager();

        em.getTransaction().begin();

        List<Project> found = em
                .createQuery("SELECT p FROM Project AS p ORDER BY p.startDate DESC,p.name ASC")
                .setMaxResults(10)
                .getResultList();



        for (Project project : found) {
            System.out.println(String.format("Project name: %s", project.getName()));
            System.out.println(String.format("        Project Description: %s", project.getDescription()));
            System.out.println(String.format("        Project Start Date: %s", project.getStartDate()));
            System.out.println(String.format("        Project End Date: %s", project.getEndDate()));
        }

        em.getTransaction().commit();
    }
}
