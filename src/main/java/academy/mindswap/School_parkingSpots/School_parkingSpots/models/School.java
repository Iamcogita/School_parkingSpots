package academy.mindswap.School_parkingSpots.School_parkingSpots.models;

import lombok.Data;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
@ToString
@Table(name = "Schools")
public class School {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id;
    private String schoolName;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        School school = (School) o;
        return id.equals(school.id) && schoolName.equals(school.schoolName) && Objects.equals(parkingSpots, school.parkingSpots) && Objects.equals(teachers, school.teachers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, schoolName, parkingSpots, teachers);
    }
}
