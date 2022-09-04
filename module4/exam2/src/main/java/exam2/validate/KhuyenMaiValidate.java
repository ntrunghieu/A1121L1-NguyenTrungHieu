package exam2.validate;

import exam2.entity.KhuyenMai;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

public class KhuyenMaiValidate implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return KhuyenMai.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        LocalDate localDate = LocalDate.now();
        Date date1 = java.sql.Date.valueOf(localDate);
        KhuyenMai khuyenMai = (KhuyenMai) target;





        if (khuyenMai.getBatDau().before(date1)) {
            errors.rejectValue("batDau", "batDau", "Phai lon hon ngay hien tai");

        }else if (khuyenMai.getKetThuc().before(khuyenMai.getBatDau()) ){
            errors.rejectValue("ketThuc", "ketThuc", "Phai lon hon ngay bat dau");

        }else if (khuyenMai.getBatDau() == null && khuyenMai.getKetThuc() == null) {
            errors.rejectValue("ketThuc", "ketThuc.rong", "Chua chon ngay");

        }




        if (khuyenMai.getMucGiamGia() == null){
            errors.rejectValue("mucGiamGia", "mucGiamGia", "Khong duoc rong");

        }


    }
}
