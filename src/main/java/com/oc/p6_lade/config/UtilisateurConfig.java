package com.oc.p6_lade.config;

import com.oc.p6_lade.entity.Privilege;
import com.oc.p6_lade.entity.Utilisateur;
import com.oc.p6_lade.repository.UtilisateurRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Configuration
public class UtilisateurConfig {

    @Bean
    CommandLineRunner commandLineRunner(UtilisateurRepository utilisateurRepository) {
        return args -> {
            Utilisateur federico = new Utilisateur(
                    1L,
                    "Federico",
                    "Desmoulin",
                    "desmoulin.federico@gmail.com",
                    "MOTpasse",
                    Privilege.MEMBRE,
                    Timestamp.valueOf(LocalDateTime.now()),

            );

            Utilisateur mathieu = new Utilisateur(
                    2L,
                    "Mathieu",
                    "Desmoulin",
                    "desmoulin.mathieu@gmail.com",
                    "MOTpasse",
                    Privilege.UTILISATEUR,
                    Timestamp.valueOf(LocalDateTime.now())
            );

            utilisateurRepository.saveAll(
                    List.of(federico, mathieu)
            );
        };
    }
}
