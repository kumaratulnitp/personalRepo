package com.interview;

import java.util.Arrays;
import java.util.Stack;

public class DFSPath {

    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'a', 'b', 'c', 'd'},
                {'e', 'f', 'g', 'h'},
                {'f', 'i', 'j', 'k'},
                {'l', 'm', 'n', 'o'}
        };

        String s = "efg";
        char[] ss = s.toCharArray();

        DFSPath dfsPath = new DFSPath();
        dfsPath.doBacktrack(grid, ss);
        System.out.println("==========");
        grid = new char[][]{
                {'a', 'b', 'c', 'd'},
                {'e', 'f', 'k', 'h'},
                {'f', 'i', 'j', 'k'},
                {'g', 'm', 'n', 'o'}
        };
        dfsPath.doBacktrack(grid, ss);
    }

    int[][] path;

    public void printStack(Stack<int[]> s) {
        if (s.isEmpty()) {
            return;
        }
        int[] val = s.pop();
        printStack(s);
        System.out.print("[" + val[0] + ", " + val[1] + "],");
    }

    public int[][] findPath(char[][] grid, char[] s) {
        for(int i=0; i < grid.length; i++) {
            for(int j=0; j < grid[0].length; j++) {
                if (grid[i][j] == s[0]) {
                    Stack<int[]> result = dfs(grid, s, i,j);
                    printStack(result);
                }
            }
        }


        return new int[][]{};
    }

    class Data {
        int i;
        int j;
        int idx;
        Stack<int[]> s;
        public Data(int i, int j, int idx) {
            this.i = i;
            this.j = j;
            this.idx = idx;
            s = new Stack<>();
        }
    }

    public void doBacktrack(char[][] grid, char[] s) {
        for(int i=0; i < grid.length; i++) {
            for(int j=0; j < grid[0].length; j++) {
                if (grid[i][j] == s[0]) {
                    myPath = new int[s.length][2];
                    myPath[0] = new int[]{i, j};
                    boolean flag = backtrack(grid, s, i, j, 0);
                    if (flag) {
                        System.out.println("==============");
                        for(int[] cell:myPath){
                            System.out.println(Arrays.toString(cell));
                        }
                        return;
                    }
                }
            }
        }
    }

    int[][] myPath;
    public boolean backtrack(char[][] grid, char[] s, int row, int col, int idx) {
        if (idx >= s.length) {
            return false;
        }
        if (idx == s.length - 1 ) {
            return true;
        }
        boolean flag = false;
        if (row + 1 < grid.length && grid[row+1][col] == s[idx+1]) {
            myPath[idx+1] = new int[] {row+1, col};
            flag = backtrack(grid, s, row+1, col, idx+1);
        }
        if (flag == false && col + 1 < grid[0].length && grid[row][col+1] == s[idx+1]) {
            myPath[idx+1] = new int[]{row, col+1};
            flag = backtrack(grid, s, row, col+1, idx+1);
        }
        return flag;
    }

    public Stack<int[]> dfs(char[][] grid, char[] s, int i, int j) {
        Stack<int[]> result = new Stack<>();
        Stack<int[]> tracePath = new Stack<>();
        tracePath.push(new int[]{i, j});
        //result.push(new int[]{i,j});

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        visited[i][j] = true;
        int idx = 1;
        while (!tracePath.empty() && idx < s.length) {
            int[] current = tracePath.pop();
            i = current[0];
            j = current[1];

            boolean flag =false;

            if (i + 1 < grid.length && grid[i + 1][j] == s[idx] && visited[i + 1][j] == false) {
                tracePath.push(new int[]{i + 1, j});
                visited[i + 1][j] = true;
                flag = true;
            }
            if (j + 1 < grid[0].length && grid[i][j + 1] == s[idx] && visited[i][j + 1] == false) {
                tracePath.push(new int[]{i, j+1});
                visited[i][j + 1] = true;
                flag = true;
            }

            if (flag) {
                result.push(new int[]{i,j});
            } else {
                result.pop();
            }


            idx++;
        }
        if (idx == s.length) {
            result.push(new int[]{i, j});
            System.out.println("reached end");
        }
        return result;
    }
}
