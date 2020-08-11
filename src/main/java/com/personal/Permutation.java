package com.personal;

public class Permutation {

	public static void main(String[] args) {

		int[] numbers= {1, 2, 3};
		permutation(numbers, 0);

		System.out.println("----------");
		int[] n2 = {1, 2, 3, 4};
		permutation(n2, 0);

	}
	/*
	 *	1 call for reset
	 *  2 would be placed at index position and then call for rest
	 *  3 would be replaced with index position and then call for rest  
	 */

	public static void permutation(int[] numbers, int index) {

		//base case here 
		if (index == numbers.length) {
			//print the array
			for(int i=0; i < numbers.length; i++) {
				System.out.print(numbers[i] + ",");
			}
			System.out.println();//dummy print
			return;
		}

		for (int i=index; i < numbers.length; i++ ) {
			int temp ;
			temp = numbers[index];
			numbers[index] = numbers[i];
			numbers[i] = temp; 
			permutation(numbers, index+1);

			numbers[i] = numbers[index];
			numbers[index] = temp;
		}

	}

}
