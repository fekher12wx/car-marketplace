package com.example.freelance.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "competences")
public class Competence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom", nullable = false)
    private String nom;

    @Enumerated(EnumType.STRING)
    @Column(name = "niveau", nullable = false)
    private NiveauCompetence niveau;

    @Column(name = "annees_experience")
    private Integer anneesExperience;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "freelance_id", nullable = false)
    private Freelance freelance;

    // Constructors
    public Competence() {}

    public Competence(String nom, NiveauCompetence niveau, Freelance freelance) {
        this.nom = nom;
        this.niveau = niveau;
        this.freelance = freelance;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public NiveauCompetence getNiveau() {
        return niveau;
    }

    public void setNiveau(NiveauCompetence niveau) {
        this.niveau = niveau;
    }

    public Integer getAnneesExperience() {
        return anneesExperience;
    }

    public void setAnneesExperience(Integer anneesExperience) {
        this.anneesExperience = anneesExperience;
    }

    public Freelance getFreelance() {
        return freelance;
    }

    public void setFreelance(Freelance freelance) {
        this.freelance = freelance;
    }

    @Override
    public String toString() {
        return "Competence{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", niveau=" + niveau +
                ", anneesExperience=" + anneesExperience +
                '}';
    }
}
