package org.dao;

import org.entities.User;
import org.entities.enums.UserStatus;
import org.idao.IDaoUser;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends GenericDAO implements IDaoUser {

    public UserDAO() {

    }

    public void add(User user) {
        try {
            String queryString = "INSERT INTO users(user_id, email, login, password, status) VALUES(?,?,?,?,?)";
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            ptmt.setInt(1, user.getIdentifier());
            ptmt.setString(2, user.getEmail());
            ptmt.setString(3, user.getLogin());
            ptmt.setString(4, user.getPassword());
            ptmt.setString(5, user.getStatus().name());
            ptmt.executeUpdate();
            System.out.println("Data Added Successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ptmt != null)
                    ptmt.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void delete(int id) {

        try {
            String queryString = "DELETE FROM users WHERE user_id=?";
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            ptmt.setInt(1, id);
            ptmt.executeUpdate();
            System.out.println("Data deleted Successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ptmt != null)
                    ptmt.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public List<User> findAll() {
        List<User> userList = new ArrayList<>();

        try {
            String queryString = "SELECT * FROM users";
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            resultSet = ptmt.executeQuery();
            while (resultSet.next()) {
                User user = new User();

                user.setIdentifier(resultSet.getInt("user_id"));
                user.setEmail(resultSet.getString("email"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                user.setStatus(UserStatus.valueOf(resultSet.getString("status")));

                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null)
                    resultSet.close();
                if (ptmt != null)
                    ptmt.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return userList;
    }

    public User find(String email) {
        User user = new User();

        try {
            String queryString = "SELECT * FROM users WHERE email='" + email + "'";
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            resultSet = ptmt.executeQuery();

            while (resultSet.next()) {
                user.setIdentifier(resultSet.getInt("user_id"));
                user.setEmail(resultSet.getString("email"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                user.setStatus(UserStatus.valueOf(resultSet.getString("status")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null)
                    resultSet.close();
                if (ptmt != null)
                    ptmt.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return user;
    }
}
