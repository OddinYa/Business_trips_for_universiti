package serjir.universiti.cours_project.business_trips.DAO;

import org.hibernate.annotations.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import serjir.universiti.cours_project.business_trips.entity.Travel;
import serjir.universiti.cours_project.business_trips.repository.TripRepo;

import java.util.Objects;
import java.util.Optional;

@Component
public class TravelDAOImpl implements DataServiceTravel {

    @Autowired
    TripRepo repo;


    @Override
    public void createEntity(Travel travel) {
        repo.save(travel);
    }

    @Override
    public Travel findTheEntity(Integer id) {
        return null;
    }

    @Override
    public void updateEntity(Integer id, Travel travel) {
        Optional<Travel> optionalTravel = repo.findById(id);

        if(optionalTravel.isPresent()){
            Travel existingTravel = optionalTravel.get();

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
