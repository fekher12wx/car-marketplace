package com.example.freelance.repository;

import com.example.freelance.entities.Freelance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FreelanceRepository extends JpaRepository<Freelance, Long> {

    Optional<Freelance> findByEmail(String email);

    List<Freelance> findByDisponible(Boolean disponible);

    List<Freelance> findByVilleContainingIgnoreCase(String ville);

    @Query("SELECT f FROM Freelance f JOIN f.competences c WHERE c.nom LIKE %:competence%")
    List<Freelance> findByCompetence(@Param("competence") String competence);
}
