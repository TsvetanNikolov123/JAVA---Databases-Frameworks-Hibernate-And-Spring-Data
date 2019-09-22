package app.tasks;

import app.entities.Town;

import javax.persistence.EntityManager;
import java.util.List;

public class P02_RemoveObjects {
    private final EntityManager entityManager;

    public P02_RemoveObjects(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void removeObjects(){
        List<Town> towns = entityManager
                .createQuery("FROM Town WHERE length(name) > 5", Town.class)
                .getResultList();

        for (Town town : towns) {
            entityManager.detach(town);
            String townNameToLower = town.getName().toLowerCase();
            town.setName(townNameToLower);
            entityManager.merge(town);
        }
    }
}
