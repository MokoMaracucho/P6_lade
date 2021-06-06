package com.oc.p6_lade.service;

import com.oc.p6_lade.entity.Privilege;
import com.oc.p6_lade.form.FormInscription;
import org.jasypt.util.password.ConfigurablePasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

import com.oc.p6_lade.entity.Utilisateur;
import com.oc.p6_lade.repository.UtilisateurRepository;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {

    private static final String ALGORYTHME_CHIFFREMENT 		= "SHA-256";

    private final UtilisateurRepository utilisateurRepository;

    @Autowired
    public UtilisateurServiceImpl(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    @Override
    public void enregistrerUtilisateur(FormInscription formInscription) {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setPrenomUtilisateur(formInscription.getPrenomFormInscription());
        utilisateur.setNomUtilisateur(formInscription.getNomFormInscription());
        utilisateur.setEmailUtilisateur(formInscription.getEmailFormInscription());
        String motDePasseFormInscription = formInscription.getEmailFormInscription();
        ConfigurablePasswordEncryptor passwordEncryptor = new ConfigurablePasswordEncryptor();
        passwordEncryptor.setAlgorithm(ALGORYTHME_CHIFFREMENT);
        passwordEncryptor.setPlainDigest(false);
        String motDePasseChiffre = passwordEncryptor.encryptPassword(motDePasseFormInscription);
        utilisateur.setMotDePasseUtilisateur(motDePasseChiffre);
        List<Utilisateur> listeUtilisateurs = utilisateurRepository.findAll();
        if(listeUtilisateurs.isEmpty()) {
            utilisateur.setPrivilegeUtilisateur(Privilege.MEMBRE);
        } else {
            utilisateur.setPrivilegeUtilisateur(Privilege.UTILISATEUR);
        }
        utilisateur.setDateInscriptionUtilisateur(new Timestamp(System.currentTimeMillis()));
        utilisateurRepository.save(utilisateur);
    }

    @Override
    public Utilisateur selectionUtilisateurParEmail(String emailUtilisateur) {
        return utilisateurRepository.getByEmailUtilisateur(emailUtilisateur);
    }

    @Override
    public boolean existanceEmailUtilisateur(String emailUtilisateur) {
        return utilisateurRepository.existsByEmailUtilisateur(emailUtilisateur);
    }

    @Override
    public List<Utilisateur> listeUtilisateurs() {
        return utilisateurRepository.findAll();
    }
}
