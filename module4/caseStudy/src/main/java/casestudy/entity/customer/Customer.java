package casestudy.entity.customer;

import casestudy.entity.contract.Contract;
import casestudy.entity.employee.Position;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.List;
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;
    @NotEmpty(message = "Ten khong duoc de trong")
    private String customerName;
    private String customerBirthday;
    private boolean customerGender;
    private String customerIdCard;
    private String customerPhone;
    private String customerEmail;
    private String customerAddress;


//    @ManyToOne
//    @JoinColumn(name = "customer_type_id", nullable = false)
//    private CustomerType customerType;

    @ManyToOne
    @JoinColumn
    private CustomerType customerType;


//    @OneToMany(mappedBy = "customer")
//    private List<Contract> contracts;

    public Customer() {
    }

    public Customer(Long customerId, @NotEmpty(message = "Ten khong duoc de trong") String customerName, String customerBirthday, boolean customerGender, String customerIdCard, String customerPhone, String customerEmail, String customerAddress, CustomerType customerType) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerBirthday = customerBirthday;
        this.customerGender = customerGender;
        this.customerIdCard = customerIdCard;
        this.customerPhone = customerPhone;
        this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
        this.customerType = customerType;
//        this.contracts = contracts;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerBirthday() {
        return customerBirthday;
    }

    public void setCustomerBirthday(String customerBirthday) {
        this.customerBirthday = customerBirthday;
    }

    public boolean isCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(boolean customerGender) {
        this.customerGender = customerGender;
    }

    public String getCustomerIdCard() {
        return customerIdCard;
    }

    public void setCustomerIdCard(String customerIdCard) {
        this.customerIdCard = customerIdCard;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

//    public List<Contract> getContracts() {
//        return contracts;
//    }
//
//    public void setContracts(List<Contract> contracts) {
//        this.contracts = contracts;
//    }
}
