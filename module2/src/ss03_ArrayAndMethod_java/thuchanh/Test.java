package ss03_ArrayAndMethod_java.thuchanh;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhap diem:");
        
        int n=scanner.nextInt();
        while (n<4){
            System.out.println("nhap lai");
            n=scanner.nextInt();
        }
        System.out.println("qua mon");
    }
}
