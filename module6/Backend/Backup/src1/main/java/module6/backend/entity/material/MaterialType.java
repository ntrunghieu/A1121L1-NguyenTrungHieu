package module6.backend.entity.material;

import javax.persistence.*;

@Entity
@Table(name = "material_type")
public class MaterialType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long materialTypeId;
    private String materialTypeName;
    private Boolean materialTypeFlag = false;

    public MaterialType() {
    }

    public MaterialType(Long materialTypeId, String materialTypeName, Boolean materialTypeFlag) {
        this.materialTypeId = materialTypeId;
        this.materialTypeName = materialTypeName;
        this.materialTypeFlag = materialTypeFlag;
    }

    public Long getMaterialTypeId() {
        return materialTypeId;
    }

    public void setMaterialTypeId(Long materialTypeId) {
        this.materialTypeId = materialTypeId;
    }

    public String getMaterialTypeName() {
        return materialTypeName;
    }

    public void setMaterialTypeName(String materialName) {
        this.materialTypeName = materialName;
    }

    public Boolean getMaterialTypeFlag() {
        return materialTypeFlag;
    }

    public void setMaterialTypeFlag(Boolean materialTypeFlag) {
        this.materialTypeFlag = materialTypeFlag;
    }
}
