package yaroslav.patients.database.web.controller;

import yaroslav.patients.database.model.entity.Diagnose;
import yaroslav.patients.database.model.entity.Drug;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by yaroslav on 7/5/14.
 */
@Named
@RequestScoped
public class DiagnoseBean implements Serializable{
    Diagnose diagnose;

    @PostConstruct
    void init(){
        diagnose = new Diagnose();
    }

    public Diagnose getDiagnose() {
        return diagnose;
    }

    public void setDiagnose(Diagnose diagnose) {
        this.diagnose = diagnose;
    }
}
