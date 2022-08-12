package casestudy.valid;

import casestudy.entity.customer.Customer;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class CustomerValidate implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Customer.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Customer customer = (Customer) target;
        String customerName = customer.getCustomerName();
        ValidationUtils.rejectIfEmpty(errors, "customerName", "name.empty");
//        if (student.getPhoneNumber().length() != 10) {
//            errors.rejectValue("phoneNumber", "phonenumber", new String[]{"10"}, "Số điện thoại không đúng định dạng");
//        } else if (!student.getPhoneNumber().startsWith("0")) {
//            errors.rejectValue("phoneNumber", "phonenumberstart", "Số điện thoại không đúng định dạng");
//        }

        if (!customerName.matches("(^$(CS)-[//d]{4}$)")) {
            errors.rejectValue("customerName", "name.matches");
        }
    }
}
