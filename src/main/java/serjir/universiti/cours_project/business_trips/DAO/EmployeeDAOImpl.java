package serjir.universiti.cours_project.business_trips.DAO;

import org.springframework.stereotype.Component;
import serjir.universiti.cours_project.business_trips.entity.Employee;
import serjir.universiti.cours_project.business_trips.repository.EmployeeRepo;

import java.util.List;
import java.util.Objects;

@Component
public class EmployeeDAOImpl implements DataServiceEmployee {
    private final EmployeeRepo repo;

    public EmployeeDAOImpl(EmployeeRepo repo) {
        this.repo = repo;
    }

    @Override
    public void createEntity(Employee employee) {

    }

    @Override
    public Employee findTheEntity(Integer id) {
        return null;
    }

    @Override
    public void updateEntity(Integer id, Employee employee) {

    }

    @Override
    public void deleteEntity(Integer id) {

    }

    @Override
    public List<Employee> getEmployees() {

        return repo.findAll();
    }
}
