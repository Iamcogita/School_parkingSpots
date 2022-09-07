package academy.mindswap.School_parkingSpots.School_parkingSpots.repositories;

import academy.mindswap.School_parkingSpots.School_parkingSpots.models.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolRepository extends JpaRepository<School , Integer> {
}
