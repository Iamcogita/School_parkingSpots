package academy.mindswap.School_parkingSpots.School_parkingSpots.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;

@Document
@Data
@ToString(exclude = "owner")
@Table(name = "Vehicles")
public class Vehicle {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id;
    private String brand;
    private String model;
    private String licensePlate;
    private String fuelType;
    private Boolean isTwoWheeler;

    @JsonIgnore
    @OneToOne
    private Teacher owner;
}
