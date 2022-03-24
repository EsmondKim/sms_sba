package perscholas.jpa.service;

import perscholas.jpa.dao.CourseDAO;
import perscholas.jpa.entitymodels.Course;
import perscholas.jpa.entitymodels.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class CourseService implements CourseDAO {

    private static final String PERSISTENCE_UNIT_NAME = "test";

    private EntityManagerFactory emFactoryObj =
            Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

    public Course findById(int cId) {
        EntityManager em = emFactoryObj.createEntityManager();

        String sql = "SELECT c FROM courses c WHERE c.cId = :cId";
        TypedQuery<Course> query = em.createQuery(sql, Course.class);
        query.setParameter("cId", cId);

        try {
            return query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    public Course update( Course course ) {
        EntityManager em = emFactoryObj.createEntityManager();
        em.getTransaction().begin();

        // save the movie to the database
        em.merge(course);

        // commit the transaction
        em.getTransaction().commit();
        em.clear();

        return course;
    }

    public Course save( Course course ) {
        EntityManager em = emFactoryObj.createEntityManager();
        em.getTransaction().begin();

        // save the movie to the database
        em.persist(course);

        // commit the transaction
        em.getTransaction().commit();
        em.clear();

        return course;
    }

    public List<Course> getAllCourses() {
        EntityManager em = emFactoryObj.createEntityManager();
        String sql = "SELECT c FROM courses c";
        TypedQuery<Course> query = em.createQuery(sql, Course.class);
        List<Course> result = query.getResultList();
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }//for
        return result;
    }//getAllCourses()

}//public class CourseService
