package co.edu.uniquindio.proyectoBases2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableJpaRepositories(basePackages = "co.edu.uniquindio.proyectoBases2.repositories.jpa")
@EnableMongoRepositories(basePackages = "co.edu.uniquindio.proyectoBases2.repositories.mongo")
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
