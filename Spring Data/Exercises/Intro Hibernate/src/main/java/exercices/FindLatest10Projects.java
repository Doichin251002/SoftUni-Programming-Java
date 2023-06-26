package exercices;

import entities.Project;
import utils.Utils;

import javax.persistence.EntityManager;
import java.util.Comparator;

public class FindLatest10Projects {
    private static final String GET_STARTED_PROJECTS =
            "FROM Project ORDER BY startDate DESC, name";
    public static void main(String[] args) {
        EntityManager entityManager = Utils.createEntityManager();

        entityManager.createQuery(GET_STARTED_PROJECTS, Project.class)
                .setMaxResults(10)
                .getResultList()
                .stream().sorted(Comparator.comparing(Project::getName))
                .forEach(System.out::println);

        entityManager.close();
    }
}
