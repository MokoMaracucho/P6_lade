package com.oc.p6_lade.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oc.p6_lade.entity.Secteur;
import com.oc.p6_lade.entity.Site;
import com.oc.p6_lade.entity.Utilisateur;
import com.oc.p6_lade.exception.ResourceNotFoundException;
import com.oc.p6_lade.form.FormAjoutSecteur;
import com.oc.p6_lade.repository.SecteurRepository;
import com.oc.p6_lade.repository.SiteRepository;

@Service
public class SecteurServiceImpl implements SecteurService {

    private SiteRepository siteRepository;

    private SecteurRepository secteurRepository;

    @Autowired
    public SecteurServiceImpl(SiteRepository siteRepository, SecteurRepository secteurRepository) {
        this.siteRepository = siteRepository;
        this.secteurRepository = secteurRepository;
    }

    @Override
    public void enregistrerSecteur(FormAjoutSecteur formAjoutSecteur, Utilisateur utilisateur) {
        Secteur secteur = new Secteur();
        secteur.setNomSecteur(formAjoutSecteur.getNomSecteur());
        secteur.setUtilisateur(utilisateur);
        Site site = siteRepository.getByNomSite(formAjoutSecteur.getNomSite());
        secteur.setSite(site);
        secteurRepository.save(secteur);
    }

    @Override
    public List<Secteur> listeSecteurs() {
        return secteurRepository.findAll();
    }

    @Override
    public void suppressionSecteurParId(Long idSecteur) throws ResourceNotFoundException {
        secteurRepository.deleteById(idSecteur);
    }

    @Override
    public List<Secteur> rechercheNomSecteur(String nomRecherche) throws ResourceNotFoundException {
        return secteurRepository.rechercheNomSecteur(nomRecherche);
    }
}
