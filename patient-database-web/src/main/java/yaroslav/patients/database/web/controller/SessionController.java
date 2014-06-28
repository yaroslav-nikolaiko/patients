package yaroslav.patients.database.web.controller;

import yaroslav.patients.database.web.interceptor.DialogValidation;
import yaroslav.patients.database.web.interceptor.ValidationHandler;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by yaroslav on 6/28/14.
 */
@Named
@SessionScoped
public class SessionController extends SessionStructure implements Serializable {

    public String singUp(){
        user =  userBean.getUser();
        userService.addToDataBase(user);
        return "index?faces-redirect=true";
    }

    @ValidationHandler @DialogValidation
    public void login(){
        user =  userBean.login();
    }

}
