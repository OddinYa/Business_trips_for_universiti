package serjir.universiti.cours_project.business_trips.DAO;

import org.springframework.stereotype.Component;
import serjir.universiti.cours_project.business_trips.entity.Employee;
import serjir.universiti.cours_project.business_trips.entity.Trip;
import serjir.universiti.cours_project.business_trips.repository.EmployeeRepo;
import serjir.universiti.cours_project.business_trips.repository.TripRepo;

import java.util.List;
import java.util.Optional;


@Component
public class TripDAOImpl implements DataServiceTrip {
    private final TripRepo repo;
    private final EmployeeRepo employeeRepo;

    public TripDAOImpl(TripRepo repo,
                       EmployeeRepo employeeRepo) {
        this.repo = repo;
        this.employeeRepo = employeeRepo;
    }


    @Override
    public void createEntity(Trip trip) {
        repo.save(trip);
    }

    @Override
    public Trip findTheEntity(Integer id) {
        return repo.findById(id).get();
    }


    @Override
    public void updateEntity(Integer id, Trip trip) {
        Optional<Trip> optionalTravel = repo.findById(id);

        if (optionalTravel.isPresent()) {
            Trip existingTrip = optionalTravel.get();
            Integer tempId = existingTrip.getId();

            existingTrip = trip;
            existingTrip.setId(tempId);
            repo.save(existingTrip);
        } else {
            trip.setId(id);
            repo.save(trip);
        }
    }

    @Override
    public void deleteEntity(Integer id) {
        repo.deleteById(id);
    }

    @Override
    public List<Trip> getTrips() {
        return repo.findAll();
    }


    @Override
    public void deleteList(int id) {
       Trip trip = repo.findById(id).get();
       List<Employee> employees = trip.getEmployees();

       employees.forEach(employee -> employee.setTrip(null));

       employees.clear();

       trip.setEmployees(null);
    }

    @Override
    public String createFile(Trip trip) {
        StringBuilder result = new StringBuilder();
        result.append(trip.getCity());
        result.append("  ");
        result.append(trip.getStartDate());
        result.append(" - ");
        result.append(trip.getEndDate());
        result.append("\n");
        result.append("Список сотрудников в командировке:"+"\n");
        result.append("id"+ "\t"+"Имя"+"\t"+"Фамилие"+"\n");
        for (Employee e : trip.getEmployees())
        {
         result.append(e.getId()+"\t"+e.getName()+"\t"+e.getSurname());
         result.append("\n");
        }

        return result.toString();
    }


}
