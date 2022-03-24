package perscholas.jpa.service;

import perscholas.jpa.dao.StudentsCoursesDAO;
import perscholas.jpa.entitymodels.StudentCourse;

import javax.persistence.*;
import java.util.List;

public class StudentsCoursesService implements StudentsCoursesDAO {
    private static final String PERSISTENCE_UNIT_NAME = "test";

    private EntityManagerFactory emFactoryObj =
            Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

    public StudentCourse findById(Integer id) {
        EntityManager em = emFactoryObj.createEntityManager();
        String sql = "SELECT sc FROM students_courses sc WHERE sc.id = :id";
        TypedQuery<StudentCourse> query = em.createQuery(sql, StudentCourse.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        }//try
        catch (Exception e) {
            return null;
        }//catch
    }//findById()

    public int deleteById(int id) {
        EntityManager em = emFactoryObj.createEntityManager();
        em.getTransaction().begin();

        String sql = "DELETE FROM students_courses sc WHERE sc.cId = :id";
        Query query = em.createQuery(sql);
        query.setParameter("id", id);

        int count = query.executeUpdate();
        em.getTransaction().commit();
        System.out.printf("You've deleted course %d\n", id);

        return count;
    }

    public StudentCourse save(StudentCourse studentCourse) {
        EntityManager em = emFactoryObj.createEntityManager();
        em.getTransaction().begin();

        // save the studentCourse to the database
        em.persist(studentCourse);

        // commit the transaction
        em.getTransaction().commit();
        em.clear();

        return studentCourse;
    }//save()

    public List<StudentCourse> getStudentCourses(String sEmail){
        EntityManager em = emFactoryObj.createEntityManager();
        String sql = "SELECT sc FROM students_courses sc";
        TypedQuery<StudentCourse> query = em.createQuery(sql, StudentCourse.class);
        List<StudentCourse> result = query.getResultList();
        System.out.printf("%-10s %-25s %-10s\n", "Course ID", "Student Email", "Course ID");
        for (StudentCourse studentCourse : result) {
            if (sEmail.equals(studentCourse.getsEmail()))
                System.out.printf("%-10d %-25s %-25s\n", studentCourse.getCourse().getcId(), studentCourse.getCourse().getcName(), studentCourse.getCourse().getcInstructorName());
        }//for
        return result;
    }//getStudentCourses()

}//StudentCoursesServices


