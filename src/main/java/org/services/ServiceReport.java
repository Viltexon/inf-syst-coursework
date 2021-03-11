package org.services;

import org.dao.ReportDAO;
import org.entities.Report;

import java.util.List;

public class ServiceReport {
    public List<Report> findAll (){
        ReportDAO daoReport = new ReportDAO();
        return daoReport.findAll();
    }
}
