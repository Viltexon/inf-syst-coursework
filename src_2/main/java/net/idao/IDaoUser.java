package net.idao;

import net.entities.User;

public interface IDaoUser extends IDaoBase<User> {
    User findByLogin(String login);
}
