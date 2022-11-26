package PT;

import java.util.Scanner;

public class amain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        System.out.println("nhap n: ");
//        int n= sc.nextInt();
//        System.out.println("nhap a:");
//        int a= sc.nextInt();
//        System.out.println("nhap b:");
//        int b= sc.nextInt();
//        System.out.println(giaithua(n));
//        System.out.println(fibonacci(n));
//        System.out.println("UCLN cua a va b: "+ UCLN(a,b));
        int[] arr={4,3,1,3,1,3};
        int R=arr.length;
        int L=0;
         quickSort(arr,L,R);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(i + ",");
        }

//        if (ktra(arr,n)){
//            System.out.println("tang");
//        }
//        else {
//            System.out.println("giam");
//        }
//        System.out.println(daoNguoc(n));
//        doiHeNhiPhan(n);
    }
    public static void quickSort(int[] a, int L, int R){
        int i =L, j=R;
        int Pivot = a[(L+R)/2];
        do {
            if (L<=R){
                return;
            }
            else {
                while (a[i] < Pivot){
                    i++;
                }
                while (a[j] > Pivot){
                    j--;
                }
                if (i<j){
                    swap(a[i], a[j]);
                }
                if (i<=j){
                    i++;
                    j--;
                }
            }
        }while (i<=j);
         quickSort(a, L, i);
         quickSort(a, j, R);
    }
    public static void swap(int a, int b){
        int temp=a;
        a = b;
        b = a;
    }
    public static void thapHN(int n, int x, int y, int z){
        if (n==1){

        }
    }
    public static int giaithua(int n){
        if (n<=1){
            return 1;
        }else {
            return n*giaithua(n-1);
        }
    }

//    tinh so fibo thu n
    public static int fibonacci( int n){
        if (n<=2){
            return 1;
        }else {
            return fibonacci(n-2)+fibonacci(n-1);
        }
    }
    public static int UCLN(int a, int b){
        if (a==b){
            return a;
        }else {
            if (a>b){
                return UCLN(a-b, b);
            }else {
                return UCLN(a,b-a);
            }
        }
    }
    public static boolean ktra(int[] arr, int n){
        if (n<=1){
            return true;
        }else {
//
           if (arr[n-1] < arr[n-2]){
               return false;

           }else{
               return ktra(arr, n-1);
           }
        }
    }
    public static int daoNguoc(int n){
        int m=0;
       if (n==0){
           return m;
       }else {
           m = m*10 + n%10;
           daoNguoc(n/10);
       }
return m;
    }
    public static void doiHeNhiPhan(int n ){
        String chuoi ="";
        while (n!=0){
            chuoi+=n%2;
            n=n/2;
        }
        System.out.println(chuoi);
    }
    public static int doiHeThapPhan( int n ){
        int m =0;
        int mu = 1;
        if (n==0){
            return m;
        }else {
            m = m+ n%10 * mu;
            mu*=2;
            doiHeThapPhan(n);
        }
        return m;
    }
    public static void timChuoiLaMa(String[] s){
        int i =s.length;
    }
}
