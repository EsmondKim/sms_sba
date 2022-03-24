package perscholas.jpa.entitymodels;

import javax.persistence.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity (name = "students")
@Table(name = "students")
public class Student {
        @Id
        @Column(name = "sEmail")
        private String sEmail;

        @Column(name = "sName")
        private String sName;

        @Column(name = "sPass")
        private String sPass;

//        @Column(name = "sCourses")
//        private ArrayList<Course> sCourses = new ArrayList<>();

//        @ManyToMany(fetch=FetchType.LAZY)
//        @JoinTable(name = "students_courses",
//                joinColumns = {
//                    @JoinColumn(name = "sEmail", referencedColumnName = "sEmail",
//                        nullable = false, updatable = false)}, //@JoinColumns
//                inverseJoinColumns = {
//                    @JoinColumn(name = "cId", referencedColumnName = "cId",
//                        nullable = false, updatable = false)}) //inverseJoinColumns
//        private Set<Course> courses = new HashSet<>();

    public Student() {

        }

        public Student(String sEmail, String sName, String sPass, ArrayList sCourses) {
            this.sEmail = sEmail;
            this.sName = sName;
            this.sPass = sPass;
//            this.sCourses = sCourses;
        }

    public String getsEmail() {
        return sEmail;
    }

    public void setsEmail(String sEmail) {
        this.sEmail = sEmail;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsPass() {
        return sPass;
    }

    public void setsPass(String sPass) {
        this.sPass = sPass;
    }

//    public ArrayList getsCourses() {
//        return sCourses;
//    }
//
//    public void setsCourses(ArrayList sCourses) {
//        this.sCourses = sCourses;
//    }

    @Override
    public String toString() {
        return "Student{" +
                "sEmail='" + sEmail + '\'' +
                ", sName='" + sName + '\'' +
                ", sPass='" + sPass + '\'' +
//                ", sCourses=" + sCourses +
                '}';
    }
}//public class Student

