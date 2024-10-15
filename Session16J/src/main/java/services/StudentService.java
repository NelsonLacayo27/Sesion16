package services;

import dao.StudentDAO;
import models.Student;

import java.util.List;

public class StudentService {
    private StudentDAO studentDAO = new StudentDAO();

    public void registerStudent(Student student) {
        studentDAO.save(student);
    }

    public Student getStudentByCif(String cif) {
        return studentDAO.getStudentByCif(cif);
    }

    public List<Student> getAllStudents() {
        return studentDAO.getAllStudents();
    }

    public void updateStudent(Student student) {
        studentDAO.update(student);
    }

    public void deleteStudent(Student student) {
        studentDAO.delete(student);
    }
}
