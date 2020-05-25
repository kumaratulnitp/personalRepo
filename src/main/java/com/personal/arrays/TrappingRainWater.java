package com.personal.arrays;

public class TrappingRainWater {

	public static void main(String[] args) {
		int[] a = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 }; 
		System.out.println(trappedRainWater(a));
	}
	
	
	public static int trappedRainWater(int[] a) {
		
		int[] leftMax = new int[a.length];
		int[] rightMax = new int[a.length];
		leftMax[0] = a[0];
		rightMax[a.length-1] = a[a.length-1];
		
		for(int i = 1; i < a.length; i++) {
			leftMax[i] = Math.max(leftMax[i-1], a[i]);
		}

		for(int i=a.length-2; i >=0; i--) {
			rightMax[i] = Math.max(rightMax[i+1], a[i]);
		}
		
		int volume = 0 ;
		
		for(int i=0; i < a.length; i++) {
			volume += Math.min(leftMax[i], rightMax[i]) - a[i];
		}
		return volume;
	}

}
