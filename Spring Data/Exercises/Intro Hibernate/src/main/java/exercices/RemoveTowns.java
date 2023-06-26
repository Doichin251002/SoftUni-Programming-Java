package exercices;

import entities.Address;
import entities.Town;
import utils.Utils;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Scanner;

public class RemoveTowns {
    private static final String GET_TOWN_BY_NAME = "FROM Town WHERE name = :town";
    private static final String GET_ADDRESS_BY_TOWN = "FROM Address WHERE town.id= :id";
    private static final String PRINT_FORMAT = "%d address%s in %s deleted"
            ;
    public static void main(String[] args) {
        String townName = new Scanner(System.in).nextLine();

        EntityManager entityManager = Utils.createEntityManager();

        entityManager.getTransaction().begin();

        Town townDelete = entityManager.createQuery(GET_TOWN_BY_NAME, Town.class)
                .setParameter("town", townName)
                .getSingleResult();

        List<Address> addressesToDelete = entityManager
                .createQuery(GET_ADDRESS_BY_TOWN, Address.class)
                .setParameter("id", townDelete.getId())
                .getResultList();

        addressesToDelete.forEach(t -> t.getEmployees()
                        .forEach(em -> em.setAddress(null)));

        addressesToDelete.forEach(entityManager::remove);
        entityManager.remove(townDelete);

        int countDeletedAddresses = addressesToDelete.size();

        System.out.printf(PRINT_FORMAT,
                countDeletedAddresses,
                countDeletedAddresses == 1 ? "" : "es",
                townName);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
