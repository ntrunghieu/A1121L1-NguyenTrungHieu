package ss15_Exception_Debug.thuchanh;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayExample arrayExample = new ArrayExample();
        Integer[] arr = arrayExample.random();
        Scanner scaner = new Scanner(System.in);
        System.out.println("\nVui lòng nhập chỉ số của một phần tử bất kỳ: ");
        int n = scaner.nextInt();
        try {
            System.out.println("Giá trị của phần tử có chỉ số " + n + " là " + arr[n]);
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Chỉ số vượt quá giới hạn của mảng");
        }
        System.out.println("nhap x: ");
        int x = scaner.nextInt();
        System.out.println("nhap y: ");
        int y = scaner.nextInt();
        System.out.println("nhap z: ");
        int z = scaner.nextInt();
        ArrayExample.triangle(x,y,z);


    }
}
