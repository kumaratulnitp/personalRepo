package com.interview;

import java.util.Arrays;

public class WordFound {

    public static void main(String[] args) {

        String[] words = {
                "ason",
                "aball",
                "friends"
        };
        String searchWord = "balloonnns";

        System.out.println(findFirstWord(words, searchWord));
    }

    public static String findFirstWord(String[] words, String searchWord) {

        char[] sortedSearchWord = searchWord.toCharArray();
        Arrays.sort(sortedSearchWord);
        for(String word:words) {
            if (word.length() > searchWord.length()) {
                continue;
            }

            char[] sortedWord = word.toCharArray();
            Arrays.sort(sortedWord);
            int i=0;
            int j=0;

            boolean flag = true;
            while(i < sortedWord.length && j < sortedSearchWord.length) {
                //System.out.print(sortedWord[i] );
                //System.out.print(",");
                //System.out.println(sortedSearchWord[j]);
                if (sortedWord[i] == sortedSearchWord[j]) {
                    i++;
                    j++;
                } else if (sortedWord[i] > sortedSearchWord[j]){
                    j++;
                } else {
                    flag = false;
                    break;
                }
            }

            if (flag == false) {
                continue;
            }
            if (i == sortedWord.length) {
                return word;
            }
        }
        return "";
    }
}
