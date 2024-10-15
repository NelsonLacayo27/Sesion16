package dao;

import models.Student;

import javax.persistence.*;
import java.util.List;

public class StudentDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");

    public void save(Student student) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(student);
        em.getTransaction().commit();
        em.close();
    }

    public Student getStudentByCif(String cif) {
        EntityManager em = emf.createEntityManager();
        Student student = em.find(Student.class, cif);
        em.close();
        return student;
    }

    public List<Student> getAllStudents() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Student> query = em.createQuery("SELECT s FROM Student s", Student.class);
        List<Student> students = query.getResultList();
        em.close();
        return students;
    }

    public void update(Student student) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(student);
        em.getTransaction().commit();
        em.close();
    }

    public void delete(Student student) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.contains(student) ? student : em.merge(student));
        em.getTransaction().commit();
        em.close();
    }
}
