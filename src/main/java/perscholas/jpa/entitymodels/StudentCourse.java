package perscholas.jpa.entitymodels;

import javax.persistence.*;

@Entity (name = "students_courses")
@Table(name = "students_courses")
public class StudentCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "sEmail", nullable = false)
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cId", nullable = false)
    private Course course;

    @Column(name = "sEmail", updatable = false, insertable = false)
    private String sEmail;

    @Column(name = "cId", updatable = false, insertable = false)
    private int cId;

    public StudentCourse() {

    }

    public StudentCourse(Integer id, String sEmail, int cId) {
        this.id = id;
        this.sEmail = sEmail;
        this.cId = cId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getsEmail() {
        return sEmail;
    }

    public void setsEmail(String sEmail) {
        this.sEmail = sEmail;
    }

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    @Override
    public String toString() {
        return "StudentCourse{" +
                "id=" + id +
                ", sEmail='" + sEmail + '\'' +
                ", cId=" + cId +
                '}';
    }

}//public class StudentCourse
