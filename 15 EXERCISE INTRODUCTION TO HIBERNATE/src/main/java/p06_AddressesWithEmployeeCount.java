import entities.Address;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class p06_AddressesWithEmployeeCount {
    public static void main(String[] args) {
        EntityManagerFactory managerFactory =
                Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = managerFactory.createEntityManager();

        em.getTransaction().begin();

        List<Address> result = em
                .createQuery("SELECT a FROM Address AS a order by a.employees.size DESC, a.town.id ASC")
                .setMaxResults(10)
                .getResultList();

        for (Address address : result) {
            System.out.printf("%s, %s - %d employees%n",
                    address.getText(),
                    address.getTown().getName(),
                    address.getEmployees().size());
        }

        em.getTransaction().commit();
    }
}
