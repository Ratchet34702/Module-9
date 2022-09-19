import List.*;

public class Main {
    public static void main(String[] args) {

        MyList<Integer> myList = new MyLinkedList<>();
        System.out.println(myList);
        for (int i = 0; i < 100; i++)  {
            myList.add(i);
            System.out.println(myList.get(i));
        }
        for (int i = 0; i < 10; i++)  {
            myList.remove(60 - i);
            System.out.println(myList);
        }


    }
}