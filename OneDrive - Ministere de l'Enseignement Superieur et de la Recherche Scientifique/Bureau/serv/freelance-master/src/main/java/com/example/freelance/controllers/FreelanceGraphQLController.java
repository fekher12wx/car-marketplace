package com.example.freelance.controllers;

import com.example.freelance.entities.*;
import com.example.freelance.services.CompetenceService;
import com.example.freelance.services.FreelanceService;
import com.example.freelance.services.LienProfessionnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class FreelanceGraphQLController {

    @Autowired
    private FreelanceService freelanceService;

    @Autowired
    private CompetenceService competenceService;

    @Autowired
    private LienProfessionnelService lienService;

    // ========== QUERIES ==========

    @QueryMapping
    public List<Freelance> freelances() {
        return freelanceService.getAllFreelances();
    }

    @QueryMapping
    public Freelance freelance(@Argument String id) {
        Optional<Freelance> freelance = freelanceService.getFreelanceById(Long.parseLong(id));
        return freelance.orElse(null);
    }

    @QueryMapping
    public List<Freelance> freelancesDisponibles() {
        return freelanceService.getFreelancesDisponibles();
    }

    @QueryMapping
    public List<Freelance> freelancesByVille(@Argument String ville) {
        return freelanceService.getFreelancesByVille(ville);
    }

    @QueryMapping
    public List<Freelance> freelancesByCompetence(@Argument String competence) {
        return freelanceService.getFreelancesByCompetence(competence);
    }

    @QueryMapping
    public List<Competence> competences() {
        return competenceService.getAllCompetences();
    }

    @QueryMapping
    public List<LienProfessionnel> liens() {
        return lienService.getAllLiens();
    }

    // ========== MUTATIONS ==========

    @MutationMapping
    public Freelance createFreelance(
            @Argument String nom,
            @Argument String prenom,
            @Argument String email,
            @Argument String telephone,
            @Argument String bio,
            @Argument String ville,
            @Argument Double tarifHoraire) {

        Freelance freelance = new Freelance();
        freelance.setNom(nom);
        freelance.setPrenom(prenom);
        freelance.setEmail(email);
        freelance.setTelephone(telephone);
        freelance.setBio(bio);
        freelance.setVille(ville);
        freelance.setTarifHoraire(tarifHoraire);
        freelance.setDisponible(true);

        return freelanceService.createFreelance(freelance);
    }

    @MutationMapping
    public Freelance updateFreelance(
            @Argument String id,
            @Argument String nom,
            @Argument String prenom,
            @Argument String email,
            @Argument String telephone,
            @Argument String bio,
            @Argument String ville,
            @Argument Double tarifHoraire,
            @Argument Boolean disponible) {

        Optional<Freelance> existingFreelance = freelanceService.getFreelanceById(Long.parseLong(id));
        if (existingFreelance.isEmpty()) {
            return null;
        }

        Freelance freelance = existingFreelance.get();
        if (nom != null) freelance.setNom(nom);
        if (prenom != null) freelance.setPrenom(prenom);
        if (email != null) freelance.setEmail(email);
        if (telephone != null) freelance.setTelephone(telephone);
        if (bio != null) freelance.setBio(bio);
        if (ville != null) freelance.setVille(ville);
        if (tarifHoraire != null) freelance.setTarifHoraire(tarifHoraire);
        if (disponible != null) freelance.setDisponible(disponible);

        return freelanceService.updateFreelance(freelance);
    }

    @MutationMapping
    public Boolean deleteFreelance(@Argument String id) {
        try {
            if (!freelanceService.existsById(Long.parseLong(id))) {
                return false;
            }
            freelanceService.deleteFreelance(Long.parseLong(id));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @MutationMapping
    public Competence addCompetence(
            @Argument String freelanceId,
            @Argument String nom,
            @Argument NiveauCompetence niveau,
            @Argument Integer anneesExperience) {

        Optional<Freelance> freelance = freelanceService.getFreelanceById(Long.parseLong(freelanceId));
        if (freelance.isEmpty()) {
            return null;
        }

        Competence competence = new Competence();
        competence.setNom(nom);
        competence.setNiveau(niveau);
        competence.setAnneesExperience(anneesExperience);
        competence.setFreelance(freelance.get());

        return competenceService.createCompetence(competence);
    }

    @MutationMapping
    public LienProfessionnel addLienProfessionnel(
            @Argument String freelanceId,
            @Argument TypeLien type,
            @Argument String url,
            @Argument String titre) {

        Optional<Freelance> freelance = freelanceService.getFreelanceById(Long.parseLong(freelanceId));
        if (freelance.isEmpty()) {
            return null;
        }

        LienProfessionnel lien = new LienProfessionnel();
        lien.setType(type);
        lien.setUrl(url);
        lien.setTitre(titre);
        lien.setFreelance(freelance.get());

        return lienService.createLien(lien);
    }

    @MutationMapping
    public Boolean deleteCompetence(@Argument String id) {
        try {
            competenceService.deleteCompetence(Long.parseLong(id));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @MutationMapping
    public Boolean deleteLienProfessionnel(@Argument String id) {
        try {
            lienService.deleteLien(Long.parseLong(id));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
