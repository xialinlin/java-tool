package org.osgl.util.algo;

import org.osgl.$;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Array insertion sort algorithm. 
 *
 * Use {@link java.util.Arrays#binarySearch(Object[], int, int, Object, java.util.Comparator)}
 * to locate the index to be inserted, and use
 */
public class ArraySimpleInsertionSort<T> extends ArraySortBase<T> implements ArraySort<T> {

    protected T[] sort0(T[] ts, int from, int to, Comparator<T> comp, T[] newTs) {
        newTs[0] = ts[from];
        for (int i = from + 1; i < to; ++i) {
            T t = ts[i];
            newTs[i - from] = t;
            int j = i - from - 1;
            while (j >= 0) {
                if (comp.compare(t, newTs[j]) < 0) {
                    j--;
                    continue;
                }
                break;
            }
            j++;
            System.arraycopy(newTs, j, newTs, j + 1, i - from - j);
            newTs[j] = t;
        }
        return newTs;
    }

    public static void main(String[] args) {
        Integer[] ia = {5, 4, 3, 2, 1};
        ArraySimpleInsertionSort<Integer> s = new ArraySimpleInsertionSort<Integer>();
        Integer[] a = s.apply(ia, 0, 4, $.F.NATURAL_ORDER);
        System.out.println(Arrays.toString(a));
    }

}
