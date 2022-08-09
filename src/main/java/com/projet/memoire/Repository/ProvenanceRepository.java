package com.projet.memoire.Repository;

import com.projet.memoire.Models.Provenance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProvenanceRepository extends JpaRepository<Provenance, Long> {
    public Provenance findByEmailId(String emailId);
    public Provenance findByEmailIdAndPassword(String emailId, String password);
}
