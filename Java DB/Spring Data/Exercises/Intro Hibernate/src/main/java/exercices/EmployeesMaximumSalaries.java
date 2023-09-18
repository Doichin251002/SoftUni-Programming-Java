package exercices;

import utils.Utils;

import javax.persistence.EntityManager;

public class EmployeesMaximumSalaries {
    private static final String GET_DEPARTMENTS_MAX_SALARY =
            """
            SELECT department.name, max(salary)
            FROM Employee
            GROUP BY department.id
            HAVING max(salary) NOT BETWEEN 30000 AND 70000""";
    public static void main(String[] args) {
        EntityManager entityManager = Utils.createEntityManager();

        entityManager.createQuery(GET_DEPARTMENTS_MAX_SALARY, Object[].class)
                .getResultList()
                .forEach(objects -> System.out.println(objects[0] + " " + objects[1]));

        entityManager.close();
    }
}
