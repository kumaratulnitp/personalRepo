package com.i;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    public static void main(String[] args) {
        WordBreak wb = new WordBreak();
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        System.out.println(wb.wordBreak("leetcode", wordDict));
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>();
        for(String word: wordDict)
            dict.add(word);
        boolean f = wb(s, dict, 0);
        return f;
    }

    public boolean wb(String s, Set<String> dict, int idx) {
        if (idx >= s.length()) {
            return true;
        }

        boolean res = false;
        for(int i = idx+1; i <= s.length() ; i++) {
            String cw = s.substring(idx, i);
            if (dict.contains(cw)) {
                res = wb(s, dict, i);
                if (res){
                    return true;
                }
            }

        }
        return res;
    }
}
