package yaroslav.patients.database.model.service;

import yaroslav.patients.database.model.entity.Drug;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by yaroslav on 6/28/14.
 */
@Stateless
public class DrugService extends AbstractService<Drug> {

    public DrugService() {
        super(Drug.class);
    }

    @Override @Inject
    void initEntityManager(EntityManager em) {
        super.initEntityManager(em);
    }

    public List<Drug> availableDrugs() {
        return resultList(Drug.ALL_DRUGS);
    }

    public void add(Drug drug) {
        em.persist(drug);
    }

}
