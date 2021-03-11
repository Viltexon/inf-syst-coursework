package org.services;

import org.dao.UserDAO;
import org.entities.User;
//import org.entities.enums.UserStatus;

public class ServiceLogin {
    public Boolean login (String email, String password){
        UserDAO userDAO = new UserDAO();
        User user = userDAO.find(email);

        if (user.getIdentifier() != 0) {
            return user.getPassword().equals(password);
        }
        return false;
    }
}
