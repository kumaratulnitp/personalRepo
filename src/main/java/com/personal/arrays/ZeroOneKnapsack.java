package com.personal.arrays;

import java.util.List;

public class ZeroOneKnapsack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int minCostknapsack(List<Integer> costs, List<Integer> weights, int weight, int currentIndex) {
		if (weight == 0) {
			return 0;
		}
		
		if (weights.get(currentIndex) > weight) {
			return minCostknapsack(costs, weights, weight, currentIndex-1);
		}
		
		int excludeCost = minCostknapsack(costs, weights, weight, currentIndex-1);
		int includeCost = costs.get(currentIndex) + 
				minCostknapsack(costs, weights, weight - weights.get(currentIndex), currentIndex-1);
		return Math.min(excludeCost, includeCost);
	}

}
