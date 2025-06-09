package com.example.freelance.config;

import com.example.freelance.entities.*;
import com.example.freelance.services.CompetenceService;
import com.example.freelance.services.FreelanceService;
import com.example.freelance.services.LienProfessionnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private FreelanceService freelanceService;

    @Autowired
    private CompetenceService competenceService;

    @Autowired
    private LienProfessionnelService lienService;

    @Override
    public void run(String... args) throws Exception {
        if (freelanceService.getAllFreelances().isEmpty()) {
            // Créer des freelances de test

            // Freelance 1: Développeur Full-Stack
            Freelance dev1 = new Freelance();
            dev1.setNom("fekher");
            dev1.setPrenom("yahya");
            dev1.setEmail("fekheryahya@email.com");
            dev1.setTelephone("+94791352");
            dev1.setBio("Développeur Full-Stack avec 5 ans d'expérience en React et Spring Boot");
            dev1.setVille("Paris");
            dev1.setTarifHoraire(65.0);
            dev1.setDisponible(true);
            dev1 = freelanceService.createFreelance(dev1);

            // Compétences pour dev1
            Competence comp1 = new Competence("Java", NiveauCompetence.EXPERT, dev1);
            comp1.setAnneesExperience(5);
            competenceService.createCompetence(comp1);

            Competence comp2 = new Competence("React", NiveauCompetence.AVANCE, dev1);
            comp2.setAnneesExperience(3);
            competenceService.createCompetence(comp2);

            Competence comp3 = new Competence("Spring Boot", NiveauCompetence.EXPERT, dev1);
            comp3.setAnneesExperience(4);
            competenceService.createCompetence(comp3);

            // Liens pour dev1
            LienProfessionnel lien1 = new LienProfessionnel(TypeLien.LINKEDIN, "https://linkedin.com/in/fekher", dev1);
            lien1.setTitre("Profil LinkedIn");
            lienService.createLien(lien1);

            LienProfessionnel lien2 = new LienProfessionnel(TypeLien.GITHUB, "https://github.com/fekher", dev1);
            lien2.setTitre("Projets GitHub");
            lienService.createLien(lien2);

            // Freelance 2: Designer UI/UX
            Freelance designer1 = new Freelance();
            designer1.setNom("baha");
            designer1.setPrenom("baha");
            designer1.setEmail("baha@email.com");
            designer1.setTelephone("+24685975");
            designer1.setBio("Designer UI/UX passionnée par l'expérience utilisateur et le design thinking");
            designer1.setVille("Lyon");
            designer1.setTarifHoraire(55.0);
            designer1.setDisponible(true);
            designer1 = freelanceService.createFreelance(designer1);

            // Compétences pour designer1
            Competence comp4 = new Competence("Figma", NiveauCompetence.EXPERT, designer1);
            comp4.setAnneesExperience(4);
            competenceService.createCompetence(comp4);

            Competence comp5 = new Competence("Adobe XD", NiveauCompetence.AVANCE, designer1);
            comp5.setAnneesExperience(3);
            competenceService.createCompetence(comp5);

            Competence comp6 = new Competence("Prototypage", NiveauCompetence.EXPERT, designer1);
            comp6.setAnneesExperience(5);
            competenceService.createCompetence(comp6);

            // Liens pour designer1
            LienProfessionnel lien3 = new LienProfessionnel(TypeLien.BEHANCE, "https://behance.net/baha", designer1);
            lien3.setTitre("Portfolio Behance");
            lienService.createLien(lien3);

            LienProfessionnel lien4 = new LienProfessionnel(TypeLien.PORTFOLIO, "https://baha-design.com", designer1);
            lien4.setTitre("Site Portfolio");
            lienService.createLien(lien4);

            // Freelance 3: Data Scientist
            Freelance datascientist = new Freelance();
            datascientist.setNom("iheb");
            datascientist.setPrenom("iheb");
            datascientist.setEmail("iheb@email.com");
            datascientist.setTelephone("+947854795");
            datascientist.setBio("Data Scientist spécialisé en Machine Learning et analyse prédictive");
            datascientist.setVille("Toulouse");
            datascientist.setTarifHoraire(75.0);
            datascientist.setDisponible(false);
            datascientist = freelanceService.createFreelance(datascientist);

            // Compétences pour datascientist
            Competence comp7 = new Competence("Python", NiveauCompetence.EXPERT, datascientist);
            comp7.setAnneesExperience(6);
            competenceService.createCompetence(comp7);

            Competence comp8 = new Competence("Machine Learning", NiveauCompetence.EXPERT, datascientist);
            comp8.setAnneesExperience(4);
            competenceService.createCompetence(comp8);

            Competence comp9 = new Competence("TensorFlow", NiveauCompetence.AVANCE, datascientist);
            comp9.setAnneesExperience(3);
            competenceService.createCompetence(comp9);

            // Liens pour datascientist
            LienProfessionnel lien5 = new LienProfessionnel(TypeLien.GITHUB, "https://github.com/iheb", datascientist);
            lien5.setTitre("Projets Data Science");
            lienService.createLien(lien5);

            LienProfessionnel lien6 = new LienProfessionnel(TypeLien.LINKEDIN, "https://linkedin.com/in/iheb", datascientist);
            lien6.setTitre("Profil LinkedIn");
            lienService.createLien(lien6);

            System.out.println("✅ Données de test créées avec succès!");
            System.out.println("📊 3 freelances créés avec leurs compétences et liens");
        }
    }
}
