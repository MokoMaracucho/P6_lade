package com.oc.p6_lade.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oc.p6_lade.entity.Secteur;
import com.oc.p6_lade.entity.Utilisateur;
import com.oc.p6_lade.entity.Voie;
import com.oc.p6_lade.exception.ResourceNotFoundException;
import com.oc.p6_lade.form.FormAjoutVoie;
import com.oc.p6_lade.repository.SecteurRepository;
import com.oc.p6_lade.repository.VoieRepository;

@Service
public class VoieServiceImpl implements VoieService {

    private SecteurRepository secteurRepository;

    private VoieRepository voieRepository;

    @Autowired
    public VoieServiceImpl(SecteurRepository secteurRepository, VoieRepository voieRepository) {
        this.secteurRepository = secteurRepository;
        this.voieRepository = voieRepository;
    }

    @Override
    public void enregistrerVoie(FormAjoutVoie formAjoutVoie, Utilisateur utilisateur) {
        Voie voie = new Voie();
        voie.setNomVoie(formAjoutVoie.getNomVoie());
        voie.setEquipeVoie(formAjoutVoie.getEquipeVoie());
        voie.setCotationVoie(formAjoutVoie.getCotationVoie());
        voie.setUtilisateur(utilisateur);
        Secteur secteur = secteurRepository.getByNomSecteur(formAjoutVoie.getNomSecteur());
        voie.setSecteur(secteur);
        voieRepository.save(voie);
    }

    @Override
    public List<Voie> listeVoies() {
        return voieRepository.findAll();
    }

    @Override
    public void suppressionVoieParId(Long idVoie) throws ResourceNotFoundException {
        voieRepository.deleteById(idVoie);
    }

    @Override
    public List<Voie> rechercheNomVoie(String nomRecherche) throws ResourceNotFoundException {
        return voieRepository.rechercheNomVoie(nomRecherche);
    }
}
