package casestudy.entity.customer;

import casestudy.entity.employee.Employee;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "customer_type" )
public class CustomerType {
    @Column(name = "customer_type_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerTypeId;
    @Column(name = "customer_type_name")
    private String customerTypeName;

    @OneToMany(targetEntity = Customer.class)
    private List<Customer> employees;


//    @OneToMany(targetEntity = Customer.class)
//    private List<Customer> customers;


    public CustomerType() {
    }

    public CustomerType(Long customerTypeId, String customerTypeName, List<Customer> employees) {
        this.customerTypeId = customerTypeId;
        this.customerTypeName = customerTypeName;
        this.employees = employees;
    }

    public Long getCustomerTypeId() {
        return customerTypeId;
    }

    public void setCustomerTypeId(Long customerTypeId) {
        this.customerTypeId = customerTypeId;
    }

    public String getCustomerTypeName() {
        return customerTypeName;
    }

    public void setCustomerTypeName(String customerTypeName) {
        this.customerTypeName = customerTypeName;
    }

    public List<Customer> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Customer> employees) {
        this.employees = employees;
    }
}
