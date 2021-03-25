package net.services;


import net.dao.VoteDao;
import net.entities.Vote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/votes")
public class VoteRestController {

    @Autowired
    private VoteDao voteDao;

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Vote> getVote(@PathVariable("id") Integer voteId) {
        if (voteId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Vote vote = voteDao.getById(voteId);

        if (vote == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(vote, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Vote> saveVote(@RequestBody @Valid Vote vote) {
        HttpHeaders headers = new HttpHeaders();

        if (vote == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.voteDao.add(vote);

        return new ResponseEntity<>(vote, headers, HttpStatus.OK);
    }


    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Vote> deleteVote(@PathVariable("id") Integer id) {
        Vote vote = this.voteDao.getById(id);

        if (vote == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.voteDao.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Vote>> getAllVotes() {
        List<Vote> votes = this.voteDao.getAll();

        if (votes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(votes, HttpStatus.OK);
    }
}
