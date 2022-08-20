package exam.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "tin_tuc")
public class TinTuc {
    @Id
    @Column(name = "id_tin_tuc")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTintuc;
    @NotEmpty(message = "khong duoc de trong")
    private String tieuDe;
        @DateTimeFormat(pattern = "dd/MM/yyyy")
//    @NotNull(message = "chua chon ngay")
    private Date ngayDangtin;
    @Size(max = 500, min = 1, message = "phai duoi 500 ki tu")
    @NotEmpty( message = "khong duoc de trong")
    private String noiDung;
    @NotEmpty(message = "khong duoc de trong")
    private String tenPhongVien;
    @ManyToOne
    @JoinColumn(name = "danh_muc")
    private DanhMuc danhMuc;

    public TinTuc() {
    }

    public TinTuc(Long idTintuc, String tieuDe, Date ngayDangtin, String noiDung, String tenPhongVien, DanhMuc danhMuc) {
        this.idTintuc = idTintuc;
        this.tieuDe = tieuDe;
        this.ngayDangtin = ngayDangtin;
        this.noiDung = noiDung;
        this.tenPhongVien = tenPhongVien;
        this.danhMuc = danhMuc;
    }

    public Long getIdTintuc() {
        return idTintuc;
    }

    public void setIdTintuc(Long idTintuc) {
        this.idTintuc = idTintuc;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public Date getNgayDangtin() {
        return ngayDangtin;
    }

    public void setNgayDangtin(Date ngayDangtin) {
        this.ngayDangtin = ngayDangtin;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getTenPhongVien() {
        return tenPhongVien;
    }

    public void setTenPhongVien(String tenPhongVien) {
        this.tenPhongVien = tenPhongVien;
    }

    public DanhMuc getDanhMuc() {
        return danhMuc;
    }

    public void setDanhMuc(DanhMuc danhMuc) {
        this.danhMuc = danhMuc;
    }
}
