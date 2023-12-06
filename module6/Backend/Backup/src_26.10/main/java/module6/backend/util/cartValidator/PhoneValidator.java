package module6.backend.util.cartValidator;

import module6.backend.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class PhoneValidator implements ConstraintValidator<PhoneCustom, String> {
    @Autowired
    private ICustomerRepository customerRepository;
    @Override
    public void initialize(PhoneCustom constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        boolean check = true;
        String[] phone = customerRepository.getAllPhone();
        for (int i =0;i < phone.length;i++){
            if (value.equals(phone[i])) {
                check = false;
                break;
            }
        }
        return check;
    }


}
