package app;

import app.tasks.P03_ContainsEmployee;
import app.tasks.P04_EmployeesWithSalaryOver50000;
import app.tasks.P06_AddingANewAddressAndUpdatingEmployee;

import javax.persistence.EntityManager;

public class Engine implements Runnable {

    private final EntityManager entityManager;

    public Engine(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void run() {
        this.entityManager.getTransaction().begin();

        /**
         * 2.	Remove Objects
         */
//        P02_RemoveObjects removeObjects = new P02_RemoveObjects(entityManager);
//        removeObjects.removeObjects();


        /**
         * 3.	Contains Employee
         */
//        P03_ContainsEmployee containsEmployee = new P03_ContainsEmployee(entityManager);
//        containsEmployee.containsEmployee();

        /**
         * 4.	Employees with Salary Over 50 000
         */
        P04_EmployeesWithSalaryOver50000 employeesWithSalaryOver50000 =
                new P04_EmployeesWithSalaryOver50000(entityManager);
        employeesWithSalaryOver50000.EmployeesWithSalaryOver50000();


        /**
         * 6.	Adding a New Address and Updating Employee
         */
//        P06_AddingANewAddressAndUpdatingEmployee addingANewAddressAndUpdatingEmployee =
//                new P06_AddingANewAddressAndUpdatingEmployee(entityManager);
//        addingANewAddressAndUpdatingEmployee.addingNewAddressAndUpdatingEmployee();

        /**
         *
         */
        this.entityManager.getTransaction().commit();
        this.entityManager.close();
    }

}
