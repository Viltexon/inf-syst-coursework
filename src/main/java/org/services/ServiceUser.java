package org.services;

import org.dao.UserDAO;
import org.entities.User;
//import org.entities.enums.UserStatus;

public class ServiceUser {
    public Boolean login (String email, String password){
        UserDAO userDAO = new UserDAO();
        User user = userDAO.find(email);

        if (user.getIdentifier() != 0) {
            return user.getPassword().equals(password);
        }
        return false;
    }

    public User getUser (String email){
        UserDAO daoUser = new UserDAO();
        return daoUser.find(email);
    }
}
