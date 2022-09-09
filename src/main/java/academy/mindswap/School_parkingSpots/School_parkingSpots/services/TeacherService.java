package academy.mindswap.School_parkingSpots.School_parkingSpots.services;

import academy.mindswap.School_parkingSpots.School_parkingSpots.models.*;
import academy.mindswap.School_parkingSpots.School_parkingSpots.repositories.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.awt.*;
import java.util.Optional;

@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;

    private final ParkingSpotRepository parkingSpotRepository;

    private final VehicleRepository vehicleRepository;

    private final SchoolRepository schoolRepository;

    public TeacherService(TeacherRepository teacherRepository,
                          ParkingSpotRepository parkingSpotRepository,
                          VehicleRepository vehicleRepository,
                          SchoolRepository schoolRepository) {
        this.teacherRepository = teacherRepository;
        this.parkingSpotRepository = parkingSpotRepository;
        this.vehicleRepository = vehicleRepository;
        this.schoolRepository = schoolRepository;
    }

    public Teacher getTeacher(Integer id){
        Optional<Teacher> teacher = teacherRepository.findById(id);
        if(teacher.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"teacher not found");
        }
        return teacher.get();
    }

    public void saveTeacher(Teacher teacher){
        Optional<School> school = schoolRepository.findById(1);
        if(school.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"School not found");
        }
        school.get().addTeachers(teacher);
        schoolRepository.save(school.get());
    }

    public Teacher createTeacher(Teacher teacher){
        saveTeacher(teacher);
        return teacherRepository.save(teacher);
    }

    public void assignVehicle(Teacher teacher,Vehicle vehicle){
        teacher.setPersonalVehicle(vehicle);
        teacherRepository.save(teacher);
    }

    public Vehicle createVehicle(Vehicle vehicle, Integer teacherId){
        Teacher teacher = getTeacher(teacherId);
        Vehicle newVehicle= vehicleRepository.save(vehicle);
        assignVehicle(teacher,newVehicle);
        return newVehicle;
    }

    public void assignSpot(Teacher teacher,ParkingSpot spot){
        teacher.setPersonalSpot(spot);
        teacherRepository.save(teacher);
    }

    public ParkingSpot createSpot(ParkingSpot spot , Integer teacherId){
        Teacher teacher = getTeacher(teacherId);
        ParkingSpot allocatedSpot = parkingSpotRepository.save(spot);
        assignSpot(teacher , allocatedSpot);
        return allocatedSpot;
    }


}
