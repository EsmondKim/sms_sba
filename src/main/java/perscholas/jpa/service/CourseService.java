package perscholas.jpa.service;

import perscholas.jpa.dao.CourseDAO;
import perscholas.jpa.entitymodels.Course;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class CourseService implements CourseDAO {

    private static final String PERSISTENCE_UNIT_NAME = "test";

    private EntityManagerFactory emFactoryObj =
            Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);


    public List<Course> getAllCourses() {
        EntityManager em = emFactoryObj.createEntityManager();
        String sql = "SELECT c FROM Course";
        TypedQuery<Course> query = em.createQuery(sql, Course.class);
        List<Course> result = query.getResultList();
        return result;
    }//getAllCourses()

}//public class CourseService
