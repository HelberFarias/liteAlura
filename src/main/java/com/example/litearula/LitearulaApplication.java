package com.example.litearula;

import com.example.litearula.external.GutendexClient;
import com.example.litearula.service.DataConverter;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LitearulaApplication implements CommandLineRunner {
    DataConverter converter = new DataConverter();
    GutendexClient client = new GutendexClient();

    public static void main(String[] args) {
        SpringApplication.run(LitearulaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Principal principal = new Principal(converter, client);
        principal.showMenu();
    }
}
