package yaroslav.patients.database.model.entity;

import org.joda.time.LocalDate;
import org.joda.time.Years;
import yaroslav.patients.database.model.utils.Sex;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
* Created by yaroslav on 6/26/14.
*/
@Entity
@Table(name = "PATIENT")
@NamedQueries({@NamedQuery(name=Patient.MAX_LOCAL_ID, query = "SELECT MAX(p.localId) FROM Patient p")})
public class Patient {
    public static final String MAX_LOCAL_ID = "MAX_LOCAL_ID";

    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private Integer localId;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Enumerated(EnumType.STRING)
    private Sex sex;
    @Temporal(TemporalType.DATE)
    private Date birthDay;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "PATIENT_FK")
    private List<Diagnose> diagnosises;

    public Patient() {
        diagnosises = new ArrayList<>();
    }

    public Patient(Integer localId){
        this.localId = localId;
    }

    public void addDiagnose(Diagnose diagnose){
        diagnosises.add(diagnose);
    }

    public void removeDiagnose(Diagnose diagnose) {
        diagnosises.remove(diagnose);
    }

    public boolean existDiagnose(Diagnose diagnose){
        return diagnosises.contains(diagnose);
    }

    public int getAge() {
        if(birthDay!=null)
            return Years.yearsBetween(new LocalDate(birthDay),new LocalDate()).getYears();
        return 0;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public List<Diagnose> getDiagnosises() {
        return diagnosises;
    }

    public void setDiagnosises(List<Diagnose> diagnosises) {
        this.diagnosises = diagnosises;
    }

    public Integer getLocalId() {
        return localId;
    }

    public void setLocalId(Integer localId) {
        this.localId = localId;
    }
}
