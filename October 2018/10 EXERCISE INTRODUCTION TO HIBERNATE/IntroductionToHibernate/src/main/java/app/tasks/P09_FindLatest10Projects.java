package app.tasks;

import app.entities.Project;

import javax.persistence.EntityManager;
import java.util.List;

public class P09_FindLatest10Projects {
    private final EntityManager entityManager;

    public P09_FindLatest10Projects(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void findLatest10Projects() {
        List<Project> projects = entityManager
                .createQuery("SELECT p FROM Project AS p ORDER BY p.startDate DESC", Project.class)
                .setMaxResults(10)
                .getResultList();

        StringBuilder sb = new StringBuilder();

        projects.stream()
                .sorted((p1, p2) -> p1.getName().compareTo(p2.getName()))
                .forEach(p -> sb.append(String.format("Project name: %s%n" +
                                "       Project Description: %s%n" +
                                "       Project Start Date: %s%n" +
                                "       Project End Date: %s%n",
                        p.getName(),
                        p.getDescription(),
                        p.getStartDate(),
                        p.getEndDate())));
        System.out.println(sb.toString());
    }
}
