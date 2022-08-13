package com.interview;

import java.util.*;
import java.util.function.Consumer;

public class Interview08Aug {

    public static void main(String[] args) {
        int[] a = {1,2};
        Set<Integer> s = new HashSet<>();

        Arrays.stream(a).forEach(i -> s.add(i));

        System.out.println(s);
    }

    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        Set<Integer> restrict = new HashSet<>();
        for(int restrictedNum:restricted) {
            restrict.add(restrictedNum);
        }

        Map<Integer, List<Integer>> paths = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < edges.length; i++) {
            List<Integer> currentNodeEdges = paths.getOrDefault(edges[i][0], new ArrayList<>());
            currentNodeEdges.add(edges[i][1]);
            paths.put(edges[i][0], currentNodeEdges);
        }

        for(Integer i: paths.getOrDefault(0, new ArrayList<>())){
            if (!restrict.contains(i)) {
                q.offer(i);
            }
        }
        Set<Integer> dest = new HashSet<>();

        while(!q.isEmpty()) {
            int currentNode = q.poll();
            dest.add(currentNode);
            for(Integer i: paths.getOrDefault(currentNode, new ArrayList<>())){
                if (!restrict.contains(i)) {
                    q.offer(i);
                }
            }
        }
        return dest.size();
    }

    public static void main22(String[] args) {
        char[][] grid1 = {
                {'c', 'c', 't', 'n', 'a', 'x'},
                {'c', 'c', 'a', 't', 'n', 't'},
                {'a', 'c', 'n', 'n', 't', 't'},
                {'t', 'n', 'i', 'i', 'p', 'p'},
                {'a', 'o', 'o', 'o', 'a', 'a'},
                {'s', 'a', 'a', 'a', 'o', 'o'},
                {'k', 'a', 'i', 'o', 'k', 'i'}
        };
        String word1 = "catnip";
        String word2 = "cccc";
        String word3 = "s";
        String word4 = "ant";
        String word5 = "aoi";
        String word6 = "ki";
        String word7 = "aaoo";
        String word8 = "ooo";

        char[][] grid2 = {{'a'}};
        String word9 = "a";

        // System.out.println(findWord(words, string1));
        // System.out.println(findWord(words, string2));
        // System.out.println(findWord(words, string3));
        // System.out.println(findWord(words, string4));
        // System.out.println(findWord(words, string5));
        // System.out.println(findWord(words, string6));


        int[][] path = find(grid1, word1);
        for(int[] currentPath: path) {
            System.out.println(Arrays.toString(currentPath));
        }
    }

    public static void main2(String[] argv) {
        char[][] grid1 = {
                {'c', 'c', 't', 'n', 'a', 'x'},
                {'c', 'c', 'a', 't', 'n', 't'},
                {'a', 'c', 'n', 'n', 't', 't'},
                {'t', 'n', 'i', 'i', 'p', 'p'},
                {'a', 'o', 'o', 'o', 'a', 'a'},
                {'s', 'a', 'a', 'a', 'o', 'o'},
                {'k', 'a', 'i', 'o', 'k', 'i'}
        };
        String word1 = "catnip";
        String word2 = "cccc";
        String word3 = "s";
        String word4 = "ant";
        String word5 = "aoi";
        String word6 = "ki";
        String word7 = "aaoo";
        String word8 = "ooo";

        char[][] grid2 = {{'a'}};
        String word9 = "a";

        // System.out.println(findWord(words, string1));
        // System.out.println(findWord(words, string2));
        // System.out.println(findWord(words, string3));
        // System.out.println(findWord(words, string4));
        // System.out.println(findWord(words, string5));
        // System.out.println(findWord(words, string6));


        int[][] path = find(grid1, word1);
        for(int[] currentPath: path) {
            System.out.println(Arrays.toString(currentPath));
        }
    }

    public static int[][] findUtil(char[][] grid, String searchWord) {
        int[][] path = new int[searchWord.length()][];
        for(int i=0; i < grid.length; i++) {
            for(int j=0; j < grid[0].length; j++) {
                path = new int[searchWord.length()][];
                if (searchWord.charAt(0) == grid[i][j]) {
                    boolean flag = helper(grid, searchWord, i, j, 0, path);
                    if (flag) {
                        return path;
                    }
                }
            }
        }
        return path;
    }

    public static boolean helper(char[][] grid, String searchWord, int gridI, int gridJ, int idx, int[][] path) {
        if (idx == searchWord.length()) {
            return true;
        }
        path[idx] = new int[]{gridI, gridJ};
        if (idx < searchWord.length() && gridI + 1< grid.length ) {
            helper(grid, searchWord,gridI+1, gridJ, idx+1, path) ;
        }
        if (idx < searchWord.length() && gridJ + 1 < grid[0].length ) {
            helper(grid, searchWord, gridI, gridJ+1, idx+1, path);
        }
        return false;
    }

    public static int[][] find(char[][] grid, String searchWord) {
        int[][] path = new int[searchWord.length()][];

        int idx = 0;
        for(int i=0; i < grid.length; i++) {
            for(int j=0; j < grid[0].length; j++) {
                idx = 0;
                path = new int[searchWord.length()][];
                if( grid[i][j] == searchWord.charAt(idx)) {
                    //start search here
                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[]{i,j});
                    while (!q.isEmpty() && idx < searchWord.length() ) {
                        int[] cell = q.poll();
                        path[idx] = new int[]{cell[0], cell[1]};

                        if (idx == searchWord.length()-1) {
                            return path;
                        }

                        if (cell[0] + 1 < grid.length && idx+1 < searchWord.length() &&
                                grid[cell[0] + 1][cell[1]] == searchWord.charAt(idx+1)) {
                            idx++;
                            q.offer(new int[]{cell[0]+1, cell[1]});

                        }
                        else if (cell[1] + 1 < grid[0].length && idx+1 < searchWord.length() &&
                                grid[cell[0]][cell[1]+1] == searchWord.charAt(idx+1)) {

                            idx++;
                            q.offer(new int[]{cell[0], cell[1]+1});
                        }

                    }

                }
            }
        }

        return path;
    }


    public static String findWord(String[] words, String searchWord) {
        Map<String, String> wordMap = new HashMap<>();
        for(String word: words) {
            char[] charWord = word.toCharArray();
            Arrays.sort(charWord);
            String newWord = new String(charWord);
            wordMap.put(word, newWord);
            //cat -> act
            //dada -> aadd
        }
        char[] charSearchWord = searchWord.toCharArray();
        Arrays.sort(charSearchWord);
        String sortedSearchWord = new String(charSearchWord);

        //cat (act), ctay(abcty)
        for(String key:wordMap.keySet()) {
            int i=0;
            int j=0;
            String mapWord = wordMap.get(key);
            //System.out.println(mapWord + "," + sortedSearchWord);
            while (i < mapWord.length() && j < sortedSearchWord.length() ) {
                //System.out.println(i + "," + j + mapWord.charAt(i) + "," + sortedSearchWord.charAt(j));
                if (mapWord.charAt(i) == sortedSearchWord.charAt(j)) {
                    i++;
                    j++;
                } else if (mapWord.charAt(i) > sortedSearchWord.charAt(j)) {
                    j++;
                } else {
                    //System.out.println();
                    break;
                }

            }
            //System.out.println(j);
            if (i == mapWord.length() ) {
                //System.out.println(mapWord);
                return key;
            }
        }

        return "-";
    }
}


