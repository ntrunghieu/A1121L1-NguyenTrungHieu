package module6.backend.entity;

import module6.backend.entity.account.Account;
import module6.backend.entity.material.Material;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Entity
@Table(name = "import")
public class Import {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long importId;
    @NotEmpty
    @Length(max = 20)
    @Pattern(regexp = "HDN-\\d{3}")
    private String importCode;
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate importStartDate;
    @NotNull
    @Min(0)
    private Integer importQuantity;
    private Boolean importFlag = false;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "import_account_id")
    private Account importAccountId;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "import_material_id")
    private Material importMaterialId;

    public Import() {
    }

    public Import(Long importId, String importCode, LocalDate importStartDate, Integer importQuantity, Boolean importFlag, Account importAccountId, Material importMaterialId) {
        this.importId = importId;
        this.importCode = importCode;
        this.importStartDate = importStartDate;
        this.importQuantity = importQuantity;
        this.importFlag = importFlag;
        this.importAccountId = importAccountId;
        this.importMaterialId = importMaterialId;
    }

    public Long getImportId() {
        return importId;
    }

    public void setImportId(Long importId) {
        this.importId = importId;
    }

    public String getImportCode() {
        return importCode;
    }

    public void setImportCode(String importCode) {
        this.importCode = importCode;
    }

    public LocalDate getImportStartDate() {
        return importStartDate;
    }

    public void setImportStartDate(LocalDate importStartDate) {
        this.importStartDate = importStartDate;
    }

    public Integer getImportQuantity() {
        return importQuantity;
    }

    public void setImportQuantity(Integer importQuantity) {
        this.importQuantity = importQuantity;
    }

    public Boolean getImportFlag() {
        return importFlag;
    }

    public void setImportFlag(Boolean importFlag) {
        this.importFlag = importFlag;
    }

    public Account getImportAccountId() {
        return importAccountId;
    }

    public void setImportAccountId(Account importAccountId) {
        this.importAccountId = importAccountId;
    }

    public Material getImportMaterialId() {
        return importMaterialId;
    }

    public void setImportMaterialId(Material importMaterialId) {
        this.importMaterialId = importMaterialId;
    }
}
