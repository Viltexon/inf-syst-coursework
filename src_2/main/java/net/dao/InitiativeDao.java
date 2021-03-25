package net.dao;

import lombok.extern.slf4j.Slf4j;
import net.entities.Initiative;
import net.idao.IDaoInitiative;
import net.repositories.InitiativeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class InitiativeDao implements IDaoInitiative {

    @Autowired
    InitiativeRepository initiativeRepository;

    @Override
    public Initiative getById(Integer id) {
        log.info("IN InitiativeServiceImpl getById {}", id);
        return initiativeRepository.findOne(id);
    }

    @Override
    public void add(Initiative initiative) {
        log.info("IN InitiativeServiceImpl save {}", initiative);
        initiativeRepository.save(initiative);
    }

    @Override
    public Initiative update(Initiative initiative) {
        return null;
    }

    @Override
    public void delete(Integer id) {
        log.info("IN InitiativeServiceImpl delete {}", id);
        initiativeRepository.delete(id);
    }

    @Override
    public List<Initiative> getAll() {
        log.info("IN InitiativeServiceImpl getAll");
        return initiativeRepository.findAll();
    }
}
