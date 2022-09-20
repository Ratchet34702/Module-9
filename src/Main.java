import List.*;
import Map.MyHashMap;
import Map.MyMap;

public class Main {

    //TODO: Create tests, implement few toStrings
    public static void main(String[] args) {

        MyMap<Integer, String> myHashMap = new MyHashMap<Integer, String>();
        for (int i = 0; i < 2000; i++) {
            myHashMap.put(i, String.valueOf(i));
        }
        long time = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            System.out.println(myHashMap.get(i) + ' ');
        }
    }
}