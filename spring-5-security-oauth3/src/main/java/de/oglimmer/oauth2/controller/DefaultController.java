package de.oglimmer.oauth2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DefaultController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/secured")
    public String secured() {
        return "secured";
    }

}
