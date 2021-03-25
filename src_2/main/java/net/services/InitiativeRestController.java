package net.services;

import net.dao.InitiativeDao;
import net.entities.Initiative;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/initiatives")
public class InitiativeRestController {

    @Autowired
    InitiativeDao initiativeDao;

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Initiative> getInitiative(@PathVariable("id") Integer initiativeId) {
        if (initiativeId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Initiative initiative = initiativeDao.getById(initiativeId);

        if (initiative == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(initiative, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Initiative> saveInitiative(@RequestBody @Valid Initiative initiative) {
        HttpHeaders headers = new HttpHeaders();

        if (initiative == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.initiativeDao.add(initiative);

        return new ResponseEntity<>(initiative, headers, HttpStatus.OK);
    }


    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Initiative> deleteInitiative(@PathVariable("id") Integer id) {
        Initiative vote = this.initiativeDao.getById(id);

        if (vote == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.initiativeDao.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Initiative>> getAllInitiatives() {
        List<Initiative> votes = this.initiativeDao.getAll();

        if (votes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(votes, HttpStatus.OK);
    }
}
