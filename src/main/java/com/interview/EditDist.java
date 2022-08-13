package com.interview;

import java.util.Arrays;

public class EditDist {
    public static void main(String[] args) {

        int[][] mm = new int[23][21];
        for(int[] row:mm) {
            Arrays.fill(row, -1);
        }
        //Arrays.fill(mm, -1);
        for(int[] row:mm) {
            for(int i:row) {
                System.out.print(i + ",");
            }
            System.out.println();
        }

        EditDist e = new EditDist();
        System.out.println(e.isOneEditDistance("ab", "acb"));
    }

    public boolean isOneEditDistance(String s, String t) {
        int i = dist(s,t,0,0);
        return i == 1 ? true : false;

    }

    public int dist(String s, String t, int sIdx, int tIdx) {

        if (sIdx >= s.length() || tIdx >= t.length()){
            return Math.abs(s.length() - sIdx - t.length() + tIdx);
        }

        if (s.charAt(sIdx) == t.charAt(tIdx)) {
            return dist(s, t, sIdx+1, tIdx+1);
        } else {
            int l = dist(s, t, sIdx, tIdx+1) + 1;
            int r = dist(s, t, sIdx+1, tIdx) + 1;
            int k = dist(s, t, sIdx+1, tIdx+1) + 1;
            return Math.min(Math.min(l,r), k);
        }
    }
}
