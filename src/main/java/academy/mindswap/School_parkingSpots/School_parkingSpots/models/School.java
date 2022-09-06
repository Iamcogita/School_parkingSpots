package academy.mindswap.School_parkingSpots.School_parkingSpots.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name = "Schools")
public class School {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Integer id;
    private String schoolName;
    @OneToMany(
            cascade = {CascadeType.ALL},
            orphanRemoval = false,
            mappedBy = "school"
    )
    private Set<ParkingSpot> parkingSpots;

    public void addParkingSpots(ParkingSpot spot){
        parkingSpots.add(spot);
        spot.setSchool(this);
    }



}
