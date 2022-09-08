package academy.mindswap.School_parkingSpots.School_parkingSpots.services;

import academy.mindswap.School_parkingSpots.School_parkingSpots.models.ParkingSpot;
import academy.mindswap.School_parkingSpots.School_parkingSpots.models.School;
import academy.mindswap.School_parkingSpots.School_parkingSpots.models.Teacher;
import academy.mindswap.School_parkingSpots.School_parkingSpots.repositories.SchoolRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class SchoolService {

    private final SchoolRepository schoolRepository;

    public SchoolService(SchoolRepository schoolRepository) {this.schoolRepository = schoolRepository;}

    public School createSchool(School school){return schoolRepository.save(school);}


}
