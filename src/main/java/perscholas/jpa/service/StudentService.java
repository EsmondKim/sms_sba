package perscholas.jpa.service;

import perscholas.jpa.entitymodels.Course;
import perscholas.jpa.entitymodels.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();

    Student getStudentByEmail(String sEmail);

    boolean validateStudent(String sEmail, String sPassword);

    void registerStudentToCourse();

    List<Course> getStudentCourses(String sEmail);

}//public student StudentService
