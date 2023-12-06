package module6.backend.entity.customer;

import javax.persistence.*;

@Entity
@Table(name = "customer_type")
public class CustomerType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerTypeId;
    private String customerTypeName;
    private Boolean customerTypeFlag = false;

    public CustomerType() {
    }

    public CustomerType(Long customerTypeId, String customerTypeName, Boolean customerTypeFlag) {
        this.customerTypeId = customerTypeId;
        this.customerTypeName = customerTypeName;
        this.customerTypeFlag = customerTypeFlag;
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

    public Boolean getCustomerTypeFlag() {
        return customerTypeFlag;
    }

    public void setCustomerTypeFlag(Boolean customerTypeFlag) {
        this.customerTypeFlag = customerTypeFlag;
    }
}
