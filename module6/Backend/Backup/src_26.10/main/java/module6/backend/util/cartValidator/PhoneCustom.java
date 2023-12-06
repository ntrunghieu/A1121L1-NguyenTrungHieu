package module6.backend.util.cartValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PhoneValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface PhoneCustom {
    String message();
    Class<?> [] groups() default {};
    Class<? extends Payload> [] payload() default {};
}
