package academy.mindswap.School_parkingSpots.School_parkingSpots.repositories;

import academy.mindswap.School_parkingSpots.School_parkingSpots.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Integer > {
}
