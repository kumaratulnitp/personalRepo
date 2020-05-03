package com.personal.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElement {

	public static void main(String[] args) {
		KthLargestElement obj = new KthLargestElement();
		List<Integer> elements = new ArrayList<Integer>();
		elements.add(10);
		elements.add(23);
		elements.add(33);
		elements.add(46);
		elements.add(55);
		elements.add(69);
		System.out.println(obj.findKthLargest(elements, 4));
		System.out.println(obj.findKthLargest(elements, 2));
		System.out.println(obj.findKthLargest(elements, 1));
	}
	
	private Integer findKthLargest(List<Integer> elements, int k) {
		if (elements == null) 
			return null;
//		Comparator<? super Comparator<Integer>> comparator = 
	//			(Comparator<Integer> i1, Comparator<Integer> i2) -> i1.compare(o1, o2) > 0 ? i1: i2;
		//PriorityQueue<Integer> maxElements = new PriorityQueue<Integer>(comparator);
		PriorityQueue<Integer> maxElements = new PriorityQueue<Integer>(k, Collections.reverseOrder());
		elements.stream().forEach(i -> {
			maxElements.offer(i);
		});
		for(int i=1; i<k; i++) {
			maxElements.poll();
		}
		return maxElements.poll();
	}
}
