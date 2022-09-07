package academy.mindswap.School_parkingSpots.School_parkingSpots.services;

import academy.mindswap.School_parkingSpots.School_parkingSpots.models.Car;
import academy.mindswap.School_parkingSpots.School_parkingSpots.models.Teacher;

import academy.mindswap.School_parkingSpots.School_parkingSpots.repositories.CarRepository;
import academy.mindswap.School_parkingSpots.School_parkingSpots.repositories.MotorcycleRepository;
import academy.mindswap.School_parkingSpots.School_parkingSpots.repositories.TeacherRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;

    private final CarRepository carRepository;

    private final MotorcycleRepository motorcycleRepository;

    public TeacherService(TeacherRepository teacherRepository, CarRepository carRepository, MotorcycleRepository motorcycleRepository) {
        this.teacherRepository = teacherRepository;
        this.carRepository = carRepository;
        this.motorcycleRepository = motorcycleRepository;
    }

    public Teacher getTeacher(Integer id){
        Optional<Teacher> teacher = teacherRepository.findById(id);
        if(teacher.isEmpty()){throw new ResponseStatusException(HttpStatus.NOT_FOUND,"teacher not found");
        }
        return teacher.get();
    }

    public void assignCar(Teacher teacher,Car car){
        teacher.setVehicle(car);

        teacherRepository.save(teacher);
    }

    public Teacher createTeacher(Teacher teacher){return teacherRepository.save(teacher);}

    public Car createCar(Car car, Integer teacherId){
        Car carToBeReturn = carRepository.save(car);

        Teacher teacher = getTeacher(teacherId);

        assignCar(teacher,carToBeReturn);

        return carToBeReturn;
    }
}
