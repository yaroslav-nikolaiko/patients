package yaroslav.patients.database.model.entity;

import javax.persistence.*;

/**
* Created by yaroslav on 6/26/14.
*/
@Entity
@NamedQueries({@NamedQuery(name=Drug.ALL_DRUGS, query = "SELECT d FROM Drug d")})
public class Drug {
    public static final String ALL_DRUGS = "ALL_DRUGS";
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Drug drug = (Drug) o;

        if (name != null ? !name.equals(drug.name) : drug.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
