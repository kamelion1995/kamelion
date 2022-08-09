package com.projet.memoire.Repository;

import com.projet.memoire.Models.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository  extends JpaRepository<Profile, Long> {
}
