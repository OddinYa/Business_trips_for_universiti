package serjir.universiti.cours_project.business_trips.DAO;

import serjir.universiti.cours_project.business_trips.entity.Travel;

public interface DataServiceTravel {

    public void createEntity(Travel travel);
    public Travel findTheEntity(Integer id);

    public void updateEntity (Integer id, Travel travel);

    public void deleteEntity(Integer id);


}
