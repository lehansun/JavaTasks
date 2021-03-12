package com.javarush.task.task33.task3310.strategy;

import java.io.Serializable;
import java.util.Objects;

public class Entry implements Serializable {
    Long key;
    String value;
    Entry next;
    int hash;

    public Entry(int hash, Long key, String value, Entry next) {
        this.key = key;
        this.value = value;
        this.next = next;
        this.hash = hash;
    }

    public Long getKey() {
        return this.key;
    }

    public String getValue() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Entry)) return false;
        Entry entry = (Entry) o;
        return Objects.equals(getKey(), entry.getKey()) && Objects.equals(getValue(), entry.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getKey(), getValue());
    }

    //    public int hashCode(){
//        return super.hashCode();
//    }
//
//    public boolean equals(Object o){
//        if (!o.getClass().equals(this.getClass())) return false;
//        Entry eqs = (Entry) o;
//        return  eqs.key.equals(key) && eqs.value.equals(value);
//    }

    public String toString() {
        return key + "=" + value;
    }
}
