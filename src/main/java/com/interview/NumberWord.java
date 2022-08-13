package com.interview;

import java.util.*;

public class NumberWord {

    public static int reachableNodes(int n, int[][] edges, int[] restricted) {
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

            currentNodeEdges = paths.getOrDefault(edges[i][1], new ArrayList<>());
            currentNodeEdges.add(edges[i][0]);
            paths.put(edges[i][1], currentNodeEdges);
        }

        for(Integer i: paths.getOrDefault(0, new ArrayList<>())){
            if (!restrict.contains(i)) {
                q.offer(i);
            }
        }
        Set<Integer> dest = new HashSet<>();
        dest.add(0);
        Set<Integer> vist = new HashSet<>();
        while(!q.isEmpty()) {
            int currentNode = q.poll();
            vist.add(currentNode);
            dest.add(currentNode);
            for(Integer i: paths.getOrDefault(currentNode, new ArrayList<>())){
                if (vist.contains(i)) {
                    continue;
                }
                if (!restrict.contains(i)) {
                    q.offer(i);
                }
            }
        }
        return dest.size();
    }

    public static void main(String[] args) {
        //NumberWord nw = new NumberWord();
        //List<String> res = nw.letterCombinations("23");
        //System.out.println(res);
        int[][] edges = {{0,1},{1,2},{3,1},{4,0},{0,5},{5,6}};
        int[] restricted = {4,5};

        Set<Integer> s = new HashSet<>();
        for(int i:restricted)
            s.add(i);


        int n = 7;
        System.out.println(reachableNodes(n, edges, restricted));

    }

    private static Map<Integer, String> keys ;

    static {
        keys = new HashMap<>();
        keys.put(2, "abc");
        keys.put(3, "def");
        keys.put(4, "ghi");
        keys.put(5, "jkl");
        keys.put(6, "mno");
        keys.put(7, "pqr");
        keys.put(8, "stu");
        keys.put(9, "wxyz");
    }

    private List<String> result;

    public List<String> letterCombinations(String digits) {
        result = new ArrayList<>();
        process(digits, 0, "");
        return result;
    }

    private void process(String digits, int index, String currentWord) {
        if (index == digits.length()) {
            if (!currentWord.equals(""))
                result.add(currentWord);
            return;
        }
        /*
        if (index >= digits.length()) {
            return;
        }

         */
        /*
        if (index == digits.length()-1) {
            String currentDict = keys.getOrDefault(digits.charAt(index), "");
            for(int i=0; i < currentDict.length(); i++ ) {
                String s = currentWord + currentDict.charAt(i);
                result.add(s);
            }
            return;
        }
        */

        String currentDict = keys.getOrDefault(digits.charAt(index), "");
        for(int i=0; i < currentDict.length(); i++) {
            process(digits, index+1, currentWord + currentDict.charAt(i));
        }
        if (currentDict.equals("")) {
            process(digits, index+1, currentWord);
        }
    }
}
