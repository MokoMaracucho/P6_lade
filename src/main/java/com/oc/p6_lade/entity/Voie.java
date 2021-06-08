package com.oc.p6_lade.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="voie")
public class Voie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_voie", updatable=false)
    private Long idVoie;

    @NotEmpty
    @Column(name="nom_voie")
    private String nomVoie;

    @Column(name="equipe_voie")
    private Boolean	equipeVoie;

    @NotEmpty
    @Column(name="cotation_voie")
    private String cotationVoie;

    @ManyToOne
    @OnDelete(action= OnDeleteAction.CASCADE)
    @JoinColumn(name="id_utilisateur")
    private Utilisateur utilisateur;

    @ManyToOne
    @OnDelete(action=OnDeleteAction.CASCADE)
    @JoinColumn(name="id_secteur")
    private Secteur secteur;

    @OneToMany
    @JoinTable(name="longueur", joinColumns=@JoinColumn(name="id_voie"), inverseJoinColumns=@JoinColumn(name="id_longueur"))
    private List<Longueur> listeLongueurs;

    public Voie() {
    }

    public Voie(String nomVoie, Boolean equipeVoie, String cotationVoie, Utilisateur utilisateur, Secteur secteur, List<Longueur> listeLongueurs) {
        this.nomVoie = nomVoie;
        this.equipeVoie = equipeVoie;
        this.cotationVoie = cotationVoie;
        this.utilisateur = utilisateur;
        this.secteur = secteur;
        this.listeLongueurs = listeLongueurs;
    }

    public Voie(Long idVoie, String nomVoie, Boolean equipeVoie, String cotationVoie, Utilisateur utilisateur, Secteur secteur, List<Longueur> listeLongueurs) {
        this.idVoie = idVoie;
        this.nomVoie = nomVoie;
        this.equipeVoie = equipeVoie;
        this.cotationVoie = cotationVoie;
        this.utilisateur = utilisateur;
        this.secteur = secteur;
        this.listeLongueurs = listeLongueurs;
    }

    public Long getIdVoie() {
        return idVoie;
    }

    public void setIdVoie(Long idVoie) {
        this.idVoie = idVoie;
    }

    public String getNomVoie() {
        return nomVoie;
    }

    public void setNomVoie(String nomVoie) {
        this.nomVoie = nomVoie;
    }

    public Boolean getEquipeVoie() {
        return equipeVoie;
    }

    public void setEquipeVoie(Boolean equipeVoie) {
        this.equipeVoie = equipeVoie;
    }

    public String getCotationVoie() {
        return cotationVoie;
    }

    public void setCotationVoie(String cotationVoie) {
        this.cotationVoie = cotationVoie;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Secteur getSecteur() {
        return secteur;
    }

    public void setSecteur(Secteur secteur) {
        this.secteur = secteur;
    }

    public List<Longueur> getListeLongueurs() {
        return listeLongueurs;
    }

    public void setListeLongueurs(List<Longueur> listeLongueurs) {
        this.listeLongueurs = listeLongueurs;
    }

    @Override
    public String toString() {
        return "Voie{" +
                "idVoie=" + idVoie +
                ", nomVoie='" + nomVoie + '\'' +
                ", equipeVoie=" + equipeVoie +
                ", cotationVoie='" + cotationVoie + '\'' +
                ", utilisateur=" + utilisateur +
                ", secteur=" + secteur +
                ", listeLongueurs=" + listeLongueurs +
                '}';
    }
}
