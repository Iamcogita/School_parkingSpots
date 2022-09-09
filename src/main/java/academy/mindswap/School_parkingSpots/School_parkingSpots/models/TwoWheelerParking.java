package academy.mindswap.School_parkingSpots.School_parkingSpots.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "two_wheeler_parking")
public class TwoWheelerParking {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id;
    private String typeOfParking;
    private Boolean isOccupied;

    /*  ----------------------SEPARATOR FOR CLARITY------------------------------  */

    @ToString.Exclude
    @JsonIgnoreProperties
    @JsonIgnore
    @OneToMany(
            cascade = {CascadeType.ALL},
            orphanRemoval = false,
            mappedBy = "motorcycleParking"
    )
    private Set<Teacher> twoWheelerParking;

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
        return id != null && Objects.equals(id, that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
