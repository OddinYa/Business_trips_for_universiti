package serjir.universiti.cours_project.business_trips.DAO;

import java.util.Objects;

public interface DataServiceEmployee {

    public void createEntity(Objects objects);
    public Objects findTheEntity(Integer id);

    public void updateEntity (Integer id,Objects objects);

    public void deleteEntity(Integer id);


}
