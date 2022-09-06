package academy.mindswap.School_parkingSpots.School_parkingSpots.services;

import academy.mindswap.School_parkingSpots.School_parkingSpots.models.Car;
import academy.mindswap.School_parkingSpots.School_parkingSpots.repositories.CarRepository;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {this.carRepository = carRepository;}

    public Car createCar(Car car){
        return carRepository.save(car);
    }

}
