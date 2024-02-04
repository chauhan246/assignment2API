package com.individualAssignment2.assignment2API;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Assignment2ApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(Assignment2ApiApplication.class, args);

        Assignment2APIController controller = new Assignment2APIController();
        controller.getEmojiHub();

        controller.getAnime();
    }

}
