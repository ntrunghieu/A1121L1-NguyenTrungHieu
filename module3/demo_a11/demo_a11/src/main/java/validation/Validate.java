package validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
    private static Pattern pattern;
    private static Matcher matcher;
    private static final String REGEX_CUSTOMER_ID = "^(KH-)\\d{4}$";
    private static final String REGEX_PHONE = "^(09|\\(84\\)\\+9)[01]\\d{7}$";
    private static final String REGEX_DATE = "^\\d{4}(\\/|-)\\d{2}(\\/|-)\\d{2}$";
    private static final String REGEX_ID_CARD = "^\\d{9}|\\d{12}$";
    private static final String REGEX_EMAIL = "^\\w{3,}(\\.?\\w+)*@[a-z]{2,7}(.[a-z]{2,5}){1,3}$";

    public static boolean regexId(String phone)  {
        pattern = Pattern.compile(REGEX_CUSTOMER_ID);
        matcher = pattern.matcher(phone);
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
//
//    public static void regexDate(String date) throws DateException {
//        pattern = Pattern.compile(REGEX_DATE);
//        matcher = pattern.matcher(date);
//        if (!matcher.find()) throw new DateException("Date Format Exception (dd/mm/YYYY)!!!");
//    }
//
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
