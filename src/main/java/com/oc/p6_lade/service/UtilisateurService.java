package com.oc.p6_lade.service;

import java.util.List;

import com.oc.p6_lade.entity.Utilisateur;
import com.oc.p6_lade.form.FormInscription;

public interface UtilisateurService {

    public void enregistrerUtilisateur(FormInscription formInscription);

    public Utilisateur selectionUtilisateurParEmail(String emailUtilisateur);

    public boolean existanceEmailUtilisateur(String emailUtilisateur);

    public List<Utilisateur> listeUtilisateurs();
}
