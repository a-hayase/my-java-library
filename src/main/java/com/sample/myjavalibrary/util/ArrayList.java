package com.sample.myjavalibrary.util;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.List;

public class ArrayList<E> extends AbstractList<E> implements List<E> {
    private Object[] value;
    private int size;

    public ArrayList() {
        value = new Object[10];
    }

    private int capacity() {
        return value.length;
    }

    private int getIndex(Object o, int end) {
        if (o == null) {
            for (int i = 0; i < end; i++) {
                if (value[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < end; i++) {
                if (o.equals(value[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    public boolean add(E e) {
        if (size >= capacity()) {
            // valueの容量を増やしたいが、配列は容量を増やすことができない。
            // そのため、次の手順でvalueの容量を増やす。
            // 1. 新しい配列を作る
            // 2. 新しい配列に、古い配列の内容をコピーする
            // 手順は、どうやらArrays.copyOf(t[] original, int newLength)がやってくれるっぽい
            value = Arrays.copyOf(value, size * 2);
        }
        value[size] = e;
        size++;
        return true;
    }

    public int size() {
        return size;
    }

    public E get(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        return (E) value[index];
    }

    public int indexOf(Object o) {
        return getIndex(o, size());
    }

    public boolean remove(Object o) {
        // 指定された要素がこのリストにあったらその最初のものをリストから削除する
        // その要素がリストにない場合変更はなし
        // 指定された要素がリストに含まれていたらtrueを返す
        int newSize;
        int i = 0;
        if (o == null) {
            for (; i < size(); i++) {
                if (value[i] == null) {
                    newSize = size() - 1;
                    System.arraycopy(value, );
                    return true;
                }
            }
        } else {
            for (; i < size(); i++) {
                if (value[i].equals(o)) {
                    newSize = size() - 1;
                    value = Arrays.copyOf(value, newSize);
                    return true;
                }
            }
        }
        return false;
    }


    public boolean contains(Object o) {
        if (indexOf(o) != -1) {
            return true;
        }
        return false;
    }
}
