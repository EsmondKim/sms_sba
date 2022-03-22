package perscholas.jpa.service;

import perscholas.jpa.entitymodels.Course;
import perscholas.jpa.entitymodels.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public interface CourseService {

    List<Course> getAllCourses();

}//public class CourseService
