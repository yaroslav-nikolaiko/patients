package yaroslav.patients.database.web.controller;

import yaroslav.patients.database.model.entity.Drug;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by yaroslav on 6/29/14.
 */
@RequestScoped
@Named
public class DrugBean implements Serializable {
    Drug drug;

    @PostConstruct
    void init(){
        drug = new Drug();
    }

    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }
}
