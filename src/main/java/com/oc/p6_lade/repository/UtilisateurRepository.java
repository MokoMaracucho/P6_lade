package com.oc.p6_lade.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oc.p6_lade.entity.Utilisateur;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

    Utilisateur getByEmailUtilisateur(String emailUtilisateur);

    Boolean existsByEmailUtilisateur(String emailUtilisateur);
}
