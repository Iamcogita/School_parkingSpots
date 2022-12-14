package academy.mindswap.School_parkingSpots.School_parkingSpots.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Vehicles")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name = "vehicle_type",
        discriminatorType = DiscriminatorType.STRING
)
public abstract class Vehicle {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Integer id;
    private String brand;
    private String model;
    private String licensePlate;
}
