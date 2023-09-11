package serjir.universiti.cours_project.business_trips.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Travel {
    @Id
    @Column(name = "id")
    private Integer id;
    @OneToMany
    private List<Employee> employee;


    @Temporal(TemporalType.DATE)
    @Column(name = "start_date")
    private Date startDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "end_date")
    private Date endDate;

}
