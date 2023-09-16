package serjir.universiti.cours_project.business_trips.DAO;

import org.springframework.stereotype.Component;
import serjir.universiti.cours_project.business_trips.entity.Trip;
import serjir.universiti.cours_project.business_trips.repository.TripRepo;

import java.util.Optional;

@Component
public class TripDAOImpl implements DataServiceTrip {
    private final TripRepo repo;

    public TripDAOImpl(TripRepo repo) {
        this.repo = repo;
    }


    @Override
    public void createEntity(Trip travel) {
        repo.save(travel);
    }

    @Override
    public Trip findTheEntity(Integer id) {
        return null;
    }

    @Override
    public void updateEntity(Integer id, Trip travel) {
        Optional<Trip> optionalTravel = repo.findById(id);

        if(optionalTravel.isPresent()){
            Trip existingTravel = optionalTravel.get();

            // todo update TravelEntity

        }else {
            travel.setId(id);
            repo.save(travel);
        }


    }

    @Override
    public void deleteEntity(Integer id) {
        repo.deleteById(id);
    }
}
