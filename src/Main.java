import List.*;
import Map.MyHashMap;
import Map.MyMap;
import Queue.MyQueue;
import Stack.MyStack;

import java.util.HashMap;

public class Main {

    //TODO: Create tests, implement few toStrings
    public static void main(String[] args) {
        testHashMap();
        testArrayList();
        testLinkedList();
        testStack();
        testQueue();
    }

    static void testHashMap() {
        System.out.println("HashMap:");
        MyMap<Integer, String> myHashMap = new MyHashMap<Integer, String>();
        for (int i = 0; i < 2000; i++) {
            myHashMap.put(i, String.valueOf(i));
        }
        for (int i = 1000; i < 1500; i++) {
            myHashMap.remove(i);
        }
        System.out.println(myHashMap);
        System.out.println();
    }

    static void testLinkedList() {
        System.out.println("LinkedList:");
        MyList<Integer> myList = new MyLinkedList<>();
        for (int i = 0; i < 200; i++) {
            myList.add(i);
        }
        for (int i = 10; i < 100; i++) {
            myList.remove(i);
        }
        System.out.println(myList);
        System.out.println();
    }

    static void testArrayList() {
        System.out.println("ArrayList:");
        MyList<Integer> myList = new MyArrayList<>();
        for (int i = 0; i < 200; i++) {
            myList.add(i);
        }
        for (int i = 10; i < 100; i++) {
            myList.remove(i);
        }
        System.out.println(myList);
        System.out.println();
    }

    static void testQueue() {
        System.out.println("Queue:");
        MyQueue<Integer> myQueue = new MyQueue<>();
        for (int i = 0; i < 200; i++) {
            myQueue.add(i);
        }
        for (int i = 0; i < 100; i++) {
            myQueue.poll();
        }
        System.out.println(myQueue);
        System.out.println();
    }

    static void testStack() {
        System.out.println("Stack:");
        MyStack<Integer> myStack = new MyStack<>();
        for (int i = 0; i < 200; i++) {
            myStack.push(i);
        }
        for (int i = 0; i < 100; i++) {
            myStack.pop();
        }
        System.out.println(myStack);
        System.out.println();
    }



}