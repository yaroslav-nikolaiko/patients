package yaroslav.patients.database.model.service;



import yaroslav.patients.database.model.entity.Patient;
import yaroslav.patients.database.model.entity.User;
import yaroslav.patients.database.model.interceptor.ValidationHandlerEjb;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.validation.constraints.NotNull;

/**
 * Created by yaroslav on 6/26/14.
 */
@Stateless
@ValidationHandlerEjb
public class UserService extends AbstractService<User> {

    public UserService() {
        super(User.class);
    }

    public User find(String login, String password) {
        return singeResult(User.FIND_BY_LOGIN_AND_PASSWORD, login, password);
    }

    public boolean loginExist(String login) {
        Query query = em.createNamedQuery(User.COUNT_BY_LOGIN, User.class);
        query.setParameter("login", login);
        return (Long) query.getSingleResult() > 0;
    }

    public void addPatient(User user, Patient patient){
        int localId = user.getMaxPatientLocalId();
        user.addPatient(patient, ++localId);
        em.persist(patient);
        update(user);
    }

    public void removePatient(User user, Patient patient) {
        user.removePatient(patient);
        update(user);
    }

    @Inject @Override
    void initEntityManager(EntityManager em){
        super.initEntityManager(em);
    }
}
