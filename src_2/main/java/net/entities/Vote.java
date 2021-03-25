package net.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "votes")
public class Vote extends BaseId{

    @Column(name = "init_id")
    private Integer init_id;

    @Column(name = "user_id")
    private Integer user_id;

    public Integer getInit_id() {
        return init_id;
    }
    public void setInit_id(Integer init_id) {
        this.init_id = init_id;
    }

    public Integer getUser_id() {
        return user_id;
    }
    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    //    Builder


    @Override
    public String toString() {
        return "Vote{" +
                "id = " + this.getIdentifier() +
                ", init_id='" + init_id + '\'' +
                ", user_id='" + user_id + '\'' +
                '}';
    }
}
