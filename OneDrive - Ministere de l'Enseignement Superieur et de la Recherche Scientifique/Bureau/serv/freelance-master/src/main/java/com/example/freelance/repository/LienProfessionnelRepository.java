package com.example.freelance.repository;

import com.example.freelance.entities.LienProfessionnel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LienProfessionnelRepository extends JpaRepository<LienProfessionnel, Long> {

    List<LienProfessionnel> findByFreelanceId(Long freelanceId);
}
