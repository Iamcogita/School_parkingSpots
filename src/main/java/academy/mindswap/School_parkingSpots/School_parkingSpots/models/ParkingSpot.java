package academy.mindswap.School_parkingSpots.School_parkingSpots.models;

import lombok.Data;
import javax.persistence.*;


@Entity
@Data
@Table(name = "parking_spots")
public class ParkingSpot {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Integer id;

    private Boolean isOccupied;

    private String typeOfVehicle;

    @ManyToOne
    private School school;

}
