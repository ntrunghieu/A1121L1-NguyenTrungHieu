package baitapngoai;

import java.util.Scanner;

public class lab6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap chuoi");
        String chuoi = sc.nextLine();
        String mangChuoi[] = chuoi.split("-");
        boolean check = kiemTraSNT(chuoi);
        if (check){
            System.out.println(mangChuoi[1] + " la so nguyen to");
        }else {
            System.out.println("khong phai so nguyen to");
        }

//        System.out.println(mangChuoi[1]);
//        for (int i = 0; i < mangChuoi.length; i++) {
//            System.out.println(mangChuoi[1]);
//        }
    }
    public static boolean kiemTraSNT(String chuoi){
        String mangChuoi[] = chuoi.split("-");
        String mangChuoi1[] = mangChuoi[1].split("\\.");
        int num = Integer.parseInt(mangChuoi1[0]);
        if (num < 2){
            return false;
        }
        for (int i = 2; i < Math.sqrt(num); i++) {
            if (num % i == 0){
                return false;
            }
        }
        return true;

    }
}
