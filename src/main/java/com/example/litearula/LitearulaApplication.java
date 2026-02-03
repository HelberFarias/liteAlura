package com.example.litearula;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LitearulaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LitearulaApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        Principal principal = new Principal();
        principal.showMenu();
    }
}
