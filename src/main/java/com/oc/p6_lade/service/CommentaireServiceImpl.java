package com.oc.p6_lade.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oc.p6_lade.entity.Commentaire;
import com.oc.p6_lade.entity.Site;
import com.oc.p6_lade.entity.Utilisateur;
import com.oc.p6_lade.form.FormAjoutCommentaire;
import com.oc.p6_lade.repository.CommentaireRepository;
import com.oc.p6_lade.repository.SiteRepository;

@Service
public class CommentaireServiceImpl implements CommentaireService {

    private CommentaireRepository commentaireRepository;

    private SiteRepository siteRepository;

    @Autowired
    public CommentaireServiceImpl(CommentaireRepository commentaireRepository, SiteRepository siteRepository) {
        this.commentaireRepository = commentaireRepository;
        this.siteRepository = siteRepository;
    }

    @Override
    public void enregistrerCommentaire(FormAjoutCommentaire formCommentaire, Utilisateur utilisateur, Long idSite) {
        Commentaire commentaire = new Commentaire();
        commentaire.setCommentaire(formCommentaire.getCommentaire());
        commentaire.setUtilisateur(utilisateur);
        Site site = siteRepository.getOne(idSite);
        commentaire.setSite(site);
        commentaireRepository.save(commentaire);
    }

    @Override
    public List<Commentaire> listeCommentaires() {
        return commentaireRepository.findAll();
    }

    @Override
    public List<Commentaire> listeCommentairesByIdSite(Long idSite) {
        return commentaireRepository.findAllByIdSite(idSite);
    }

    @Override
    public void supprimerCommentaireById(Long idCommentaire) {
        commentaireRepository.deleteById(idCommentaire);
    }
}
