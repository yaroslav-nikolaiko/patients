package yaroslav.patients.database.web.controller;

import yaroslav.patients.database.model.entity.Patient;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by yaroslav on 6/29/14.
 */
@Named
@RequestScoped
public class PatientBean implements Serializable {
    Patient patient;

    @PostConstruct
    void init() {
        patient = new Patient();
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

}
