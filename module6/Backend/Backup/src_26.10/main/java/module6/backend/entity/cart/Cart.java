package module6.backend.entity.cart;

import module6.backend.entity.account.Account;
import module6.backend.entity.customer.Customer;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;
    private String cartCode;
    private Integer cartQuantity;

    private LocalDate cartDateCreate;

    private Double cartTotalMoney;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cart_status_id")
    private CartStatus cartStatusId;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cart_account_id")
    private Account cartAccountId;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cart_customer_id")
    private Customer cartCustomerId;

    public Cart() {
    }


    public Cart(Long cartId, String cartCode, Integer cartQuantity, LocalDate cartDateCreate, Double cartTotalMoney, CartStatus cartStatusId, Account cartAccountId, Customer cartCustomerId) {
        this.cartId = cartId;
        this.cartCode = cartCode;
        this.cartQuantity = cartQuantity;
        this.cartDateCreate = cartDateCreate;
    }

    public Cart(Long cartId, String cartCode, Integer cartQuantity, Double cartTotalMoney, CartStatus cartStatusId, Account cartAccountId, Customer cartCustomerId) {
        this.cartId = cartId;
        this.cartCode = cartCode;
        this.cartQuantity = cartQuantity;

        this.cartTotalMoney = cartTotalMoney;
        this.cartStatusId = cartStatusId;
        this.cartAccountId = cartAccountId;
        this.cartCustomerId = cartCustomerId;
    }

    public Cart(Long cartId, String cartCode, Integer cartQuantity, LocalDate cartDateCreate, Double cartTotalMoney, CartStatus cartStatusId, Customer cartCustomerId) {
        this.cartId = cartId;
        this.cartCode = cartCode;
        this.cartQuantity = cartQuantity;
        this.cartDateCreate = cartDateCreate;
        this.cartTotalMoney = cartTotalMoney;
        this.cartStatusId = cartStatusId;
        this.cartCustomerId = cartCustomerId;
    }

    public Cart(Integer cartQuantity, Double cartTotalMoney, CartStatus cartStatusId) {
        this.cartQuantity = cartQuantity;
        this.cartTotalMoney = cartTotalMoney;
        this.cartStatusId = cartStatusId;
    }

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public String getCartCode() {
        return cartCode;
    }

    public void setCartCode(String cartCode) {
        this.cartCode = cartCode;
    }

    public Integer getCartQuantity() {
        return cartQuantity;
    }

    public void setCartQuantity(Integer cartQuantity) {
        this.cartQuantity = cartQuantity;
    }

    public Double getCartTotalMoney() {
        return cartTotalMoney;
    }

    public void setCartTotalMoney(Double cartTotalMoney) {
        this.cartTotalMoney = cartTotalMoney;
    }

    public CartStatus getCartStatusId() {
        return cartStatusId;
    }

    public void setCartStatusId(CartStatus cartStatusId) {
        this.cartStatusId = cartStatusId;
    }

    public Account getCartAccountId() {
        return cartAccountId;
    }

    public void setCartAccountId(Account cartAccountId) {
        this.cartAccountId = cartAccountId;
    }

    public Customer getCartCustomerId() {
        return cartCustomerId;
    }

    public void setCartCustomerId(Customer cartCustomerId) {
        this.cartCustomerId = cartCustomerId;
    }


    public LocalDate getCartDateCreate() {
        return cartDateCreate;
    }

    public void setCartDateCreate(LocalDate cartDateCreate) {
        this.cartDateCreate = cartDateCreate;
    }

}
