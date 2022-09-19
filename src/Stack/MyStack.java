package Stack;

import List.MyLinkedList;

public class MyStack<E> implements MyStackInterface<E> {

    private final MyLinkedList<E> elementsList;

    public MyStack() {
        elementsList = new MyLinkedList<>();
    }

    @Override
    public void push(E value) {
        elementsList.add(value);
    }

    @Override
    public void clear() {
        elementsList.clear();
    }

    @Override
    public int size() {
        return elementsList.size();
    }

    @Override
    public E peek() {
        return elementsList.get(size() - 1);
    }

    @Override
    public E pop() {
        E temp = elementsList.get(size() - 1);
        elementsList.remove(size() - 1);
        return temp;
    }

    @Override
    public String toString() {
        return elementsList.toString();
    }
}
