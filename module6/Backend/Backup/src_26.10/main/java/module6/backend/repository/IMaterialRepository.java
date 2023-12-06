package module6.backend.repository;

import module6.backend.entity.Import;
import module6.backend.entity.material.Material;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
@Transactional
public interface IMaterialRepository extends JpaRepository<Material, Long> {


    //HoangTND - Statistic Material
    //List material
    @Query(value = "select material.material_code, material.material_name, `import`.import_quantity, cart.cart_quantity, material.material_quantity from `import` \n" +
            "join material on `import`.import_material_id = material.material_id\n" +
            "join cart_material on cart_material.material_id = material.material_id\n" +
            "join cart on cart.cart_id = cart_material.cart_id;  ", nativeQuery = true)
    List<String> findAllStatisticMaterial();

    //Search material
    @Query(value = "select material.material_code, material.material_name, sum(`import`.import_quantity), `import`.import_start_date, cart.cart_quantity, material.material_quantity from `import` \n" +
            "join material on `import`.import_material_id = material.material_id\n" +
            "join cart_material on cart_material.material_id = material.material_id\n" +
            "join cart on cart.cart_id = cart_material.cart_id\n" +
            "group by`import`.import_material_id\n" +
            "having `import`.import_start_date between :fromDate and :toDate", nativeQuery = true)
    List<String> searchStatisticMaterial(@Param("fromDate") String fromDate,
                                         @Param("toDate") String toDate);

    @Query(value = "select material.material_code, material.material_name, `import`.import_quantity, cart.cart_quantity, material.material_quantity from `import` \n" +
            "join material on `import`.import_material_id = material.material_id\n" +
            "join cart_material on cart_material.material_id = material.material_id\n" +
            "join cart on cart.cart_id = cart_material.cart_id;  ", nativeQuery = true)
    String[] findAllStatisticMaterial1();


    @Query(value = "select material.material_code, material.material_name, `import`.import_quantity, cart.cart_quantity, material.material_quantity from `import`\n" +
            "    join material on `import`.import_material_id = material.material_id\n" +
            "    join cart_material on cart_material.material_id = material.material_id\n" +
            "    join cart on cart.cart_id = cart_material.cart_id;", nativeQuery = true)
    List<String> getData();


    // Thắng code tìm kiếm material theo material code
    Material findByMaterialCode(String materialCode);

    // Thắng code thêm mới Vật tư (Import)
    @Query(value = "INSERT INTO `material` (`material_code`, `material_name`, `material_quantity`, `material_price`, `material_expiridate`, `material_unit`, `material_type_id`, `material_customer_id`, `material_image`,`material_describe`) VALUES (?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8, ?9, ?10)", nativeQuery = true)
    @Transactional
    @Modifying
    void createMaterialImport(String code, String name, Integer quantity, Double price, LocalDate hsd, String unit, Long typeId, Long customerId, String image, String describe);

    // Thắng code list material theo customer_id
    @Query(value = "SELECT * FROM material where material_flag = 0 and material_id > 0 and material_type_id > 0 and material_customer_id = ?1", nativeQuery = true)
    List<Material> findAllMaterialImport(Long customerId);

    // Thắng code list material kiểm tra tồn tại code customer
    @Query(value = "SELECT material_code FROM material", nativeQuery = true)
    List<String> findAllMaterialImportString();

    //Thắng code update vật tư theo nhập kho
    @Query(value = "UPDATE `material` SET `material_code` = ?1, `material_name` = ?2, `material_unit` = ?3, `material_quantity` = ?4 WHERE (`material_id` = ?5)", nativeQuery = true)
    @Transactional
    @Modifying
    void updateMaterialImport(String materialCode, String materialName, String materialUnit, Integer quantityMaterial, Long materialId);


    /*
    HieuCLH
    Query lay san pham moi
    */
    @Query(value = "select * from material order by material_id desc limit 4", nativeQuery = true)
    List<Material> findTopNewMaterial();

    @Transactional
    @Modifying
    @Query(value = "UPDATE material set material_flag = true where material_id = :id", nativeQuery = true)
    void deleteById(Long id);

    @Query(value = "select * from material where material_flag = false and ( material_name like %:search% or material_code like %:search% or " +
            " material_unit like %:search%)", nativeQuery = true)
    Page<Material> findAll(Pageable pageable, String search);


    @Query(value = "select * from material where material_flag = false and ( material_name like :search or material_code like :search or " +
            " material_unit like :search)", nativeQuery = true)
    Page<Material> findAllByMaterial(@Param("search") String search, Pageable pageable);

    Page<Material> findAll(Pageable pageable);


    //    @Query(value = "INSERT INTO `material` (`material_code`, `material_name`, `material_quantity`, `material_price`, `material_expiridate`, `material_unit`, `material_type_id`, `material_customer_id`) VALUES (?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8)", nativeQuery = true)
//    @Transactional
//    @Modifying
//    void createMaterial(String code, String name, Integer quantity, Double price, LocalDate hsd, String unit, Long typeId, Long customerId);
//
//    @Query(value = "UPDATE `material` SET `material_code` = ?1, `material_name` = ?2, `material_price` = ?3, `material_quantity` = ?4, `material_expiridate` = ?5, `material_image` = ?6, `material_describe` = ?7, `material_unit` = ?8, `material_type_id` = ?9, `material_customer_id` = ?10 WHERE (`material_id` = ?11);", nativeQuery = true)
//    @Transactional
//    @Modifying
//    void updateMaterial(String code, String name, Double price, Integer quantity, LocalDate hsd, String img, String des, String unit, Long typeId, Long customerId, Long materialId);
//CuongHD-material-create-edit
    @Query(value = "INSERT INTO `material` (`material_code`, `material_name`, `material_price`, `material_quantity`, " +
            "`material_expiridate`,`material_image`,`material_describe`, `material_unit`, `material_type_id`, `material_customer_id`)" +
            " VALUES (?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8,?9,?10)", nativeQuery = true)
    @Transactional
    @Modifying
    void createMaterialImport(String code, String name, Double price, Integer quantity, LocalDate hsd, String img, String des, String unit, Long typeId, Long customerId);

    @Query(value = "UPDATE `material` SET `material_code` = ?1, `material_name` = ?2, `material_price` = ?3, `material_quantity` = ?4, `material_expiridate` = ?5, `material_image` = ?6, `material_describe` = ?7, `material_unit` = ?8, `material_type_id` = ?9, `material_customer_id` = ?10 WHERE (`material_id` = ?11);", nativeQuery = true)
    @Transactional
    @Modifying
    void updateMaterialImport(String code, String name, Double price, Integer quantity, LocalDate hsd, String img, String des, String unit, Long typeId, Long customerId, Long materialId);
}
