package yaroslav.patients.database.model.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
* Created by yaroslav on 6/26/14.
*/
@Entity
@Table(name = "DIAGNOSIS")
public class Diagnose {
    @Id
    @GeneratedValue
    private Long id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    private String text;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(joinColumns = {@JoinColumn(name = "DIAGNOSTIC_ID")},
                inverseJoinColumns = {@JoinColumn(name = "DRUG_ID")})
    private List<Drug> drugs;

    public Diagnose() {
        drugs = new ArrayList<>();
    }

    public void addDrug(Drug drug) {
        drugs.add(drug);
    }

    public void addDrugs(Collection<Drug> drugs) {
        this.drugs.addAll(drugs);
    }

    public void removeDrug(Drug drug) {
        drugs.remove(drug);
    }

    public void removeDrugs(Collection<Drug> drugs ) {
        this.drugs.removeAll(drugs);
    }

    /********************************************************************************************
     *                                              Getters and Setters
     ********************************************************************************************/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Drug> getDrugs() {
        return drugs;
    }

    public void setDrugs(List<Drug> drugs) {
        this.drugs = drugs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Diagnose diagnose = (Diagnose) o;

        if (text != null ? !text.equals(diagnose.text) : diagnose.text != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return text != null ? text.hashCode() : 0;
    }
}
