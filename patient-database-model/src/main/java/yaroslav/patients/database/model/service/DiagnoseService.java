package yaroslav.patients.database.model.service;

import yaroslav.patients.database.model.entity.Diagnose;
import yaroslav.patients.database.model.entity.Drug;
import yaroslav.patients.database.model.interceptor.ValidationHandlerEjb;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.Collection;

/**
 * Created by yaroslav on 6/28/14.
 */
@Stateless
@ValidationHandlerEjb
public class DiagnoseService extends AbstractService<Diagnose> {

    @EJB DrugService drugService;

    public DiagnoseService() {
        super(Diagnose.class);
    }

    public void addDrugs(Diagnose diagnose, Collection<Drug> drugs) {
        diagnose.addDrugs(drugs);
        for (Drug drug : drugs) {
            if( drugService.find(drug.getId()) == null ){
                drugService.addToDataBase(drug);
            }
            diagnose.addDrug(drug);
        }
        update(diagnose);
    }

    public void removeDrugs(Diagnose diagnose, Collection<Drug> drugs){
        diagnose.removeDrugs(drugs);
        update(diagnose);
    }

    @Inject @Override
    void initEntityManager(EntityManager em){
        super.initEntityManager(em);
    }
}
