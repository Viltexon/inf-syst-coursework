package net.services;


import net.dao.ReportDao;
import net.entities.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/reports")
public class ReportRestController {

    @Autowired
    ReportDao reportDao;

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Report> getReport(@PathVariable("id") Integer reportId) {
        if (reportId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Report report = reportDao.getById(reportId);

        if (report == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(report, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Report> saveReport(@RequestBody @Valid Report report) {
        HttpHeaders headers = new HttpHeaders();

        if (report == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.reportDao.add(report);

        return new ResponseEntity<>(report, headers, HttpStatus.OK);
    }


    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Report> deleteReport(@PathVariable("id") Integer id) {
        Report report = this.reportDao.getById(id);

        if (report == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.reportDao.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Report>> getAllReports() {
        List<Report> reports = this.reportDao.getAll();

        if (reports.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(reports, HttpStatus.OK);
    }
}
