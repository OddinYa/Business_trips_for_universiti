package serjir.universiti.cours_project.business_trips.controllers;


import lombok.Data;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import serjir.universiti.cours_project.business_trips.DAO.EmployeeDAOImpl;
import org.springframework.stereotype.Controller;
import serjir.universiti.cours_project.business_trips.entity.Employee;

@Controller
@Data
@RequestMapping("/employee")
public class ControllerEmployee {

    private final EmployeeDAOImpl employeeDAO;


    public ControllerEmployee(EmployeeDAOImpl employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @GetMapping
    private String getEmployee(Model model){
        model.addAttribute("employees",employeeDAO.getEmployees());
        return "employees";
    }
    @GetMapping("/new")
    public String newEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "new";
    }

    @PostMapping()
    public String create(@ModelAttribute Employee employee, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "new";
        }
        employeeDAO.createEntity(employee);

        return "redirect:/employees";
    }


}
