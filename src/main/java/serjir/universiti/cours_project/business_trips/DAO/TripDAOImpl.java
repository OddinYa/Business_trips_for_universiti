package serjir.universiti.cours_project.business_trips.DAO;

import org.springframework.stereotype.Component;
import serjir.universiti.cours_project.business_trips.entity.Trip;
import serjir.universiti.cours_project.business_trips.repository.TripRepo;

import java.util.List;
import java.util.Optional;

@Component
public class TripDAOImpl implements DataServiceTrip {
    private final TripRepo repo;

    public TripDAOImpl(TripRepo repo) {
        this.repo = repo;
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
    public void updateEntity(Integer id, Trip travel) {
        Optional<Trip> optionalTravel = repo.findById(id);

        if (optionalTravel.isPresent()) {
            Trip existingTravel = optionalTravel.get();

            // todo update TravelEntity

        } else {
            travel.setId(id);
            repo.save(travel);
        }


    }

    @Override
    public void deleteEntity(Integer id) {
        repo.deleteById(id);
    }

    @Override
    public List<Trip> getEmployees() {
        return repo.findAll();
    }

    @Override
    public List<Trip> searchEntity(Integer id, String name, String surname) {
        return null;
    }
}
