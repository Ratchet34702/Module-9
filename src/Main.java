import List.*;
import Stack.MyStack;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        MyStack<Integer> myStack = new MyStack<>();
        System.out.println(myStack);
        for (int i = 0; i < 50; i++)  {
            myStack.push(i);
            System.out.println(myStack);
        }
        for (int i = 0; i < 40; i++)  {
            myStack.pop();
            System.out.println(myStack);
        }

        HashMap<Integer, String> hashMap = new HashMap<>();


    }
}