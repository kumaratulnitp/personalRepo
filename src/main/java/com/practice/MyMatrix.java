package com.practice;

public class MyMatrix {

    public static void main(String[] args) {
        MyMatrix m = new MyMatrix();
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
        };
        m.rotate(matrix);
        for(int i=0; i < matrix.length; i++) {
            for(int j=0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void rotate(int[][] matrix) {

        int max = matrix.length - 1;
        for(int row=0; row < (matrix.length ) /2; row++) {
            for(int col=0; col < (matrix.length + 1)/2 ; col++) {

                int temp = matrix[row][col];

                matrix[row][col] = matrix[max-col][row];
                matrix[max-col][row] = matrix[max-row][max-col] ;
                matrix[max-row][max-col] = matrix[col][max-row] ;
                matrix[col][max-row] = temp;
            }
        }
    }
}
