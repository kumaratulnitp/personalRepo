package com.personal.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class ThreeSum {

	public static void main(String[] args) {
		ThreeSum obj = new ThreeSum();
		
	}
	
	private int findThreeSum(List<Integer> elements,int index, int num, int remainingSum) {
		if (remainingSum == 0 ) {
			return 0;
		}
		List<Integer> result = new ArrayList<Integer>();
		for (int i =index; i < elements.size(); i++) {
			int sum1 = i + findThreeSum(elements, index+1, num-1, remainingSum-i);
			int sum2 = findThreeSum(elements, index+1, num, remainingSum);
		}
		return 0;
	}
}
