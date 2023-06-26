package exercices;

import entities.Employee;
import utils.Utils;

import javax.persistence.EntityManager;

public class EmployeesSalaryOver50000 {
    private static final String GET_EMPLOYEE_FIRST_NAMES_WITH_SALARY_OVER_50000_QUERY =
            "FROM Employee WHERE salary > 50000";

    public static void main(String[] args) {
        EntityManager entityManager = Utils.createEntityManager();

        entityManager
                .createQuery(GET_EMPLOYEE_FIRST_NAMES_WITH_SALARY_OVER_50000_QUERY, Employee.class)
                .getResultList()
                .stream().map(Employee::getFirstName)
                .forEach(System.out::println);

        entityManager.close();
    }
}
