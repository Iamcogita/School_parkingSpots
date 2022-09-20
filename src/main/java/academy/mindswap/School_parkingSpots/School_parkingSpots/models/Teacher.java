package academy.mindswap.School_parkingSpots.School_parkingSpots.models;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;

@Document
@Data
@RequiredArgsConstructor
@Table(name= "Teachers")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String sensitiveData;

    @OneToOne
    private Vehicle personalVehicle;

    @OneToOne
    private ParkingSpot personalSpot;

    @ManyToOne
    private School school;


}
