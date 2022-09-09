package academy.mindswap.School_parkingSpots.School_parkingSpots.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;


@Entity
@Data
@Table(name = "parking_spots")
public class ParkingSpot {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id;
    private String typeOfParking;
    private Boolean isOccupied;

    @ToString.Exclude
    @JsonIgnoreProperties
    @JsonIgnore
    @OneToOne( mappedBy = "personalSpot" )
    private Teacher reservedSpot;

    @ToString.Exclude
    @JsonIgnoreProperties
    @JsonIgnore
    @ManyToOne
    private School school;


}
