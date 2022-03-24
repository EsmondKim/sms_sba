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
    private CourseService courseService = new CourseService();
    private StudentsCoursesService studentsCoursesService = new StudentsCoursesService();

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

    public Student update(Student student) {
        EntityManager em = emFactoryObj.createEntityManager();
        em.getTransaction().begin();

        em.merge(student);

        em.getTransaction().commit();
        em.clear();

        return student;
    }

    public Student save(Student student) {
        EntityManager em = emFactoryObj.createEntityManager();
        em.getTransaction().begin();

        em.persist(student);

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
        String sql = "SELECT s FROM students s";
        TypedQuery<Student> query = em.createQuery(sql, Student.class);
        List<Student> result = query.getResultList();
        for (int i = 0; i < result.size(); i++) {
            if (sEmail.equals(result.get(i).getsEmail()) && sPass.equals(result.get(i).getsPass())) {
                return true;
            }//if statement
        }//for loop
        System.out.println("Invalid email and password combination.");
        return false;
    }//validateStudent()

    public void registerStudentToCourse(String sEmail, int cId) {
        Student student = findById(sEmail);
        Course course = courseService.findById(cId);
        StudentCourse studentCourse = new StudentCourse();
        studentCourse.setStudent(student);
        studentCourse.setCourse(course);
        studentsCoursesService.save(studentCourse);
        System.out.printf("You're registered for course %d.\n", cId);
    }

}//public student StudentService
