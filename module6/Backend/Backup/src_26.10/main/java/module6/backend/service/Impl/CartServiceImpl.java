package module6.backend.service.Impl;

import module6.backend.entity.cart.Cart;
import module6.backend.entity.cart.CartMaterial;
import module6.backend.entity.cart.DataMail;
import module6.backend.entity.customer.Customer;
import module6.backend.entity.customer.CustomerType;
import module6.backend.repository.ICartRepository;
import module6.backend.repository.ICustomerTypeRepository;
import module6.backend.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CartServiceImpl implements ICartService {
    @Autowired
    private ICartRepository cartRepository;

    @Autowired
    private DataMailServiceImpl dataMailService;

    @Autowired
    private ICustomerTypeRepository customerTypeRepository;

    @Autowired
    private CartMaterialServiceImpl cartMaterialService;

    private Double totalMoneyBill = 0.0;
    private String codeBill = "";

    @Override
    public void updateCartStatusAndCustomer(Long idCustomer, Long idCart , LocalDate date, String code) {
        cartRepository.updateCartStatusAndCustomer(idCustomer,idCart, date,code);
    }

    @Override
    public void sendEmail(Long[] cartId, Customer customer) {
       List<CartMaterial> cartMaterials = cartMaterialService.findCartMaterialByFlagAndId(cartId);
       for(CartMaterial cart : cartMaterials){
          totalMoneyBill = totalMoneyBill + cart.getCartId().getCartTotalMoney();
          codeBill = cart.getCartId().getCartCode();
       }
        try {
            DataMail dataMail = new DataMail();
            dataMail.setTo(customer.getCustomerEmail());
            dataMail.setSubject("Hóa đơn thanh toán");
            Map<String, Object> props = new HashMap<>();
            props.put("codeBill", codeBill);
            props.put("cartList", cartMaterials);
            props.put("customer", customer);
            props.put("totalMoneyBill", totalMoneyBill);
            dataMail.setProps(props);
            dataMailService.sendMail(dataMail,"Mail");
            System.out.println("Send Mail pass");
        } catch (MessagingException exp){
            exp.printStackTrace();
        }
    }

    @Override
    public void updateCart(Integer quantity, Double money, Long id) {
        cartRepository.updateCart(quantity,money,id);
    }

    @Override
    public Long getTypeId() {
        List<CustomerType> customerTypes = customerTypeRepository.findAll();
        Long customerTypes1 = 0L;
        for (CustomerType customerType: customerTypes) {
            customerTypes1 = customerType.getCustomerTypeId();
            break;
        }
        return customerTypes1;
    }

    @Override
    public String randomCustomerCode() {
        String[] code1 = cartRepository.listCustomerCode();
        String customerCode;
        boolean check = true;
        do {
            int code = (int) Math.floor(((Math.random() * 89999) + 10000));
            customerCode = "MKH-" + String.valueOf(code) ;
            for (int i = 0 ; i < code1.length;i++) {
                if (code1[i].equals(customerCode)){
                    check = false;
                    break;
                } else {
                    if (i == code1.length-1){
                        check = true;
                    }
                }
            }
        } while (!check);
        return customerCode;
    }

    @Override
    public String randomCartCode() {
        String[] code1 = cartRepository.listCartCode();
        String cartrCode;
        boolean check = true;
        do {
            int code = (int) Math.floor(((Math.random() * 89999) + 10000));
            cartrCode = "MHD-" + String.valueOf(code) ;
            for (int i = 0 ; i < code1.length;i++) {
                if (code1[i] == null) {
                    continue;
                }
                if (code1[i].equals(cartrCode)){
                    check = false;
                    break;
                } else {
                    if (i == code1.length-1){
                        check = true;
                    }
                }
            }
        } while (!check);
        return cartrCode;
    }

    @Override
    public Cart findByCartId(Long id) {
        return cartRepository.findByCartId(id);
    }

    @Override
    public void updateQuantityMaterial(Integer quantity, Long id) {
        cartRepository.updateQuantityMaterial(quantity,id);
    }
}
