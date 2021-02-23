package org.entities;

import org.entities.enums.UserStatus;

public class User extends BaseId{

    private String email;
    private String login;
    private String password;
    private UserStatus status;

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public UserStatus getStatus() {
        return status;
    }
    public void setStatus(UserStatus status) {
        this.status = status;
    }

    public static class Builder {
        private User user;

        public Builder() {
            user = new User();
        }

        public Builder id(Integer id) {
            user.setIdentifier(id);
            return this;
        }
        public Builder email(String email) {
            user.setEmail(email);
            return this;
        }
        public Builder login(String login) {
            user.setLogin(login);
            return this;
        }
        public Builder password(String password) {
            user.setPassword(password);
            return this;
        }
        public Builder status(UserStatus status) {
            user.setStatus(status);
            return this;
        }

        public User build() {
            return user;
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "id = " + this.getIdentifier() +
                ", email='" + email + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", status='" + status.toString() + '\'' +
                '}';
    }
}

