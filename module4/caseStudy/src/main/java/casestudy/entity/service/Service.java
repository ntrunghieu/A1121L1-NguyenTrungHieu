package casestudy.entity.service;

import org.hibernate.type.descriptor.sql.VarcharTypeDescriptor;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_id")
    private Long serviceId;
    @NotEmpty(message = "Dich vu khong duoc de trong")
    @Column(name = "service_name")
    private String serviceName;
    //    @Pattern(regexp = "^[0-9]*$", message = "Dien tich phai lon hon 0")
    @Min(value = 1, message = "Dien tich phai lon hon 0")
    @Column(name = "service_area")
    private Integer serviceArea;
    @Min(value = 1, message = "Positive number only")
//    @Pattern(regexp = "^[0-9]*$", message = "Cost phai lon hon khong")
    @Column(name = "service_cost")
    private Integer serviceCost;
    @Min(value = 1, message = "phai la so duong va lon hon 0")
//    @Pattern(regexp = "^[0-9]*$", message = "So luong nguoi phai lon hon 0")
    @Column(name = "service_max_people")
    private Integer serviceMaxPeople;
    @NotEmpty(message = "khong duoc de trong")
    @Column(name = "standard_room")
    private String standardRoom;
    @NotEmpty(message = "khong duoc de trong")
    @Column(name = "description_other_convenience", columnDefinition = "varchar(100)")
    private String descriptionOtherConvenience;
    //    @NotEmpty(message = "Dien tich khong duoc de trong")
//    @Pattern(regexp = "^[0-9]*$", message = "Dien tich phai lon hon 0")
    @Min(value = 0, message = "Positive number only")
    @Column(name = "pool_area")
    private Double poolArea;
    //    @NotEmpty(message = "Number of floors khong duoc de trong")
//    @Pattern(regexp = "^[0-9]*$", message = "Number of floors phai lon hon 0")
    @Min(value = 0, message = "Positive number only")
    @Column(name = "number_of_floors")
    private Integer numberOfFloors;

    @ManyToOne
    @JoinColumn(name = "rent_type_id", nullable = false)
    private RentType rentType;

    @ManyToOne
    @JoinColumn(name = "service_type_id", nullable = false)
    private ServiceType serviceType;

    public Service() {
    }

    public Service(Long serviceId, String serviceName, Integer serviceArea, Integer serviceCost,
                   Integer serviceMaxPeople, String standardRoom, String descriptionOtherConvenience,
                   Double poolArea, Integer numberOfFloors, RentType rentType, ServiceType serviceType) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.serviceArea = serviceArea;
        this.serviceCost = serviceCost;
        this.serviceMaxPeople = serviceMaxPeople;
        this.standardRoom = standardRoom;
        this.descriptionOtherConvenience = descriptionOtherConvenience;
        this.poolArea = poolArea;
        this.numberOfFloors = numberOfFloors;
        this.rentType = rentType;
        this.serviceType = serviceType;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Integer getServiceArea() {
        return serviceArea;
    }

    public void setServiceArea(Integer serviceArea) {
        this.serviceArea = serviceArea;
    }

    public Integer getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(Integer serviceCost) {
        this.serviceCost = serviceCost;
    }

    public Integer getServiceMaxPeople() {
        return serviceMaxPeople;
    }

    public void setServiceMaxPeople(Integer serviceMaxPeople) {
        this.serviceMaxPeople = serviceMaxPeople;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public void setDescriptionOtherConvenience(String descriptionOtherConvenience) {
        this.descriptionOtherConvenience = descriptionOtherConvenience;
    }

    public Double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(Double poolArea) {
        this.poolArea = poolArea;
    }

    public Integer getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(Integer numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

}
