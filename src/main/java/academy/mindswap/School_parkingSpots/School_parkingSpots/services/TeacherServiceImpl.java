package academy.mindswap.School_parkingSpots.School_parkingSpots.services;

import academy.mindswap.School_parkingSpots.School_parkingSpots.models.ParkingSpot;
import academy.mindswap.School_parkingSpots.School_parkingSpots.models.Teacher;
import academy.mindswap.School_parkingSpots.School_parkingSpots.models.Vehicle;

public interface TeacherServiceImpl {
    Teacher getTeacher(Integer id); // 4

    void saveTeacherToSchool(Teacher teacher);

    Teacher createTeacher(Teacher teacher);  // 1

    void assignVehicle(Teacher teacher, Vehicle vehicle);

    Vehicle createVehicle(Vehicle vehicle, Integer teacherId); // 2

    void assignSpot(Teacher teacher, ParkingSpot spot);

    ParkingSpot createSpot(ParkingSpot spot, Integer teacherId); // 3
}
