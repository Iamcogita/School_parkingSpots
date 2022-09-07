package academy.mindswap.School_parkingSpots.School_parkingSpots.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;
import javax.persistence.*;

@Entity
@Data
@ToString(exclude = "owner")
@Table(name = "Vehicles")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name = "vehicle_type",
        discriminatorType = DiscriminatorType.STRING
)
public abstract class Vehicle {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id;
    private String brand;
    private String model;
    private String licensePlate;

    @JsonIgnore
    @OneToOne( mappedBy = "personalVehicle")
    private Teacher owner;
}
