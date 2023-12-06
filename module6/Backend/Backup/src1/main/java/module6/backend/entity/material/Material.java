package module6.backend.entity.material;

import module6.backend.entity.customer.Customer;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "material")
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long materialId;
    private String materialCode;
    private String materialName;
    private Double materialPrice;
    private Integer materialQuantity = 0;
    private LocalDate materialExpiridate;
    private String materialImage;
    private String materialDescribe;
    private Boolean materialFlag = false;
    private String materialUnit;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "material_type_id")
    private MaterialType materialTypeId;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "material_customer_id")
    private Customer materialCustomerId;

    public Material() {
    }

    public Material(Long materialId, String materialCode, String materialName, Double materialPrice, Integer materialQuantity, LocalDate materialExpiridate, String materialImage, String materialDescribe, Boolean materialFlag, String materialUnit, MaterialType materialTypeId, Customer materialCustomerId) {
        this.materialId = materialId;
        this.materialCode = materialCode;
        this.materialName = materialName;
        this.materialPrice = materialPrice;
        this.materialQuantity = materialQuantity;
        this.materialExpiridate = materialExpiridate;
        this.materialImage = materialImage;
        this.materialDescribe = materialDescribe;
        this.materialFlag = materialFlag;
        this.materialUnit = materialUnit;
        this.materialTypeId = materialTypeId;
        this.materialCustomerId = materialCustomerId;
    }

    public Long getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Long materialId) {
        this.materialId = materialId;
    }

    public String getMaterialCode() {
        return materialCode;
    }

    public void setMaterialCode(String materialCode) {
        this.materialCode = materialCode;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public Double getMaterialPrice() {
        return materialPrice;
    }

    public void setMaterialPrice(Double materialPrice) {
        this.materialPrice = materialPrice;
    }

    public Integer getMaterialQuantity() {
        return materialQuantity;
    }

    public void setMaterialQuantity(Integer materialQuantity) {
        this.materialQuantity = materialQuantity;
    }

    public LocalDate getMaterialExpiridate() {
        return materialExpiridate;
    }

    public void setMaterialExpiridate(LocalDate materialExpiridate) {
        this.materialExpiridate = materialExpiridate;
    }

    public String getMaterialImage() {
        return materialImage;
    }

    public void setMaterialImage(String materialImage) {
        this.materialImage = materialImage;
    }

    public String getMaterialDescribe() {
        return materialDescribe;
    }

    public void setMaterialDescribe(String materialDescribe) {
        this.materialDescribe = materialDescribe;
    }

    public Boolean getMaterialFlag() {
        return materialFlag;
    }

    public void setMaterialFlag(Boolean materialFlag) {
        this.materialFlag = materialFlag;
    }

    public String getMaterialUnit() {
        return materialUnit;
    }

    public void setMaterialUnit(String materialUnit) {
        this.materialUnit = materialUnit;
    }

    public MaterialType getMaterialTypeId() {
        return materialTypeId;
    }

    public void setMaterialTypeId(MaterialType materialTypeId) {
        this.materialTypeId = materialTypeId;
    }

    public Customer getMaterialCustomerId() {
        return materialCustomerId;
    }

    public void setMaterialCustomerId(Customer materialCustomerId) {
        this.materialCustomerId = materialCustomerId;
    }
}
