package academy.mindswap.School_parkingSpots.School_parkingSpots.models;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@Table(name= "Teachers")
public class Teacher {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String sensitiveData;

    @OneToOne
    private Vehicle personalVehicle;

    @OneToOne
    private ParkingSpot personalSpot;

    @OneToOne
    @ToString.Exclude
    private ParkingSpot motorcycleParking;

    @ManyToOne
    private School school;

}
