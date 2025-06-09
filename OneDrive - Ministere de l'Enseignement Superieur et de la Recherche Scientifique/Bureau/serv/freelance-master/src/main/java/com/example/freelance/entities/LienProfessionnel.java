package com.example.freelance.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "liens_professionnels")
public class LienProfessionnel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private TypeLien type;

    @Column(name = "url", nullable = false)
    private String url;

    @Column(name = "titre")
    private String titre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "freelance_id", nullable = false)
    private Freelance freelance;

    // Constructors
    public LienProfessionnel() {}

    public LienProfessionnel(TypeLien type, String url, Freelance freelance) {
        this.type = type;
        this.url = url;
        this.freelance = freelance;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TypeLien getType() {
        return type;
    }

    public void setType(TypeLien type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Freelance getFreelance() {
        return freelance;
    }

    public void setFreelance(Freelance freelance) {
        this.freelance = freelance;
    }

    @Override
    public String toString() {
        return "LienProfessionnel{" +
                "id=" + id +
                ", type=" + type +
                ", url='" + url + '\'' +
                ", titre='" + titre + '\'' +
                '}';
    }
}
