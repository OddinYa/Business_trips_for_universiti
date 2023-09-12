package serjir.universiti.cours_project.business_trips.entity;




import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import serjir.universiti.cours_project.business_trips.enums.Position;


@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name ="employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String Name;
    private String Surname;

    private Position position;
    @ManyToOne()
    private Travel travel;


}
