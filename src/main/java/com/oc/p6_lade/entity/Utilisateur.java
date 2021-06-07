package com.oc.p6_lade.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table
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

    @Enumerated(EnumType.STRING)
    @Column(name="privilege_utilisateur", length=300)
    private Privilege privilegeUtilisateur;

    @Column(name="date_inscription_utilisateur")
    private Timestamp dateInscriptionUtilisateur;

    @OneToMany
    @JoinTable(name="tb_site", joinColumns=@JoinColumn(name="id_utilisateur"), inverseJoinColumns=@JoinColumn(name="id_site"))
    private List<Site> listeSites;

    @OneToMany
    @JoinTable(name="tb_commentaire", joinColumns=@JoinColumn(name="id_utilisateur"), inverseJoinColumns=@JoinColumn(name="id_commentaire"))
    private List<Commentaire> listeCommentaires;

    @OneToMany
    @JoinTable(name="tb_secteur", joinColumns=@JoinColumn(name="id_utilisateur"), inverseJoinColumns=@JoinColumn(name="id_secteur"))
    private List<Secteur> listeSecteurs;

    @OneToMany
    @JoinTable(name="tb_reservation_topo", joinColumns=@JoinColumn(name="id_utilisateur"), inverseJoinColumns=@JoinColumn(name="id_reservation_topo"))
    private List<ReservationTopo> listeReservationsTopo;

    public Utilisateur() {
    }

    public Utilisateur(String prenomUtilisateur, String nomUtilisateur, String emailUtilisateur, String motDePasseUtilisateur, Privilege privilegeUtilisateur, Timestamp dateInscriptionUtilisateur, List<Site> listeSites, List<Commentaire> listeCommentaires, List<Secteur> listeSecteurs, List<ReservationTopo> listeReservationsTopo) {
        this.prenomUtilisateur = prenomUtilisateur;
        this.nomUtilisateur = nomUtilisateur;
        this.emailUtilisateur = emailUtilisateur;
        this.motDePasseUtilisateur = motDePasseUtilisateur;
        this.privilegeUtilisateur = privilegeUtilisateur;
        this.dateInscriptionUtilisateur = dateInscriptionUtilisateur;
        this.listeSites = listeSites;
        this.listeCommentaires = listeCommentaires;
        this.listeSecteurs = listeSecteurs;
        this.listeReservationsTopo = listeReservationsTopo;
    }

    public Utilisateur(Long idUtilisateur, String prenomUtilisateur, String nomUtilisateur, String emailUtilisateur, String motDePasseUtilisateur, Privilege privilegeUtilisateur, Timestamp dateInscriptionUtilisateur, List<Site> listeSites, List<Commentaire> listeCommentaires, List<Secteur> listeSecteurs, List<ReservationTopo> listeReservationsTopo) {
        this.idUtilisateur = idUtilisateur;
        this.prenomUtilisateur = prenomUtilisateur;
        this.nomUtilisateur = nomUtilisateur;
        this.emailUtilisateur = emailUtilisateur;
        this.motDePasseUtilisateur = motDePasseUtilisateur;
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
                ", privilegeUtilisateur=" + privilegeUtilisateur +
                ", dateInscriptionUtilisateur=" + dateInscriptionUtilisateur +
                ", listeSites=" + listeSites +
                ", listeCommentaires=" + listeCommentaires +
                ", listeSecteurs=" + listeSecteurs +
                ", listeReservationsTopo=" + listeReservationsTopo +
                '}';
    }
}
