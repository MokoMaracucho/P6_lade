package com.oc.p6_lade.controller;

import com.oc.p6_lade.entity.Privilege;
import com.oc.p6_lade.entity.Utilisateur;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping(path="lade/utilisateur")
public class UtilisateurController {

    @GetMapping(path="liste_utilisateurs")
    public List<Utilisateur> listeUtilisateurs() {
        return List.of(
                new Utilisateur(
                        1L,
                        "Federico",
                        "Desmoulin",
                        "desmoulin.federico@gmail.com",
                        "MOTpasse",
                        Privilege.MEMBRE,
                        LocalDate.of(2021, Month.JUNE, 6)
                )
        );
    }
}
