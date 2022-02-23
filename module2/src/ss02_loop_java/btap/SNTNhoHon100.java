package ss02_loop_java.btap;

import com.sun.xml.internal.ws.policy.EffectiveAlternativeSelector;

import java.util.Scanner;

public class SNTNhoHon100 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("nhap n: ");

        int num=scanner.nextInt();
        if (num<2){
            System.out.println(num+" khong phai SNT");
        }else {
            for (int i=2;i<Math.sqrt(num);i++){
                if (num%i==0){
                    System.out.print(" khong co snt");
                }else {
                    System.out.print(i+" ");
                }
            }

        }
    }

}
