package com.oc.p6_lade.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oc.p6_lade.entity.Commentaire;
import com.oc.p6_lade.entity.Site;
import com.oc.p6_lade.entity.Utilisateur;
import com.oc.p6_lade.exception.ResourceNotFoundException;
import com.oc.p6_lade.form.FormAjoutSite;
import com.oc.p6_lade.repository.CommentaireRepository;
import com.oc.p6_lade.repository.SiteRepository;

@Service
public class SiteServiceImpl implements SiteService {

    private SiteRepository siteRepository;

    private CommentaireRepository commentaireRepository;

    @Autowired
    public SiteServiceImpl(SiteRepository siteRepository, CommentaireRepository commentaireRepository) {
        this.siteRepository = siteRepository;
        this.commentaireRepository = commentaireRepository;
    }

    @Override
    public void enregistrerSite(FormAjoutSite formAjoutSite, Utilisateur utilisateur) {
        Site site = new Site();
        site.setNomSite(formAjoutSite.getNomSite());
        site.setRegionSite(formAjoutSite.getRegionSite());
        site.setUtilisateur(utilisateur);
        siteRepository.save(site);
        if(formAjoutSite.getCommentaireSite() != null) {
            Commentaire commentaire = new Commentaire();
            commentaire.setCommentaire(formAjoutSite.getCommentaireSite());
            commentaire.setUtilisateur(utilisateur);
            Site siteCree = siteRepository.getOne(site.getIdSite());
            commentaire.setSite(siteCree);
            commentaireRepository.save(commentaire);
        }
    }

    @Override
    public List<Site> listeSites() {
        return siteRepository.findAll();
    }

    @Override
    public Site selectionnerSiteParId(Long idSite) throws ResourceNotFoundException {
        return siteRepository.findById(idSite).orElseThrow(() -> new ResourceNotFoundException(idSite));
    }

    @Override
    public void suppressionSiteParId(Long idSite) throws ResourceNotFoundException {
        siteRepository.deleteById(idSite);
    }

    @Override
    public List<Site> rechercheNomSite(String nomRecherche) throws ResourceNotFoundException {
        return siteRepository.rechercheNomSite(nomRecherche);
    }

    @Override
    public List<Site> rechercheRegionSite(String regionRecherche) throws ResourceNotFoundException {
        return siteRepository.rechercheRegionSite(regionRecherche);
    }

    @Override
    public List<Site> rechercheNomRegionSite(String nomRecherche, String regionRecherche) throws ResourceNotFoundException {
        return siteRepository.rechercheNomRegionSite(nomRecherche, regionRecherche);
    }
}
