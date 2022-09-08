package academy.mindswap.School_parkingSpots.School_parkingSpots.services;

import academy.mindswap.School_parkingSpots.School_parkingSpots.models.*;
import academy.mindswap.School_parkingSpots.School_parkingSpots.repositories.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class TeacherService {


    private final TeacherRepository teacherRepository;

    private final ParkingSpotRepository parkingSpotRepository;

    private final CarRepository carRepository;

    private final MotorcycleRepository motorcycleRepository;

    private final SchoolRepository schoolRepository;

    public TeacherService(TeacherRepository teacherRepository,
                          ParkingSpotRepository parkingSpotRepository,
                          CarRepository carRepository,
                          MotorcycleRepository motorcycleRepository,
                          SchoolRepository schoolRepository) {
        this.teacherRepository = teacherRepository;
        this.parkingSpotRepository = parkingSpotRepository;
        this.carRepository = carRepository;
        this.motorcycleRepository = motorcycleRepository;
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
        return teacherRepository.save(teacher);}


    public void assignCar(Teacher teacher,Car car){
        teacher.setPersonalVehicle(car);
        teacherRepository.save(teacher);
    }

    public Car createCar(Car car, Integer teacherId){
        Teacher teacher = getTeacher(teacherId);
        Car carToBeReturned = carRepository.save(car);
        assignCar(teacher,carToBeReturned);
        return carToBeReturned;
    }
    public void assignMotorcycle(Teacher teacher, Motorcycle motorcycle){
        teacher.setPersonalVehicle(motorcycle);
        teacherRepository.save(teacher);
    }

    public Motorcycle createMotorcycle(Motorcycle motorcycle, Integer teacherId){
        Teacher teacher = getTeacher(teacherId);
        Motorcycle newMotorcycle = motorcycleRepository.save(motorcycle);
        assignMotorcycle(teacher,newMotorcycle);
        return newMotorcycle;
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
