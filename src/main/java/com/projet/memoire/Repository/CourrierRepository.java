package com.projet.memoire.Repository;

import com.projet.memoire.Models.Courrier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourrierRepository extends JpaRepository<Courrier, Long> {
}
