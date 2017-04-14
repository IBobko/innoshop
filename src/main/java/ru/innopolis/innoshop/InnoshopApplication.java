package ru.innopolis.innoshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Main class of Application which starts first.
 */
@SpringBootApplication
@EnableScheduling
public class InnoshopApplication {
    /**
     * The main function which executes when application is started.
     *
     * @param args Arguments of command line.
     */
    public static void main(final String[] args) {
        SpringApplication.run(InnoshopApplication.class, args);
    }


}

