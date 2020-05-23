package com.personal.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author kumar
 * [1,2,3,6]
 * Using hashing - create a hashmap of integers -> list of integers, where
 * key = subset sum ( from 0th element to ith)
 * values = indices of the elements for which this key has equal to required sum
 * example - 
 * 
 * required sum = 3
 * 
 * index = 0 
 * subsetsum = 1
 * remaining sum = 2 
 * map push 1->0
 * 
 * index = 1
 * subsetsum = 3
 * remainingsum=0
 * map contains key with remainingsum so print
 * map push 3->1
 * 
 * index = 2
 * subsetsum = 6
 * remainingsum = -3
 * map contains key with remainingsum so print
 * map push -3->2
 * 
 * index = 3
 * subsetsum = 12
 * remainingsum = -9
 * map push -9->3
 */
public class SubarraysWithGivenSum {

	public static void main(String[] args) {
		int[] a = {1, 2, 3, 6};
		findSubArrayWithGivenSum(a, 6);
	}
	
	private static<K, V> void insert(Map<K, List<V>> myMap, K key,V value) {
		if (!myMap.containsKey(key)) {
			myMap.put(key, new ArrayList<>());
		}
		myMap.get(key).add(value);
	}
	
	private static void printAllSubArray(int[] a, int i, int j) {
		System.out.println(
				IntStream.range(i, j+1)
				.mapToObj(key -> a[key])
				.collect(Collectors.toList())
				);
	}
	
	private static void findSubArrayWithGivenSum(int[] a, int sum) {
		Map<Integer, List<Integer>> myMap = new HashMap<>();
		
		insert(myMap, 0, -1);
		int sumSoFar = 0;
		for (int index = 0; index < a.length; index++) {
			sumSoFar += a[index];
			int remainingSum = sumSoFar - sum ;
			System.out.println("->" + index + "," + sumSoFar + "," + remainingSum);
			if (myMap.containsKey(remainingSum)) {
				List<Integer> list = myMap.get(remainingSum);
				System.out.println( "---" + list);
				for (Integer i:list) {
					printAllSubArray(a, i+1, index);
				}
			}
			insert(myMap, sumSoFar, index);
		}
		
	}
}
