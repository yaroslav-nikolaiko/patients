package yaroslav.patients.database.model.service;



import yaroslav.patients.database.model.entity.User;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 * Created by yaroslav on 6/26/14.
 */
@Stateless
public class UserService {
    @Inject
    EntityManager em;

    public User find(String login, String password) {
        TypedQuery<User> query = em.createNamedQuery(User.FIND_BY_LOGIN_AND_PASSWORD, User.class);
        query.setParameter("login", login);
        query.setParameter("password", password);
        return query.getSingleResult();
    }

    public void add(User user){
        em.persist(user);
    }

    public boolean loginExist(String login) {
        Query query = em.createNamedQuery(User.COUNT_BY_LOGIN, User.class);
        query.setParameter("login", login);
        return (Long) query.getSingleResult() > 0;
    }


}
