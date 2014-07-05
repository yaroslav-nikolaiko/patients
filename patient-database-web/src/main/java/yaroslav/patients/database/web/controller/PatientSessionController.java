package yaroslav.patients.database.web.controller;

import yaroslav.patients.database.model.entity.Diagnose;
import yaroslav.patients.database.model.entity.Drug;
import yaroslav.patients.database.model.entity.Patient;
import yaroslav.patients.database.model.exception.EJBIllegalArgumentException;
import yaroslav.patients.database.model.service.PatientService;
import yaroslav.patients.database.web.interceptor.DialogValidation;
import yaroslav.patients.database.web.interceptor.ValidationHandler;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 * Created by yaroslav on 7/2/14.
 */
@Named
@SessionScoped
@ValidationHandler
public class PatientSessionController implements Serializable {
    @EJB PatientService patientService;
    @Inject DiagnoseBean diagnoseBean;
    Patient currentPatient;
    List<Drug> selectedDrugs;
    Drug oneFuckingDrugNeedRefactor;

    public Patient getCurrentPatient() {
        return currentPatient;
    }

    public void setCurrentPatient(Patient currentPatient) {
        this.currentPatient = currentPatient;
    }

    @DialogValidation
    public void editPatient() {
        patientService.update(currentPatient);
    }

    @DialogValidation
    public  void removeSelectedDrugs(Diagnose diagnose){
        diagnose.removeDrugs(selectedDrugs);
        patientService.update(currentPatient);
        selectedDrugs = null;
    }

    @DialogValidation
    public void addDrugToDiagnose(Diagnose diagnose){
        diagnose.addDrug(oneFuckingDrugNeedRefactor);
        oneFuckingDrugNeedRefactor = null;
        patientService.update(currentPatient);
    }

    @DialogValidation
    public void addDiagnose() throws EJBIllegalArgumentException {
        Diagnose diagnose = diagnoseBean.getDiagnose();
        patientService.addDiagnose(currentPatient, diagnose);
    }


    public List<Drug> getSelectedDrug() {
        return selectedDrugs;
    }

    public void setSelectedDrug(List<Drug> selectedDrugs) {
        this.selectedDrugs = selectedDrugs;
    }

    public List<Drug> getSelectedDrugs() {
        return selectedDrugs;
    }

    public void setSelectedDrugs(List<Drug> selectedDrugs) {
        this.selectedDrugs = selectedDrugs;
    }

    public Drug getOneFuckingDrugNeedRefactor() {
        return oneFuckingDrugNeedRefactor;
    }

    public void setOneFuckingDrugNeedRefactor(Drug oneFuckingDrugNeedRefactor) {
        this.oneFuckingDrugNeedRefactor = oneFuckingDrugNeedRefactor;
    }


}
