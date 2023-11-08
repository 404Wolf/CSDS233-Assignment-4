import java.nio.BufferOverflowException;
import java.util.Arrays;
import java.util.function.Function;

public class Submission {
    public static final int[] testArray1 = new int[]{14, 17, 18, 3, 8, 1, 18, 11, 13, 20};
    public static final int[] testArray2 = new int[]{2, 12, 22, 32, 42, 52, 62, 72, 82, 92};

    public static void main(String[] args) {
        int index;

        try {
            System.out.println("Inserting elements of ");
            System.out.println(Arrays.toString(testArray1) + " into new hashmap...");
            HashMap<Integer> onlyArray1 = new HashMap<>(10, (k) -> k);
            for (int item : testArray2) {
                index = onlyArray1.add(item, item);
                System.out.println(onlyArray1);
                System.out.println("Inserted at index " + index);
            }

            System.out.println("Inserting elements of ");
            System.out.println(Arrays.toString(testArray2) + " into new hashmap with a fancy hash function...");
            HashMap<Integer> onlyArray2 = new HashMap<>(10, (k) -> (int) Math.cosh((double) (k + 2) / 5));
            for (int item : testArray2) {
                index = onlyArray2.add(item, item);
                System.out.println(onlyArray2);
                System.out.println("Inserted at index " + index);
            }

            System.out.println("Combining the array");
            System.out.println(Arrays.toString(testArray1));
            System.out.println("With");
            System.out.println(Arrays.toString(testArray2) + "in a new hashmap...");

            HashMap<Integer> combiningBothExample = new HashMap<>(20, (k) -> k, (k) -> (7 - (k % 7)));
            for (int item : testArray2) {
                index = combiningBothExample.add(item, item);
                System.out.println(combiningBothExample);
                System.out.println("Inserted at index " + index);
            }
            for (int item : testArray1) {
                index = combiningBothExample.add(item, item);
                System.out.println(combiningBothExample);
                System.out.println("Inserted at index " + index);
            }
        }
        catch (HashMap.EndlessDoubleHashException e) {
            System.out.println("Double hashing failed, an infinite loop has been avoided. Exiting...");
        }
    }

    public static class HashMap <T> {
        public final int size;
        public int count;
        public final Object[] map;
        public final Function<Integer, Integer> hashFunc1;
        public final Function<Integer, Integer> hashFunc2;

        HashMap(int size, Function<Integer, Integer> hashFunc1, Function<Integer, Integer> hashFunc2) {
            this.size = size;
            this.map = new Object[size];
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
        public int add(int key, T item) throws EndlessDoubleHashException {
            if (count == size)
                throw new IndexOutOfBoundsException("No more empty space in hashmap");

            int hash1 = this.hashFunc1.apply(key);
            int hash2 = this.hashFunc2.apply(key);
            int index = hash1;
            assert index <= size;

            int overflowCount = 0;
            while (map[index] != null) {
                if (overflowCount > size * 50)
                    throw new EndlessDoubleHashException();
                index = (index + hash2) % size;
                overflowCount++;
            }

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

        public static class EndlessDoubleHashException extends Exception {}
    }
}

