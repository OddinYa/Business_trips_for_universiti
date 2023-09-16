package serjir.universiti.cours_project.business_trips.DAO;

import org.springframework.stereotype.Component;
import serjir.universiti.cours_project.business_trips.entity.Employee;
import serjir.universiti.cours_project.business_trips.repository.EmployeeRepo;

import java.util.List;
import java.util.Optional;

@Component
public class EmployeeDAOImpl implements DataServiceEmployee {
    private final EmployeeRepo repo;

    public EmployeeDAOImpl(EmployeeRepo repo) {
        this.repo = repo;
    }

    @Override
    public void createEntity(Employee employee) {
       repo.save(employee);
    }

    @Override
    public Employee findTheEntity(Integer id) {
        return repo.getReferenceById(id);
    }

    @Override
    public void updateEntity(Integer id, Employee employee) {
        Optional<Employee> optionalTravel = repo.findById(id);

        if(optionalTravel.isPresent()){
            Employee existingTravel = optionalTravel.get();
            Integer tempId = existingTravel.getId();
            existingTravel = employee;
            existingTravel.setId(tempId);

            repo.save(employee);
        }else {
            employee.setId(id);
            repo.save(employee);
        }
    }

    @Override
    public void deleteEntity(Integer id) {
        repo.deleteById(id);
    }

    @Override
    public List<Employee> getEmployees() {

        return repo.findAll();
    }
}
