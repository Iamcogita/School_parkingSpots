package academy.mindswap.School_parkingSpots.School_parkingSpots.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "parking_spots")
public class ParkingSpot {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id;
    private String typeOfParking;
    private Boolean isOccupied;

    /*  ----------------------SEPARATOR FOR CLARITY------------------------------  */

    @ToString.Exclude
    @JsonIgnoreProperties
    @JsonIgnore
    @OneToOne( mappedBy = "personalSpot" )
    private Teacher reservedSpot;

    /*  ----------------------SEPARATOR FOR CLARITY------------------------------  */

    @ToString.Exclude
    @JsonIgnoreProperties
    @JsonIgnore
    @ManyToOne
    private School school;

    /*  ----------------------SEPARATOR FOR CLARITY------------------------------  */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ParkingSpot that = (ParkingSpot) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
