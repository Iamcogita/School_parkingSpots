package academy.mindswap.School_parkingSpots.School_parkingSpots.services;

import academy.mindswap.School_parkingSpots.School_parkingSpots.Logger.LogExecutionTime;
import academy.mindswap.School_parkingSpots.School_parkingSpots.commands.TeacherDto;
import academy.mindswap.School_parkingSpots.School_parkingSpots.models.ParkingSpot;
import academy.mindswap.School_parkingSpots.School_parkingSpots.models.Teacher;
import academy.mindswap.School_parkingSpots.School_parkingSpots.models.Vehicle;

import javax.transaction.Transactional;
import java.util.List;

public interface TeacherServiceImpl {
    Teacher getTeacher(Integer id);

    void saveTeacherToSchool(Teacher teacher);

    @Transactional
    Teacher createTeacher(Teacher teacher);

    void assignVehicle(Teacher teacher, Vehicle vehicle);

    Vehicle createVehicle(Vehicle vehicle, Integer teacherId);

    void assignSpot(Teacher teacher, ParkingSpot spot);

    ParkingSpot createSpot(ParkingSpot spot, Integer teacherId);

    @LogExecutionTime
    List<TeacherDto> getAllTeachers();

    void deleteTeacher(Teacher teacher);

    void deleteTeacherById(Integer id);
}
