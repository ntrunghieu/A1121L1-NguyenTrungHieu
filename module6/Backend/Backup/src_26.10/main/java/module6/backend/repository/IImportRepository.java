package module6.backend.repository;

import module6.backend.entity.Import;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface IImportRepository extends JpaRepository<Import, Long> {
    @Query(value = "select sum(`import`.import_quantity * material.material_price) as tien_nhap_hang from `import` join material on import.import_material_id = material.material_id ;", nativeQuery = true)
    Integer nhap();

    @Query(value = "select sum(`import`.import_quantity * material.material_price) as tien_nhap_hang from `import` join material on import.import_material_id = material.material_id where month(import_start_date) like :month and year(import_start_date) like :year", nativeQuery = true)
    Integer searchnhap(@Param("month") String month , @Param("year") String year );

    // Thắng code list import
    @Query(value = "select * from import where import_account_id > 0 and import_material_id > 0 and import_id > 0 and import_flag = 0", nativeQuery = true)
    Page<Import> findAllImport(Pageable pageable);

    // Thắng code list import
    @Query(value = "select import_code from import", nativeQuery = true)
    List<String> findAllImportString();

    // Thắng code search import
    @Query(value = "select * from import where import_account_id > 0 and import_material_id > 0 and import_id > 0 and import_flag = 0 and import_code like ?1 and (import_start_date between ?2 and ?3)", nativeQuery = true)
    Page<Import> searchImport(String code, String startDate, String endDate, Pageable pageable);

    // Thắng code search import chỉ code
    @Query(value = "select * from import where import_account_id > 0 and import_material_id > 0 and import_id > 0 and import_flag = 0 and import_code like ?1", nativeQuery = true)
    Page<Import> searchImportCode(String importCode, Pageable pageable);

    // Thắng code xoá import
    @Query(value = "UPDATE import SET import_id = ?1, `import_flag` = ?2  WHERE (`import_id` = ?3)", nativeQuery = true)
    @Transactional
    @Modifying
    void deleteImport(Long idAfterUpdate, Boolean flag, Long idBeforeUpdate);

    // Thắng code find import by id
    @Query(value = "select * from import where `import_id` = ?1 and `import_flag` = 0 and `import_account_id` > 0 and `import_material_id` > 0", nativeQuery = true)
    Optional<Import> findImportById(Long id);

    // Thắng code find import theo import_code
    @Query(value = "select * from import where `import_code` = ?1 and `import_flag` = 0 and `import_account_id` > 0 and `import_material_id` > 0;", nativeQuery = true)
    Import findImportByCode(String importCode);

    // Thắng code update import
    @Query(value = "UPDATE `import` SET `import_code` = ?1, `import_start_date` = ?2, `import_quantity` = ?3, `import_account_id` = ?4, `import_material_id` = ?5 WHERE (`import_id` = ?6);", nativeQuery = true)
    @Transactional
    @Modifying
    void updateImport(String code, LocalDate startDate, Integer quantity, Long idAccount, Long idMaterial, Long idImport);

    // Thắng code create import
    @Query(value = "INSERT INTO `import` (`import_code`, `import_start_date`, `import_quantity`, `import_account_id`, `import_material_id`) VALUES (?1, ?2, ?3, ?4, ?5);", nativeQuery = true)
    @Transactional
    @Modifying
    void createImport(String code, LocalDate startDate, Integer quantity, Long idAccount, Long idMaterial);
}
