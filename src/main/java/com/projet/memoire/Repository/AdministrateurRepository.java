package com.projet.memoire.Repository;

import com.projet.memoire.Models.Administrateur;
import com.projet.memoire.Models.Agent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministrateurRepository extends JpaRepository<Administrateur, Long> {

    public Administrateur findByEmailId(String emailId);
    public Administrateur findByEmailIdAndPassword(String emailId, String password);
}
