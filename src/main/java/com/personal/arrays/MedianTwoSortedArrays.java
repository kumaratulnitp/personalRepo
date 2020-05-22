package com.personal.arrays;

public class MedianTwoSortedArrays {

	public static void main(String[] args) {
		MedianTwoSortedArrays obj = new MedianTwoSortedArrays();
		int[] arr = new int[] {2, 3, 4, 13, 45, 56, 67, 98};
		System.out.println(obj.binarySearch(arr, 0, arr.length, 45));
		System.out.println(obj.binarySearch(arr, 0, arr.length, 98));
		System.out.println(obj.binarySearch(arr, 0, arr.length, 13));
		System.out.println(obj.binarySearch(arr, 0, arr.length, 44));
		
		System.out.println(obj.binarySearchIterative(arr, 45));
		System.out.println(obj.binarySearchIterative(arr, 98));
		System.out.println(obj.binarySearchIterative(arr, 13));
		System.out.println(obj.binarySearchIterative(arr, 44));
		
		//{2,3,4,5,6,9} => median = middle element = (4+5) / 2
		int[] a = new int[] {2, 3, 5};
		int[] b = new int[] {1, 6, 7};
		System.out.println("*********");
		System.out.println(obj.findMedianInSameSizeArray(a, b, 0, 2, 0, 2));
		
	}
	
	public int findMedian(int[] array1, int[] array2) {
		//TODO
		return 0;
	}
	
	public int findMedian(int[] array1, int [] array2, int arr1Left, int arr1Right, 
			int arr2Left, int arr2Right, int midPosition) {
		//TODO
		return 0;
	}
	
	public int binarySearch(int[] arr, int start, int end, int data) {
		if (start > end) {
			return -1;
		}
		int mid = (start + end ) / 2 ;
		if (data == arr[mid]) {
			return mid;
		}
		else if (data > arr[mid] ) {
			return binarySearch(arr, mid+1, end, data);
		} else {
			return binarySearch(arr, start, mid-1, data);
		}
	}

	public int binarySearchIterative(int[] arr, int data) {
		int start = 0 ;
		int end = arr.length;
		while (start <= end) {
			int mid = (start + end ) / 2 ;
			if (arr[mid] == data) {
				return mid;
			} else if (data > arr[mid]) {
				start = mid + 1; 
			} else {
				end = mid - 1;
			}
		}
		return -1;
	}
	
	/**
	 * @param a
	 * @param b
	 * @param aStart
	 * @param aEnd
	 * @param bStart
	 * @param bEnd
	 * @return
	 * 
	 * The idea is to keep trimming the array part that we are looking into, 
	 * until remaining elements in that part is 2
	 * once only 2 elements remain in both array, we hit the terminating condition.
	 */
	public int findMedianInSameSizeArray(int[] a, int[] b, int aStart, int aEnd, int bStart, int bEnd ) {
		if (aEnd - aStart == 1) {
			return (Math.max(a[aStart], b[bStart]) + Math.min(a[aEnd], b[bEnd])) / 2 ;
		}
		int aMedian = medianInArray(a, aStart, aEnd);
		int bMedian = medianInArray(b, bStart, bEnd);
		if (aMedian == bMedian ) {
			return aMedian;
		} else if (aMedian < bMedian ) {
			return findMedianInSameSizeArray(a, b, (aStart + aEnd  + 1)/2 , aEnd, bStart, (bStart + bEnd + 1)/2);
		}else {
			return findMedianInSameSizeArray(a, b, aStart, (aStart + aEnd  + 1)/2, (bStart + bEnd + 1)/2, bEnd);
		}
	}
	
	private int medianInArray(int[] a, int start, int end) {
		int mid = end - start + 1;
		if (mid % 2 == 0 ) {
			return ( a[start + mid/2] + a[start + mid/2 - 1]) / 2 ;
		} else {
			return a[start + mid/2];
		}
	}
}
