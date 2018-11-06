package app.tasks;

import app.entities.Address;
import app.entities.Employee;
import app.entities.Town;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Scanner;

public class P11_RemoveTowns {
    private final EntityManager entityManager;
    private Scanner scanner = new Scanner(System.in);

    public P11_RemoveTowns(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void removeTown() {
        System.out.print("Enter town: ");
        String townToRemove = scanner.nextLine();

        List<Employee> employees = entityManager.createQuery("SELECT e FROM Employee AS e " +
                "WHERE e.address.town.name = :townName", Employee.class)
                .setParameter("townName", townToRemove).getResultList();


        List<Address> addresses = entityManager.createQuery("SELECT a FROM Address AS a " +
                "WHERE a.town.name = :townName", Address.class)
                .setParameter("townName", townToRemove)
                .getResultList();

        List<Town> towns = entityManager.createQuery("SELECT t FROM Town AS t " +
                "WHERE t.name = :townName", Town.class)
                .setParameter("townName", townToRemove)
                .getResultList();

        int deletedCount = addresses.size();

        employees.forEach(e -> e.setAddress(null));
        for (Address address : addresses) {
            entityManager.remove(address);
        }
        towns.forEach(entityManager::remove);

        System.out.printf(deletedCount == 1 ?
                String.format("1 address in %s was deleted.", townToRemove) :
                String.format("%d addresses in %s were deleted.", deletedCount, townToRemove));
    }
}
