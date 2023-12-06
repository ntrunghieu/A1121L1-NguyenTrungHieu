package module6.backend.repository;

import module6.backend.entity.material.MaterialType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMaterialTypeRepository extends JpaRepository<MaterialType, Long> {
}
