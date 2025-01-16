package org.example.lab9.configuraremasini;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.logging.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class MainApp implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(Masina.class);
    @Autowired
    MasinaJDBC masinaJDBC;

    public static void main(String[] args) {
        SpringApplication.run(MainApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Adaugarea unei masini");
        //masinaJDBC.insert(new Masina("TM42MIV","Audi",2012,"Alb",423000));

        System.out.println("Toate Masinile: ");
        masinaJDBC.findAll().forEach(System.out::println);


    }


}
