package services;

import models.City;
import models.Student;

import java.util.List;

public class ManagementService {
    private CityService cityService;
    private StudentService studentService;

    public ManagementService(CityService cityService, StudentService studentService) {
        this.cityService = cityService;
        this.studentService = studentService;
    }

    public City getCityByName(String name) {
        return cityService.getCityByName(name);
    }

    public void listStudents() {
        //  listar estudiantes
    }

    public void listCities() {
        //  listar ciudades
    }
}
