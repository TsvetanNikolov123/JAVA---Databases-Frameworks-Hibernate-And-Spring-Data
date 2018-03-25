
import entities.Address;
import entities.Employee;
import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class p10_RemoveTowns {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        EntityManagerFactory managerFactory =
                Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = managerFactory.createEntityManager();

        String townName = reader.readLine();

        em.getTransaction().begin();

        Query addressQuery = em
                .createQuery("SELECT a FROM Address AS a WHERE a.town.name = :townName");

        addressQuery.setParameter("townName", townName);

        List<Address> addresses = addressQuery
                .getResultList();


        Town town =
                null;

        for (Address address : addresses) {
            for (Employee employee : address.getEmployees()) {
                employee.setAddress(null);
            }
            em.flush();
            em.remove(address);
            town = address.getTown();
        }

        em.remove(town);

        em.getTransaction().commit();
        em.close();
    }
}
