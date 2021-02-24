package org.idao;

import org.entities.Vote;

import java.util.List;

public interface IDaoVote {

    void add(Vote vote);
    void delete(int id);
    List<Vote> findAll();

}
