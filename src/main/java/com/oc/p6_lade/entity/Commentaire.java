package com.oc.p6_lade.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="commentaire")
public class Commentaire {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_commentaire", updatable=false)
    private Long idCommentaire;

    @NotEmpty()
    @Column(name="commentaire")
    private String commentaire;

    @ManyToOne
    @OnDelete(action=OnDeleteAction.CASCADE)
    @JoinColumn(name="id_utilisateur")
    private Utilisateur utilisateur;

    @ManyToOne
    @OnDelete(action=OnDeleteAction.CASCADE)
    @JoinColumn(name="id_site")
    private Site site;

    public Commentaire() {
    }

    public Commentaire(String commentaire, Utilisateur utilisateur, Site site) {
        this.commentaire = commentaire;
        this.utilisateur = utilisateur;
        this.site = site;
    }

    public Commentaire(Long idCommentaire, String commentaire, Utilisateur utilisateur, Site site) {
        this.idCommentaire = idCommentaire;
        this.commentaire = commentaire;
        this.utilisateur = utilisateur;
        this.site = site;
    }

    public Long getIdCommentaire() {
        return idCommentaire;
    }

    public void setIdCommentaire(Long idCommentaire) {
        this.idCommentaire = idCommentaire;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
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

    @Override
    public String toString() {
        return "Commentaire{" +
                "idCommentaire=" + idCommentaire +
                ", commentaire='" + commentaire + '\'' +
                ", utilisateur=" + utilisateur +
                ", site=" + site +
                '}';
    }
}
