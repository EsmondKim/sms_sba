package perscholas.jpa.service;

import perscholas.jpa.dao.StudentsCoursesDAO;
import perscholas.jpa.entitymodels.StudentCourse;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class StudentsCoursesService implements StudentsCoursesDAO {
    private static final String PERSISTENCE_UNIT_NAME = "test";

    private EntityManagerFactory emFactoryObj =
            Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

    public StudentCourse findById(Integer id) {
        EntityManager em = emFactoryObj.createEntityManager();
        String sql = "SELECT sc FROM StudentCourse sc WHERE sc.id = :studentCourseId";
        TypedQuery<StudentCourse> query = em.createQuery(sql, StudentCourse.class);
        query.setParameter("studentCourseId", id);
        try {
            return query.getSingleResult();
        }//try
        catch (Exception e) {
            return null;
        }//catch
    }//findById()

    public StudentCourse save(StudentCourse studentCourse) {
        EntityManager em = emFactoryObj.createEntityManager();
        em.getTransaction().begin();

        // save the actor to the database
        em.persist(studentCourse);

        // commit the transaction
        em.getTransaction().commit();
        em.clear();

        return studentCourse;
    }//save()

    public List<StudentCourse> getStudentCourses(String sEmail){
        EntityManager em = emFactoryObj.createEntityManager();
        String sql = "SELECT sc FROM students_courses sc";
//        String sql = "SELECT c.cId, c.cName, c.cInstructorName \n" +
//                "FROM students s, courses c, students_courses sc \n" +
//                "WHERE :sEmail = sc.sEmail AND c.cId = sc.cId\n";
        TypedQuery<StudentCourse> query = em.createQuery(sql, StudentCourse.class);
        List<StudentCourse> result = query.getResultList();
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }//for
        return result;
    }//getStudentCourses()


}//StudentCoursesServices


