package com.oc.p6_lade.service;

import java.util.List;

import com.oc.p6_lade.entity.Secteur;
import com.oc.p6_lade.entity.Utilisateur;
import com.oc.p6_lade.exception.ResourceNotFoundException;
import com.oc.p6_lade.form.FormAjoutSecteur;

public interface SecteurService {

    public void enregistrerSecteur(FormAjoutSecteur formAjoutSecteur, Utilisateur utilisateur);

    public List<Secteur> listeSecteurs();

    public void suppressionSecteurParId(Long idSecteur) throws ResourceNotFoundException;

    public List<Secteur> rechercheNomSecteur(String nomRecherche) throws ResourceNotFoundException;
}
