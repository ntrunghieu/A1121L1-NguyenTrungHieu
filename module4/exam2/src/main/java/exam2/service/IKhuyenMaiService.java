package exam2.service;

import exam2.entity.KhuyenMai;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.Optional;

public interface IKhuyenMaiService {
    Iterable<KhuyenMai> findAll();

    Optional<KhuyenMai> findById(Long id);

    void save(KhuyenMai khuyenMai);

    KhuyenMai findById1(Long id);

    void remove(Long id);

//    Iterable<TinTuc> findAllByCustomerType(CustomerType customerType);


    Page<KhuyenMai> findAll(Pageable pageable);
    Page<KhuyenMai> findAllByTieuDeContaining(String tieude, Pageable pageable);
    Page<KhuyenMai> findAllByMucGiamGiaAndBatDauAndKetThucContaining(Integer mucgiam, Date batdau, Date ketthuc, Pageable pageable);
    Page<KhuyenMai> findAllByMucGiamGiaContaining(String mucgiam, Pageable pageable);

    Page<KhuyenMai> findAllByBatDauContaining(Date batdau, Pageable pageable);
    Page<KhuyenMai> findAllByKetThucContaining(Date ketthuc, Pageable pageable);
}
