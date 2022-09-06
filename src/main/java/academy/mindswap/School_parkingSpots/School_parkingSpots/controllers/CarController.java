package academy.mindswap.School_parkingSpots.School_parkingSpots.controllers;

import academy.mindswap.School_parkingSpots.School_parkingSpots.models.Car;
import academy.mindswap.School_parkingSpots.School_parkingSpots.services.CarService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {this.carService = carService;}

    @PostMapping
    public Car createCar(@RequestBody Car car){return carService.createCar(car);}


}
