package List;

public class MyArrayList<E> implements MyList<E> {
    private E[] elementsArray;
    private int currentLength;
    private final static int MIN_CAPACITY = 10;

    public MyArrayList() {
        clear();
    }

    public MyArrayList(int size) {
        if (size < 1) {
            clear();
        } else {
            elementsArray = (E[]) new Object[size];
            currentLength = 0;
        }
    }

    public MyArrayList(E[] array) {
        elementsArray = (E[]) new Object[array.length * 3 / 2 + 1];
        for (E element : array) {
            add(element);
        }
    }

    @Override
    public void add(E value) {
        elementsArray[currentLength++] = value;
        grow();
    }

    public void set(int index, E value) {
        if (index < 0 || index > currentLength) {
            throw new IndexOutOfBoundsException(index + " " + size());
        }
        elementsArray[index] = value;
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index > currentLength) {
            throw new IndexOutOfBoundsException(index + " " + size());
        }
        System.arraycopy(elementsArray, index + 1, elementsArray, index, currentLength - index);
        currentLength--;
        shrink();
    }

    @Override
    public void clear() {
        currentLength = 0;
        elementsArray = (E[]) new Object[MIN_CAPACITY];
    }

    @Override
    public int size() {
        return currentLength;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index > currentLength) {
            throw new IndexOutOfBoundsException();
        }
        return elementsArray[index];
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");
        for (int i = 0; i < currentLength; i++) {
            stringBuilder.append(get(i));
            stringBuilder.append(", ");
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public int getCapacity() {
        return elementsArray.length;
    }

    private void grow() {
        if(currentLength == elementsArray.length) {
            E[] newArray = (E[]) new Object[currentLength * 3 / 2 + 1];
            System.arraycopy(elementsArray, 0, newArray, 0, currentLength);
            elementsArray = newArray;
        }
    }

    private void shrink() {
        if (currentLength * 3 / 2 + 1 < (elementsArray.length - 1) * 2 / 3) {
            E[] newArray = (E[]) new Object[(elementsArray.length - 1) * 2 / 3];
            System.arraycopy(elementsArray, 0, newArray, 0, currentLength);
            elementsArray = newArray;
        }
    }
}
