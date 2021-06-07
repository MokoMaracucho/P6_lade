package com.oc.p6_lade.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oc.p6_lade.entity.Longueur;
import com.oc.p6_lade.entity.Utilisateur;
import com.oc.p6_lade.entity.Voie;
import com.oc.p6_lade.exception.ResourceNotFoundException;
import com.oc.p6_lade.form.FormAjoutLongueur;
import com.oc.p6_lade.repository.LongueurRepository;
import com.oc.p6_lade.repository.VoieRepository;

@Service
public class LongueurServiceImpl implements LongueurService {

    private VoieRepository voieRepository;

    private LongueurRepository longueurRepository;

    @Autowired
    public LongueurServiceImpl(VoieRepository voieRepository, LongueurRepository longueurRepository) {
        this.voieRepository = voieRepository;
        this.longueurRepository = longueurRepository;
    }

    @Override
    public void enregistrerLongueur(FormAjoutLongueur formAjoutLongueur, Utilisateur utilisateur) {
        Longueur longueur = new Longueur();
        longueur.setNomLongueur(formAjoutLongueur.getNomLongueur());
        longueur.setCotationLongueur(formAjoutLongueur.getCotationLongueur());
        longueur.setUtilisateur(utilisateur);
        Voie voie = voieRepository.getByNomVoie(formAjoutLongueur.getNomVoie());
        longueur.setVoie(voie);
        longueurRepository.save(longueur);
    }

    @Override
    public List<Longueur> listeLongueurs() {
        return longueurRepository.findAll();
    }

    @Override
    public void suppressionLongueurParId(Long idLongueur) throws ResourceNotFoundException {
        longueurRepository.deleteById(idLongueur);
    }

    @Override
    public List<Longueur> rechercheNomLongueur(String nomRecherche) throws ResourceNotFoundException {
        return longueurRepository.rechercheNomLongueur(nomRecherche);
    }
}
