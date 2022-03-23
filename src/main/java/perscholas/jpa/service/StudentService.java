package perscholas.jpa.service;

import perscholas.jpa.dao.StudentDAO;
import perscholas.jpa.entitymodels.Course;
import perscholas.jpa.entitymodels.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class StudentService implements StudentDAO {

    private static final String PERSISTENCE_UNIT_NAME = "test";

    private EntityManagerFactory emFactoryObj =
            Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

    public List<Student> getAllStudents() {
        EntityManager em = emFactoryObj.createEntityManager();
        String sql = "SELECT s from students s";
        TypedQuery<Student> query = em.createQuery(sql, Student.class);
        List<Student> result = query.getResultList();
            for (int i = 0; i < result.size(); i++) {
                System.out.println(result.get(i));
            }//for
        return result;
    }//getAllStudents()

    public Student getStudentByEmail(String sEmail) {
        EntityManager em = emFactoryObj.createEntityManager();

        String sql = "SELECT s FROM students s WHERE s.sEmail = :sEmail";
        TypedQuery<Student> query = em.createQuery(sql, Student.class);
        query.setParameter("sEmail", sEmail);
        try {
            List<Student> result = query.getResultList();
            System.out.println(result);
            return query.getSingleResult();
        }//try
        catch (Exception e) {
            return null;
        }//catch
    }//getStudentByEmail

    public boolean validateStudent(String sEmail, String sPass) {
        String sql = "SELECT s FROM students s WHERE s.sEmail = :sEmail AND s.sPass = :sPass";
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

}//public student StudentService
