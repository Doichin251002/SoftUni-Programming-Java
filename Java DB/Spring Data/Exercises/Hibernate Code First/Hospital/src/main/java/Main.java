import entities.Patient;

import javax.persistence.Persistence;
import java.util.Date;

public class Main {
    public static void main(String[] args) {Persistence.createEntityManagerFactory("hospital").createEntityManager();}
}