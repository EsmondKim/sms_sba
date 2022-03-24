package jpa.entitymodels;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import perscholas.jpa.entitymodels.Student;
import perscholas.jpa.service.StudentService;

public class StudentCoursesServiceTest {
    private static StudentService studentService;

    @BeforeAll
    public static void setUp() {
        studentService = new StudentService();
    }

    @Test
    public void getStudentByEmail() {
        // given
        Student expected = new Student();
        expected.setsEmail("aiannitti7@is.gd");
        expected.setsName("Alexandra Iannitti");
        expected.setsPass("TWP4hf5j");

        // when
        Student actual = studentService.getStudentByEmail("aiannitti7@is.gd");

        // then
        Assertions.assertEquals(expected.getsEmail(), actual.getsEmail());
    }

}
