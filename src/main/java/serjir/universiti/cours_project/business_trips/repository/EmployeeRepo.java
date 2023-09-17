package serjir.universiti.cours_project.business_trips.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import serjir.universiti.cours_project.business_trips.entity.Employee;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Integer> {

    List<Employee>findByName(String name);
    List<Employee>findBySurname(String name);

    List<Employee>findBySurnameAndName(String surname,String name);
}
