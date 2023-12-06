package module6.backend.util.cartValidator;

import module6.backend.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class EmailValidator implements ConstraintValidator<EmailCustom, String> {

    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public void initialize(EmailCustom constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
         boolean check = true;
         String[] email = customerRepository.getAllEmail();
         for (int i =0;i < email.length;i++){
             if (value.equals(email[i])) {
                 check = false;
                 break;
             }
         }
         return check;
    }
}
