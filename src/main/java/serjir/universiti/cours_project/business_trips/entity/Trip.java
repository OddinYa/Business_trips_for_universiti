package serjir.universiti.cours_project.business_trips.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "trip")
@NoArgsConstructor
public class Trip {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Temporal(TemporalType.DATE)
    @Column(name = "start_date")
    private Date startDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "end_date")
    private Date endDate;
    @Column(name = "city")
    private String city;

    @OneToMany
    private List<Employee> employees = new ArrayList<>();

    public List<Employee> getEmployees(){
        return employees;
    }

    public Trip(Date start, Date end, String city) {
        this.city = city;
        this.endDate = end;
        this.startDate = start;
    }

}
