package com.example.freelance.repository;

import com.example.freelance.entities.Competence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompetenceRepository extends JpaRepository<Competence, Long> {

    List<Competence> findByFreelanceId(Long freelanceId);

    List<Competence> findByNomContainingIgnoreCase(String nom);
}
