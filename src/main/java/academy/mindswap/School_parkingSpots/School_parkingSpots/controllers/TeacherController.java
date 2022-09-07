package academy.mindswap.School_parkingSpots.School_parkingSpots.controllers;

import academy.mindswap.School_parkingSpots.School_parkingSpots.models.Car;
import academy.mindswap.School_parkingSpots.School_parkingSpots.models.Teacher;
import academy.mindswap.School_parkingSpots.School_parkingSpots.services.TeacherService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {this.teacherService = teacherService;}

    @PostMapping
    public Teacher createTeacher(@RequestBody Teacher teacher){return teacherService.createTeacher(teacher);}

    @PostMapping("cars/{id}")
    public Car createCar(@RequestBody Car car, @PathVariable Integer id){
        return teacherService.createCar(car,id);
    }

    @GetMapping("/{id}")
    public Teacher getTeacher(@PathVariable Integer id){
        return teacherService.getTeacher(id);
    }


}
