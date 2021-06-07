package com.oc.p6_lade.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Table
public class Secteur {

    @Id
    @SequenceGenerator(
            name = "secteur_sequence",
            sequenceName = "secteur_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "secteur_sequence"
    )
    @Column(name="id_secteur", updatable=false)
    private Long idSecteur;

    @NotEmpty
    @Column(name="nom_secteur")
    private String nomSecteur;

    @ManyToOne
    @JoinColumn(name="id_utilisateur")
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name="id_site")
    private Site site;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinTable(name="tb_voie", joinColumns=@JoinColumn(name="id_secteur"), inverseJoinColumns=@JoinColumn(name="id_voie"))
    private List<Voie> listeVoies;

    public Secteur() {
    }

    public Secteur(String nomSecteur, Utilisateur utilisateur, Site site, List<Voie> listeVoies) {
        this.nomSecteur = nomSecteur;
        this.utilisateur = utilisateur;
        this.site = site;
        this.listeVoies = listeVoies;
    }

    public Secteur(Long idSecteur, String nomSecteur, Utilisateur utilisateur, Site site, List<Voie> listeVoies) {
        this.idSecteur = idSecteur;
        this.nomSecteur = nomSecteur;
        this.utilisateur = utilisateur;
        this.site = site;
        this.listeVoies = listeVoies;
    }

    public Long getIdSecteur() {
        return idSecteur;
    }

    public void setIdSecteur(Long idSecteur) {
        this.idSecteur = idSecteur;
    }

    public String getNomSecteur() {
        return nomSecteur;
    }

    public void setNomSecteur(String nomSecteur) {
        this.nomSecteur = nomSecteur;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }

    public List<Voie> getListeVoies() {
        return listeVoies;
    }

    public void setListeVoies(List<Voie> listeVoies) {
        this.listeVoies = listeVoies;
    }

    @Override
    public String toString() {
        return "Secteur{" +
                "idSecteur=" + idSecteur +
                ", nomSecteur='" + nomSecteur + '\'' +
                ", utilisateur=" + utilisateur +
                ", site=" + site +
                ", listeVoies=" + listeVoies +
                '}';
    }
}