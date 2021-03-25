package net.services;

import net.dao.UserDao;
import net.entities.User;
import net.entities.enums.UserStatus;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.Assert.*;

@SpringBootTest
public class UserRestControllerTest {
//    @Autowired
//    private UserDao dao;
//    private User testUser = null;
//    private final String testLogin = "TestUser";
//    private final String testPassword = "123456";
//
//
//
//    @Test
//    public void daoAdd(){
//        User testUser = new User();
//        testUser.setIdentifier(2);
//        testUser.setEmail("probe1@gmail.com");
//        testUser.setLogin("Probe1");
//        testUser.setPassword("123456");
//        testUser.setStatus(UserStatus.valueOf("USER"));
//        dao.add(testUser);
//        assertNotNull(testUser);
//    }
//
//    @Test
//    public void daoView() {
////        var userslistBeforeAdd = dao.findAll().size();
////        var user = dao.add(new User("ggsdfb", "hbjgd"));
////        assertThat(user, notNullValue());
////        var userslistAfterAdd = dao.findAll().size();
////        assert(userslistBeforeAdd + 1 == userslistAfterAdd);
////        dao.delete(user);
////        var userslistAfterDelete = dao.findAll().size();
////        assert(userslistBeforeAdd == userslistAfterDelete);
//        System.out.println(dao.getAll());
//    }
}