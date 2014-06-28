package yaroslav.patients.database.model.service;

import yaroslav.patients.database.model.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by yaroslav on 6/28/14.
 */
public abstract class AbstractService<T> {
    EntityManager em;
    private Class<T> entityClass;

    protected AbstractService(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    void initEntityManager(EntityManager em){
        this.em = em;
    }

    public T update(@NotNull T entity) {
        return em.merge(entity);
    }

    public void add(@NotNull T entity){
        em.persist(entity);
    }

    T singeResult(String queryName, String... param){
        TypedQuery<T> query = buildQuery(queryName, param);
        return query.getSingleResult();
    }

    List<T> resultList(String queryName, String... param){
        TypedQuery<T> query = buildQuery(queryName, param);
        return query.getResultList();
    }

    private TypedQuery<T> buildQuery(String queryName, String... param){
        TypedQuery<T> query = em.createNamedQuery(queryName, entityClass);
        for (int i=0; i<param.length; i++)
            query.setParameter(i+1, param[i]);
        return query;
    }

}
