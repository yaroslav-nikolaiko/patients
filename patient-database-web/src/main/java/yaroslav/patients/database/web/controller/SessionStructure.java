package yaroslav.patients.database.web.controller;

import yaroslav.patients.database.model.entity.Drug;
import yaroslav.patients.database.model.entity.Patient;
import yaroslav.patients.database.model.entity.User;
import yaroslav.patients.database.model.service.DrugService;
import yaroslav.patients.database.model.utils.Sex;

import javax.ejb.EJB;
import javax.enterprise.inject.Produces;
import javax.interceptor.ExcludeClassInterceptors;
import javax.interceptor.ExcludeDefaultInterceptors;
import java.io.Serializable;
import java.util.List;

/**
 * Created by yaroslav on 6/28/14.
 */
@ExcludeDefaultInterceptors
public class SessionStructure implements Serializable {
    @EJB
    DrugService drugService;

    User user;
    List<Patient> selectedPatients;
    List<Patient> filteredPatients;


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Patient> getSelectedPatients() {
        return selectedPatients;
    }

    public void setSelectedPatients(List<Patient> selectedPatients) {
        this.selectedPatients = selectedPatients;
    }

    public Sex[] getAvailableSex(){
        return Sex.values();
    }

    public List<Patient> getFilteredPatients() {
        return filteredPatients;
    }

    public void setFilteredPatients(List<Patient> filteredPatients) {
        this.filteredPatients = filteredPatients;
    }


    @Produces
    public List<Drug> getAvailableDrugs(){
        return drugService.availableDrugs();
    }
}
