package com.interview;

import java.util.*;

public class Waterland {
    /*
    Given matrix of 0, 1 and 0 is land and 1 is water.
    Return true if you can reach from all cell which has land to given position.
    If any cell which is land and not able to reach to target land then it should return false.
     */


    public static void main(String[] args) {
        int[][] grid = {
                {0,0,0,0,0},
                {0,1,1,1,1},
                {0,0,0,0,0},
                {0,1,1,1,1},
                {0,0,0,0,0},
                {0,0,0,0,0},
        };
        System.out.println(isReachable(grid, 0,3));

        int[][] grid1 = {
                {-1,0,0,0,0},
                {0,1,1,1,1},
                {0,0,0,0,0},
                {-1,0,1,1,1},
                {0,0,0,0,0},
                {0,0,0,0,0},
        };
        Data d = maxTreasurePath(grid1, 0,3, 1, 0);
        System.out.println(d.toString());
    }

    static class Data {
        int row;
        int col;
        List<int[]> path;
        int len;
        int p;

        Data(int row, int col, List<int[]> path, int len, int p) {
            this.row = row;
            this.col = col;
            this.path = new ArrayList<>(path);
            this.len = len;
            this.p = p;
        }

        @Override
        public String toString() {
            String pp = "";
            for(int[] dddd: path) {
                pp += dddd[0] + ","+ dddd[1] + ":";
            }
            return "Data{" +
                    "row=" + row +
                    ", col=" + col +
                    ", path=" + pp +
                    ", len=" + len +
                    ", p=" + p +
                    '}';
        }
    }

    public static Data maxTreasurePath(int[][] grid, int row1, int col1, int row2, int col2) {
        Queue<Data> q = new LinkedList<>();
        int min = Integer.MAX_VALUE;
        Data minData = null;

        List<int[]> path = new ArrayList<>();
        path.add(new int[]{row1, col1});
        int p = 0;
        if (grid[row1][col1] == -1) {
            p =1;
        }
        q.offer(new Data(row1, col1, path, 0, p));

        boolean[][] v = new boolean[grid.length][grid[0].length];
        v[row1][col1] = true;
        while(!q.isEmpty()) {
            Data d = q.poll();
            if (d.row == row2 && d.col == col2) {
                if (d.len < min) {
                    minData = d;
                }
                if (minData == null || d.p < minData.p) {
                    minData = d;
                }
            }
            pushToQ(grid, d, q, v, d.row+1, d.col);
            pushToQ(grid, d, q, v, d.row-1, d.col);
            pushToQ(grid, d, q, v, d.row, d.col+1);
            pushToQ(grid, d, q, v, d.row, d.col-1);
        }
        return minData;
    }

    private static void pushToQ(int[][] grid, Data d, Queue<Data> q, boolean[][] visited, int i, int j) {
        if ( i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && visited[i][j] == false && grid[i][j] != 1) {
            d.path.add(new int[]{i, j});
            int p = 0;
            if (grid[i][j] == -1) {
                p = 1;
            }
            q.offer(new Data(i,j, d.path, d.len+1, d.p + p));
            visited[i][j] = true;
        }
    }

    public static boolean isReachable(int[][] grid, int row, int col) {
        for(int i =0; i<grid.length; i++) {
            for(int j=0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    boolean result = dfs(grid, row, col, i, j);
                    if (result == false) {
                        return false;
                    }
                }
            }
        }
        return false;
    }

    public static boolean dfs(int[][] grid,int row,int col,int i,int j){
        Stack<int[]> s = new Stack<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        s.push(new int[]{i, j});
        visited[i][j] = true;
        while(!s.isEmpty()) {
            int[] pos = s.pop();
            i = pos[0];
            j = pos[1];

            if ( row == i && col == j) {
                return true;
            }

            pushToStack(grid, i+1, j, s, visited);
            pushToStack(grid, i-1, j, s, visited);
            pushToStack(grid, i, j+1, s, visited);
            pushToStack(grid, i, j-1, s, visited);
        }
        return false;
    }

    private static void pushToStack(int[][] grid, int i, int j, Stack<int[]> s, boolean[][] visited) {
        if ( i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 0 && visited[i][j] == false) {
            s.push(new int[]{i, j});
            visited[i][j] = true;
        }
    }

    ////////////////////////////////


    public static boolean dfsr(int[][] grid,int row,int col,int i,int j, boolean[][] v){
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length ) {
            return false;
        }
        if (row == i && col == j) {
            return true;
        }
        if ( i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 0 && v[i][j] == false) {
            v[i][j] = true;
            return dfsr(grid, row, col, i+1, j, v) ||
                    dfsr(grid, row, col, i-1, j, v) ||
                    dfsr(grid, row, col, i, j+1, v) ||
                    dfsr(grid, row, col, i, j-1, v);
        }
        return false;
    }

}
