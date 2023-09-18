package serjir.universiti.cours_project.business_trips.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
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
    private LocalDate startDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "end_date")
    private LocalDate endDate;
    @Column(name = "city")
    private String city;

    @OneToMany
    private List<Employee> employees = new ArrayList<>();

    public List<Employee> getEmployees(){
        return employees;
    }

    public Trip(LocalDate start, LocalDate end, String city) {
        this.city = city;
        this.endDate = end;
        this.startDate = start;
    }

    public void addEmployee(Employee employee){
        employees.add(employee);
    }

    public void deleteEmployee(Employee employee) {
       Integer employeeIdToDelete = employee.getId();
       employees.removeIf(obj -> obj.getId()==employeeIdToDelete);
    }
}
