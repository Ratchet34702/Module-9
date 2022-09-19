package Queue;

public interface MyQueueInterface<E> {
    void add(E value);
    void clear();
    int size();
    E peek();
    E poll();
}
