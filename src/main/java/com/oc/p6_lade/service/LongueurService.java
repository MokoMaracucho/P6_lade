package com.oc.p6_lade.service;

import java.util.List;

import com.oc.p6_lade.entity.Longueur;
import com.oc.p6_lade.entity.Utilisateur;
import com.oc.p6_lade.exception.ResourceNotFoundException;
import com.oc.p6_lade.form.FormAjoutLongueur;

public interface LongueurService {

    public void enregistrerLongueur(FormAjoutLongueur formAjoutLongueur, Utilisateur utilisateur);

    public List<Longueur> listeLongueurs();

    public void suppressionLongueurParId(Long idLongueur) throws ResourceNotFoundException;

    public List<Longueur> rechercheNomLongueur(String nomRecherche) throws ResourceNotFoundException;
}
