package org.services;

import org.dao.UserDAO;
import org.entities.User;

public class ServiceUser {
    public User getUser (String email){
        UserDAO daoUser = new UserDAO();
        return daoUser.find(email);
    }
}
