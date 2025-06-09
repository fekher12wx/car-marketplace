package com.example.freelance.entities;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "freelances")
public class Freelance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom", nullable = false)
    private String nom;

    @Column(name = "prenom", nullable = false)
    private String prenom;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "telephone")
    private String telephone;

    @Column(name = "bio", columnDefinition = "TEXT")
    private String bio;

    @Column(name = "ville")
    private String ville;

    @Column(name = "tarif_horaire")
    private Double tarifHoraire;

    @Column(name = "disponible")
    private Boolean disponible = true;

    @OneToMany(mappedBy = "freelance", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Competence> competences = new ArrayList<>();

    @OneToMany(mappedBy = "freelance", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<LienProfessionnel> liens = new ArrayList<>();

    // Constructors
    public Freelance() {}

    public Freelance(String nom, String prenom, String email) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public Double getTarifHoraire() {
        return tarifHoraire;
    }

    public void setTarifHoraire(Double tarifHoraire) {
        this.tarifHoraire = tarifHoraire;
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }

    public List<Competence> getCompetences() {
        return competences;
    }

    public void setCompetences(List<Competence> competences) {
        this.competences = competences;
    }

    public List<LienProfessionnel> getLiens() {
        return liens;
    }

    public void setLiens(List<LienProfessionnel> liens) {
        this.liens = liens;
    }

    @Override
    public String toString() {
        return "Freelance{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", ville='" + ville + '\'' +
                ", disponible=" + disponible +
                '}';
    }
}
