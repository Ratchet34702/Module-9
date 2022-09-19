package Stack;

public interface MyStackInterface<E> {
    void push(E value);
    void clear();
    int size();
    E peek();
    E pop();
}
