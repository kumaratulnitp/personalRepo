package com.personal.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MaximumSumSubArray {

	public static void main(String[] args) {
		MaximumSumSubArray obj = new MaximumSumSubArray();
		List<Integer> elements = new ArrayList<Integer>();
		elements.add(1);
		elements.add(-2);
		elements.add(3);
		elements.add(4);
		elements.add(-5);
		elements.add(9);
		System.out.println(obj.findMaximumSumSubArray(elements));
	}
	
	private Integer findMaximumSumSubArray(List<Integer> elements) {
		int currentMax = Integer.MIN_VALUE;
		int finalMax = Integer.MIN_VALUE;
		for(int i:elements) {
			currentMax += i;
			if (currentMax < 0) {
				currentMax = 0;
			}
			if (finalMax < currentMax) {
				finalMax = currentMax;
			}
		}
		return finalMax;
	}
}
