package com.example.mvctest;

import com.example.mvctest.entities.Patient;
import com.example.mvctest.repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@SpringBootApplication
public class MvcTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(MvcTestApplication.class, args);
    }


    @Bean
    CommandLineRunner start(PatientRepository patientRepository) {
        return args -> {
            for (int i = 0; i < 25; i++) {
                patientRepository.save(
                        new Patient(null, "Nawfal", new Date(), Math.random() > 0.5 ? true:false, (int) (Math.random() * 5)));
                patientRepository.save(
                        new Patient(null, "Abrak", new Date(), Math.random() > 0.5 ? true:false, (int) (Math.random() * 5)));
                patientRepository.save(
                        new Patient(null, "Marouane", new Date(), Math.random() > 0.5 ? true:false, (int) (Math.random() * 5)));
                patientRepository.save(
                        new Patient(null, "Hamza", new Date(), Math.random() > 0.5 ? true:false, (int) (Math.random() * 5)));
            }

            patientRepository.findAll().forEach(p -> {
                System.out.println(p.getName());
            });
        };
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
