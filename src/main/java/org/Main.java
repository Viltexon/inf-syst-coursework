package org;

import org.dao.UserDAO;
import org.entities.User;
import org.entities.enums.UserStatus;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        // User test
        UserDAO userDao = new UserDAO();
        User user = new User();

        user.setIdentifier(1);
        user.setEmail("probe1@gmail.com");
        user.setLogin("Probe1");
        user.setPassword("123456");
        user.setStatus(UserStatus.valueOf("USER"));

        userDao.add(user);

        System.out.println(userDao.findAll());
        userDao.delete(1);
        System.out.println(userDao.findAll());

    }
}
