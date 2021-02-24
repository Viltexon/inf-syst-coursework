package org.idao;

import org.entities.Initiative;
import org.entities.enums.InitiativeStatus;

import java.util.List;

public interface IDaoInitiative {

    void add(Initiative initiative);
    void delete(int id);
    List<Initiative> findAll();

}
