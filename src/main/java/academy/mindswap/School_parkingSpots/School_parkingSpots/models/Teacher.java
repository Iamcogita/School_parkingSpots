package academy.mindswap.School_parkingSpots.School_parkingSpots.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name= "Teachers")
public class Teacher {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @OneToOne(mappedBy = "owner")
    private Vehicle vehicle;

    @OneToOne
    private ParkingSpot parkingSpot;



}
