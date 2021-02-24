package org;


import org.entities.User;
import org.dao.UserDAO;
import org.entities.enums.UserStatus;

import org.dao.InitiativeDAO;
import org.entities.Initiative;
import org.entities.enums.InitiativeStatus;

import org.dao.ReportDAO;
import org.entities.Report;

import org.entities.Vote;
import org.dao.VoteDAO;

import java.sql.Date;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        // User test
        UserDAO userDao = new UserDAO();
        User user = new User();

        user.setIdentifier(1);
        user.setEmail("probe1@gmail.com");
        user.setLogin("Probe1");
        user.setPassword("123456");
        user.setStatus(UserStatus.valueOf("USER"));

        userDao.add(user);

        InitiativeDAO initiativeDAO = new InitiativeDAO();
        Initiative initiative = new Initiative();

        initiative.setIdentifier(1);
        initiative.setName("Probe1");
        initiative.setDescription("Awesome initiative 10/10!");
        initiative.setUser_id(1);
        initiative.setVoting_days_left(5);
        initiative.setImplem_start_date(Date.valueOf("2014-11-16"));
        initiative.setBudget(2000);
        initiative.setVotes_num(0);
        initiative.setStatus(InitiativeStatus.valueOf("pre_vote"));

        initiativeDAO.add(initiative);

        ReportDAO reportDAO = new ReportDAO();
        Report report = new Report();

        report.setIdentifier(1);
        report.setInit_id(1);
        report.setDescription("Ended nicely");
        report.setImplem_end_date(Date.valueOf("2020-02-24"));
        report.setEnd_budget(2000);

        reportDAO.add(report);

        VoteDAO voteDAO = new VoteDAO();
        Vote vote = new Vote();

        vote.setIdentifier(1);
        vote.setInit_id(1);
        vote.setUser_id(1);

        voteDAO.add(vote);

        System.out.println(userDao.findAll());
        System.out.println(initiativeDAO.findAll());
        System.out.println(reportDAO.findAll());
        System.out.println(voteDAO.findAll());
        initiativeDAO.delete(1);
        userDao.delete(1);
        reportDAO.delete(1);
        voteDAO.delete(1);
        System.out.println(userDao.findAll());
        System.out.println(initiativeDAO.findAll());
        System.out.println(reportDAO.findAll());
        System.out.println(voteDAO.findAll());

    }
}
