package module6.backend.repository;

import module6.backend.entity.cart.CartMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICartMaterialRepository extends JpaRepository<CartMaterial, Long> {
}
