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
@Table(name = "Schools")
public class School {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id;
    private String schoolName;

    /*  ----------------------SEPARATOR FOR CLARITY------------------------------  */

    @ToString.Exclude
    @JsonIgnoreProperties
    @JsonIgnore
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

    /*  ----------------------SEPARATOR FOR CLARITY------------------------------  */
    @ToString.Exclude
    @JsonIgnoreProperties
    @JsonIgnore
    @OneToMany(
            cascade = {CascadeType.ALL},
            orphanRemoval = false,
            mappedBy = "school"
    )
    private Set<Teacher> teachers;

    public void addTeachers(Teacher teacher){
        teachers.add(teacher);
        teacher.setSchool(this);
    }

    /*  ----------------------SEPARATOR FOR CLARITY------------------------------  */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        School school = (School) o;
        return id != null && Objects.equals(id, school.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}