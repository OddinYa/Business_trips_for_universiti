package serjir.universiti.cours_project.business_trips.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import serjir.universiti.cours_project.business_trips.enums.Position;


@Getter
@Setter
@EqualsAndHashCode
@Entity
@NoArgsConstructor
@Table(name ="employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String surname;

    private String position;

    @ManyToOne()
    private Travel travel;

    public  Employee(String name,String surname,String position){
        this.name = name;
        this.surname = surname;
        this.position = position;
        travel = null;
    }
}
