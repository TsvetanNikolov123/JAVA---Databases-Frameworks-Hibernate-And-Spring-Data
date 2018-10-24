import entities.Address;
import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p05_AddingANewAddressAndUpdatingEmployee {
    public static void main(String[] args) throws IOException {
        EntityManagerFactory managerFactory =
                Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = managerFactory.createEntityManager();

        em.getTransaction().begin();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String lastName = reader.readLine().trim();
        Address newAddress = new Address();
        newAddress.setText("Vitoshka 15");
        em.persist(newAddress);

        Employee found = (Employee) em.createQuery("SELECT  e FROM Employee AS e WHERE e.lastName = ?")
                .setParameter(0,lastName)
                .setMaxResults(1)
                .getSingleResult();

        found.setAddress(newAddress);

        em.getTransaction().commit();
    }
}
