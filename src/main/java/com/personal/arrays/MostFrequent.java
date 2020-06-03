package com.personal.arrays;

import java.util.Arrays;

public class MostFrequent {
	public static void main(String[] args) {
		int[] a = {4,13,12,6,8};
		Arrays.sort(a, 2, 5);
		for(int i:a) {
			System.out.println(i);
		}
	}
}
