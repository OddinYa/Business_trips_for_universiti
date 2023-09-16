package serjir.universiti.cours_project.business_trips.DAO;

import serjir.universiti.cours_project.business_trips.entity.Trip;

public interface DataServiceTrip {

    public void createEntity(Trip travel);
    public Trip findTheEntity(Integer id);

    public void updateEntity (Integer id, Trip travel);

    public void deleteEntity(Integer id);


}
