package Queue;

import List.MyLinkedList;

public class MyQueue<E> implements MyQueueInterface<E> {

    private MyLinkedList<E> myLinkedList;

    @Override
    public void add(E value) {
        myLinkedList.add(value);
    }


    @Override
    public void clear() {
        myLinkedList.clear();
    }

    @Override
    public int size() {
        return myLinkedList.size();
    }

    @Override
    public E peek() {
        return myLinkedList.get(0);
    }

    @Override
    public E poll() {
        E temp = peek();
        myLinkedList.remove(0);
        return temp;
    }
}
