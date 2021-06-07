package com.oc.p6_lade.service;

import java.sql.Timestamp;
import java.util.List;

import org.jasypt.util.password.ConfigurablePasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oc.p6_lade.form.FormInscription;
import com.oc.p6_lade.form.FormMajUtilisateur;
import com.oc.p6_lade.entity.Privilege;
import com.oc.p6_lade.entity.Utilisateur;
import com.oc.p6_lade.exception.ResourceNotFoundException;
import com.oc.p6_lade.repository.UtilisateurRepository;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {

    private static final String ALGORYTHME_CHIFFREMENT 		= "SHA-256";

    private UtilisateurRepository utilisateurRepository;

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
    public Utilisateur selectionnerUtilisateurParId(Long idUtilisateur) throws ResourceNotFoundException {
        return utilisateurRepository.findById(idUtilisateur).orElseThrow(() -> new ResourceNotFoundException(idUtilisateur));
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

    @Override
    public FormMajUtilisateur formulaireMajUtilisateur(Utilisateur utilisateur) {
        FormMajUtilisateur formMajUtilisateur = new FormMajUtilisateur();
        formMajUtilisateur.setPrenomFormMajUtilisateur(utilisateur.getPrenomUtilisateur());
        formMajUtilisateur.setNomFormMajUtilisateur(utilisateur.getNomUtilisateur());
//		forMajUtilisateur.setEmailFormMajUtilisateur(utilisateur.getEmailUtilisateur());
        if(utilisateur.getPrivilegeUtilisateur() == Privilege.UTILISATEUR) {
            formMajUtilisateur.setMembreFormMajUtilisateur(false);
        } else {
            formMajUtilisateur.setMembreFormMajUtilisateur(true);
        }
        return formMajUtilisateur;
    }

    @Override
    public void traitementMajUtilisateur(FormMajUtilisateur formMajUtilisateur) {
        Long idUtilisateur = formMajUtilisateur.getIdFormMajUtilisateur();
        Utilisateur utilisateur = utilisateurRepository.getOne(idUtilisateur);
        if(utilisateur.getPrenomUtilisateur() != formMajUtilisateur.getPrenomFormMajUtilisateur()) {
            utilisateur.setPrenomUtilisateur(formMajUtilisateur.getPrenomFormMajUtilisateur());
        }
        if(utilisateur.getNomUtilisateur() != formMajUtilisateur.getNomFormMajUtilisateur()) {
            utilisateur.setNomUtilisateur(formMajUtilisateur.getNomFormMajUtilisateur());
        }
//		if(utilisateur.getEmailUtilisateur() != formMajUtilisateur.getEmailFormMajUtilisateur()) {
//			utilisateur.setEmailUtilisateur(formMajUtilisateur.getEmailFormMajUtilisateur());
//			String emailMaj = formMajUtilisateur.getEmailFormMajUtilisateur();
//			utilisateurRepository.majEmailUtilisateur(idUtilisateur, emailMaj);
//		}
        if(formMajUtilisateur.getMembreFormMajUtilisateur() == null) {
            formMajUtilisateur.setMembreFormMajUtilisateur(false);
        }
        if(formMajUtilisateur.getMembreFormMajUtilisateur() == true) {
            utilisateur.setPrivilegeUtilisateur(Privilege.MEMBRE);
        } else {
            utilisateur.setPrivilegeUtilisateur(Privilege.UTILISATEUR);
        }
        utilisateurRepository.save(utilisateur);
    }

    @Override
    public void suppressionUtilisateurParId(Long idUtilisateur) throws ResourceNotFoundException {
        utilisateurRepository.deleteById(idUtilisateur);
    }
}
