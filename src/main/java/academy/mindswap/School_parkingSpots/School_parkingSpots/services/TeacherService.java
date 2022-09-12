package academy.mindswap.School_parkingSpots.School_parkingSpots.services;

import academy.mindswap.School_parkingSpots.School_parkingSpots.models.*;
import academy.mindswap.School_parkingSpots.School_parkingSpots.repositories.*;
import com.sun.xml.bind.v2.TODO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;
import java.awt.*;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class TeacherService implements TeacherServiceImpl {

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

    @Override
    public Teacher getTeacher(Integer id){
        Optional<Teacher> teacher = teacherRepository.findById(id);
        if(teacher.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"teacher not found");
        }
        return teacher.get();
    }

    @Override
    public void saveTeacher(Teacher teacher){
        Optional<School> school = schoolRepository.findById(1);
        if(school.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"School not found");
        }
        school.get().addTeachers(teacher);
        schoolRepository.save(school.get());
    }

    @Override
    public Teacher createTeacher(Teacher teacher){
        saveTeacher(teacher);
        return teacherRepository.save(teacher);
    }

    @Override
    public void assignVehicle(Teacher teacher, Vehicle vehicle){
        teacher.setPersonalVehicle(vehicle);
        teacherRepository.save(teacher);
    }

    @Override
    public Vehicle createVehicle(Vehicle vehicle, Integer teacherId){
        Teacher teacher = getTeacher(teacherId);
        Vehicle newVehicle= vehicleRepository.save(vehicle);
        assignVehicle(teacher,newVehicle);
        return newVehicle;
    }

    @Override
    public void assignSpot(Teacher teacher, ParkingSpot spot){
        teacher.setPersonalSpot(spot);
        teacherRepository.save(teacher);
    }

    @Override
    public ParkingSpot createSpot(ParkingSpot spot, Integer teacherId){
        Teacher teacher = getTeacher(teacherId);
        ParkingSpot allocatedSpot = parkingSpotRepository.save(spot);
        assignSpot(teacher , allocatedSpot);
        return allocatedSpot;
    }

    // testing:

    public Set<Teacher> getAllTeachers(){
        Set<Teacher> allTeachers = new HashSet<>();
        allTeachers.addAll(teacherRepository.findAll());
        return allTeachers ;
    }


    // TODO
    //  convert to DTO
    //  validation?
    //  apply logger
    //  change args with AOP
    //  controller advice with exception handler 404

}
