package com.oc.p6_lade.controller;

import com.oc.p6_lade.entity.Utilisateur;
import com.oc.p6_lade.form.FormInscription;
import com.oc.p6_lade.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(path="lade/utilisateur")
public class UtilisateurController {

    public static final String ATT_SESSION_STATUT							= "sessionStatut";

    public static final String ATT_UTILISATEUR				 				= "utilisateur";

    public static final String ATT_FORM_INSCRIPTION 						= "formInscription";

    public static final String ATT_LISTE_UTILISATEURS				 		= "listeUtilisateurs";

    private final UtilisateurService utilisateurService;

    @Autowired
    public UtilisateurController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @GetMapping("/inscription_utilisateur")
    public String inscriptionUtilisateur(Model model) {
        model.addAttribute(ATT_FORM_INSCRIPTION, new FormInscription());
        return "inscription_utilisateur";
    }

    @PostMapping("/traitement_formulaire_inscription")
    public String traitementInscriptionUtilisateur(HttpServletRequest request, @Valid @ModelAttribute("formInscription") FormInscription formInscription, BindingResult bindingResult, Model model) {
        HttpSession session = request.getSession();
        if(bindingResult.hasErrors()) {
            session.setAttribute(ATT_SESSION_STATUT, false);
            return "/inscription_utilisateur";
        } else {
            utilisateurService.enregistrerUtilisateur(formInscription);
            Utilisateur utilisateur = utilisateurService.selectionUtilisateurParEmail(formInscription.getEmailFormInscription());
            session.setAttribute(ATT_SESSION_STATUT, true);
            session.setAttribute(ATT_UTILISATEUR, utilisateur);
            model.addAttribute(ATT_UTILISATEUR, utilisateur);
            return "redirect:/utilisateur/liste_utilisateurs";
        }
    }

    @GetMapping(path="liste_utilisateurs")
    public String listeUtilisateurs(Model model) {
        List<Utilisateur> listeUtilisateurs = utilisateurService.listeUtilisateurs();
        model.addAttribute(ATT_LISTE_UTILISATEURS, listeUtilisateurs);
        return "liste_utilisateurs";
    }
}
