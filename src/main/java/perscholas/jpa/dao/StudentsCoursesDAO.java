package perscholas.jpa.dao;

import perscholas.jpa.entitymodels.StudentCourse;

import java.util.List;

public interface StudentsCoursesDAO {
    public StudentCourse findById(Integer id);

    public StudentCourse save(StudentCourse studentCourse);

    List<StudentCourse> getStudentCourses(String sEmail);

}//StudentCoursesDAO
