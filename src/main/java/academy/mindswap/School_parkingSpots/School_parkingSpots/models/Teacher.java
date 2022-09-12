package academy.mindswap.School_parkingSpots.School_parkingSpots.models;

import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;

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

    @ManyToOne
    private School school;


}
