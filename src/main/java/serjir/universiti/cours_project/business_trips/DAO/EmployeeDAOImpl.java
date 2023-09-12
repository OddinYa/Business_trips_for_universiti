package serjir.universiti.cours_project.business_trips.DAO;

import org.springframework.stereotype.Component;
import serjir.universiti.cours_project.business_trips.repository.EmployeeRepo;

import java.util.Objects;

@Component
public class EmployeeDAOImpl implements DataServiceEmployee {
    private final EmployeeRepo repo;

    public EmployeeDAOImpl(EmployeeRepo repo) {
        this.repo = repo;
    }

    @Override
    public void createEntity(Objects objects) {

    }

    @Override
    public Objects findTheEntity(Integer id) {
        return null;
    }

    @Override
    public void updateEntity(Integer id, Objects objects) {

    }

    @Override
    public void deleteEntity(Integer id) {

    }
}
