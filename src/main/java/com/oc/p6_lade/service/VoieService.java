package com.oc.p6_lade.service;

import java.util.List;

import com.oc.p6_lade.entity.Utilisateur;
import com.oc.p6_lade.entity.Voie;
import com.oc.p6_lade.exception.ResourceNotFoundException;
import com.oc.p6_lade.form.FormAjoutVoie;

public interface VoieService {

    public void enregistrerVoie(FormAjoutVoie formAjoutVoie, Utilisateur utilisateur);

    public List<Voie> listeVoies();

    public void suppressionVoieParId(Long idVoie) throws ResourceNotFoundException;

    public List<Voie> rechercheNomVoie(String nomRecherche) throws ResourceNotFoundException;
}
