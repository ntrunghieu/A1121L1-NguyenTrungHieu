package ss10_DSA_danhsach.thuchanh;

import javax.xml.soap.Node;
import java.util.Arrays;

public class MyLinkedTest {
    public static void main(String[] args) {
        System.out.println("/=/=/=/= TESTING /=/=/=/=");
        MyLinked<Integer> ml=new MyLinked<>(10);
        ml.addFirst(3);
        ml.addFirst(2);
        ml.addFirst(21);

        ml.addFirst(6);

        ml.addFirst(4);

        ml.add(0,99);
//        ml.add(0,98);
        ml.printList();



    }
}
