package academy.mindswap.School_parkingSpots.School_parkingSpots.commands;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.*;

@Data
@NoArgsConstructor
public class TeacherDto {



    @NotNull
    private Integer id;
    @NotBlank(message = "Name is mandatory")
    private String name;
    @Size(min=6, message= "Password must be at least 6 characters long")
    private String sensitiveData;

}
