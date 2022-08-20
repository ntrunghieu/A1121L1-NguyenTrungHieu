package exam2.entity;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;
@Entity
@Table(name = "khuyen_mai")
public class KhuyenMai {
    @Id
    @Column(name = "id_khuyen_mai")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "khong duoc de trong")
    private String tieuDe;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date batDau;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date ketThuc;
    @Range(min = 10000, message = "ma giam gia phai lon hon 10.000")
//    @NotEmpty(message = "khong duoc de trong")
//    @Length(min = 1, max = 10000, message = "ma giam gia phai lon hon 10.000")
    private Integer mucGiamGia;
    @NotEmpty(message = "khong duoc trong")
    private String chiTiet;

    public KhuyenMai() {
    }

    public KhuyenMai(Long id, String tieuDe, Date batDau, Date ketThuc, Integer mucGiamGia, String chiTiet) {
        this.id = id;
        this.tieuDe = tieuDe;
        this.batDau = batDau;
        this.ketThuc = ketThuc;
        this.mucGiamGia = mucGiamGia;
        this.chiTiet = chiTiet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public Date getBatDau() {
        return batDau;
    }

    public void setBatDau(Date batDau) {
        this.batDau = batDau;
    }

    public Date getKetThuc() {
        return ketThuc;
    }

    public void setKetThuc(Date ketThuc) {
        this.ketThuc = ketThuc;
    }

    public Integer getMucGiamGia() {
        return mucGiamGia;
    }

    public void setMucGiamGia(Integer mucGiamGia) {
        this.mucGiamGia = mucGiamGia;
    }

    public String getChiTiet() {
        return chiTiet;
    }

    public void setChiTiet(String chiTiet) {
        this.chiTiet = chiTiet;
    }
}
