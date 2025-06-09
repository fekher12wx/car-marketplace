package com.example.freelance.services;

import com.example.freelance.entities.Competence;
import com.example.freelance.repository.CompetenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompetenceService {

    @Autowired
    private CompetenceRepository competenceRepository;

    public List<Competence> getAllCompetences() {
        return competenceRepository.findAll();
    }

    public Optional<Competence> getCompetenceById(Long id) {
        return competenceRepository.findById(id);
    }

    public List<Competence> getCompetencesByFreelance(Long freelanceId) {
        return competenceRepository.findByFreelanceId(freelanceId);
    }

    public Competence createCompetence(Competence competence) {
        return competenceRepository.save(competence);
    }

    public Competence updateCompetence(Competence competence) {
        return competenceRepository.save(competence);
    }

    public void deleteCompetence(Long id) {
        competenceRepository.deleteById(id);
    }
}
