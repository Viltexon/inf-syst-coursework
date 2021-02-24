package org.idao;

import org.entities.Report;

import java.util.List;

public interface IDaoReport {

    void add(Report report);
    void delete(int id);
    List<Report> findAll();

}
