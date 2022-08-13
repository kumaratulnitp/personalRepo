package com.i;

import java.util.Arrays;

public class MinDist {

    public static void main(String[] args) {
        MinDist md = new MinDist();
        System.out.println(md.minDistance("ros", "h"));
        
        StringBuilder sb = new StringBuilder("a");
        System.out.println(sb.toString().equals(""));


    }

    public int minDistance(String word1, String word2) {
        dp = new int[word1.length()+1][word2.length()+1];
        for(int[] row:dp)
            Arrays.fill(row, -1);

        int r = f1(word1, word2, 0,0);
        return r;
    }

    private int[][] dp;
    public int f1(String w1, String w2, int i1, int i2) {
        if (i1 == w1.length() ) {
            System.out.println(w1.substring(0, i1) + "," + w2.substring(0, i2) + "=" + Math.abs(i1-i2));
            return w2.length()-i2;
        } else if (i2 == w2.length()) {
            return w1.length()-i1;
        }

        if (dp[i1][i2] == -1) {
            if (w1.charAt(i1) == w2.charAt(i2)) {
                dp[i1][i2] = f1(w1, w2, i1+1, i2+1);
            } else {
                int l = f1(w1, w2, i1+1, i2) + 1;
                int r = f1(w1, w2, i1, i2+1) + 1;
                int self = 1 + f1(w1, w2, i1+1, i2+1);
                dp[i1][i2] = Math.min(l, Math.min(r, self));
            }
            System.out.println(w1.substring(0, i1) + "," + w2.substring(0, i2) + "=" + dp[i1][i2]);
        }
        return dp[i1][i2];
    }
}
