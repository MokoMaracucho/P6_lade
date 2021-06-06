package com.oc.p6_lade.controller;

import com.oc.p6_lade.entity.Utilisateur;
import com.oc.p6_lade.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping(path="lade/utilisateur")
public class UtilisateurController {

    public static final String ATT_LISTE_UTILISATEURS				 		= "listeUtilisateurs";

    private final UtilisateurService utilisateurService;

    @Autowired
    public UtilisateurController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @GetMapping(path="liste_utilisateurs")
    public String listeUtilisateurs(Model model) {
        List<Utilisateur> listeUtilisateurs = utilisateurService.listeUtilisateurs();
        model.addAttribute(ATT_LISTE_UTILISATEURS, listeUtilisateurs);
        return "liste_utilisateurs";
    }
}
