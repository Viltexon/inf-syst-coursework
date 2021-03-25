package net.dao;

import lombok.extern.slf4j.Slf4j;
import net.entities.Vote;
import net.idao.IDaoVote;
import net.repositories.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class VoteDao implements IDaoVote {

    @Autowired
    VoteRepository voteRepository;


    @Override
    public Vote getById(Integer id) {
        log.info("IN VoteServiceImpl getById {}", id);
        return voteRepository.findOne(id);
    }

    @Override
    public void add(Vote vote) {
        log.info("IN VoteServiceImpl save {}", vote);
        voteRepository.save(vote);
    }

    @Override
    public Vote update(Vote vote) {
        return null;
    }

    @Override
    public void delete(Integer id) {
        log.info("IN VoteServiceImpl delete {}", id);
        voteRepository.delete(id);
    }

    @Override
    public List<Vote> getAll() {
        log.info("IN VoteServiceImpl getAll");
        return voteRepository.findAll();
    }
}
