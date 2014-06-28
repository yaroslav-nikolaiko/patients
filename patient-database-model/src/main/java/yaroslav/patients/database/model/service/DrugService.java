package yaroslav.patients.database.model.service;

import yaroslav.patients.database.model.entity.Drug;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

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
}
