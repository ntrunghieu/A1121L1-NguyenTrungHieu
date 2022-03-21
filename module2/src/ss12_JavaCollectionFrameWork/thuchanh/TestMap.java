package ss12_JavaCollectionFrameWork.thuchanh;

import java.util.*;

public class TestMap {
    public static void main(String[] args) {
        //hashMap
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Smith", 30);
        hashMap.put("Anderson", 31);
        hashMap.put("Lewis", 29);
        hashMap.put("Cook", 29);
        System.out.println("Display entries in es");
        System.out.println(hashMap+ "\n");
        //treeMap
        Map<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("Smith", 30);
        treeMap.put("Anderson", 31);
        treeMap.put("Lewis", 29);
        treeMap.put("Cook", 29);
        System.out.println("Display entries in ascending order of key");
        System.out.println(treeMap+ "\n");
        Map<String, Integer> treeMapReverse = new TreeMap<>(Collections.reverseOrder());
        System.out.println("Display entries in decrease order of key");
        treeMap.putAll(hashMap);
        System.out.println(treeMap);
        //
        TreeMap<String, Integer> sorted = new TreeMap<String, Integer>(treeMap);
        Set<Map.Entry<String,Integer>> setValue=sorted.entrySet();
        for (Map.Entry<String,Integer> maps:setValue) {
            System.out.println(maps.getKey()+" ==> "+ maps.getValue());
        }

        //linkedHashMap
        Map<String, Integer> linkedHashMap = new LinkedHashMap<>(16, 0.75f, true);
        linkedHashMap.put("Smith", 30);
        linkedHashMap.put("Anderson", 31);
        linkedHashMap.put("Lewis", 29);
        linkedHashMap.put("Cook", 29);
        System.out.println("\nThe age for " + "Lewis is " + linkedHashMap.get("Lewis"));
    }

}
