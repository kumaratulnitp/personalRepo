package com.personal.arrays;

import java.util.Stack;

public class LargestAreaArray {

	public static void main(String[] args) {
		int[] a = {2,1,5,6,2,3};
		System.out.println(maxArea(a));
	}

	public static int maxArea(int[] a) {
		int max = Integer.MIN_VALUE;
		Stack<Integer> increasingHeightIndexStack = new Stack<>();

		int index = 0 ;
		while (index < a.length) {
			if (	increasingHeightIndexStack.isEmpty() || 
					a[index] >= a[increasingHeightIndexStack.peek()] ) {
				increasingHeightIndexStack.push(index);
				System.out.println("pushing " + index + "height" + a[index] + "stack " + increasingHeightIndexStack);
				
				index++;
			} else {
				int lastIndex = increasingHeightIndexStack.pop();
				int height = a[lastIndex];
				int width = increasingHeightIndexStack.isEmpty() ? index : 
					index - increasingHeightIndexStack.peek() - 1 ;
				max = Math.max(height * width, max);
				int currentArea = height * width;
				System.out.println("lastIndex " + lastIndex + ", index " + index + "height " + height + "currentArea " + currentArea + ",stack " + increasingHeightIndexStack);
			}
		}

		while (!increasingHeightIndexStack.isEmpty()) {
			System.out.println("**");
			int lastIndex = increasingHeightIndexStack.pop();
			int height = a[lastIndex];
			int width = increasingHeightIndexStack.isEmpty() ? index : 
				index - increasingHeightIndexStack.peek() - 1 ;
			max = Math.max(height * width, max);
			int currentArea = height * width;
			System.out.println("lastIndex " + lastIndex + ", index " + index + "height " + height  +"currentArea" + currentArea + ",stack " + increasingHeightIndexStack);
		}
		return max;
	}

}
