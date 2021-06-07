package com.oc.p6_lade.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.oc.p6_lade.entity.ReservationTopo;

@Repository
public interface ReservationTopoRepository extends JpaRepository<ReservationTopo, Long> {

    @Query(value="SELECT * FROM db_lade.reservation_topo WHERE id_topo IN ( SELECT id_topo FROM db_lade.topo WHERE id_utilisateur = :idProprietaire)", nativeQuery=true)
    List<ReservationTopo> findAllByIdProprietaireTopo(@Param("idProprietaire") Long idProprietaire);

    @Query(value="SELECT * FROM db_lade.reservation_topo WHERE id_utilisateur = :idUtilisateur", nativeQuery=true)
    List<ReservationTopo> findAllByIdDemandeurReservationTopo(@Param("idUtilisateur") Long idUtilisateur);
}
