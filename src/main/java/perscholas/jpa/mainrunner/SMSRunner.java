package perscholas.jpa.mainrunner;
import perscholas.jpa.entitymodels.Course;
import perscholas.jpa.entitymodels.Student;
import perscholas.jpa.entitymodels.StudentCourse;
import perscholas.jpa.service.CourseService;
import perscholas.jpa.service.StudentService;
import perscholas.jpa.service.StudentsCoursesService;

import java.util.Scanner;

public class SMSRunner {
    private CourseService courseService = new CourseService();
    private StudentService studentService = new StudentService();
    private StudentsCoursesService studentsCoursesService = new StudentsCoursesService();

    public void run() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Are you a student?");
        System.out.println("Type 1 to answer yes and continue, type 2 to quit.");
        int stuCheck = sc.nextInt();
        sc.nextLine();
        if(stuCheck == 1) {
            System.out.println("Enter your email.");
            String sEmail = sc.nextLine();
            System.out.println("Enter your password.");
            String sPass = sc.nextLine();
                    if(studentService.validateStudent(sEmail, sPass)) {
                        studentsCoursesService.getStudentCourses(sEmail);

                        System.out.println("1. Register for a course. 2. Logout.");
                        int continueChoice = sc.nextInt();
                        sc.nextLine();
                        if (continueChoice == 1) {
                            courseService.getAllCourses();
                            System.out.println("Enter the course ID for the course you would like to register for.");
                            int courseId = sc.nextInt();
                            sc.nextLine();
                            System.out.println(courseId);
                            Student student = studentService.findById(sEmail);
                            Course course = courseService.findById(courseId);
                            StudentCourse studentCourse = new StudentCourse();
                            studentCourse.setStudent(student);
                            studentCourse.setCourse(course);
                            studentsCoursesService.save(studentCourse);
                        }//if continueChoice
                        else if (continueChoice == 2) {
                            System.out.println("You have quit using the SMS system. Goodbye!");
                        }//else if continueChoice
                    }//if validateStudent()
//            studentService.registerStudentToCourse(sEmail, courseId);

        }//if validateStudent() true
        else {
            System.out.println("You have quit using the SMS system. Goodbye!");
        }//else
    }//run()

    public static void main(String[] args) {
        new SMSRunner().run();
    }//psv main
}//public class SMSRunner
