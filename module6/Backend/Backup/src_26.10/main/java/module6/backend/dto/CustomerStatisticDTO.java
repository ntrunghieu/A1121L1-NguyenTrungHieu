package module6.backend.dto;

import module6.backend.entity.cart.Cart;
import module6.backend.entity.cart.CartStatus;
import module6.backend.entity.customer.Customer;

public class CustomerStatisticDTO {
    private Customer customer;
    private Cart cart;
    private CartStatus cartStatus;

    public CustomerStatisticDTO() {
    }

    public CustomerStatisticDTO(Customer customer, Cart cart, CartStatus cartStatus) {
        this.customer = customer;
        this.cart = cart;
        this.cartStatus = cartStatus;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public CartStatus getCartStatus() {
        return cartStatus;
    }

    public void setCartStatus(CartStatus cartStatus) {
        this.cartStatus = cartStatus;
    }
}
