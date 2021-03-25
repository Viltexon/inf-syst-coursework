package net.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "reports")
public class Report extends BaseId{

    @Column(name = "init_id")
    private Integer init_id;

    @Column(name = "description")
    private String description;

    @Column(name = "implem_end_date")
    private Date implem_end_date;

    @Column(name = "end_budget")
    private Integer end_budget;

    public Integer getInit_id() {
        return init_id;
    }
    public void setInit_id(Integer init_id) {
        this.init_id = init_id;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public Date getImplem_end_date() {
        return implem_end_date;
    }
    public void setImplem_end_date(Date implem_end_date) {
        this.implem_end_date = implem_end_date;
    }

    public Integer getEnd_budget() {
        return end_budget;
    }
    public void setEnd_budget(Integer end_budget) {
        this.end_budget = end_budget;
    }

//    Builder


    @Override
    public String toString() {
        return "Report{" +
                "id = " + this.getIdentifier() +
                ", init_id='" + init_id + '\'' +
                ", description='" + description + '\'' +
                ", implem_end_date='" + implem_end_date + '\'' +
                ", end_budget='" + end_budget + '\'' +
                '}';
    }

}
