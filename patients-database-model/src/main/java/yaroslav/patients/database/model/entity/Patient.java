package yaroslav.patients.database.model.entity;


import yaroslav.patients.database.model.utils.Sex;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
* Created by yaroslav on 6/26/14.
*/
@Entity
@Table(name = "PATIENT")
public class Patient {
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
    private List<Diagnosis> diagnosises;

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

    public List<Diagnosis> getDiagnosises() {
        return diagnosises;
    }

    public void setDiagnosises(List<Diagnosis> diagnosises) {
        this.diagnosises = diagnosises;
    }
}
