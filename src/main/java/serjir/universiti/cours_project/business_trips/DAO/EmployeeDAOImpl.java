package serjir.universiti.cours_project.business_trips.DAO;

import org.springframework.stereotype.Component;
import serjir.universiti.cours_project.business_trips.entity.Employee;
import serjir.universiti.cours_project.business_trips.repository.EmployeeRepo;

import java.util.*;
import java.util.stream.Collectors;

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

        if (optionalTravel.isPresent()) {
            Employee existingTravel = optionalTravel.get();
            Integer tempId = existingTravel.getId();
            existingTravel = employee;
            existingTravel.setId(tempId);

            repo.save(employee);
        } else {
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

        List<Employee> list = repo.findAll();
        Comparator<Employee> idComparator = Comparator.comparing(Employee::getId);
        Collections.sort(list, idComparator);

        return list;
    }

    @Override
    public List<Employee> searchEntity(Integer id, String name, String surname) {


        if (id != null) {

            return repo.findById(id).stream().toList();

        } else {
            if (surname != "") {

                if (name != "") {
                    return repo.findBySurnameAndName(surname, name);
                }
                return repo.findBySurname(surname);
            } else {
                return repo.findByName(name);
            }
        }


    }
}
