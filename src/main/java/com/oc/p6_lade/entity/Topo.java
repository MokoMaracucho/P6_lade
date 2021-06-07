package com.oc.p6_lade.entity;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table
public class Topo {

    @Id
    @SequenceGenerator(
            name = "topo_sequence",
            sequenceName = "topo_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "topo_sequence"
    )
    @Column(name="id_topo", updatable=false)
    private Long idTopo;

    @NotEmpty
    @Column(name="nom_topo")
    private String nomTopo;

    @NotEmpty
    @Column(name="region_topo")
    private String regionTopo;

    @NotEmpty
    @Column(name="description_topo")
    private String descriptionTopo;

    @Column(name="date_parution_topo")
    private Timestamp dateParutionTopo;

    @Column(name="disponibilite_topo")
    private Boolean disponibiliteTopo;

    @ManyToOne
    @JoinColumn(name="id_utilisateur")
    private Utilisateur utilisateur;

    @OneToMany
    @JoinTable(name="tb_reservation_topo", joinColumns=@JoinColumn(name="id_topo"), inverseJoinColumns=@JoinColumn(name="id_reservation_topo"))
    private List<ReservationTopo> listeReservationsTopo;

    public Topo() {
    }

    public Topo(String nomTopo, String regionTopo, String descriptionTopo, Timestamp dateParutionTopo, Boolean disponibiliteTopo, Utilisateur utilisateur, List<ReservationTopo> listeReservationsTopo) {
        this.nomTopo = nomTopo;
        this.regionTopo = regionTopo;
        this.descriptionTopo = descriptionTopo;
        this.dateParutionTopo = dateParutionTopo;
        this.disponibiliteTopo = disponibiliteTopo;
        this.utilisateur = utilisateur;
        this.listeReservationsTopo = listeReservationsTopo;
    }

    public Topo(Long idTopo, String nomTopo, String regionTopo, String descriptionTopo, Timestamp dateParutionTopo, Boolean disponibiliteTopo, Utilisateur utilisateur, List<ReservationTopo> listeReservationsTopo) {
        this.idTopo = idTopo;
        this.nomTopo = nomTopo;
        this.regionTopo = regionTopo;
        this.descriptionTopo = descriptionTopo;
        this.dateParutionTopo = dateParutionTopo;
        this.disponibiliteTopo = disponibiliteTopo;
        this.utilisateur = utilisateur;
        this.listeReservationsTopo = listeReservationsTopo;
    }

    public Long getIdTopo() {
        return idTopo;
    }

    public void setIdTopo(Long idTopo) {
        this.idTopo = idTopo;
    }

    public String getNomTopo() {
        return nomTopo;
    }

    public void setNomTopo(String nomTopo) {
        this.nomTopo = nomTopo;
    }

    public String getRegionTopo() {
        return regionTopo;
    }

    public void setRegionTopo(String regionTopo) {
        this.regionTopo = regionTopo;
    }

    public String getDescriptionTopo() {
        return descriptionTopo;
    }

    public void setDescriptionTopo(String descriptionTopo) {
        this.descriptionTopo = descriptionTopo;
    }

    public Timestamp getDateParutionTopo() {
        return dateParutionTopo;
    }

    public void setDateParutionTopo(Timestamp dateParutionTopo) {
        this.dateParutionTopo = dateParutionTopo;
    }

    public Boolean getDisponibiliteTopo() {
        return disponibiliteTopo;
    }

    public void setDisponibiliteTopo(Boolean disponibiliteTopo) {
        this.disponibiliteTopo = disponibiliteTopo;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public List<ReservationTopo> getListeReservationsTopo() {
        return listeReservationsTopo;
    }

    public void setListeReservationsTopo(List<ReservationTopo> listeReservationsTopo) {
        this.listeReservationsTopo = listeReservationsTopo;
    }

    @Override
    public String toString() {
        return "Topo{" +
                "idTopo=" + idTopo +
                ", nomTopo='" + nomTopo + '\'' +
                ", regionTopo='" + regionTopo + '\'' +
                ", descriptionTopo='" + descriptionTopo + '\'' +
                ", dateParutionTopo=" + dateParutionTopo +
                ", disponibiliteTopo=" + disponibiliteTopo +
                ", utilisateur=" + utilisateur +
                ", listeReservationsTopo=" + listeReservationsTopo +
                '}';
    }
}
