package exam.validate;

import exam.entity.TinTuc;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class TinTucValidate implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return TinTuc.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        LocalDate localDate =   LocalDate.now();
        Date date1= java.sql.Date.valueOf(localDate);
        TinTuc tinTuc= (TinTuc) target;


        if (tinTuc.getNgayDangtin().before(date1)){
            errors.rejectValue("ngayDangtin", "ngay.lonhon", "Phai lon hon ngay hien tai");

        }else if (tinTuc.getNgayDangtin() == null){
            errors.rejectValue("ngayDangtin", "ngay.lonhon", "Chua chon ngay");

        }



//        ValidationUtils.rejectIfEmpty(errors, "ngayDangtin", "ngay.empty","khong duoc de trong");


//        if (student.getPhoneNumber().length() != 10) {
//            errors.rejectValue("phoneNumber", "phonenumber", new String[]{"10"}, "Số điện thoại không đúng định dạng");
//        } else if (!student.getPhoneNumber().startsWith("0")) {
//            errors.rejectValue("phoneNumber", "phonenumberstart", "Số điện thoại không đúng định dạng");
//        }
    }
}
