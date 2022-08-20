package exam.repository;

import exam.entity.DanhMuc;
import exam.entity.TinTuc;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITinTucRepository extends JpaRepository<TinTuc, Long> {
//    Iterable<TinTuc> findAllByTieuDe(TinTuc tinTuc);

    Page<TinTuc> findAllByTieuDeContaining(String tieude, Pageable pageable);

    //    Page<Customer> findAllByCustomerNameContaining(String name, Pageable pageable);
//    List<TinTuc> findAllByTieuDeContaining(String name, Pageable pageable);

    @Query("SELECT e FROM TinTuc e ORDER BY e.tieuDe DESC")
    List<TinTuc> findAllByTieuDe();

    Page<TinTuc> findAllByTieuDeAndNoiDungAndDanhMuc(String tieuDe,String noiDung,String danhMuc, Pageable pageable);

    Page<TinTuc> findAllByDanhMucContaining(Long id, Pageable pageable);
//    Page<TinTuc> findAllByDanhMucOrDanhMuc(String tenDanhMuc, Pageable pageable);



}
