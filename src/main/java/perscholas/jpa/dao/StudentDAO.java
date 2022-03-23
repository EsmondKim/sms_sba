package perscholas.jpa.dao;
import perscholas.jpa.entitymodels.Course;
import perscholas.jpa.entitymodels.Student;
import java.util.List;

public interface StudentDAO {

    List<Student> getAllStudents();

    Student getStudentByEmail(String sEmail);

    boolean validateStudent(String sEmail, String sPassword);

    void registerStudentToCourse();

    List<Course> getStudentCourses(String sEmail);

}//StudentDAO
