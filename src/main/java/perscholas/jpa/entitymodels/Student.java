package perscholas.jpa.entitymodels;

import javax.persistence.*;
import java.util.ArrayList;


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

    public Student() {

        }

        public Student(String sEmail, String sName, String sPass, ArrayList sCourses) {
            this.sEmail = sEmail;
            this.sName = sName;
            this.sPass = sPass;
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

