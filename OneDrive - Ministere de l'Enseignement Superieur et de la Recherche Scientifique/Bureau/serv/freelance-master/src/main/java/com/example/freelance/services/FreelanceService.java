package com.example.freelance.services;

import com.example.freelance.entities.Freelance;
import com.example.freelance.repository.FreelanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FreelanceService {

    @Autowired
    private FreelanceRepository freelanceRepository;

    public List<Freelance> getAllFreelances() {
        return freelanceRepository.findAll();
    }

    public Optional<Freelance> getFreelanceById(Long id) {
        return freelanceRepository.findById(id);
    }

    public Optional<Freelance> getFreelanceByEmail(String email) {
        return freelanceRepository.findByEmail(email);
    }

    public List<Freelance> getFreelancesDisponibles() {
        return freelanceRepository.findByDisponible(true);
    }

    public List<Freelance> getFreelancesByVille(String ville) {
        return freelanceRepository.findByVilleContainingIgnoreCase(ville);
    }

    public List<Freelance> getFreelancesByCompetence(String competence) {
        return freelanceRepository.findByCompetence(competence);
    }

    public Freelance createFreelance(Freelance freelance) {
        return freelanceRepository.save(freelance);
    }

    public Freelance updateFreelance(Freelance freelance) {
        return freelanceRepository.save(freelance);
    }

    public void deleteFreelance(Long id) {
        freelanceRepository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return freelanceRepository.existsById(id);
    }
}
