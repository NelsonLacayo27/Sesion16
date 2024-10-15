import models.City;
import models.Student;
import services.CityService;
import services.StudentService;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CityService cityService = new CityService();
        StudentService studentService = new StudentService();

        int opt = 0;
        String menu = "Gestión de Estudiantes y Ciudades\n"
                + "\n 1. Registrar\n" + " 2. Listar\n"
                + " 3. Actualizar\n" + " 4. Eliminar\n" + " 5. Salir\n" +
                " ---> ";

        while (opt != 5) {
            System.out.println(menu);
            opt = scanner.nextInt();

            switch (opt) {
                case 1:
                    System.out.println("\n¿Quieres registrar un estudiante o ciudad?\n"
                            + "1. Estudiante\n" + "2. Ciudad\n" + " ---> ");
                    int choice = scanner.nextInt();

                    if (choice == 1) {
                        // Registrar estudiante
                        Student student = new Student();
                        System.out.println("Ingresa el CIF del estudiante: ");
                        student.setCif(scanner.next());
                        System.out.println("Ingresa el nombre del estudiante: ");
                        student.setFirstName(scanner.next());
                        System.out.println("Ingresa el apellido del estudiante: ");
                        student.setLastName(scanner.next());
                        System.out.println("Ingresa el email del estudiante: ");
                        student.setEmail(scanner.next());
                        System.out.println("Ingresa el nombre de la ciudad del estudiante: ");
                        City city = cityService.getCityByName(scanner.next());
                        student.setCity(city);
                        studentService.registerStudent(student);
                        System.out.println("Estudiante registrado exitosamente.");
                    } else if (choice == 2) {
                        // Registrar ciudad
                        System.out.println("Ingresa el nombre de la ciudad: ");
                        String cityName = scanner.next();
                        cityService.registerCity(cityName);
                        System.out.println("Ciudad registrada exitosamente.");
                    } else {
                        System.out.println("Ingresa un número válido.");
                    }
                    break;

                case 2:
                    System.out.println("\n¿Quieres ver la lista de todos los estudiantes o de las ciudades?\n"
                            + "1. Estudiantes\n" + "2. Ciudades\n" + " ---> ");
                    int listChoice = scanner.nextInt();
                    if (listChoice == 1) {
                        // Listar estudiantes
                        List<Student> students = studentService.getAllStudents();
                        System.out.println("\nLista de estudiantes\n");
                        if (students.isEmpty()) {
                            System.out.println("No hay estudiantes registrados.\n");
                        } else {
                            for (Student student : students) {
                                System.out.println(student.getFirstName() + " " + student.getLastName() + " (" +
                                        student.getCif() + ")\n" + student.getEmail() + "\nCiudad: " +
                                        (student.getCity() != null ? student.getCity().getName() : "Sin ciudad"));
                                System.out.println();
                            }
                        }
                    } else if (listChoice == 2) {
                        // Listar ciudades
                        List<City> cities = cityService.getAllCities();
                        System.out.println("\nLista de ciudades\n");
                        if (cities.isEmpty()) {
                            System.out.println("No hay ciudades registradas.\n");
                        } else {
                            for (City city : cities) {
                                System.out.println("Ciudad: " + city.getName());
                                System.out.println("Estado: " + (city.getState() ? "Activo" : "Inactivo"));
                                System.out.println();
                            }
                        }
                    } else {
                        System.out.println("Ingresa un número válido.");
                    }
                    break;

                case 3:
                    //
                    break;

                case 4:

                    break;

                case 5:
                    System.out.println("\nSaliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        }

        scanner.close();
    }
}
