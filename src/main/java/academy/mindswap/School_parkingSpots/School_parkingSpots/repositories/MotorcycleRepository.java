package academy.mindswap.School_parkingSpots.School_parkingSpots.repositories;

import academy.mindswap.School_parkingSpots.School_parkingSpots.models.Motorcycle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotorcycleRepository extends JpaRepository<Motorcycle, Integer > {
}
