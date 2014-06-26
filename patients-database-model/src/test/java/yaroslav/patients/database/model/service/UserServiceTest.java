package yaroslav.patients.database.model.service;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert .*;

import yaroslav.patients.database.model.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Created by yaroslav on 6/26/14.
 */
public class UserServiceTest {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("PatientsTest");
    private EntityManager em;
    private EntityTransaction tx;

    @Before
    public void init() throws Exception {
        em = emf.createEntityManager();
        tx = em.getTransaction();
    }

    @After
    public void close() throws Exception {
        if(em != null)
            em.close();
    }

    @Test
    public void shouldCreateUser() throws Exception{
        User user = new User();
        user.setPassword("1234");
        user.setLogin("admin");

        tx.begin();
        em.persist(user);
        tx.commit();
        assertNotNull(user.getId());
    }

}
