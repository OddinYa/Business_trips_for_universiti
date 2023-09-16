package serjir.universiti.cours_project.business_trips.DAO;

import serjir.universiti.cours_project.business_trips.entity.Employee;

import java.util.List;
import java.util.Objects;

public interface DataServiceEmployee {

    public void createEntity(Employee employee);
    public Employee findTheEntity(Integer id);

    public void updateEntity (Integer id,Employee employee);

    public void deleteEntity(Integer id);

    public List<Employee> getEmployees();

    public List<Employee> searchEntity(Integer id,String name,String surname);

}
