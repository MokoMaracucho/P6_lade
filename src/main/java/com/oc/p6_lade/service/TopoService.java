package com.oc.p6_lade.service;

import java.util.List;

import com.oc.p6_lade.entity.ReservationTopo;
import com.oc.p6_lade.entity.Site;
import com.oc.p6_lade.entity.StatutReservationTopo;
import com.oc.p6_lade.entity.Topo;
import com.oc.p6_lade.entity.Utilisateur;
import com.oc.p6_lade.exception.ResourceNotFoundException;
import com.oc.p6_lade.form.FormAjoutTopo;

public interface TopoService {

    public void enregistrerTopo(FormAjoutTopo formAjoutTopo, Utilisateur utilisateur);

    public void enregistrerReservationTopo(Long idTopo, Utilisateur utilisateur);

    public List<Topo> listeTopos();

    public List<ReservationTopo> listeReservationsTopo();

    public List<ReservationTopo> listeReservationsTopo(Long idUtilisateur);

    public List<ReservationTopo> listeDemandesReservationTopo(Long idDemandeurReservationTopo);

    public void majReservationTopo(Long idReservationTopo, Utilisateur utilisateur, StatutReservationTopo reponseDemandeReservationTopo);

    public List<Topo> rechercheNomTopo(String nomRecherche) throws ResourceNotFoundException;

    public List<Topo> rechercheRegionTopo(String regionRecherche) throws ResourceNotFoundException;

    public List<Topo> rechercheNomRegionTopo(String nomRecherche, String regionRecherche) throws ResourceNotFoundException;
}
