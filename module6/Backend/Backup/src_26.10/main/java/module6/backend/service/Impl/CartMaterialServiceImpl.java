package module6.backend.service.Impl;

import module6.backend.entity.cart.Cart;
import module6.backend.entity.cart.CartMaterial;
import module6.backend.repository.ICartMaterialRepository;
import module6.backend.service.ICartMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartMaterialServiceImpl implements ICartMaterialService {
    @Autowired
    private ICartMaterialRepository cartMaterialRepository;

    @Override
    public List<CartMaterial> findCartMaterialByStatusAndFlag() {
        return cartMaterialRepository.findCartMaterialByStatusAndFlag();
    }

    @Override
    public void deleteCartByCartId(Long cartId) {
        cartMaterialRepository.deleteCartByCartId(cartId);
    }

    @Override
    public void deleteCartByCartId2(Long[] cartId) {
        for (int i =0; i<cartId.length;i++) {
            cartMaterialRepository.deleteCartByCartId(cartId[i]);
        }
    }

    @Override
    public List<CartMaterial> findCartMaterialByStatusAndFlagAndMaterialId(Long[] cartId) {
        List<CartMaterial> cartMaterials = new ArrayList<>();
        for (int i =0; i<cartId.length;i++) {
            cartMaterials.add(cartMaterialRepository.findCartMaterialByStatusAndFlagAndMaterialId(cartId[i])) ;
        }
        return cartMaterials;
    }

    @Override
    public List<CartMaterial> findCartMaterialByFlagAndId(Long[] cartId) {
        List<CartMaterial> cartMaterials = new ArrayList<>();
        for (int i =0; i<cartId.length;i++) {
            cartMaterials.add(cartMaterialRepository.findCartMaterialByFlagAndId(cartId[i])) ;
        }
        return cartMaterials;
    }

    @Override
    public CartMaterial getCartMaterialById(Long id) {
        return cartMaterialRepository.getCartMaterialById(id);
    }

    @Override
    public CartMaterial findCartMaterialByStatusAndFlagAndMaterialId1(Long materialId) {
        return cartMaterialRepository.findCartMaterialByStatusAndFlagAndMaterialId1(materialId);
    }


}
