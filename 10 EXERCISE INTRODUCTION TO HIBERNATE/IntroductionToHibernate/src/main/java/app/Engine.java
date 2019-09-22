package app;

import app.tasks.*;

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
        P02_RemoveObjects removeObjects = new P02_RemoveObjects(entityManager);
        removeObjects.removeObjects();


        /**
         * 3.	Contains Employee
         */
//        P03_ContainsEmployee containsEmployee = new P03_ContainsEmployee(entityManager);
//        containsEmployee.containsEmployee();

        /**
         * 4.	Employees with Salary Over 50 000
         */
//        P04_EmployeesWithSalaryOver50000 employeesWithSalaryOver50000 =
//                new P04_EmployeesWithSalaryOver50000(entityManager);
//        employeesWithSalaryOver50000.EmployeesWithSalaryOver50000();

        /**
         * 5.	Employees from Department
         */
//        P05_EmployeesFromDepartment employeesFromDepartment=  new P05_EmployeesFromDepartment(entityManager);
//        employeesFromDepartment.employeesFromDepartment();


        /**
         * 6.	Adding a New Address and Updating Employee
         */
//        P06_AddingANewAddressAndUpdatingEmployee addingANewAddressAndUpdatingEmployee =
//                new P06_AddingANewAddressAndUpdatingEmployee(entityManager);
//        addingANewAddressAndUpdatingEmployee.addingNewAddressAndUpdatingEmployee();

        /**
         *7.	Addresses with Employee Count
         */
//        P07_AddressesWithEmployeeCount addressesWithEmployeeCount = new P07_AddressesWithEmployeeCount(entityManager);
//        addressesWithEmployeeCount.addressesWithEmployeeCount();

        /**
         * 8.	Get Employee with Project
         */
//        P08_GetEmployeeWithProject getEmployeeWithProject = new P08_GetEmployeeWithProject(entityManager);
//        getEmployeeWithProject.getEmployeeWithProject();

        /**
         * 9.	Find Latest 10 Projects
         */
//        P09_FindLatest10Projects findLatest10Projects = new P09_FindLatest10Projects(entityManager);
//        findLatest10Projects.findLatest10Projects();

        /**
         * 10.	Increase Salaries
         */
//        P10_IncreaseSalaries increaseSalaries = new P10_IncreaseSalaries(entityManager);
//        increaseSalaries.increaseSalaries();

        /**
         * 11.	Remove Towns
         */
//        P11_RemoveTowns removeTowns = new P11_RemoveTowns(entityManager);
//        removeTowns.removeTown();

        /**
         * 12.	Find Employees by First Name
         */
//        P12_FindEmployeesByFirstName findEmployeesByFirstName = new P12_FindEmployeesByFirstName(entityManager);
//        findEmployeesByFirstName.findEmployeesByFirstName();

        /**
         * 13.	Employees Maximum Salaries
         */
//        P13_EmployeesMaximumSalaries employeesMaximumSalaries = new P13_EmployeesMaximumSalaries(entityManager);
//        employeesMaximumSalaries.employeesMaximumSalaries();


        this.entityManager.getTransaction().commit();
        this.entityManager.close();
    }

}
