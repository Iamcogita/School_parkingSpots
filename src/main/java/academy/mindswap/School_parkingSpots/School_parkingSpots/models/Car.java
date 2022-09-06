package academy.mindswap.School_parkingSpots.School_parkingSpots.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@DiscriminatorValue("car")
public class Car extends Vehicle{

    private Integer numberOfDoors;

    public Car(){}


}
