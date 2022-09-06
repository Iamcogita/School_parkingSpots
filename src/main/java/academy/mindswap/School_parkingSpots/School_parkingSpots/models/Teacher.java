package academy.mindswap.School_parkingSpots.School_parkingSpots.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name= "Teachers")
public class Teacher {

    @Id
    private Integer id;

    @OneToOne(mappedBy = "owner")
    private Vehicle vehicle;

    @OneToOne
    private ParkingSpot parkingSpot;



}
