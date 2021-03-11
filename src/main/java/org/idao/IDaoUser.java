package org.idao;

import org.entities.User;
import org.entities.enums.UserStatus;

import java.util.List;

public interface IDaoUser {

    void add(User user);
    void delete(int id);
    List<User> findAll();
    User find(String email);

}
