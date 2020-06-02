package com.personal.arrays;

public class RotatedSortedArray {

	public static void main(String[] args) {
		int[] a = { 12, 14, 15, 17, 5, 7};
		System.out.println(findPivot(a));
		System.out.println("------");
		int b = 1;
		b = b << 1;
		System.out.println(b);
		b = b << 1;
		System.out.println(b);
		b = b << 1;
		System.out.println(b);
		b = b << 1;
		System.out.println(b);
	}
	
	public static int findPivot(int[] a) {
		int start = 0;
		int end = a.length - 1;
		int mid = (start + end) / 2 ;
		
		while (start <= end) {
			mid = (start + end) / 2 ;
			System.out.println("start " + start + "mid" + mid + "end" + end);
			if ( /* mid < a.length - 1 && */ a[mid] > a[mid+1]) {
				return mid + 1;
			} else if (a[start] <= a[mid]) {
				start = mid + 1;
			} else if (a[start] > a[mid]) {
				end = mid - 1;
			}
		}
		return 0;
	}

}
