package perscholas.jpa.service;

import perscholas.jpa.dao.StudentDAO;
import perscholas.jpa.entitymodels.Course;
import perscholas.jpa.entitymodels.Student;
import perscholas.jpa.entitymodels.StudentCourse;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class StudentService implements StudentDAO {

    private static final String PERSISTENCE_UNIT_NAME = "test";

    private EntityManagerFactory emFactoryObj =
            Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

    public Student findById(String sEmail) {
        EntityManager em = emFactoryObj.createEntityManager();

        String sql = "SELECT s FROM students s WHERE s.sEmail = :sEmail";
        TypedQuery<Student> query = em.createQuery(sql, Student.class);
        query.setParameter("sEmail", sEmail);

        try {
            return query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    public Student update( Student student ) {
        EntityManager em = emFactoryObj.createEntityManager();
        em.getTransaction().begin();

        // save the movie to the database
        em.merge(student);

        // commit the transaction
        em.getTransaction().commit();
        em.clear();

        return student;
    }

    public Student save( Student student ) {
        EntityManager em = emFactoryObj.createEntityManager();
        em.getTransaction().begin();

        // save the movie to the database
        em.persist(student);

        // commit the transaction
        em.getTransaction().commit();
        em.clear();

        return student;
    }

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
        EntityManager em = emFactoryObj.createEntityManager();
        String sql = "SELECT s FROM students s WHERE s.sEmail = :sEmail AND s.sPass = :sPass";
        TypedQuery<Student> query = em.createQuery(sql, Student.class);
        List<Student> result = query.getResultList();
        if(result.contains(result.get(0).getsPass())) {
            return true;
        }
        else {
            System.out.println("Your email and password combination are invalid.");
            return false;
        }
    }//validateStudent()

    public List<Student> registerStudentToCourse(String sEmail, int cId) {
        EntityManager em = emFactoryObj.createEntityManager();
        String sql = "SELECT sc FROM students_courses sc WHERE s.sEmail = :sEmail AND c.cId = cId";
        TypedQuery<Student> query = em.createQuery(sql, Student.class);
        List<Student> result = query.getResultList();
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }//for
        return result;
    }//registerStudentToCourse()

    public List<StudentCourse> getStudentCourses(String sEmail){
        EntityManager em = emFactoryObj.createEntityManager();
        String sql = "SELECT c.cId, c.cName, c.InstructorName FROM students s, courses c, students_courses sc WHERE c.cId = sc.cId AND s.sEmail = sc.sEmail";
        TypedQuery<StudentCourse> query = em.createQuery(sql, StudentCourse.class);
        List<StudentCourse> result = query.getResultList();
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }//for
        return result;
    }//getStudentCourses()

}//public student StudentService
