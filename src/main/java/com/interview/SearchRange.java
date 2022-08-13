package com.interview;

import java.util.Arrays;

public class SearchRange {

    public static void main(String[] args) {
        SearchRange sr = new SearchRange();
        int[] i = {5,7,8,8,8,8,8,8,33};
        i = new int[]{1,1};
        int target = 1;

        int[] r = sr.searchRange(i, target);
        System.out.println(Arrays.toString(r));
    }

    public int[] searchRange(int[] nums, int target) {
        int l = leftBin(nums, target) ;
        if (l == -1 ) {
            return new int[]{-1,-1};
        }
        int r = rightBin(nums, target);
        return new int[]{l, r};
    }

    private int leftBin(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;
        int mid ;
        while (l <= r) {
            mid = l + (r-l)/2;
            if (nums[mid] == target) {
              if (mid == 0 || nums[mid-1] < target) {
                  return mid;
              } else {
                  r = mid - 1;
              }
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else /* nums[mid] > target */ {
                r = mid-1;
            }
        }
        return -1;
    }

    private int rightBin(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;
        int mid ;
        while (l <= r) {
            mid = l + (r-l)/2;
            if (nums[mid] == target) {
                if (mid == nums.length-1 || nums[mid+1] > target)
                    return mid;
                else
                    l = mid + 1;
            } else if (nums[mid] < target) {
                l = mid + 1 ;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }
}
