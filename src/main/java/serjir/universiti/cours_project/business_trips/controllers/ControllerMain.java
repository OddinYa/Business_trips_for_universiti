package serjir.universiti.cours_project.business_trips.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping
public class ControllerMain {
    @GetMapping
    public String mainController() {
        return "main";
    }
}
