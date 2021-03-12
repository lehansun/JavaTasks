package com.javarush.task.task33.task3310.strategy;


public class OurHashMapStorageStrategy implements StorageStrategy {
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;
    private Entry[] table = new Entry[DEFAULT_INITIAL_CAPACITY];
    private int size = 0;
    private int threshold = (int) (DEFAULT_INITIAL_CAPACITY * DEFAULT_LOAD_FACTOR);
    private float loadFactor = DEFAULT_LOAD_FACTOR;


    @Override
    public boolean containsKey(Long key) {
        return getEntry(key) != null;
    }

    @Override
    public boolean containsValue(String value) {
        return getKey(value) != null;
    }

    @Override
    public void put(Long key, String value) {
        addEntry(hash(key), key, value, size);
        size++;

        if (size > threshold) {
            resize(size*4/3 + 1);
        }
    }

    @Override
    public Long getKey(String value) {
        for (int i = 0; i < size; i++) {
            if (table[i].getValue().equals(value)) {
                return table[i].getKey();
            }
        }
        return null;
    }

    @Override
    public String getValue(Long key) {
        for (int i = 0; i < size; i++) {
            if (table[i].getKey().equals(key)) {
                return table[i].getValue();
            }
        }
        return null;
    }

    private int hash(Long k){
        int h;
        return (k == null) ? 0 : (h = k.hashCode()) ^ (h >>> 16);
    }

//    Что это???
    private int indexFor(int hash, int length) {
        return 0;
    }

    private Entry getEntry(Long key) {
        for (Entry e : table) {
            if(e.getKey().equals(key)) {
                return e;
            }
        }
        return null;
    }

    private void resize(int newCapacity) {
        Entry[] newTable = new Entry[newCapacity];
        transfer(newTable);
    }

    private void transfer(Entry[] newTable) {
        for (int i = 0; i < size; i++) {
            newTable[i] = table[i];
        }
        table = newTable;
    }

    private void addEntry(int hash, Long key, String value, int bucketIndex) {
        createEntry(hash, key, value, bucketIndex);
//        if (table[bucketIndex] == null) {
//            createEntry(hash, key, value, bucketIndex);
//        } else {
//            createEntry(hash, key, value, bucketIndex+1);
//            size++;
//        }
    }

    private void createEntry(int hash, Long key, String value, int bucketIndex) {
        table[bucketIndex] = new Entry(hash, key, value, table[bucketIndex+1]);
        if (bucketIndex > 0) {
            table[bucketIndex - 1].next = table[bucketIndex];
        }
    }

}
