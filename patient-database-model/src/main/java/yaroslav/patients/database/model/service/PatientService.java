package yaroslav.patients.database.model.service;

import yaroslav.patients.database.model.entity.Patient;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by yaroslav on 6/28/14.
 */
public class PatientService extends AbstractService<Patient> {

    public PatientService() {
        super(Patient.class);
    }

    public List<Patient> findByName(@NotNull String name) {
        return resultList(Patient.FIND_BY_FIRST_NAME, name);
    }

    public List<Patient> findByName(@NotNull String firstName, @NotNull String lastName) {
        return resultList(Patient.FIND_BY_FIRST_AND_LAST_NAME, firstName, lastName);
    }

    @Inject @Override
    void initEntityManager(EntityManager em){
        super.initEntityManager(em);
    }
}
