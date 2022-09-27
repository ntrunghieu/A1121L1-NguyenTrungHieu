package casestudy.entity.customer;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "customerType")
@Table(name = "customer_type" )
public class CustomerType {
    @Column(name = "customer_type_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerTypeId;

    @Column(name = "customer_type_name")
    private String customerTypeName;

    @OneToMany(targetEntity = Customer.class)
    @JsonBackReference
    private Set<Customer> customers;


//    @OneToMany(targetEntity = Customer.class)
//    private List<Customer> customers;


    public CustomerType() {
    }

    public CustomerType(Long customerTypeId, String customerTypeName, Set<Customer> customers) {
        this.customerTypeId = customerTypeId;
        this.customerTypeName = customerTypeName;
        this.customers = customers;
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

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> employees) {
        this.customers = employees;
    }
}
