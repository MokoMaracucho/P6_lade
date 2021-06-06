package com.oc.p6_lade.entity;

import javax.persistence.*;
import java.time.LocalDate;

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
    private Long idUtilisateur;

    private String prenomUtilisateur;

    private String nomUtilisateur;

    private String emailUtilisateur;

    private String motDePasseUtilisateur;

    private Privilege privilegeUtilisateur;

    private LocalDate dateInscriptionUtilisateur;

    public Utilisateur() {
    }

    public Utilisateur(
            String prenomUtilisateur,
            String nomUtilisateur,
            String emailUtilisateur,
            String motDePasseUtilisateur,
            Privilege privilegeUtilisateur,
            LocalDate dateInscriptionUtilisateur) {
        this.prenomUtilisateur = prenomUtilisateur;
        this.nomUtilisateur = nomUtilisateur;
        this.emailUtilisateur = emailUtilisateur;
        this.motDePasseUtilisateur = motDePasseUtilisateur;
        this.privilegeUtilisateur = privilegeUtilisateur;
        this.dateInscriptionUtilisateur = dateInscriptionUtilisateur;
    }

    public Utilisateur(
            Long idUtilisateur,
            String prenomUtilisateur,
            String nomUtilisateur,
            String emailUtilisateur,
            String motDePasseUtilisateur,
            Privilege privilegeUtilisateur,
            LocalDate dateInscriptionUtilisateur
    ) {
        this.idUtilisateur = idUtilisateur;
        this.prenomUtilisateur = prenomUtilisateur;
        this.nomUtilisateur = nomUtilisateur;
        this.emailUtilisateur = emailUtilisateur;
        this.motDePasseUtilisateur = motDePasseUtilisateur;
        this.privilegeUtilisateur = privilegeUtilisateur;
        this.dateInscriptionUtilisateur = dateInscriptionUtilisateur;
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

    public LocalDate getDateInscriptionUtilisateur() {
        return dateInscriptionUtilisateur;
    }

    public void setDateInscriptionUtilisateur(LocalDate dateInscriptionUtilisateur) {
        this.dateInscriptionUtilisateur = dateInscriptionUtilisateur;
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
                '}';
    }
}
