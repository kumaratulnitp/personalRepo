package com.personal.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSorted {

	public static void main(String[] args) {
		MergeKSorted obj = new MergeKSorted();
		
		List<List<Integer>> sortedLists = new ArrayList<List<Integer>>();
		List<Integer> list1 = Arrays.asList(19,30);
		sortedLists.add(list1);
		List<Integer> list2 = Arrays.asList(15,25);
		sortedLists.add(list2);
		
		List<Integer> list3 = Arrays.asList(21, 26);
		sortedLists.add(list3 );
		List<Integer> finalList = obj.mergeKSorted(sortedLists );
		finalList.stream().forEach(i -> System.out.println(i));

	}
	
	private List<Integer> mergeKSorted(List<List<Integer>> sortedLists) {
		List<Integer> finalList= new ArrayList<Integer>();
		PriorityQueue<Integer> temporaryHeap = new PriorityQueue<Integer>();
		for(List<Integer> sortedList:sortedLists) {
			for(Integer item:sortedList) {
				temporaryHeap.offer(item);
			}
		}
		while(!temporaryHeap.isEmpty()) {
			finalList.add(temporaryHeap.poll());
		}
		
		return finalList;
	}

}
