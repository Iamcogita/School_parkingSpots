package academy.mindswap.School_parkingSpots.School_parkingSpots.commands;

import lombok.Builder;
import lombok.Data;
import javax.validation.constraints.*;

@Builder
@Data
public class TeacherDto {

    @NotBlank(message = "Name is mandatory")
    private String name;
    @Size(min=6, message= "Password must be at least 6 characters long")
    private String sensitiveData;

}
