package exercices;

import entities.Employee;
import utils.Utils;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class IncreaseSalaries {
    private static final String GET_EMPLOYEES_BY_DEPARTMENTS =
            "FROM Employee WHERE department.name IN (: dNames)";

    private static final String DEPARTMENT_NAMES = "'Engineering', 'Tool Design', 'Marketing', 'Information Services'";

    private static final String PRINT_FORMAT = "%s %s ($%.2f) \n";

    public static void main(String[] args) {
        EntityManager entityManager = Utils.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager
                .createQuery(GET_EMPLOYEES_BY_DEPARTMENTS, Employee.class)
                .setParameter("dNames", DEPARTMENT_NAMES)
                .getResultList()
                .forEach(employee ->
                {
                    employee.setSalary(employee.getSalary().multiply(BigDecimal.valueOf(1.12)));
                    System.out.printf(PRINT_FORMAT,
                            employee.getFirstName(),
                            employee.getLastName(),
                            employee.getSalary());
                });

        entityManager.flush();
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
