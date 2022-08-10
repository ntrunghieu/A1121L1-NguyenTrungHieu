package casestudy.entity.employee;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "education_degree")
public class EducationDegree {
    @Column(name = "education_degree_id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long educationDegreeId;
    @Column(name = "education_degree_name")
    private String educationName;

    @OneToMany(targetEntity = Employee.class)
    private List<Employee> employees;

    public EducationDegree() {
    }

    public EducationDegree(Long educationDegreeId, String educationName, List<Employee> employees) {
        this.educationDegreeId = educationDegreeId;
        this.educationName = educationName;
        this.employees = employees;
    }

    public Long getEducationDegreeId() {
        return educationDegreeId;
    }

    public void setEducationDegreeId(Long educationDegreeId) {
        this.educationDegreeId = educationDegreeId;
    }

    public String getEducationName() {
        return educationName;
    }

    public void setEducationName(String educationName) {
        this.educationName = educationName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
