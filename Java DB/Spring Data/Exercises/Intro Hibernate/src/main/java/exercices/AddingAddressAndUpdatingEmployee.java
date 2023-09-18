package exercices;

import entities.Address;
import entities.Employee;
import entities.Town;
import utils.Utils;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Scanner;

public class AddingAddressAndUpdatingEmployee {
    private static final String ADDRESS_TEXT = "Vitoshka 15";
    private static final String GET_TOWN_BY_NAME = "FROM Town WHERE name LIKE :tName";
    private static final String GET_EMPLOYEE_BY_LAST_NAME = "FROM Employee WHERE last_name LIKE :lName";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String employeeLastName = scanner.nextLine();

        EntityManager entityManager = Utils.createEntityManager();
        entityManager.getTransaction().begin();

        Address newAddress = new Address();
        newAddress.setText(ADDRESS_TEXT);

        entityManager.persist(newAddress);

        List<Employee> employees = entityManager.createQuery(GET_EMPLOYEE_BY_LAST_NAME, Employee.class)
                .setParameter("lName", employeeLastName)
                .getResultList();

        employees.forEach(employee -> employee.setAddress(newAddress));

        entityManager.flush();
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
