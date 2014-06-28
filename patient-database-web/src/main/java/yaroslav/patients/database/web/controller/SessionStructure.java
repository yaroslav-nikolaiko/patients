package yaroslav.patients.database.web.controller;

import yaroslav.patients.database.model.entity.User;
import yaroslav.patients.database.model.service.UserService;

import javax.ejb.EJB;
import javax.inject.Inject;
import java.io.Serializable;

/**
 * Created by yaroslav on 6/28/14.
 */
public class SessionStructure implements Serializable {
    @EJB    UserService userService;
    @Inject UserBean userBean;

    User user;
}
