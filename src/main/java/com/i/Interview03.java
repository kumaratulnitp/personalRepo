package com.i;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Interview03 {

    public static void main(String[] args) {
        int[] a = new int[]{3,2,4,5,1,0};
        List<Integer> b = new ArrayList<>();
        b.add(3);
        b.add(2);
        Integer[] c = (Integer[]) b.toArray();
    }
}
