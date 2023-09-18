package exercices;

import entities.Town;
import utils.Utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class ChangeCasing {

    private static final String GET_TOWNS_QUERY = "FROM Town";

    public static void main(String[] args) {
        EntityManager entityManager = Utils.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        List<Town> townsList = entityManager.createQuery(GET_TOWNS_QUERY, Town.class).getResultList();
        for (Town town : townsList) {
            if (town.getName().length() > 5) {
                entityManager.detach(town);
                continue;
            }

            town.setName(town.getName().toUpperCase());
            entityManager.persist(town);
        }

        transaction.commit();

        entityManager.close();
    }
}
