package serjir.universiti.cours_project.business_trips.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import serjir.universiti.cours_project.business_trips.entity.Travel;

@Repository
public interface TravelRepo extends JpaRepository<Travel,Integer> {
}
