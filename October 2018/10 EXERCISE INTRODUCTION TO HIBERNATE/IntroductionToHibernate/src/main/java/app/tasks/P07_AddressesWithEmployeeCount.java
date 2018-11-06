package app.tasks;

import app.entities.Address;

import javax.persistence.EntityManager;
import java.util.List;

public class P07_AddressesWithEmployeeCount {
    private final EntityManager entityManager;

    public P07_AddressesWithEmployeeCount(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void addressesWithEmployeeCount() {
        List<Address> addresses = entityManager
                .createQuery("SELECT a FROM Address AS a ORDER BY a.employees.size DESC, a.town.id ASC", Address.class)
                .setMaxResults(10)
                .getResultList();

        StringBuilder sb = new StringBuilder();

        for (Address address : addresses) {
            sb.append(String.format("%s, %s - %d - employees",
                    address.getText(),
                    address.getTown().getName(),
                    address.getEmployees().size()));
            sb.append(System.lineSeparator());
        }

        System.out.println(sb.toString());
    }
}
