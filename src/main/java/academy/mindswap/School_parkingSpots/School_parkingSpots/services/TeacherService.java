package academy.mindswap.School_parkingSpots.School_parkingSpots.services;

import academy.mindswap.School_parkingSpots.School_parkingSpots.Logger.LogExecutionTime;
import academy.mindswap.School_parkingSpots.School_parkingSpots.commands.TeacherConverter;
import academy.mindswap.School_parkingSpots.School_parkingSpots.commands.TeacherDto;
import academy.mindswap.School_parkingSpots.School_parkingSpots.models.*;
import academy.mindswap.School_parkingSpots.School_parkingSpots.repositories.*;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class TeacherService implements TeacherServiceImpl {

    private final Logger LOGGER = LoggerFactory.getLogger(TeacherService.class);

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
    public Teacher saveTeacher(Teacher teacher){
        Optional<School> school = schoolRepository.findById(1);
        if(school.isEmpty()){throw new ResponseStatusException(HttpStatus.NOT_FOUND,"School not found");}
        school.get().addTeachers(teacher);
        schoolRepository.save(school.get());
        return teacher;
    }

    @Override
    public Teacher createTeacher(Teacher teacher){
        return teacherRepository.save(saveTeacher(teacher));
    }

    @Override
    public void assignVehicle(Teacher teacher, Vehicle vehicle){
        teacher.setPersonalVehicle(vehicle);
        teacherRepository.save(teacher);
    }

    @Override
    public Vehicle createVehicle(Vehicle vehicle, Integer teacherId){
        Teacher teacher = getTeacher(teacherId);
        Vehicle newVehicle = vehicleRepository.save(vehicle);
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

    @LogExecutionTime
    public List<TeacherDto> getAllTeachers() {
        LOGGER.info("Getting all teachers");
        return teacherRepository.findAll().stream()
                .map(TeacherConverter::modelTeacherToDto)
                .toList();
    }

    // TODO
    //  convert to DTO -wip
    //  validation? -wip
    //  apply logger -wip
    //  change args with AOP
    //  controller advice with exception handler 404

}
