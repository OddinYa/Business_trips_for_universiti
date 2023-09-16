package serjir.universiti.cours_project.business_trips.controllers;


import lombok.Data;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import serjir.universiti.cours_project.business_trips.entity.Employee;
import serjir.universiti.cours_project.business_trips.DAO.EmployeeDAOImpl;
@Controller
@RequestMapping("/employee")
public class ControllerEmployee {

    private final EmployeeDAOImpl employeeDAO;


    public ControllerEmployee(EmployeeDAOImpl employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @GetMapping
    private String getEmployee(Model model) {
        model.addAttribute("employees", employeeDAO.getEmployees());
        return "employees";
    }

    @GetMapping("/new")
    public String newEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "new";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@RequestParam(name = "name") String name,
                         @RequestParam("surname") String surname,
                         @RequestParam("position") String position, Model model) {


        Employee employee = new Employee(name, surname, position);

        employeeDAO.createEntity(employee);

        return "redirect:/employee";
    }

    @GetMapping("/{id}")
    public String getEmployee(@PathVariable("id") int id, Model model) {

        Employee employee = employeeDAO.findTheEntity(id);
        model.addAttribute("employee", employee);

        return "employee";
    }

    @PostMapping(value = "/{id}/delete")
    public String delete(@PathVariable("id") int id, Model model){
        employeeDAO.deleteEntity(id);
        return "message";
    }

}
