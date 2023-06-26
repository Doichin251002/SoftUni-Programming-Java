package exercices;

import entities.Employee;
import utils.Utils;

import javax.persistence.EntityManager;
import java.util.Scanner;

public class ContainsEmployee {
    private static final String GET_EMPLOYEE_BY_FIRST_LAST_NAME_QUERY =
            "FROM Employee WHERE concat_ws(' ', first_name, last_name) LIKE : fullName";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fullName = scanner.nextLine().trim();

        EntityManager entityManager = Utils.createEntityManager();

        try {
            entityManager
                    .createQuery(GET_EMPLOYEE_BY_FIRST_LAST_NAME_QUERY, Employee.class)
                    .setParameter("fullName", fullName)
                    .getSingleResult();

            System.out.println("Yes");
        } catch (Exception e) {
            System.out.println("No");
        }

        entityManager.close();
    }
}
