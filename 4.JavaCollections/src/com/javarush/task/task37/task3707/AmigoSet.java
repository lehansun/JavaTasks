package com.javarush.task.task37.task3707;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

public class AmigoSet<E> extends AbstractSet<E> implements Serializable, Cloneable, Set<E> {
    private static final Object PRESENT = new Object();
    private transient HashMap<E,Object> map;

    public AmigoSet() {
        map = new HashMap<>();
    }

    public AmigoSet(Collection<? extends E> collection) {
        double capacity = Math.max(16, Math.ceil(collection.size()/.75f));
        this.map = new HashMap<>((int)capacity);
        for (E e : collection) {
            this.map.put(e, PRESENT);
        }

    }

    private void writeObject(ObjectOutputStream ous) throws IOException {
        ous.defaultWriteObject();
        ous.writeObject(HashMapReflectionHelper.callHiddenMethod(map, "capacity"));
        ous.writeObject(HashMapReflectionHelper.callHiddenMethod(map, "loadFactor"));
        ous.writeObject(map.size());
        for (E e : map.keySet()) {
            ous.writeObject(e);
        }
    }

    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject();
        int capacity = (int) ois.readObject();
        float loadFactor = (float) ois.readObject();
        int size = (int) ois.readObject();
        this.map = new HashMap<>(capacity, loadFactor);
        for (int i = 0; i < size; i++) {
            this.map.put((E) ois.readObject(), PRESENT);
        }
    }

    @Override
    public Iterator<E> iterator() {
        return map.keySet().iterator();
    }

    @Override
    public boolean add(E e) {
        return map.put(e, PRESENT) == null;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public boolean remove(Object o) {
        return  map.remove(o)==null;
    }

    @Override
    public Object  clone() throws InternalError {
        AmigoSet set;
        try {
            set = (AmigoSet) super.clone();
            set.map = (HashMap) map.clone();
        } catch (Exception e) {
            throw new InternalError();
        }
        return set;
    }
}
