package serjir.universiti.cours_project.business_trips.DAO;

import org.springframework.stereotype.Component;
import serjir.universiti.cours_project.business_trips.entity.Travel;
import serjir.universiti.cours_project.business_trips.repository.TravelRepo;

import java.util.Optional;

@Component
public class TravelDAOImpl implements DataServiceTravel {
    private final TravelRepo repo;

    public TravelDAOImpl(TravelRepo repo) {
        this.repo = repo;
    }


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
