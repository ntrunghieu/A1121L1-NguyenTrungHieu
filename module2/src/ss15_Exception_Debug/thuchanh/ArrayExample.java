package ss15_Exception_Debug.thuchanh;

import java.util.Random;

public class ArrayExample {
    public Integer[] random(){
        Random rd=new Random();
        Integer[] arr=new Integer[100];
        System.out.println("Danh sách phần tử của mảng: " );
        for (int i = 0; i < 100; i++) {
            arr[i] = rd.nextInt(100);
            System.out.print(arr[i]+ " ");
        }
        return arr;
    }
    public static void triangle(int x,int y, int z){
        try {
            if (x+y>z && x+z>y && x+y>z){
                System.out.println("triangle");
            }
        }catch (IllegalArgumentException e){
            System.out.println("loi "+e.getMessage());
        }
    }
}
