package module6.backend.service;

import module6.backend.entity.cart.Cart;
import module6.backend.entity.cart.CartMaterial;
import module6.backend.entity.customer.Customer;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ICartService {

    void updateCartStatusAndCustomer(Long idCustomer , Long idCart, LocalDate date, String code);

    void sendEmail(Long[] id,Customer customer);

    void updateCart(Integer quantity , Double money , Long id);

    Long getTypeId();

    String randomCustomerCode();

    String randomCartCode();

    Cart findByCartId(Long id);

    void updateQuantityMaterial(Integer quantity,Long id);
}
