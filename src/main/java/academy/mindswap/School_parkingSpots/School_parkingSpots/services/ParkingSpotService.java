package academy.mindswap.School_parkingSpots.School_parkingSpots.services;

import academy.mindswap.School_parkingSpots.School_parkingSpots.models.ParkingSpot;
import academy.mindswap.School_parkingSpots.School_parkingSpots.models.School;
import academy.mindswap.School_parkingSpots.School_parkingSpots.repositories.ParkingSpotRepository;
import academy.mindswap.School_parkingSpots.School_parkingSpots.repositories.SchoolRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class ParkingSpotService {

    private final SchoolRepository schoolRepository;

    private final ParkingSpotRepository parkingSpotRepository;

    public ParkingSpotService(SchoolRepository schoolRepository,
                              ParkingSpotRepository parkingSpotRepository) {
        this.schoolRepository = schoolRepository;
        this.parkingSpotRepository = parkingSpotRepository;
    }

    public ParkingSpot createTwoWheelerParking(ParkingSpot spot){
        saveSpots(spot);
        return parkingSpotRepository.save(spot);
    }

    public ParkingSpot createSpot(ParkingSpot spot){
        saveSpots(spot);
        return parkingSpotRepository.save(spot);
    }

    public void saveSpots(ParkingSpot spot){
        Optional<School> school = schoolRepository.findById(1);
        if(school.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"School not found");
        }
        school.get().addParkingSpots(spot);
        schoolRepository.save(school.get());
    }
}
