package com.interview;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class LongestPalindrome {

    public static void main(String[] args) {
        String s = "abccccdd";
        lp(s, 0, s.length()-1, "", "");
        System.out.println(maxString);
        System.out.println(Objects.hash(1,2));
        System.out.println(Objects.hash(2,1));

        maxString = "";
        dp = new HashSet<>();
        lp(s, 0, s.length()-1, "", "");
        System.out.println(maxString);
    }

    static String maxString = "";
    static Set<Integer> dp= new HashSet<>();
    //sdfatta
    public static void lp(String s, int l, int r, String leftWord, String rightWord) {
        if (l > r) {
            return;
        }
        int key = Objects.hash(l, r);
        if (!dp.contains(key)) {
            if (l == r) {
                String result = leftWord + s.charAt(l) + rightWord;
                if (result.length() > maxString.length()) {
                    maxString = result;
                }
                System.out.println("odd " + result);
            }
            if (l + 1 == r) {
                if (s.charAt(l) == s.charAt(r)) {
                    String result = leftWord + s.charAt(l) + s.charAt(r) + rightWord;
                    if (result.length() > maxString.length()) {
                        maxString = result;
                    }
                    System.out.println("even " + result);
                }
                return;
            }
            if (s.charAt(l) == s.charAt(r)) {
                lp(s, l + 1, r - 1, leftWord + s.charAt(l), rightWord + s.charAt(r));
            } else {
                lp(s, l + 1, r, "", "");
                lp(s, l, r - 1, "", "");
            }
            dp.add(key);
        }
    }
}
