package com.projet.memoire.Repository;

import com.projet.memoire.Models.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository  extends JpaRepository<Service, Long> {
}
