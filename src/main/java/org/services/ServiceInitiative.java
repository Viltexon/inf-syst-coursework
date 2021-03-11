package org.services;

import org.dao.InitiativeDAO;
import org.entities.Initiative;
import org.entities.enums.InitiativeStatus;

import java.util.List;

public class ServiceInitiative {

    public Boolean addInitiative (String name, String description, Integer user_id, Integer budget){
        try {
            Initiative initiative = new Initiative();
            initiative.setName(name);
            initiative.setDescription(description);
            initiative.setUser_id(user_id);
            initiative.setBudget(budget);

            initiative.setVotes_num(0);
            initiative.setStatus(InitiativeStatus.valueOf("pre_vote"));

            InitiativeDAO initiativeDAO = new InitiativeDAO();
            initiativeDAO.addNew(initiative);
            return true;
        } catch (Exception e) {
            System.out.println("Something went wrong.");
            return false;
        }
    }

    public List<Initiative> findAll (){
        InitiativeDAO daoInitiative = new InitiativeDAO();
        return daoInitiative.findAll();
    }

    public void updateVotes (){
        InitiativeDAO daoInitiative = new InitiativeDAO();
        daoInitiative.update();
    }
}
