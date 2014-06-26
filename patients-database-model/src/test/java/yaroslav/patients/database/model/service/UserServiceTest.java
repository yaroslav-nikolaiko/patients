package yaroslav.patients.database.model.service;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert .*;

import yaroslav.patients.database.model.entity.User;

import javax.ejb.embeddable.EJBContainer;
import javax.inject.Inject;
import javax.naming.Context;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yaroslav on 6/26/14.
 */
public class UserServiceTest {
    //private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("PatientsTest");
    //private EntityManager em;
    @Inject
    private EntityManager em;
    private EntityTransaction tx;
    //@Inject
    //EntityManagerProducer producer;

    public UserServiceTest() throws Exception{
        //EntityManagerProducer.empty();
        Class.forName("yaroslav.patients.database.model.service.WeldContext");
    }

    @Before
    public void init() throws Exception {

        //em = emf.createEntityManager();
        tx = em.getTransaction();
        //tx = producer.getEntityManager().getTransaction();
//        Map<String, Object> properties = new HashMap<>();
//        properties.put(EJBContainer.MODULES, new File("target/classes"));
//        try(EJBContainer ec = EJBContainer.createEJBContainer(properties)){
//            Context ctx = ec.getContext();
//        }
    }

    @After
    public void close() throws Exception {
        //if(em != null)
        //    em.close();
    }

    @Test
    public void shouldCreateUser() throws Exception{
        User user = new User();
        user.setPassword("1234");
        user.setLogin("admin");

        UserService service = new UserService();

        tx.begin();
        service.add(user);
        tx.commit();
        assertNotNull(user.getId());
    }

}
