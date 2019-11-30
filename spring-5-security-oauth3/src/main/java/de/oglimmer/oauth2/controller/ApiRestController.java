package de.oglimmer.oauth2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiRestController {

    @GetMapping("/rest/v1/values")
    public String getValue() {
        return "42";
    }

}
