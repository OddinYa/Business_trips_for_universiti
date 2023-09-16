package serjir.universiti.cours_project.business_trips.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import serjir.universiti.cours_project.business_trips.DAO.TripDAOImpl;


@Controller
@RequestMapping("/trip")
public class ControllerTrip {

    private final TripDAOImpl tripDAO;

    public ControllerTrip(TripDAOImpl tripDAO){
        this.tripDAO = tripDAO;
    }

    @GetMapping
    private String getEmployee(Model model) {
        model.addAttribute("trip", tripDAO.getEmployees());
        return "trip/listtrip";
    }


}
