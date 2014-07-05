package yaroslav.patients.database.web.controller;

import yaroslav.patients.database.model.entity.Patient;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by yaroslav on 7/2/14.
 */
@Named
@SessionScoped
public class PatientSessionController implements Serializable {
    Patient currentPatient;

    public Patient getCurrentPatient() {
        return currentPatient;
    }

    public void setCurrentPatient(Patient currentPatient) {
        this.currentPatient = currentPatient;
    }
}
