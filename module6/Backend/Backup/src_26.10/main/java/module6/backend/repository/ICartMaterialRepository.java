package module6.backend.repository;

import module6.backend.entity.cart.CartMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface ICartMaterialRepository extends JpaRepository<CartMaterial, Long> {
    @Query(value = "SELECT cart_material.cart_material_id, cart_material.cart_id ,cart_material.cart_material_flag,cart_material.material_id,cart_material.cart_material_reason FROM cart_material \n" +
            "LEFT JOIN cart ON cart_material.cart_id = cart.cart_id\n" +
            "WHERE cart.cart_status_id = 1 AND cart_material.cart_material_flag = 0", nativeQuery = true)
    List<CartMaterial> findCartMaterialByStatusAndFlag();

    @Modifying
    @Query(value = "UPDATE cart_material SET cart_material_flag = 1 where cart_material_id= :cartId", nativeQuery = true)
    void deleteCartByCartId(@Param("cartId") Long cartId);

    @Query(value = "SELECT cart_material.cart_material_id, cart_material.cart_id ,cart_material.cart_material_flag,cart_material.material_id,cart_material.cart_material_reason FROM cart_material \n" +
            "LEFT JOIN cart ON cart_material.cart_id = cart.cart_id\n" +
            "WHERE cart.cart_status_id = 1 AND cart_material.cart_material_flag = 0 AND cart_material_id = :id", nativeQuery = true)
    CartMaterial findCartMaterialByStatusAndFlagAndMaterialId(@Param("id") Long cartId);

    @Query(value = "SELECT cart_material.cart_material_id, cart_material.cart_id ,cart_material.cart_material_flag,cart_material.material_id,cart_material.cart_material_reason FROM cart_material \n" +
            "LEFT JOIN cart ON cart_material.cart_id = cart.cart_id\n" +
            "WHERE cart_material.cart_material_flag = 0 AND cart_material_id = :id", nativeQuery = true)
    CartMaterial findCartMaterialByFlagAndId(@Param("id") Long cartId);


    @Query(value = "SELECT * FROM cart_material WHERE cart_material_id = :id AND cart_material_flag = 0;", nativeQuery = true)
    CartMaterial getCartMaterialById(@Param("id") Long id);

    @Query(value = "SELECT material_id FROM cart_material LEFT JOIN cart ON cart_material.cart_id = cart.cart_id WHERE cart.cart_status_id = 1 AND cart_material.cart_material_flag = 0;", nativeQuery = true)
    Long[] getCartMaterialByIdAndStatus();

    @Query(value = "SELECT cart_material.cart_material_id, cart_material.cart_id ,cart_material.cart_material_flag,cart_material.material_id,cart_material.cart_material_reason FROM cart_material \n" +
            "LEFT JOIN cart ON cart_material.cart_id = cart.cart_id\n" +
            "WHERE cart.cart_status_id = 1 AND cart_material.cart_material_flag = 0 AND material_id = :id", nativeQuery = true)
    CartMaterial findCartMaterialByStatusAndFlagAndMaterialId1(@Param("id") Long materialId);
}
