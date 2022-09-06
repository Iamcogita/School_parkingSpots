package academy.mindswap.School_parkingSpots.School_parkingSpots.repositories;

import academy.mindswap.School_parkingSpots.School_parkingSpots.models.ParkingSpot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkingSpotRepository extends JpaRepository<ParkingSpot , Integer> {
}
