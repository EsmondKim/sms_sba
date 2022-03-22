package perscholas.jpa.dao;

import perscholas.jpa.entitymodels.Course;
import perscholas.jpa.service.CourseService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class CourseDAO implements CourseService {
    private static final String PERSISTENCE_UNIT_NAME = "coursesdb";

    private EntityManagerFactory emFactoryObj =
            Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

    public List<Course> getAllCourses() {
        EntityManager em = emFactoryObj.createEntityManager();
        String sql = "SELECT c FROM Course";
        TypedQuery<Course> query = em.createQuery(sql, Course.class);
        List<Course> result = query.getResultList();
        return result;
    }//getAllCourses()

}//CourseDAO
