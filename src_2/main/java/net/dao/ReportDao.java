package net.dao;

import lombok.extern.slf4j.Slf4j;
import net.entities.Report;
import net.idao.IDaoReport;
import net.repositories.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ReportDao implements IDaoReport {

    @Autowired
    ReportRepository reportRepository;

    @Override
    public Report getById(Integer id) {
        log.info("IN ReportServiceImpl getById {}", id);
        return reportRepository.findOne(id);
    }

    @Override
    public void add(Report report) {
        log.info("IN ReportServiceImpl save {}", report);
        reportRepository.save(report);
    }

    @Override
    public Report update(Report report) {
        return null;
    }

    @Override
    public void delete(Integer id) {
        log.info("IN ReportServiceImpl delete {}", id);
        reportRepository.delete(id);
    }

    @Override
    public List<Report> getAll() {
        log.info("IN ReportServiceImpl getAll");
        return reportRepository.findAll();
    }
}
