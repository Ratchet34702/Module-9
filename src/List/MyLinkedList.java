package List;

public class MyLinkedList<E> implements MyList<E> {

    private static class MyListNode<E> {
        E element;
        MyListNode<E> previousNode;
        MyListNode<E> nextNode;

        MyListNode(E element, MyListNode<E> previousNode, MyListNode<E> nextNode) {
            this.element = element;
            this.previousNode = previousNode;
            this.nextNode = nextNode;
        }

    }

    private final MyListNode<E> header;

    {
        header = new MyListNode<>(null, null, null);
    }

    private int size;

    public MyLinkedList() {
        clear();
    }

    @Override
    public void add(E value) {
        MyListNode<E> newListNode = new MyListNode<>(value, header.previousNode, header);
        newListNode.previousNode.nextNode = newListNode;
        newListNode.nextNode.previousNode = newListNode;
        size++;
    }

    @Override
    public void remove(int index) {
        MyListNode<E> deletionNode = manageTraversal(index);
        deletionNode.previousNode.nextNode = deletionNode.nextNode;
        deletionNode.nextNode.previousNode = deletionNode.previousNode;
        size--;
    }

    @Override
    public void clear() {
        header.nextNode = header;
        header.previousNode = header;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E get(int index) {
        return manageTraversal(index).element;
    }

    private MyListNode<E> forwardTraversal(int index) {
        MyListNode<E> currentNode = header.nextNode;
        while (index-- > 0) {
            currentNode = currentNode.nextNode;
        }
        return currentNode;
    }

    private MyListNode<E> backwardTraversal(int index) {
        MyListNode<E> currentNode = header.previousNode;
        while (index++ < size - 1) {
            currentNode = currentNode.previousNode;
        }
        return currentNode;
    }

    private MyListNode<E> manageTraversal(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (index <= size / 2) {
            return forwardTraversal(index);
        }
        return backwardTraversal(index);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");
        MyListNode<E> currentNode = header.nextNode;
        int iterator = size;
        while (iterator-- > 0) {
            stringBuilder.append(currentNode.element);
            stringBuilder.append(", ");
            currentNode = currentNode.nextNode;
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
