package serjir.universiti.cours_project.business_trips.controllers;


import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import serjir.universiti.cours_project.business_trips.DAO.TripDAOImpl;
import serjir.universiti.cours_project.business_trips.entity.Trip;


import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.time.LocalDate;


@Controller
@RequestMapping("/trip")
public class ControllerTrip {

    private final TripDAOImpl tripDAO;

    public ControllerTrip(TripDAOImpl tripDAO) {
        this.tripDAO = tripDAO;
    }

    @GetMapping
    private String getTrips(Model model) {
        model.addAttribute("trip", tripDAO.getTrips());
        return "trip/listtrip";
    }

    @GetMapping("new")
    public String newEmployeeForm(Model model) {
        return "trip/new";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String create(@RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
                         @RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate,
                         @RequestParam("city") String city, Model model) {


        Trip trip = new Trip(startDate, endDate, city);

        tripDAO.createEntity(trip);

        return "redirect:/trip";
    }

    @GetMapping("/{id}")
    public String getTrip(@PathVariable("id") int id, Model model) {
        model.addAttribute("trip", tripDAO.findTheEntity(id));
        return "trip/trip";
    }

    @PostMapping(value = "/{id}/delete")
    public String delete(@PathVariable("id") int id, Model model) {
        tripDAO.deleteList(id);
        tripDAO.deleteEntity(id);

        return "trip/messageDelete";
    }

    @GetMapping("/{id}/edit")
    public String getEdit(@PathVariable("id") int id, Model model) {
        Trip trip = tripDAO.findTheEntity(id);
        model.addAttribute("trip", trip);

        return "trip/edit";
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    public String edit(@RequestParam("id") int id,
                       @RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
                       @RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate,
                       @RequestParam("city") String city, Model model) {

        Trip trip = new Trip(startDate, endDate, city);
        tripDAO.updateEntity(id, trip);
        return "redirect:/trip";
    }

    @GetMapping("/{id}/download")
    public ResponseEntity<Resource> downloadDocument(@PathVariable Integer id) {

        Trip trip = tripDAO.findTheEntity(id);

        String fileContent = tripDAO.createFile(trip);

        String nameFile = trip.getId().toString()+trip.getStartDate().toString()+trip.getEndDate().toString()+".txt";

        try {
            byte[] data = fileContent.getBytes("UTF-8");

            ByteArrayResource resource = new ByteArrayResource(data);

            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + URLEncoder.encode(nameFile, "UTF-8") + "\"");
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);

            return ResponseEntity.ok()
                    .headers(headers)
                    .contentLength(data.length)
                    .body(resource);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}


