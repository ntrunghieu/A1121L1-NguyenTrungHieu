package exam.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "danh_muc")
public class DanhMuc {
    @Id
    @Column(name = "id_danh_muc")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDanhMuc;
    private String tenDanhMuc;

    @OneToMany(targetEntity = TinTuc.class)
    private List<TinTuc> tinTucs;

    public DanhMuc() {
    }

    public DanhMuc(Long idDanhMuc, String tenDanhMuc, List<TinTuc> tinTucs) {
        this.idDanhMuc = idDanhMuc;
        this.tenDanhMuc = tenDanhMuc;
        this.tinTucs = tinTucs;
    }

    public Long getIdDanhMuc() {
        return idDanhMuc;
    }

    public void setIdDanhMuc(Long idDanhMuc) {
        this.idDanhMuc = idDanhMuc;
    }

    public String getTenDanhMuc() {
        return tenDanhMuc;
    }

    public void setTenDanhMuc(String tenDanhMuc) {
        this.tenDanhMuc = tenDanhMuc;
    }

    public List<TinTuc> getTinTucs() {
        return tinTucs;
    }

    public void setTinTucs(List<TinTuc> tinTucs) {
        this.tinTucs = tinTucs;
    }
}
