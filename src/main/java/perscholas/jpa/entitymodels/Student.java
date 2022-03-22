package perscholas.jpa.entitymodels;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "students")
public class Student {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "sEmail")
        private String sEmail;

        @Column(name = "sName")
        private String sName;

        @Column(name = "sPass")
        private String sPass;

        @Column(name = "sCourses")
        private List sCourses;

        public Student() {

        }

        public Student(String sEmail, String sName, String sPass, List sCourses) {
            this.sEmail = sEmail;
            this.sName = sName;
            this.sPass = sPass;
            this.sCourses = sCourses;
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

    public List getsCourses() {
        return sCourses;
    }

    public void setsCourses(List sCourses) {
        this.sCourses = sCourses;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sEmail='" + sEmail + '\'' +
                ", sName='" + sName + '\'' +
                ", sPass='" + sPass + '\'' +
                ", sCourses=" + sCourses +
                '}';
    }
}//public class Student

