package app.tasks;

import app.entities.Address;
import app.entities.Employee;
import app.entities.Town;

import javax.persistence.EntityManager;
import java.util.Scanner;

public class P06_AddingANewAddressAndUpdatingEmployee {

    private final EntityManager entityManager;
    private Scanner scanner = new Scanner(System.in);

    public P06_AddingANewAddressAndUpdatingEmployee(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void addingNewAddressAndUpdatingEmployee (){
        System.out.print("Enter name: ");
        String lastName = scanner.nextLine();

        Address address = new Address();
        address.setText("Vitoshka 15");

        Town town = this.entityManager
                .createQuery("FROM Town WHERE name = 'Sofia'", Town.class)
                .getSingleResult();

        address.setTown(town);
        entityManager.persist(address);

        Employee employee = entityManager
                .createQuery("FROM Employee WHERE last_name = :name", Employee.class)
                .setParameter("name", lastName)
                .getSingleResult();

        entityManager.detach(employee.getAddress());
        employee.setAddress(address);
        entityManager.merge(employee);
    }

}
