package yaroslav.patients.database.model.service;

import yaroslav.patients.database.model.entity.Diagnose;
import yaroslav.patients.database.model.entity.Patient;
import yaroslav.patients.database.model.entity.User;
import yaroslav.patients.database.model.exception.EJBIllegalArgumentException;
import yaroslav.patients.database.model.interceptor.ValidationHandlerEjb;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by yaroslav on 6/28/14.
 */
@Stateless
@ValidationHandlerEjb
public class PatientService extends AbstractService<Patient> {

    public PatientService() {
        super(Patient.class);
    }

    public void addDiagnose(Patient patient, Diagnose diagnose) throws EJBIllegalArgumentException{
        if(patient.existDiagnose(diagnose))
            throw new EJBIllegalArgumentException(String.format("Diagnose %s already exist",diagnose.getText()),
                                                    EJBIllegalArgumentException.MessageType.WARN);
        patient.addDiagnose(diagnose);
        em.persist(diagnose);
        update(patient);
    }

    public void removeDiagnose(Patient patient, Diagnose diagnose){
        patient.removeDiagnose(diagnose);
        update(patient);
    }

    public int maxLocalId(){
        Query query = em.createNamedQuery(Patient.MAX_LOCAL_ID);
        return (int) query.getSingleResult();
    }


    @Inject @Override
    void initEntityManager(EntityManager em){
        super.initEntityManager(em);
    }
}