/*
After catching your classroom students cheating before, you realize your students are getting craftier and hiding words in 2D grids of letters. The word may start anywhere in the grid, and consecutive letters can be either immediately below or immediately to the right of the previous letter.

Given a grid and a word, write a function that returns the location of the word in the grid as a list of coordinates. If there are multiple matches, return any one.

grid1 = [
    ['c', 'c', 't', 'n', 'a', 'x'],
    ['c', 'c', 'a', 't', 'n', 't'],
    ['a', 'c', 'n', 'n', 't', 't'],
    ['t', 'n', 'i', 'i', 'p', 'p'],
    ['a', 'o', 'o', 'o', 'a', 'a'],
    ['s', 'a', 'a', 'a', 'o', 'o'],
    ['k', 'a', 'i', 'o', 'k', 'i'],
]
word1 = "catnip"
word2 = "cccc"
word3 = "s"
word4 = "ant"
word5 = "aoi"
word6 = "ki"
word7 = "aaoo"
word8 = "ooo"

grid2 = [['a']]
word9 = "a"

find_word_location(grid1, word1) => [ (1, 1), (1, 2), (1, 3), (2, 3), (3, 3), (3, 4) ]
find_word_location(grid1, word2) =>
       [(0, 0), (1, 0), (1, 1), (2, 1)]
    OR [(0, 0), (0, 1), (1, 1), (2, 1)]
find_word_location(grid1, word3) => [(5, 0)]
find_word_location(grid1, word4) => [(0, 4), (1, 4), (2, 4)] OR [(0, 4), (1, 4), (1, 5)]
find_word_location(grid1, word5) => [(4, 5), (5, 5), (6, 5)]
find_word_location(grid1, word6) => [(6, 4), (6, 5)]
find_word_location(grid1, word7) => [(5, 2), (5, 3), (5, 4), (5, 5)]
find_word_location(grid1, word8) => [(4, 1), (4, 2), (4, 3)]
find_word_location(grid2, word9) => [(0, 0)]

Complexity analysis variables:

r = number of rows
c = number of columns
w = length of the word
*/

