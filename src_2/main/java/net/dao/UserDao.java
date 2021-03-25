package net.dao;

import lombok.extern.slf4j.Slf4j;
import net.entities.User;
import net.idao.IDaoUser;
import net.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserDao implements IDaoUser {

    @Autowired
    UserRepository userRepository;

    @Override
    public User getById(Integer id) {
        log.info("IN UserServiceImpl getById {}", id);
        return userRepository.findOne(id);
    }

    @Override
    public void add(User user) {
        log.info("IN UserServiceImpl save {}", user);
        userRepository.save(user);
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public void delete(Integer id) {
        log.info("IN UserServiceImpl delete {}", id);
        userRepository.delete(id);
    }

    @Override
    public List<User> getAll() {
        log.info("IN UserServiceImpl getAll");
        return userRepository.findAll();
    }

    @Override
    public User findByLogin(String login) {
        return null;
    }
}
