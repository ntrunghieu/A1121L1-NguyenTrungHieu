package module6.backend.entity.ClassDTO;

import module6.backend.entity.Import;
import module6.backend.entity.cart.Cart;
import module6.backend.entity.material.Material;

public class MaterialStatisticDTO {
    private Material material;
    private Import import1;
    private Cart cart;

    public MaterialStatisticDTO() {
    }

    public MaterialStatisticDTO(Material material, Import import1, Cart cart) {
        this.material = material;
        this.import1 = import1;
        this.cart = cart;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Import getImport1() {
        return import1;
    }

    public void setImport1(Import import1) {
        this.import1 = import1;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
