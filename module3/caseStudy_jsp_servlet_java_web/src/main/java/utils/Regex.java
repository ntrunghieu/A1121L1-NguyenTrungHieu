package utils;

import java.util.Scanner;

public class Regex {
    public static final String REGEX_STR="^[A-Z][a-z4-50]+$";
    public static final String REGEX_ID_VILLA="(SVVL)-[//d]{4}";
    public static final String REGEX_ID_HOUSE="(SVHO)-[//d]{4}";
    public static final String REGEX_ID_ROOM="(SVRO)-[//d]{4}";
    public static final String REGEX_AREA="^({3,9})\\d|[1-9]\\d{2,}$";
    public static final String REGEX_INT="^[1-9]|([1][0-9])$";
    public static final String REGEX_AMOUNT="^[1-9]|([1][0-9])|(20)$";
    public static final String REGEX_PHONE="^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$";
    public static final String REGEX_MAIL="\\b[A-Z0-9._%-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}\\b";
    public static final String REGEX_SO_TK="[//d]{10}";
    public static final String REGEX_TEN_TK="^[a-z][a-z]{2,}$";
    static Scanner scanner = new Scanner(System.in);
    public static String regexStr(String temp, String regex, String error){
        boolean check = false;
        do {
            if (temp.matches(regex)){
                check=false;
                break;
            }else {
                System.out.print(error);
                temp=scanner.nextLine();
            }
        }while (check);
        return temp;
    }
}
