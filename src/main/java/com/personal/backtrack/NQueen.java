package com.personal.backtrack;

public class NQueen {

    public static void main(String[] args) {
        int n = 3;
        int[][] result = new int[n][n];
        boolean flag = queens(n, 0, result);
        System.out.println(flag);
        if (flag) {
            for(int i=0; i<n; i++) {
                for(int j=0; j < n; j++) {
                    System.out.print(result[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

    public static boolean queens(int n, int idx, int[][] result) {
        if (idx == n) {
            return true;
        }

        for(int i=0; i < n; i++) {
            if (result[idx][i] == 0 ) {
                color(n, idx, i, result, 1);
                result[idx][i] = 2;
                //color all of its path

                boolean flag = queens(n, idx + 1, result);
                if (flag) {
                    return true;
                }

                color(n, idx, i, result, 0);
                //result[idx][i] = 0;
                //uncolor all of its path
            }
        }

        return false;
    }

    /*
    This color function has a great problem, while uncolor (colorType = 0), it uncolors over previous color's path also. Rectify it.
     */
    public static void color(int n, int row, int col, int[][] grid, int colorType) {
        //horizontal
        for(int i=0; i<n; i++) {
            grid[row][i] = colorType;
        }
        //vertical
        for(int i=0; i<n; i++ ){
            grid[i][col] = colorType;
        }
        //forward diagonal
        for(int i=0; i < n; i++) {
            if (row +i < n &&  col + i < n ) grid[row+i][col+i] = colorType;
        }
        for(int i=0; i < n; i++) {
            if (row-i >= 0 && col-i >= 0) grid[row-i][col-i] = colorType;
        }
        //backward diagonal
        for(int i=0; i < n; i++) {
            if (row-i >= 0 && col+i < n ) grid[row-i][col+i] = colorType;
        }
        for(int i=0; i < n; i++) {
            if (row+i < n && col-i >= 0) grid[row+i][col-i] = colorType;
        }
    }

    public static void color2(int n, int row, int col, int[][] grid, int colorType) {
        //horizontal
        for(int i=0; i<n; i++) {
            grid[row][i] = colorType;
        }
        //vertical
        for(int i=0; i<n; i++ ){
            grid[i][col] = colorType;
        }
        //forward diagonal
        for(int i=row+1; i < n; i++) {
            if (row+i < n && col+i < n ) grid[row+i][col+i] = colorType;
        }
        for(int i=row-1; i>=0; i--) {
            if (row-i >= 0 && col-i >= 0 && grid[row-i][col-i] != 2) grid[row-i][col-i] = colorType;
        }
        //backward diagonal
        for(int i=col+1; i < n; i++) {
            if (row-i >= 0 && col+i < n && grid[row-i][col+i] != 2) grid[row-i][col+i] = colorType;
        }
        for(int i=col; i >= 0; i--) {
            if (row+i < n && col-i >= 0 && grid[row+i][col-i] != 2) grid[row+i][col-i] = colorType;
        }
    }
}
