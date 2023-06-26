package exercices;

import entities.Employee;
import entities.Project;
import utils.Utils;

import javax.persistence.EntityManager;
import java.util.Comparator;
import java.util.Scanner;

public class GetEmployeesWithProject {
    private static final String GET_EMPLOYEE_BY_ID = "FROM Employee WHERE id = :eId";

    private static final String PRINT_FORMAT = "%s %s - %s \n";

    public static void main(String[] args) {
        int id = new Scanner(System.in).nextInt();

        EntityManager entityManager = Utils.createEntityManager();
        Employee employee = entityManager
                .createQuery(GET_EMPLOYEE_BY_ID, Employee.class)
                .setParameter("eId", id)
                .getSingleResult();

        String firstName = employee.getFirstName();
        String lastName = employee.getLastName();
        String departmentName = employee.getDepartment().getName();

        System.out.printf(PRINT_FORMAT, firstName, lastName, departmentName);
        employee.getProjects().stream().map(Project::getName).sorted().forEach(System.out::println);

        entityManager.close();
    }
}
