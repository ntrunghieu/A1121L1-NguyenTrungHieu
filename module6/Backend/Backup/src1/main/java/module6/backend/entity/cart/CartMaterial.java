package module6.backend.entity.cart;

import module6.backend.entity.material.Material;

import javax.persistence.*;

@Entity
@Table(name = "cart_material")
public class CartMaterial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartMaterialId;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cart_id")
    private Cart cartId;

    private Boolean cartMaterialFlag = false;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "material_id")
    private Material materialId;

    private String cartMaterialReason;

    public CartMaterial() {
    }

    public CartMaterial(Long cartMaterialId, Cart cartId, Boolean cartMaterialFlag, Material materialId, String cartMaterialReason) {
        this.cartMaterialId = cartMaterialId;
        this.cartId = cartId;
        this.cartMaterialFlag = cartMaterialFlag;
        this.materialId = materialId;
        this.cartMaterialReason = cartMaterialReason;
    }

    public Long getCartMaterialId() {
        return cartMaterialId;
    }

    public void setCartMaterialId(Long cartMaterialId) {
        this.cartMaterialId = cartMaterialId;
    }

    public Cart getCartId() {
        return cartId;
    }

    public void setCartId(Cart cartId) {
        this.cartId = cartId;
    }

    public Boolean getCartMaterialFlag() {
        return cartMaterialFlag;
    }

    public void setCartMaterialFlag(Boolean cartMaterialFlag) {
        this.cartMaterialFlag = cartMaterialFlag;
    }

    public Material getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Material materialId) {
        this.materialId = materialId;
    }

    public String getCartMaterialReason() {
        return cartMaterialReason;
    }

    public void setCartMaterialReason(String cartMaterialReason) {
        this.cartMaterialReason = cartMaterialReason;
    }
}
