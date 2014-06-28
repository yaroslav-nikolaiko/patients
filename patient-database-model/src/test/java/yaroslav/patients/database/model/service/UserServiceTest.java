package yaroslav.patients.database.model.service;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert .*;
import static yaroslav.patients.database.model.utils.EntityManagerProducer.*;

import org.junit.experimental.categories.Category;
import yaroslav.patients.database.model.entity.Patient;
import yaroslav.patients.database.model.entity.User;
import yaroslav.patients.database.model.utils.IntegrationTest;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

/**
 * Created by yaroslav on 6/26/14.
 */
@Category(IntegrationTest.class)
public class UserServiceTest {
    private EntityManager em;
    private EntityTransaction tx;
    private UserService userService;

    public UserServiceTest() throws Exception{
        userService = new UserService();
    }

    @Before
    public void init() throws Exception {
        em = getEntityManager();
        tx = em.getTransaction();
        userService.initEntityManager(em);
    }

    @After
    public void close() throws Exception {
        if(tx!=null && tx.isActive())
            tx.rollback();
        if(em!=null)
            em.close();
    }

    @Test
    public void shouldCreateUser() throws Exception{
        User user = userMock();

        tx.begin();
        userService.addToDataBase(user);
        em.flush();

        assertNotNull(user.getId());
    }

    @Test(expected = PersistenceException.class)
    public void addUserWithExistedNameTest(){
        tx.begin();
        userService.addToDataBase(userMock());
        em.flush();

        userService.addToDataBase(userMock());
        em.flush();
    }

    @Test
    public void loginExistTest() throws Exception{
        shouldCreateUser();

        assertTrue(userService.loginExist("admin"));
        assertFalse(userService.loginExist("non-admin"));
    }

    @Test
    public void shouldChangeUserLoginTest() throws Exception{
        User user = userMock();
        String password = user.getPassword();
        tx.begin();
        userService.addToDataBase(user);
        em.flush();

        user.setLogin("Mike");
        userService.update(user);
        em.flush();

        assertEquals(user.getId(), userService.find("Mike", password).getId());
    }

    @Test
    public void shouldAddPatientTest() throws Exception{
        User user = userMock();
        tx.begin();
        userService.addToDataBase(user);
        em.flush();

        user.addPatient(patientMock());
        em.flush();

        assertNotNull(user.getPatients().get(0).getId());
    }

    private User userMock(){
        User user = new User();
        user.setPassword(String.valueOf((int)(Math.random()*1000)));
        user.setLogin("admin");
        return user;
    }

    private Patient patientMock(){
        Patient patient = new Patient();
        patient.setFirstName("Andy");
        patient.setLastName("Sparrow");
        return patient;
    }
}
