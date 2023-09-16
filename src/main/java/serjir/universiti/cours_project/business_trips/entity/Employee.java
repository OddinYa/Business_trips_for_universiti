package serjir.universiti.cours_project.business_trips.entity;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@EqualsAndHashCode
@Entity
@NoArgsConstructor
@Table(name ="employee")
@ToString
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String surname;

    private String position;

    @ManyToOne()
    private Trip travel;

    public  Employee(String name,String surname,String position){
        this.name = name;
        this.surname = surname;
        this.position = position;
        travel = null;
    }
}
