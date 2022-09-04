package exam.service.danhmuc.impl;

import exam.entity.DanhMuc;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IDanhMucService {
    Page<DanhMuc> findAll(Pageable pageable);

    Iterable<DanhMuc> findAll();
    Optional<DanhMuc> findById(Long id);

    Page<DanhMuc> findAllByTenDanhMucContaining(String name, Pageable pageable);



}
