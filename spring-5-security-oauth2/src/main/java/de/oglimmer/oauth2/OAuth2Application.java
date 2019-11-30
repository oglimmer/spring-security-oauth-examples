package de.oglimmer.oauth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller
public class OAuth2Application {
    public static void main(String[] args) {
        SpringApplication.run(OAuth2Application.class, args);
    }

    @RequestMapping("/")
    public String index() {
        return "secured";
    }

}
