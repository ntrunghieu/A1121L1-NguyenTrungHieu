package utils;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
    private static Pattern pattern;
    private static Matcher matcher;
    private static final String REGEX_PATIENT_ID = " ^(BN-)\\d{3}$ " ;
    private static final String REGEX_BOOK_ID = " ^(S-)\\d{3}$ ";
    private static final String REGEX_STUDENT_ID = " ^(HS-)\\d{3}$ ";
    private static final String REGEX_BORROW_BOOK_ID = " ^(MS-)\\d{3}$ ";
    private static final String REGEX_PHONE = "^(09|\\(84\\)\\+9)[01]\\d{7}$";
    private static final String REGEX_DATE = "^\\d{4}(\\/|-)\\d{2}(\\/|-)\\d{2}$";
    private static final String REGEX_ID_CARD = "^\\d{9}|\\d{12}$";
    private static final String REGEX_EMAIL = "^\\w{3,}(\\.?\\w+)*@[a-z]{2,7}(.[a-z]{2,5}){1,3}$";
    private static final String REGEX_DATE1 =" ^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$ ";

    private static final String REGEX_PHONE1 = " ^(((\\+|)84)|0)(3|5|7|8|9)+([0-9]{8})$ ";
    public static boolean regexIdBook(String id)  {
        pattern = Pattern.compile(REGEX_BOOK_ID);
        matcher = pattern.matcher(id);
        if (!matcher.find()) {
            return true;
        }
        return false;
    }

    public static boolean regexIdStudent(String id)  {
        pattern = Pattern.compile(REGEX_STUDENT_ID);
        matcher = pattern.matcher(id);
        if (!matcher.find()) {
            return true;
        }
        return false;
    }

    public static boolean regexIdBorrowBook(String id)  {
        pattern = Pattern.compile(REGEX_BORROW_BOOK_ID);
        matcher = pattern.matcher(id);
        if (!matcher.find()) {
            return true;
        }
        return false;
    }



    public static boolean regexEmail(String idCard)  {
        pattern = Pattern.compile(REGEX_EMAIL);
        matcher = pattern.matcher(idCard);

        if (!matcher.find()) {
            return true;
        }
        return false;
    }

    public static boolean regexDate(Date date) throws DateException {
        pattern = Pattern.compile(REGEX_DATE1);
        matcher = pattern.matcher((CharSequence) date);
        if (!matcher.find()){
            return true;
        }
           return false;
    }

//    public static void regexPhone(String phone) throws NumberPhoneException {
//        pattern = Pattern.compile(REGEX_PHONE);
//        matcher = pattern.matcher(phone);
//        if (!matcher.find()) throw new NumberPhoneException("Number Phone Format Exception (090|091)XXXXXXX !!!");
//    }
//
//    public static void regexIdCard(String idCard) throws IdCardException {
//        pattern = Pattern.compile(REGEX_ID_CARD);
//        matcher = pattern.matcher(idCard);
//        if (!matcher.find()) throw new IdCardException("IdCard Format Exception (XXXXXXXX) | (XXXXXXXXXXX)!!!");
//    }
//
//    public static void regexEmail(String email) throws EmailException {
//        pattern = Pattern.compile(REGEX_EMAIL);
//        matcher = pattern.matcher(email);
//        if (!matcher.find()) throw new EmailException("Email Format Exception (abc@abc.abc)!!!");
//    }
//
//    public static void regexNumberInt(int number) throws NumberFormatException {
//        if (number <= 0) throw new NumberFormatException("Number Format Exception (X > 0)!!!");
//    }
//
//    public static void regexNumberDouble(double number) throws NumberFormatException {
//        if (number <= 0) throw new NumberFormatException("Number Format Exception (X > 0)!!!");
//    }
}
