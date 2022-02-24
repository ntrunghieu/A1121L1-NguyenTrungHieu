package ss03_ArrayAndMethod_java.btap;

import java.util.Scanner;

public class DeleteElement {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int[] arr={10,4,6,7,8,6,0,0,0};
        System.out.println("nhap phan tu can xoa: ");
        int x=scanner.nextInt();
        int index_del=0;
        for (int i=0;i<arr.length;i++){
            if (x==arr[i]){
                index_del=i;
            }
        }
        int j=0;
        int k=1;
        for (int i=index_del;i<arr.length-1;i++){

            arr[index_del+j]=arr[index_del+k];

            j++;
            k++;

        }
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
