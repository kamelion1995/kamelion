package com.projet.memoire.Repository;

import com.projet.memoire.Models.Agent;
import com.projet.memoire.Models.Provenance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgentRepository extends JpaRepository<Agent, Long> {

    public Agent findByEmailId(String emailId);
    public Agent findByEmailIdAndPassword(String emailId, String password);
}
