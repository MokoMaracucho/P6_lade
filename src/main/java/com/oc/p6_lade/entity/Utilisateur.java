package com.oc.p6_lade.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name="utilisateur")
public class Utilisateur {

    @Id
    @SequenceGenerator(
            name = "utilisateur_sequence",
            sequenceName = "utilisateur_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "utilisateur_sequence"
    )
    @Column(name="id_utilisateur", updatable=false)
    private Long idUtilisateur;

    @Column(name="prenom_utilisateur")
    private String prenomUtilisateur;

    @Column(name="nom_utilisateur")
    private String nomUtilisateur;

    @Column(name="email_utilisateur")
    private String emailUtilisateur;

    @Column(name="mot_de_passe_utilisateur")
    private String motDePasseUtilisateur;

    @Column(name="numero_membre_utilisateur")
    private String numeroMembreUtilisateur;

    @Enumerated(EnumType.STRING)
    @Column(name="privilege_utilisateur", length=300)
    private Privilege privilegeUtilisateur;

    @Column(name="date_inscription_utilisateur")
    private Timestamp dateInscriptionUtilisateur;

    @OneToMany
    @JoinTable(name="site", joinColumns=@JoinColumn(name="id_utilisateur"), inverseJoinColumns=@JoinColumn(name="id_site"))
    private List<Site> listeSites;

    @OneToMany
    @JoinTable(name="commentaire", joinColumns=@JoinColumn(name="id_utilisateur"), inverseJoinColumns=@JoinColumn(name="id_commentaire"))
    private List<Commentaire> listeCommentaires;

    @OneToMany
    @JoinTable(name="secteur", joinColumns=@JoinColumn(name="id_utilisateur"), inverseJoinColumns=@JoinColumn(name="id_secteur"))
    private List<Secteur> listeSecteurs;

    @OneToMany
    @JoinTable(name="reservation_topo", joinColumns=@JoinColumn(name="id_utilisateur"), inverseJoinColumns=@JoinColumn(name="id_reservation_topo"))
    private List<ReservationTopo> listeReservationsTopo;

    public Utilisateur() {
    }

    public Utilisateur(String prenomUtilisateur, String nomUtilisateur, String emailUtilisateur, String motDePasseUtilisateur, String numeroMembreUtilisateur, Privilege privilegeUtilisateur, Timestamp dateInscriptionUtilisateur, List<Site> listeSites, List<Commentaire> listeCommentaires, List<Secteur> listeSecteurs, List<ReservationTopo> listeReservationsTopo) {
        this.prenomUtilisateur = prenomUtilisateur;
        this.nomUtilisateur = nomUtilisateur;
        this.emailUtilisateur = emailUtilisateur;
        this.motDePasseUtilisateur = motDePasseUtilisateur;
        this.numeroMembreUtilisateur = numeroMembreUtilisateur;
        this.privilegeUtilisateur = privilegeUtilisateur;
        this.dateInscriptionUtilisateur = dateInscriptionUtilisateur;
        this.listeSites = listeSites;
        this.listeCommentaires = listeCommentaires;
        this.listeSecteurs = listeSecteurs;
        this.listeReservationsTopo = listeReservationsTopo;
    }

    public Utilisateur(Long idUtilisateur, String prenomUtilisateur, String nomUtilisateur, String emailUtilisateur, String motDePasseUtilisateur, String numeroMembreUtilisateur, Privilege privilegeUtilisateur, Timestamp dateInscriptionUtilisateur, List<Site> listeSites, List<Commentaire> listeCommentaires, List<Secteur> listeSecteurs, List<ReservationTopo> listeReservationsTopo) {
        this.idUtilisateur = idUtilisateur;
        this.prenomUtilisateur = prenomUtilisateur;
        this.nomUtilisateur = nomUtilisateur;
        this.emailUtilisateur = emailUtilisateur;
        this.motDePasseUtilisateur = motDePasseUtilisateur;
        this.numeroMembreUtilisateur = numeroMembreUtilisateur;
        this.privilegeUtilisateur = privilegeUtilisateur;
        this.dateInscriptionUtilisateur = dateInscriptionUtilisateur;
        this.listeSites = listeSites;
        this.listeCommentaires = listeCommentaires;
        this.listeSecteurs = listeSecteurs;
        this.listeReservationsTopo = listeReservationsTopo;
    }

    public Long getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(Long idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public String getPrenomUtilisateur() {
        return prenomUtilisateur;
    }

    public void setPrenomUtilisateur(String prenomUtilisateur) {
        this.prenomUtilisateur = prenomUtilisateur;
    }

    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    public void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }

    public String getEmailUtilisateur() {
        return emailUtilisateur;
    }

    public void setEmailUtilisateur(String emailUtilisateur) {
        this.emailUtilisateur = emailUtilisateur;
    }

    public String getMotDePasseUtilisateur() {
        return motDePasseUtilisateur;
    }

    public void setMotDePasseUtilisateur(String motDePasseUtilisateur) {
        this.motDePasseUtilisateur = motDePasseUtilisateur;
    }

    public String getNumeroMembreUtilisateur() {
        return numeroMembreUtilisateur;
    }

    public void setNumeroMembreUtilisateur(String numeroMembreUtilisateur) {
        this.numeroMembreUtilisateur = numeroMembreUtilisateur;
    }

    public Privilege getPrivilegeUtilisateur() {
        return privilegeUtilisateur;
    }

    public void setPrivilegeUtilisateur(Privilege privilegeUtilisateur) {
        this.privilegeUtilisateur = privilegeUtilisateur;
    }

    public Timestamp getDateInscriptionUtilisateur() {
        return dateInscriptionUtilisateur;
    }

    public void setDateInscriptionUtilisateur(Timestamp dateInscriptionUtilisateur) {
        this.dateInscriptionUtilisateur = dateInscriptionUtilisateur;
    }

    public List<Site> getListeSites() {
        return listeSites;
    }

    public void setListeSites(List<Site> listeSites) {
        this.listeSites = listeSites;
    }

    public List<Commentaire> getListeCommentaires() {
        return listeCommentaires;
    }

    public void setListeCommentaires(List<Commentaire> listeCommentaires) {
        this.listeCommentaires = listeCommentaires;
    }

    public List<Secteur> getListeSecteurs() {
        return listeSecteurs;
    }

    public void setListeSecteurs(List<Secteur> listeSecteurs) {
        this.listeSecteurs = listeSecteurs;
    }

    public List<ReservationTopo> getListeReservationsTopo() {
        return listeReservationsTopo;
    }

    public void setListeReservationsTopo(List<ReservationTopo> listeReservationsTopo) {
        this.listeReservationsTopo = listeReservationsTopo;
    }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "idUtilisateur=" + idUtilisateur +
                ", prenomUtilisateur='" + prenomUtilisateur + '\'' +
                ", nomUtilisateur='" + nomUtilisateur + '\'' +
                ", emailUtilisateur='" + emailUtilisateur + '\'' +
                ", motDePasseUtilisateur='" + motDePasseUtilisateur + '\'' +
                ", numeroMembreUtilisateur='" + numeroMembreUtilisateur + '\'' +
                ", privilegeUtilisateur=" + privilegeUtilisateur +
                ", dateInscriptionUtilisateur=" + dateInscriptionUtilisateur +
                ", listeSites=" + listeSites +
                ", listeCommentaires=" + listeCommentaires +
                ", listeSecteurs=" + listeSecteurs +
                ", listeReservationsTopo=" + listeReservationsTopo +
                '}';
    }
}
