package org.main;

import java.util.Arrays;
import java.util.function.Function;

public class HashMap <T> {
    public final int size;
    public int count;
    public final Object[] map;
    public final Function<Integer, Integer> hashFunc1;
    public final Function<Integer, Integer> hashFunc2;

    HashMap(int size, Function<Integer, Integer> hashFunc1, Function<Integer, Integer> hashFunc2) {
        this.size = size;
        this.map = (T[]) new Object[size];
        this.hashFunc1 = hashFunc1.compose((k) -> k % size);
        this.hashFunc2 = hashFunc2;
    }

    HashMap(int size, Function<Integer, Integer> hashFunc1) {
        this(size, hashFunc1, (k) -> 1);
    }

    /**
     * Add an item to the hashmap.
     *
     * @param item The item to add to the hashmap.
     * @return int The index at which the item was added.
     */
    public int add(int key, T item) {
        if (count == size)
            throw new IndexOutOfBoundsException("No more empty space in hashmap");

        int hash1 = this.hashFunc1.apply(key);
        int hash2 = this.hashFunc2.apply(key);
        int index = hash1;
        assert index <= size;

        while (map[index] != null)
            index = (index + hash2) % size;

        map[index] = new Entry(key, item);
        count++;
        return index;
    }

    @Override
    public String toString() {
        return Arrays.toString(map);
    }

    public class Entry {
        protected final Integer key;
        protected T data;

        Entry(int key, T data) {
            this.key = key;
            this.data = data;
        }

        Entry(int key) {
            this.key = key;
        }

        public void setData(T data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }
}
