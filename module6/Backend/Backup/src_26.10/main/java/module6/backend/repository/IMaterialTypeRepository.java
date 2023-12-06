package module6.backend.repository;

import module6.backend.entity.material.MaterialType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMaterialTypeRepository extends JpaRepository<MaterialType, Long> {
    //ThangLT code lấy list material type
    @Query(value = "SELECT * FROM sprint1.material_type where material_type_id > 0;", nativeQuery = true)
    List<MaterialType> findAllMaterialTypeImport();
}
