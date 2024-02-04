/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.individualAssignment2.assignment2API;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Nehabahen chauhan
 */
@RestController
public class Assignment2APIController {
    /**
     * Getting information of Anime and Quote at this endpoint
     * 
     * @return 
     */

    @GetMapping("/anime")
    public ResponseEntity<Anime> getAnime() {
        RestTemplate restTemplate = new RestTemplate();
        Anime response = restTemplate.getForObject("https://animechan.xyz/api/random", Anime.class);

        //Pritn information of Anime
        System.out.println("");
        System.out.println("******Anime********");
        System.out.println("Anime: " + response.getAnime());
        System.out.println("Character: " + response.getCharacter());
        System.out.println("Quote: " + response.getQuote());
        System.out.println("");

        return new ResponseEntity<Anime>(response, HttpStatus.OK);
    }

    /**
     * Get emoji name and its category and group at this endpoint
     *
     * @return emog
     */
    @GetMapping("/emoji")
    public String getEmojiHub() {
        String name;
        String category;
        String group;
        String emog = null;
        try {
            String url = "https://emojihub.yurace.pro/api/random";
            RestTemplate restTemplate = new RestTemplate();
            ObjectMapper mapper = new ObjectMapper();

            String jSonFact = restTemplate.getForObject(url, String.class);
            JsonNode root = mapper.readTree(jSonFact);

            name = root.findValue("name").asText();
            category = root.findValue("category").asText();
            group = root.findValue("group").asText();

            //print information of Emoji 
            System.out.println(" ");
            System.out.println("****** EmojiHub ********");
            emog = "Name = " + name + "\n" + "Category: " + category + "\n" + "Group: " + group;
            System.out.println(emog);

        } catch (JsonProcessingException ex) {
            Logger.getLogger(Assignment2APIController.class.getName()).log(
                    Level.SEVERE,
                    null, ex);
            System.out.println("error in getEmojiHub");

        }
        return emog;
    }

}
