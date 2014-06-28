package yaroslav.patients.database.model.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yaroslav on 6/26/14.
 */


@Entity
@Table(name = "\"USER\"")
@NamedQueries({@NamedQuery(name=User.FIND_BY_LOGIN_AND_PASSWORD, query = "SELECT u from User u WHERE u.login=?1 AND u.password=?2"),
               @NamedQuery(name=User.COUNT_BY_LOGIN, query = "SELECT COUNT(u.login) FROM User u WHERE u.login=:login")})
public class User {
    public static final String FIND_BY_LOGIN_AND_PASSWORD = "User.findByLoginAndPassword";
    public static final String COUNT_BY_LOGIN = "User.countByLogin";

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String login;
    @Column(nullable = false)
    private String password;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "USER_FK")
    private List<Patient> patients;

    public User() {
        patients = new ArrayList<>();
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public void removePatient(Patient patient) {
        patients.remove(patient);
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }
}
