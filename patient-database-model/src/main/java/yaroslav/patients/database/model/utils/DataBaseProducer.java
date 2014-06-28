package yaroslav.patients.database.model.utils;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by yaroslav on 6/28/14.
 */
public class DataBaseProducer {
    @Produces
    @PersistenceContext(unitName = "Patients")
    private EntityManager em;
}
