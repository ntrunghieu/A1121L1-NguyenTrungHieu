package springboot.form.entity;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

@Component
public class User implements Validator {
    private String firstName;
    private String lastName;

    @Pattern(regexp = "^0[0-9]{9}$",message = "Phone number need to have 10 digits")
    private String phoneNumber;

    @Pattern(regexp = "^[a-zA-Z0-9.!#$%&’*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$",message = "Invalid email")
    private String email;

    @Min(18)
    private int age;

    public User() {
    }

    public User(String firstName, String lastName,String phoneNumber, String email, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.age = age;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        String firstName = user.getFirstName();
        String lastName = user.getLastName();

        ValidationUtils.rejectIfEmpty(errors,"firstName","name.empty");
        ValidationUtils.rejectIfEmpty(errors,"lastName","name.empty");
        if(firstName.length()<5 || firstName.length()>45) {
            errors.rejectValue("firstName","name.length");
        }
        if(lastName.length()<5 || lastName.length()>45) {
            errors.rejectValue("lastName","name.length");
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
