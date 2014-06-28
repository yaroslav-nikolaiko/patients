package yaroslav.patients.database.model.service;



import yaroslav.patients.database.model.entity.Patient;
import yaroslav.patients.database.model.entity.User;

import javax.annotation.PostConstruct;
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
public class UserService extends AbstractService<User> {

    public UserService() {
        super(User.class);
    }

    public User find(@NotNull String login,@NotNull String password) {
//        TypedQuery<User> query = em.createNamedQuery(User.FIND_BY_LOGIN_AND_PASSWORD, User.class);
//        query.setParameter("login", login);
//        query.setParameter("password", password);
//        return query.getSingleResult();
        return singeResult(User.FIND_BY_LOGIN_AND_PASSWORD, login, password);
    }

//    public void add(@NotNull User user) {
//        persist(user);
//    }

    public boolean loginExist(@NotNull String login) {
        Query query = em.createNamedQuery(User.COUNT_BY_LOGIN, User.class);
        query.setParameter("login", login);
        return (Long) query.getSingleResult() > 0;
    }


//    public User update(@NotNull User user) {
//        return merge(user);
//    }

    public void addPatient(@NotNull User user, @NotNull Patient patient){
        user.addPatient(patient);
        em.persist(patient);
        update(user);
    }

    @Inject @Override
    void initEntityManager(EntityManager em){
        super.initEntityManager(em);
    }
}
