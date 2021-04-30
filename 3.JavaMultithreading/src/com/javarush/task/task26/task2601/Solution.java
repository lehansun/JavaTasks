package com.javarush.task.task26.task2601;

import java.util.Arrays;
import java.util.Comparator;

/* 
Почитать в инете про медиану выборки
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static Integer[] sort(Integer[] array) {
        int median = getMedian(array);
        Arrays.sort(array, new medianComparator(getMedian(array)));//implement logic here
        return array;
    }

    private static Integer getMedian(Integer[] array) {
        Arrays.sort(array);
        Integer index;
        if (array.length % 2 == 0) {
            index = array.length / 2;
            return (array[index] + array[index - 1])/2;
        } else {
            index = array.length / 2;
            return array[index];
        }
    }

    private static class medianComparator implements Comparator<Integer> {
        private Integer median;

        public medianComparator(Integer median) {
            this.median = median;
        }

        @Override
        public int compare(Integer o1, Integer o2) {
            int result = Math.abs(median - o1) - Math.abs(median - o2);
            if (result == 0) {
                return Integer.compare(o1, o2);
            }
            return result;
        }
    }
}
