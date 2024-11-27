/*
Author: Ene Bogdan
Country: Romania
*/
package exercitii._3._2._IntroToThymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "index/")
public class AboutController {

    @RequestMapping(value = "/about")
    public String about() {
        return "about";
    }
}
