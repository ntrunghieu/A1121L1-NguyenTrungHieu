package module6.backend.entity.customer;

import module6.backend.util.cartValidator.EmailCustom;
import module6.backend.util.cartValidator.PhoneCustom;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;
    @NotBlank(message ="Tên không được để trống")
    @Size(min=6 ,max = 50 , message = "Độ dài kí tự từ 6-50 - BE")
    private String customerName;
    private String customerCode;
    private String customerAvatar;
    @NotBlank(message ="Địa chỉ không được để trống")
    @Size(min=6 ,max = 255 , message = "Độ dài kí tự từ 6-255 - BE")
    private String customerAddress;
    @NotBlank(message ="Số điện thoại không được để trống")
    @PhoneCustom(message = "Số điện thoại đã tồn tại")
    @Pattern(regexp = "^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$" , message = "Số điện thoại không đúng định dạng")
    private String customerPhone;
    @NotBlank(message ="Số điện thoại không được để trống")
    @Email(message = "Email không đúng định dạng")
    @EmailCustom(message = "Email đã tồn tại")
    @Size(min=6 ,max = 50 , message = "Độ dài kí tự từ 6-50 - BE")
    private String customerEmail;
    private Boolean customerFlag = false;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "customer_type_id")
    private CustomerType customerTypeId;

    public Customer() {
    }

    public Customer(Long customerId, String customerName, String customerCode, String customerAvatar, String customerAddress, String customerPhone, String customerEmail, Boolean customerFlag, CustomerType customerTypeId) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerCode = customerCode;
        this.customerAvatar = customerAvatar;
        this.customerAddress = customerAddress;
        this.customerPhone = customerPhone;
        this.customerEmail = customerEmail;
        this.customerFlag = customerFlag;
        this.customerTypeId = customerTypeId;
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

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getCustomerAvatar() {
        return customerAvatar;
    }

    public void setCustomerAvatar(String customerAvatar) {
        this.customerAvatar = customerAvatar;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
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

    public Boolean getCustomerFlag() {
        return customerFlag;
    }

    public void setCustomerFlag(Boolean customerFlag) {
        this.customerFlag = customerFlag;
    }

    public CustomerType getCustomerTypeId() {
        return customerTypeId;
    }

    public void setCustomerTypeId(CustomerType customerTypeId) {
        this.customerTypeId = customerTypeId;
    }
}
