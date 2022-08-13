package com.interview;

import java.util.ArrayList;
import java.util.List;

public class Parenthesis {

    public static void main(String[] args) {
        Parenthesis p = new Parenthesis();
        List<String> res = p.generateParenthesis(2);
        System.out.println(res);

        StringBuilder sb = new StringBuilder("");
        char[] arr = new char[] {'a','t','u','l'};
        String s = String.valueOf(arr);
    }

    public List<String> generateParenthesis(int n) {
        results = new ArrayList<>();
        char[] currentString = new char[n*2];
        backtrackStringBuilder(0, n, n, n, new StringBuilder(""));
        return results;
    }

    List<String> results ;

    private void backtrackStringBuilder(int idx, int n, int close, int open, StringBuilder currentString) {
        if ( idx > n*2 ) {
            return;
        }
        if (close == 0 && open == 0) {
            results.add(currentString.toString());
            return;
        }

        if ( open > 0 ) {
            backtrackStringBuilder(idx+1, n, close, open-1, currentString.append('(')) ;
            currentString.deleteCharAt(currentString.length()-1);
        }
        if (close > 0 && close > open) {
            backtrackStringBuilder(idx+1, n, close-1, open, currentString.append(')'));
            currentString.deleteCharAt(currentString.length()-1);
        }
        return;
    }

    private void backtrack(int idx, int n, int close, int open, char[] currentString) {
        System.out.println(close + "," + open);
        if ( idx > n*2 ) {
            return;
        }
        if (close == 0 && open == 0) {
            results.add(String.valueOf(currentString));
            return;
        }
        if ( open > 0 ) {
            currentString[idx] = '(';
            backtrack(idx+1, n, close, open-1, currentString);
        }
        if (close > 0 && close > open) {
            currentString[idx] = ')';
            backtrack(idx+1, n, close-1, open, currentString);
        }
        return;
    }

}
