package exercices;

import entities.Employee;
import utils.Utils;

import javax.persistence.EntityManager;

public class EmployeesFromDepartment {
    private static final String GET_EMPLOYEES_BY_DEPARTMENT_QUERY =
            "FROM Employee WHERE department.name LIKE : dName ORDER BY salary, id";

    private static final String RESEARCH_AND_DEVELOPMENT_DEPARTMENT_NAME = "Research and Development";

    public static void main(String[] args) {
        EntityManager entityManager = Utils.createEntityManager();

        entityManager
                .createQuery(GET_EMPLOYEES_BY_DEPARTMENT_QUERY, Employee.class)
                .setParameter("dName", RESEARCH_AND_DEVELOPMENT_DEPARTMENT_NAME)
                .getResultList()
                .forEach(System.out::println);

        entityManager.close();
    }
}
