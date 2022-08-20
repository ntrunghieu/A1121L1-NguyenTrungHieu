package exam.service.tintuc.impl;

import exam.entity.DanhMuc;
import exam.entity.TinTuc;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ITinTucService {
    Iterable<TinTuc> findAll();

    Optional<TinTuc> findById(Long id);

    TinTuc save(TinTuc tinTuc);

    TinTuc findById1(Long id);

    void remove(Long id);

//    Iterable<TinTuc> findAllByCustomerType(CustomerType customerType);


    Page<TinTuc> findAll(Pageable pageable);
    Page<TinTuc> findAllByTieuDeContaining(String tieude, Pageable pageable);
    List<TinTuc> findAllAPI(Pageable pageable);
    //    Page<Customer> findAllByCustomerNameContaining(String name, Pageable pageable);
//    List<TinTuc> findAllByTieuDeContaining(String name, Pageable pageable);
    Page<TinTuc> search(String tieuDe,String noiDung,String danhMuc, Pageable pageable);

    Page<TinTuc> timKiemTheoTenDanhMuc(Long id, Pageable pageable);

}
