package academy.mindswap.School_parkingSpots.School_parkingSpots.controllers;

import academy.mindswap.School_parkingSpots.School_parkingSpots.models.School;
import academy.mindswap.School_parkingSpots.School_parkingSpots.services.SchoolService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/school")
public class SchoolController {

    private final SchoolService schoolService;

    public SchoolController(SchoolService schoolService) {this.schoolService = schoolService;}

    @PostMapping
    public School createSchool(@RequestBody School school){return schoolService.createSchool(school);}

}
