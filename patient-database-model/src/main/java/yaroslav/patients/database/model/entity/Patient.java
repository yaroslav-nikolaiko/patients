package yaroslav.patients.database.model.entity;


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
@NamedQueries({@NamedQuery(name=Patient.FIND_BY_FIRST_NAME, query = "SELECT p FROM Patient p WHERE p.firstName=?1"),
               @NamedQuery(name=Patient.FIND_BY_FIRST_AND_LAST_NAME, query = "SELECT p FROM Patient p WHERE p.firstName=?1 AND p.lastName=?2")})
public class Patient {
    public static final String FIND_BY_FIRST_NAME = "FIND_BY_FIRST_NAME";
    public static final String FIND_BY_FIRST_AND_LAST_NAME = "FIND_BY_FIRST_AND_LAST_NAME";

    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    private Integer age;
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

    public void addDiagnose(Diagnose diagnose){
        diagnosises.add(diagnose);
    }

    public void removeDiagnose(Diagnose diagnose) {
        diagnosises.remove(diagnose);
    }

    public boolean existDiagnose(Diagnose diagnose){
        return diagnosises.contains(diagnose);
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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
}
