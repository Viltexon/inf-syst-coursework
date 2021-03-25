package net.repositories;

import net.entities.Initiative;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InitiativeRepository extends JpaRepository<Initiative, Integer> {
}
