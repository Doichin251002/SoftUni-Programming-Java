package exercices;

import entities.Address;
import utils.Utils;

import javax.persistence.EntityManager;

public class AddressesWithEmployeeCount {
    private static final String GET_ADDRESSES_GROUPED_BY_COUNT_EMPLOYEES =
            "FROM Address ORDER BY employees.size DESC";
    public static void main(String[] args) {
        EntityManager entityManager = Utils.createEntityManager();

        entityManager
                .createQuery(GET_ADDRESSES_GROUPED_BY_COUNT_EMPLOYEES, Address.class)
                .setMaxResults(10)
                .getResultList()
                .forEach(System.out::println);

        entityManager.close();
    }
}
