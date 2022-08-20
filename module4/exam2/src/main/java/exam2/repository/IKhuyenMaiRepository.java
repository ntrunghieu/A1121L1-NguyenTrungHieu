package exam2.repository;

import exam2.entity.KhuyenMai;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface IKhuyenMaiRepository extends JpaRepository<KhuyenMai, Long> {
    Page<KhuyenMai> findAllByTieuDeContaining(String tieude, Pageable pageable);
    Page<KhuyenMai> findAllByMucGiamGiaContaining(String mucgiam, Pageable pageable);
    Page<KhuyenMai> findAllByBatDauContaining(Date batdau, Pageable pageable);
    Page<KhuyenMai> findAllByKetThucContaining(Date ketthuc, Pageable pageable);


    Page<KhuyenMai> findAllByMucGiamGiaAndBatDauAndKetThucContaining(Integer mucgiam, Date batdau, Date ketthuc, Pageable pageable);

}
