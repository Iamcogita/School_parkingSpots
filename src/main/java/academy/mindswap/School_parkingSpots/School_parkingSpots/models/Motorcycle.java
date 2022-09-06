package academy.mindswap.School_parkingSpots.School_parkingSpots.models;


import lombok.Data;

import javax.persistence.*;


@Entity
@Data
@DiscriminatorValue("motorcycle")
public class Motorcycle extends Vehicle{

    private String helmetType;

    public Motorcycle(){}


}
