package com.interview;

import java.util.Queue;
import java.util.Stack;

public class Disappear {
    public static void main(String[] args) {
        int[][] grid = {
                {2,2,2,2,2},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1}
        };
        System.out.println(new Disappear().count(grid, 1, 2));
    }

    public int count(int[][] grid, int i, int j) {
        Stack<int[]> s = new Stack<>();
        int area = 0;
        int num = grid[i][j];
        int[][] visited = new int[grid.length][grid[0].length];
        visited[i][j] = 1;
        s.push(new int[]{i,j});
        while(!s.isEmpty()) {
            int[] current = s.pop();
            i = current[0];
            j = current[1];
            area++;

            if (i + 1 < grid.length && visited[i+1][j] != 1 && grid[i+1][j] == num) {
                s.push(new int[]{i+1, j});
                visited[i+1][j] = 1;
            }
            if (j + 1 < grid[0].length && visited[i][j+1] != 1 && grid[i][j+1] == num) {
                s.push(new int[]{i, j+1});
                visited[i][j+1] = 1;
            }
            if (i -1 >= 0 && visited[i-1][j] != 1 && grid[i-1][j] == num) {
                s.push(new int[]{i-1, j});
                visited[i-1][j] = 1;
            }
            if (j - 1 >= 0 && visited[i][j-1] != 1 && grid[i][j-1] == num) {
                s.push(new int[]{i, j-1});
                visited[i][j-1] = 1;
            }
        }
        return area;
    }
}
