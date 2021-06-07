package com.oc.p6_lade.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="site")
public class Site {

    @Id
    @SequenceGenerator(
            name = "site_sequence",
            sequenceName = "site_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "site_sequence"
    )
    @Column(name="id_site", updatable=false)
    private Long idSite;

    @NotEmpty(message="Veuillez renseigner un nom de site.")
    @Column(name="nom_site")
    private String nomSite;

    @NotEmpty(message="Veuillez sélectionner une région.")
    @Column(name="region_site")
    private String regionSite;

    @ManyToOne
    @OnDelete(action= OnDeleteAction.CASCADE)
    @JoinColumn(name="id_utilisateur")
    private Utilisateur utilisateur;

    @OneToMany
    @JoinTable(name="secteur", joinColumns=@JoinColumn(name="id_site"), inverseJoinColumns=@JoinColumn(name="id_secteur"))
    private List<Secteur> listeSecteurs;

    @OneToMany
    @JoinTable(name="commentaire", joinColumns=@JoinColumn(name="id_site"), inverseJoinColumns=@JoinColumn(name="id_commentaire"))
    private List<Commentaire> listeCommentaires;

    public Site() {
    }

    public Site(String nomSite, String regionSite, Utilisateur utilisateur, List<Secteur> listeSecteurs, List<Commentaire> listeCommentaires) {
        this.nomSite = nomSite;
        this.regionSite = regionSite;
        this.utilisateur = utilisateur;
        this.listeSecteurs = listeSecteurs;
        this.listeCommentaires = listeCommentaires;
    }

    public Site(Long idSite, String nomSite, String regionSite, Utilisateur utilisateur, List<Secteur> listeSecteurs, List<Commentaire> listeCommentaires) {
        this.idSite = idSite;
        this.nomSite = nomSite;
        this.regionSite = regionSite;
        this.utilisateur = utilisateur;
        this.listeSecteurs = listeSecteurs;
        this.listeCommentaires = listeCommentaires;
    }

    public Long getIdSite() {
        return idSite;
    }

    public void setIdSite(Long idSite) {
        this.idSite = idSite;
    }

    public String getNomSite() {
        return nomSite;
    }

    public void setNomSite(String nomSite) {
        this.nomSite = nomSite;
    }

    public String getRegionSite() {
        return regionSite;
    }

    public void setRegionSite(String regionSite) {
        this.regionSite = regionSite;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public List<Secteur> getListeSecteurs() {
        return listeSecteurs;
    }

    public void setListeSecteurs(List<Secteur> listeSecteurs) {
        this.listeSecteurs = listeSecteurs;
    }

    public List<Commentaire> getListeCommentaires() {
        return listeCommentaires;
    }

    public void setListeCommentaires(List<Commentaire> listeCommentaires) {
        this.listeCommentaires = listeCommentaires;
    }

    @Override
    public String toString() {
        return "Site{" +
                "idSite=" + idSite +
                ", nomSite='" + nomSite + '\'' +
                ", regionSite='" + regionSite + '\'' +
                ", utilisateur=" + utilisateur +
                ", listeSecteurs=" + listeSecteurs +
                ", listeCommentaires=" + listeCommentaires +
                '}';
    }
}
