package com.oc.p6_lade.controller;

import com.oc.p6_lade.entity.Privilege;
import com.oc.p6_lade.entity.Utilisateur;
import com.oc.p6_lade.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping(path="lade/utilisateur")
public class UtilisateurController {

    private final UtilisateurService utilisateurService;

    @Autowired
    public UtilisateurController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @GetMapping(path="liste_utilisateurs")
    public List<Utilisateur> listeUtilisateurs() {
        return utilisateurService.listeUtilisateurs();
    }
}
