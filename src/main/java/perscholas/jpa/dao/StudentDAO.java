package perscholas.jpa.dao;
import perscholas.jpa.entitymodels.Course;
import perscholas.jpa.entitymodels.Student;
import perscholas.jpa.entitymodels.StudentCourse;

import java.util.List;

public interface StudentDAO {

    List<Student> getAllStudents();

    Student getStudentByEmail(String sEmail);

    boolean validateStudent(String sEmail, String sPassword);

    List<Student> registerStudentToCourse(String sEmail, int cId);

}//StudentDAO
