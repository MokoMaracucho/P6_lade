package com.oc.p6_lade.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="Longueur")
public class Longueur {

    @Id
    @SequenceGenerator(
            name = "longueur_sequence",
            sequenceName = "longueur_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "longueur_sequence"
    )
    @Column(name="id_longueur", updatable=false)
    private Long idLongueur;

    @NotEmpty
    @Column(name="nom_longueur")
    private String nomLongueur;

    @NotEmpty
    @Column(name="cotation_longueur")
    private String cotationLongueur;

    @ManyToOne
    @OnDelete(action= OnDeleteAction.CASCADE)
    @JoinColumn(name="id_utilisateur")
    private Utilisateur utilisateur;

    @ManyToOne
    @OnDelete(action=OnDeleteAction.CASCADE)
    @JoinColumn(name="id_voie")
    private Voie voie;

    public Longueur() {
    }

    public Longueur(String nomLongueur, String cotationLongueur, Utilisateur utilisateur, Voie voie) {
        this.nomLongueur = nomLongueur;
        this.cotationLongueur = cotationLongueur;
        this.utilisateur = utilisateur;
        this.voie = voie;
    }

    public Longueur(Long idLongueur, String nomLongueur, String cotationLongueur, Utilisateur utilisateur, Voie voie) {
        this.idLongueur = idLongueur;
        this.nomLongueur = nomLongueur;
        this.cotationLongueur = cotationLongueur;
        this.utilisateur = utilisateur;
        this.voie = voie;
    }

    public Long getIdLongueur() {
        return idLongueur;
    }

    public void setIdLongueur(Long idLongueur) {
        this.idLongueur = idLongueur;
    }

    public String getNomLongueur() {
        return nomLongueur;
    }

    public void setNomLongueur(String nomLongueur) {
        this.nomLongueur = nomLongueur;
    }

    public String getCotationLongueur() {
        return cotationLongueur;
    }

    public void setCotationLongueur(String cotationLongueur) {
        this.cotationLongueur = cotationLongueur;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Voie getVoie() {
        return voie;
    }

    public void setVoie(Voie voie) {
        this.voie = voie;
    }

    @Override
    public String toString() {
        return "Longueur{" +
                "idLongueur=" + idLongueur +
                ", nomLongueur='" + nomLongueur + '\'' +
                ", cotationLongueur='" + cotationLongueur + '\'' +
                ", utilisateur=" + utilisateur +
                ", voie=" + voie +
                '}';
    }
}
