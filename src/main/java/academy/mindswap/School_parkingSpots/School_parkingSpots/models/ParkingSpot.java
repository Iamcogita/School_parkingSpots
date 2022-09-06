package academy.mindswap.School_parkingSpots.School_parkingSpots.models;

import lombok.Data;
import javax.persistence.*;


@Entity
@Data
@Table(name = "parking_spots")
public class ParkingSpot {

    @Id
    private Integer id;

    private Boolean isOccupied;

    private String typeOfVehicle;

    @OneToOne( mappedBy = "parkingSpot")
    private Teacher teacher;

}
