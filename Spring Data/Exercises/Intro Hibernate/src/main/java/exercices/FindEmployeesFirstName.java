package exercices;

import entities.Employee;
import utils.Utils;

import javax.persistence.EntityManager;
import java.util.Scanner;

public class FindEmployeesFirstName {
    private static final String GET_EMPLOYEES_BY_FIRST_NAME_PATTERN =
            "FROM Employee WHERE firstName LIKE CONCAT(:letters, '%')";
    private static final String PRINT_FORMAT = "%s %s - %s - ($%s)%n";

    public static void main(String[] args) {
        String pattern = new Scanner(System.in).nextLine();

        EntityManager entityManager = Utils.createEntityManager();

        entityManager
                .createQuery(GET_EMPLOYEES_BY_FIRST_NAME_PATTERN, Employee.class)
                .setParameter("letters", pattern)
                .getResultList()
                .forEach(employee -> System.out.printf(PRINT_FORMAT,
                        employee.getFirstName(),
                        employee.getLastName(),
                        employee.getJobTitle(),
                        employee.getSalary()));

        entityManager.close();
    }
}

