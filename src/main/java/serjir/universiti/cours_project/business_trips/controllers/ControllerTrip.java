package serjir.universiti.cours_project.business_trips.controllers;


import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import serjir.universiti.cours_project.business_trips.DAO.TripDAOImpl;
import serjir.universiti.cours_project.business_trips.entity.Trip;

import java.util.Date;


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

    @GetMapping("new")
    public String newEmployeeForm(Model model) {
        return "trip/new";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String create(@RequestParam("startDate")  @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
                         @RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate,
                         @RequestParam("city") String city, Model model) {


        Trip trip = new Trip(startDate, endDate, city);

        tripDAO.createEntity(trip);

        return "redirect:/trip";
    }

    @GetMapping("/{id}")
    public String getTrip(@PathVariable("id") int id,Model model){
        model.addAttribute("trip",tripDAO.findTheEntity(id));
        return "trip/trip";
    }

    @PostMapping(value = "/{id}/delete")
    public String delete(@PathVariable("id") int id, Model model) {
        tripDAO.deleteEntity(id);
        return "trip/messageDelete";
    }
}
