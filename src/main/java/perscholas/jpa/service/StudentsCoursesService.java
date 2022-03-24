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
        TypedQuery<StudentCourse> query = em.createQuery(sql, StudentCourse.class);
        List<StudentCourse> result = query.getResultList();
        System.out.printf("%-10s %-25s %-10s\n", "Course ID", "Student Email", "Course ID");
        for (int i = 0; i < result.size(); i++) {
            if(sEmail.equals(result.get(i).getsEmail()))
            System.out.printf("%-10d %-25s %-25s\n", result.get(i).getCourse().getcId(), result.get(i).getCourse().getcName(), result.get(i).getCourse().getcInstructorName());
        }//for
        return result;
    }//getStudentCourses()


}//StudentCoursesServices


