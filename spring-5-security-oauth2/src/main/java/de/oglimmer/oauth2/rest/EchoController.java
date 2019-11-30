package de.oglimmer.oauth2.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EchoController {


    @GetMapping("/value")
    public String getValue() {
        return "42";
    }


}
