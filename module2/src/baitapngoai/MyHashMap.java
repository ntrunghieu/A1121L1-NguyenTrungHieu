package baitapngoai;

import java.util.ArrayList;
import java.util.Objects;

public class MyHashMap {
    private final int SIZE = 1000;
    private ArrayList<Data> myBucket[];

    private  class Data{
        int key;
        int value;
        Data(int key, int value){
            this.key = key;
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Data)) return false;
            Data data = (Data) o;
            return key == data.key;
//                    value == data.value;
        }
    }
    MyHashMap(){
        myBucket = new ArrayList[SIZE];
        for (int i = 0; i < myBucket.length; i++) {
            myBucket[i] = new ArrayList<>();
        }
    }

    private int hashFunction(int key){
        return key % SIZE;
    }

    private int put(int key){
        return 1;
    }

    private void remove(int key, int value){

    }



    private int get(int key){
        return 0;
    }
}
