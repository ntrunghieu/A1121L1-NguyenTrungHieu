package module6.backend.entity.cart;

import javax.persistence.*;

@Entity
@Table(name = "cart_status")
public class CartStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartStatusId;
    private String cartStatusName;
    private Boolean cartStatusFlag = false;

    public CartStatus() {
    }

    public CartStatus(Long cartStatusId, String cartStatusName, Boolean cartStatusFlag) {
        this.cartStatusId = cartStatusId;
        this.cartStatusName = cartStatusName;
        this.cartStatusFlag = cartStatusFlag;
    }

    public Long getCartStatusId() {
        return cartStatusId;
    }

    public void setCartStatusId(Long cartStatusId) {
        this.cartStatusId = cartStatusId;
    }

    public String getCartStatusName() {
        return cartStatusName;
    }

    public void setCartStatusName(String cartStatusName) {
        this.cartStatusName = cartStatusName;
    }

    public Boolean getCartStatusFlag() {
        return cartStatusFlag;
    }

    public void setCartStatusFlag(Boolean cartStatusFlag) {
        this.cartStatusFlag = cartStatusFlag;
    }
}
