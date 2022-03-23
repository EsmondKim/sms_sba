package perscholas.jpa.entitymodels;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;



@Entity
@Table(name = "courses")
public class Course {
    @Id
    @Column(name = "cId")
    private int cId;

    @Column(name = "cName")
    private String cName;

    @Column(name = "cInstructorName")
    private String cInstructorName;

    @ManyToMany(mappedBy = "sCourses", fetch = FetchType.LAZY)
    private List<Student> sCourses = new ArrayList<>();

    public Course() {

    }

    public Course(int cId, String cName, String cInstructorName) {
        this.cId = cId;
        this.cName = cName;
        this.cInstructorName = cInstructorName;
    }

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcInstructorName() {
        return cInstructorName;
    }

    public void setcInstructorName(String cInstructorName) {
        this.cInstructorName = cInstructorName;
    }

    @Override
    public String toString() {
        return "Course{" +
                "cId=" + cId +
                ", cName='" + cName + '\'' +
                ", cInstructorName='" + cInstructorName + '\'' +
                '}';
    }

}// public class Course
