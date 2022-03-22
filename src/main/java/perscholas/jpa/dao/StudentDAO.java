package perscholas.jpa.dao;

import org.h2.engine.User;
import perscholas.jpa.entitymodels.Course;
import perscholas.jpa.entitymodels.Student;
import perscholas.jpa.service.StudentService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class StudentDAO implements StudentService {

    private static final String PERSISTENCE_UNIT_NAME = "moviesdb";

    private EntityManagerFactory emFactoryObj =
            Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

    public List<Student> getAllStudents() {
        EntityManager em = emFactoryObj.createEntityManager();
        String sql = "SELECT s FROM Student";
        TypedQuery<Student> query = em.createQuery(sql, Student.class);
        List<Student> result = query.getResultList();
        return result;
    }//getAllStudents()

    public Student getStudentByEmail(String sEmail) {
        EntityManager em = emFactoryObj.createEntityManager();

        String sql = "SELECT s FROM Student s WHERE s.sEmail = :sEmail";
        TypedQuery<Student> query = em.createQuery(sql, Student.class);
        query.setParameter("sEmail", sEmail);
        try {
            return query.getSingleResult();
        }//try
        catch (Exception e) {
            return null;
        }//catch
    }//getStudentByEmail

    public boolean validateStudent(String sEmail, String sPassword) {
        //logic here for validation
        return true;
    }//validateStudent()

    public void registerStudentToCourse() {
        //logic here for registerStudentToCourse()
    }//registerStudentToCourse()

    public List<Course> getStudentCourses(String sEmail){
        EntityManager em = emFactoryObj.createEntityManager();
        String sql = "SELECT c FROM Course WHERE c.Id = s.sEmail";
        TypedQuery<Course> query = em.createQuery(sql, Course.class);
        List<Course> result = query.getResultList();
        return result;
    }//getStudentCourses()

}//StudentDAO
