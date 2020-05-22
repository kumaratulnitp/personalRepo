package com.personal.arrays;

public class OptimalGameStrategy {

	public static void main(String[] args) {
		int[] arr = {5,3,7,10};
		OptimalGameStrategy obj = new OptimalGameStrategy();
		
		System.out.println(obj.getMaxCoinValue(arr, 0, arr.length-1));
		int[] arr2 = {8, 15, 3, 7};
		System.out.println(obj.getMaxCoinValue(arr2, 0, arr2.length-1));
	}
	
	public int getMaxCoinValue(int[] arr, int leftIndex, int rightIndex) {
		//base cases
		System.out.println(leftIndex + "," + rightIndex);
		if (leftIndex == rightIndex) {
			return arr[leftIndex];
			
		}
		if (leftIndex + 1 == rightIndex) {
			return Math.max(arr[leftIndex], arr[rightIndex]);
		}
		
		//recursion
		int leftCoinChoiceValue = arr[leftIndex] + 
				Math.min(
						getMaxCoinValue(arr, leftIndex+1, rightIndex-1), 
						getMaxCoinValue(arr, leftIndex+2, rightIndex));
		
		int rightCoinChoiceValue = arr[rightIndex] +
				Math.min(getMaxCoinValue(arr, leftIndex, rightIndex-2),
						getMaxCoinValue(arr, leftIndex+1, rightIndex-1));
		
		return Math.max(leftCoinChoiceValue, rightCoinChoiceValue);
		
	}

}
