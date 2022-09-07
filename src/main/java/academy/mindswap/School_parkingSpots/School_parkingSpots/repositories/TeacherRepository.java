package academy.mindswap.School_parkingSpots.School_parkingSpots.repositories;
import academy.mindswap.School_parkingSpots.School_parkingSpots.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher , Integer> {
}
