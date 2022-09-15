package academy.mindswap.School_parkingSpots.School_parkingSpots.controllers;

import academy.mindswap.School_parkingSpots.School_parkingSpots.models.School;
import academy.mindswap.School_parkingSpots.School_parkingSpots.services.SchoolService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/school")
public class SchoolController {

    private final SchoolService schoolService;

    public SchoolController(SchoolService schoolService) {this.schoolService = schoolService;}


    @Valid
    @PostMapping
    public School createSchool(@RequestBody @Valid School school){return schoolService.createSchool(school);}

}
