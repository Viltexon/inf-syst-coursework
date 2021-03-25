package net.entities;

import net.entities.enums.InitiativeStatus;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "users")
public class Initiative extends BaseId{

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "user_id")
    private Integer user_id;

    @Column(name = "voting_days_left")
    private Integer voting_days_left;

    @Column(name = "implem_start_date")
    private Date implem_start_date;

    @Column(name = "budget")
    private Integer budget;

    @Column(name = "votes_num")
    private Integer votes_num;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private InitiativeStatus status;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getUser_id() {
        return user_id;
    }
    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getVoting_days_left() {
        return voting_days_left;
    }
    public void setVoting_days_left(Integer voting_days_left) {
        this.voting_days_left = voting_days_left;
    }

    public Date getImplem_start_date() {
        return implem_start_date;
    }
    public void setImplem_start_date(Date implem_start_date) {
        this.implem_start_date = implem_start_date;
    }

    public Integer getBudget() {
        return budget;
    }
    public void setBudget(Integer budget) {
        this.budget = budget;
    }

    public Integer getVotes_num() {
        return votes_num;
    }
    public void setVotes_num(Integer votes_num) {
        this.votes_num = votes_num;
    }

    public InitiativeStatus getStatus() {
        return status;
    }
    public void setStatus(InitiativeStatus status) {
        this.status = status;
    }

//    Builder


    @Override
    public String toString() {
        return "Initiative{" +
                "id = " + this.getIdentifier() +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", user_id='" + user_id + '\'' +
                ", voting_days_left='" + voting_days_left + '\'' +
                ", implem_start_date='" + implem_start_date + '\'' +
                ", budget='" + budget + '\'' +
                ", votes_num='" + votes_num + '\'' +
                ", status='" + status.toString() + '\'' +
                '}';
    }
}
