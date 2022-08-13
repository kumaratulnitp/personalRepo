package com.personal.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class IslandArea {
    public static void main(String[] args) {
        int[][] grid = {
                {1, 0, 0, 1, 0, 0},
                {0, 0, 0, 1, 0, 0},
                {0, 0, 0, 1, 0, 0},
                {0, 0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
        };

        int[][] grid2 = {
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 1, 1},
                {0, 0, 0, 1, 1},
        };
        int area = area(grid2);
        System.out.println(area);
    }

    public static int area(int[][] grid) {
        int area = 0;
        for(int i=0; i < grid.length; i++) {
            for (int j=0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 ) {
                    area = Math.max(area, calculateLand(grid, i, j));
                    System.out.println("Current island area is " + area);
                }
            }
        }
        return area;
    }

    public static int calculateLand(int[][] grid, int row, int col) {
        int area = 0;
        Stack<int[]> s = new Stack<>();
        s.push(new int[]{row,col});
        grid[row][col] = 0;
        int[] x = {0,  0,  1, -1};
        int[] y = {1, -1,  0,  0};
        while (!s.isEmpty()) {
            int[] cell = s.pop();
            //if (grid[cell[0]][cell[1]] == 1) {
                area++;
            //    grid[cell[0]][cell[1]] = 0;
            //} else {
            //    continue;
            //}

            for (int i=0; i < x.length; i++) {
                if (cell[0]+y[i] >=0 && cell[0]+y[i] < grid.length &&
                        cell[1]+x[i] >=0 && cell[1]+x[i] < grid[0].length && grid[cell[0]+y[i]][cell[1]+x[i]] == 1) {

                    s.push(new int[] {cell[0]+y[i], cell[1]+x[i]});
                    grid[cell[0]+y[i]][cell[1]+x[i]] = 0;
                }
            }

            //area++;
        }
        return area;
    }
}
