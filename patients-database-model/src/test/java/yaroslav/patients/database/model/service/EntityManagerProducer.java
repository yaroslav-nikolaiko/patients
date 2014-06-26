package yaroslav.patients.database.model.service;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by yaroslav on 6/26/14.
 */

public class EntityManagerProducer {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("PatientsTest");
    //private EntityManagerFactory emf = Persistence.createEntityManagerFactory("PatientsTest");
    private EntityManager em;

    @PostConstruct
    private void init(){
        emf = Persistence.createEntityManagerFactory("PatientsTest");
    }


//    @Produces
//    public EntityManager getEntityManager(InjectionPoint ip) {
//        if (em == null) {
//            em = emf.createEntityManager();
//        }
//        return em;
//    }

    @Produces
    public EntityManager getEntityManager() {
        if (em == null) {
            em = emf.createEntityManager();
        }
        return em;
    }

}
