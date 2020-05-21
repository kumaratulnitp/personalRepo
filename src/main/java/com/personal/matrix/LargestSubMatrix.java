package com.personal.matrix;

import java.util.concurrent.atomic.AtomicInteger;

public class LargestSubMatrix {

	public static void main(String[] args) {
		AtomicInteger i = new AtomicInteger(10);
		System.out.println(i.get());
		LargestSubMatrix lsm = new LargestSubMatrix();
		lsm.xx(i);
		System.out.println(i.get());
	}
	
	public void xx(AtomicInteger i) {
		System.out.println(i.get());
		i.set(11);
	}
	
	public int largestSubMatrix(int[][] matrix, int row, int column, AtomicInteger maxSize) {
		if (row == 0 || column == 0 ) {
			maxSize.set(Math.max(maxSize.get(), matrix[row][column]));
			return matrix[row][column];
		}
		
		int topRight = largestSubMatrix(matrix, row, column-1, maxSize);
		int bottom = largestSubMatrix(matrix, row-1, column, maxSize);
		int diagonal = largestSubMatrix(matrix, row-1, column-1, maxSize);
		
		int currentMaxSize = 0 ;
		if (matrix[row][column] != 0 ) {
			currentMaxSize = 1 + Math.min(Math.min(topRight, bottom), diagonal);
		}
		
		maxSize.set(Math.max(maxSize.get(), currentMaxSize));
		return currentMaxSize;
	}

}
