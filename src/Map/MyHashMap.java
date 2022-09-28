package Map;

import java.util.*;

public class MyHashMap<K, V> implements MyMap<K, V> {

    private static final int INITIAL_CAPACITY = 16;
    private Entry<K, V>[] entryArray;
    private int size;
    public MyHashMap() {
        clear();
    }

    @Override
    public void put(K key, V value) {
        int hash = getHash(key);
        Entry<K, V> entry = entryArray[hash];
        if (Objects.isNull(entry)) {
            entryArray[hash] = new Entry<>(key, value);
        } else {
            putInEntry(entry, key, value);
        }
        size++;
    }

    private void putInEntry(Entry<K, V> entry, K key, V value) {
        while (Objects.nonNull(entry.getNext())) {
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                return;
            }
            entry = entry.getNext();
        }
        if (entry.getKey().equals(key)) {
            entry.setValue(value);
            return;
        }
        entry.setNext(new Entry<>(key, value));
    }

    @Override
    public void remove(K key) {
        int hash = getHash(key);
        Entry<K, V> entry = entryArray[hash];
        if (Objects.isNull(entry)) {
            return;
        }
        if (entry.getKey().equals(key)) {
            entryArray[hash] = entry.getNext();
            entry.setNext(null);
            size--;
            return;
        }
        Entry<K, V> prevEntry = entry;
        entry = entry.getNext();
        while (Objects.nonNull(entry)) {
            if (entry.getKey() == key) {
                prevEntry.setNext(entry.getNext());
                entry.setNext(null);
                --size;
                return;
            }
            prevEntry = entry;
            entry = entry.getNext();
        }


    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");
        for(Entry<K, V> entry: entryArray) {
            stringBuilder.append(entry);
        }
        return stringBuilder.append("]").toString();
    }

    @Override
    public void clear() {
        entryArray = new Entry[INITIAL_CAPACITY];
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public V get(K key) {
        int hash = getHash(key);
        Entry<K, V> entry = entryArray[hash];
        while (Objects.nonNull(entry)) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
            entry = entry.getNext();
        }
        return null;
    }

    private int getHash(K key) {
        return key.hashCode() % entryArray.length;
    }

    private static class Entry<K, V> {
        private final K key;
        private V value;
        private Entry<K, V> next;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public Entry<K, V> getNext() {
            if (next == null) return null;
            return next;
        }

        public void setNext(Entry<K, V> next) {
            this.next = next;
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            Entry<K, V> temp = this;
            while (Objects.nonNull(temp)) {
                stringBuilder.append(temp.key).append("=").append(temp.value).append(", ");
                temp = temp.next;
            }
            return stringBuilder.toString();
        }
    }
}