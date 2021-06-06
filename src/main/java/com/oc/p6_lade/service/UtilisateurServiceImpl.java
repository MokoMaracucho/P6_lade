package com.oc.p6_lade.service;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import com.oc.p6_lade.entity.Privilege;
import com.oc.p6_lade.entity.Utilisateur;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {

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
