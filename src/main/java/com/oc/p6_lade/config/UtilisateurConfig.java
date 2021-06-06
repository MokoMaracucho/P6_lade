package com.oc.p6_lade.config;

import com.oc.p6_lade.entity.Privilege;
import com.oc.p6_lade.entity.Utilisateur;
import com.oc.p6_lade.repository.UtilisateurRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
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
                    LocalDate.of(2021, Month.JUNE, 6)
            );

            Utilisateur mathieu = new Utilisateur(
                    2L,
                    "Mathieu",
                    "Desmoulin",
                    "desmoulin.mathieu@gmail.com",
                    "MOTpasse",
                    Privilege.UTILISATEUR,
                    LocalDate.of(2021, Month.JUNE, 6)
            );

            utilisateurRepository.saveAll(
                    List.of(federico, mathieu)
            );
        };
    }
}
