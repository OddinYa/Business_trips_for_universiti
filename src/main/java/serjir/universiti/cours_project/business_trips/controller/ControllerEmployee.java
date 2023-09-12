package serjir.universiti.cours_project.business_trips.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import serjir.universiti.cours_project.business_trips.DAO.EmployeeDAOImpl;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping()
public class ControllerEmployee {
    @Autowired
    private final EmployeeDAOImpl employeeDAO;


    public ControllerEmployee(EmployeeDAOImpl employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @GetMapping
    private String getEmployee(Model model){
        model.addAttribute("employees");
        return "employees";
    }
}
