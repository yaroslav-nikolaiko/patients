package yaroslav.patients.database.model.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by yaroslav on 6/28/14.
 */
public final class EntityManagerProducer {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("PatientsTest");
    private EntityManagerProducer(){}

    public static EntityManager getEntityManager(){
        return emf.createEntityManager();
    }
}
