package module6.backend.service;

import module6.backend.entity.cart.Cart;
import module6.backend.entity.cart.CartMaterial;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICartMaterialService {
    List<CartMaterial> findCartMaterialByStatusAndFlag();

    void deleteCartByCartId(Long cartId);

    void deleteCartByCartId2(Long[] cartId);

    List<CartMaterial> findCartMaterialByStatusAndFlagAndMaterialId(Long[] cartId);

    List<CartMaterial> findCartMaterialByFlagAndId(Long[] cartId);

    CartMaterial getCartMaterialById( Long id);

    CartMaterial findCartMaterialByStatusAndFlagAndMaterialId1( Long materialId);
}
