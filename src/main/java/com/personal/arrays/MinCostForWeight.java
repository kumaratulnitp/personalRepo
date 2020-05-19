package com.personal.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinCostForWeight {

	public static void main(String[] args) {
		MinCostForWeight obj = new MinCostForWeight();
		List<Integer> costs = new ArrayList<Integer>();
		costs.add(20);
		costs.add(10);
		costs.add(4);
		costs.add(50);
		costs.add(100);
		
		System.out.println(obj.minCostForWeightIterative(costs, 1));
	}
	
	private int minCostForWeightIterative(List<Integer> costs,int weight) {
		int dp[] = new int[weight+1];
		dp[0] = 0 ;
		
		/*
		 * Keep building this dp array starting with weight 0 
		 * This way we will reach min cost for weight = weight eventually
		 * 
		 */
		
		for (int currentWeight=0; currentWeight <= weight; currentWeight++) {
			Integer minCostForCurrentWeight = Integer.MAX_VALUE;
			for(int itemIndex=0; itemIndex < costs.size(); itemIndex++) {
				Integer currentCost = costs.get(itemIndex) + dp[currentWeight - itemIndex - 1];
				minCostForCurrentWeight = Math.min(minCostForCurrentWeight, currentCost);
			}
			dp[currentWeight] = minCostForCurrentWeight;
		}
		return dp[weight];
	}
}
