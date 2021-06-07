package com.oc.p6_lade.entity;

import javax.persistence.*;

@Entity
@Table
public class ReservationTopo {

    @Id
    @SequenceGenerator(
            name = "reservation_topo_sequence",
            sequenceName = "reservation_topo_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "reservation_topo_sequence"
    )
    @Column(name="id_reservation_topo", updatable=false)
    private Long idReservationTopo;

    @Enumerated(EnumType.STRING)
    @Column(name="statut_reservation_topo")
    private StatutReservationTopo statutReservationTopo;

    @ManyToOne
    @JoinColumn(name="id_topo")
    private Topo topo;

    @ManyToOne
    @JoinColumn(name="id_utilisateur")
    private Utilisateur demandeurReservationTopo;

    public ReservationTopo() {
    }

    public ReservationTopo(StatutReservationTopo statutReservationTopo, Topo topo, Utilisateur demandeurReservationTopo) {
        this.statutReservationTopo = statutReservationTopo;
        this.topo = topo;
        this.demandeurReservationTopo = demandeurReservationTopo;
    }

    public ReservationTopo(Long idReservationTopo, StatutReservationTopo statutReservationTopo, Topo topo, Utilisateur demandeurReservationTopo) {
        this.idReservationTopo = idReservationTopo;
        this.statutReservationTopo = statutReservationTopo;
        this.topo = topo;
        this.demandeurReservationTopo = demandeurReservationTopo;
    }

    public Long getIdReservationTopo() {
        return idReservationTopo;
    }

    public void setIdReservationTopo(Long idReservationTopo) {
        this.idReservationTopo = idReservationTopo;
    }

    public StatutReservationTopo getStatutReservationTopo() {
        return statutReservationTopo;
    }

    public void setStatutReservationTopo(StatutReservationTopo statutReservationTopo) {
        this.statutReservationTopo = statutReservationTopo;
    }

    public Topo getTopo() {
        return topo;
    }

    public void setTopo(Topo topo) {
        this.topo = topo;
    }

    public Utilisateur getDemandeurReservationTopo() {
        return demandeurReservationTopo;
    }

    public void setDemandeurReservationTopo(Utilisateur demandeurReservationTopo) {
        this.demandeurReservationTopo = demandeurReservationTopo;
    }

    @Override
    public String toString() {
        return "ReservationTopo{" +
                "idReservationTopo=" + idReservationTopo +
                ", statutReservationTopo=" + statutReservationTopo +
                ", topo=" + topo +
                ", demandeurReservationTopo=" + demandeurReservationTopo +
                '}';
    }
}
