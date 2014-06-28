package yaroslav.patients.database.web.controller;

import yaroslav.patients.database.model.entity.User;
import yaroslav.patients.database.model.service.UserService;
import yaroslav.patients.database.web.exception.WebException;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by yaroslav on 6/28/14.
 */
@Named
@RequestScoped
public class UserBean implements Serializable {
    @EJB UserService userService;
    User user;

    @PostConstruct
    void init(){
        user = new User();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User login() {
        User user = userService.find(this.user.getLogin(), this.user.getPassword());
        if(user!=null){
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", user.getLogin());
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            WebException e = new WebException("Loggin Error", FacesMessage.SEVERITY_WARN);
            e.setExplanation("Invalid credentials");
            throw e;
        }
        return user;
    }

    public void validateLogin(FacesContext context, UIComponent component, Object value){
        String name = (String) value;
        if(userService.loginExist(name)){
            FacesMessage message = new FacesMessage("Login "+name+" already exist");
            throw new ValidatorException(message);
        }
    }

}
