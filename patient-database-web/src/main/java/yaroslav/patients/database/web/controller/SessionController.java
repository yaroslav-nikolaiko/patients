package yaroslav.patients.database.web.controller;

import org.primefaces.event.RowEditEvent;
import yaroslav.patients.database.model.entity.Diagnose;
import yaroslav.patients.database.model.entity.Drug;
import yaroslav.patients.database.model.entity.Patient;
import yaroslav.patients.database.model.service.UserService;
import yaroslav.patients.database.web.interceptor.DialogValidation;
import yaroslav.patients.database.web.interceptor.ValidationHandler;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 * Created by yaroslav on 6/28/14.
 */
@Named
@SessionScoped
@ValidationHandler
public class SessionController extends SessionStructure implements Serializable {
    @EJB UserService userService;
    @Inject UserBean userBean;
    @Inject PatientBean patientBean;
    @Inject DrugBean drugBean;

    public String singUp(){
        user =  userBean.getUser();
        userService.addToDataBase(user);
        return "index?faces-redirect=true";
    }

    @DialogValidation
    public void login(){
        user =  userBean.login();
    }

    @DialogValidation
    public void addPatient(){
       userService.addPatient(user, patientBean.getPatient());
    }

    @DialogValidation
    public void updatePatient(RowEditEvent event) {
        //Patient patient = (Patient)event.getObject();
        userService.update(user);
    }

    @DialogValidation
    public  void removeSelectedDrugs(Diagnose diagnose){
        diagnose.removeDrugs(selectedDrugs);
        userService.update(user);
        selectedDrugs = null;
    }

    @DialogValidation
    public void addDrugToDiagnose(Diagnose diagnose){
        diagnose.addDrug(oneFuckingDrugNeedRefactor);
        oneFuckingDrugNeedRefactor = null;
        userService.update(user);
    }

    @DialogValidation
    public void addDrugToDataBase(){
        drugService.add(drugBean.getDrug());
    }

}
