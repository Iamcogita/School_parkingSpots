package academy.mindswap.School_parkingSpots.School_parkingSpots.commands;

import academy.mindswap.School_parkingSpots.School_parkingSpots.models.Teacher;
import lombok.Builder;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;

@Data
@Builder
public class TeacherConverter {
    @Bean
    public static ModelMapper modelMapper() {return new ModelMapper();}

    public static TeacherDto modelTeacherToDto(Teacher teacher){
        return modelMapper().map(teacher , TeacherDto.class);
    }

    public static Teacher DtoTeacherToModel(TeacherDto teacherDto){
        return modelMapper().map(teacherDto , Teacher.class);
    }


}
