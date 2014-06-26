package yaroslav.patients.database.model.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
* Created by yaroslav on 6/26/14.
*/
@Entity
@Table(name = "DIAGNOSIS")
public class Diagnosis {
    @Id
    @GeneratedValue
    private Long id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    private String text;
    @ManyToMany
    @JoinTable(joinColumns = {@JoinColumn(name = "DIAGNOSTIC_ID")},
                inverseJoinColumns = {@JoinColumn(name = "DRUG_ID")})
    private List<Drug> drugs;

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
}
