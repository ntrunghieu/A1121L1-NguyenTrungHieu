package exam.repository;

import exam.entity.DanhMuc;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDanhMucRepository extends JpaRepository<DanhMuc,Long> {
    Page<DanhMuc> findAllByTenDanhMucContaining(String name, Pageable pageable);



}
