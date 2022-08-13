package com.practice.dp;

import java.util.*;

public class Robbery {


    /*
    {3, 4, 5, 6, 8, 9}
    left    0   2
    right   5   5
    mid     2   4

     */
    public int findMissingInSortedArray(int[] arr){
        int left = 0;
        int right = arr.length-1;
        int mid = 0;
        while (left < right) {
            mid = left + (right - left)/2;
            if (arr[mid] - arr[mid-1] == 2) {
                return arr[mid]-1;
            }
            int expectedVal = arr[0] + mid ;
            if ( arr[mid] == expectedVal) {
                left = mid+1;
            } else {
                right = mid;
            }
        }
        return -1;
    }
    //This is a tough question because of the edge cases it has
    //1. trailing zeros
    //2. leading zeros
    //Also, the complexity arises when we try to use constant space.
    public void duplicateZeros(int[] arr) {
        int zeroCount = 0;
        for (int i=0; i + zeroCount <= arr.length-1; i++) {
            if (arr[i] == 0) {
                zeroCount++;
            }
            if (i + zeroCount > arr.length-1) {
                break;
            }
        }
        for (int i=arr.length-1; i >=0; i--) {
            if (zeroCount == 0) {
                break;
            }
            if (i-zeroCount >= 0) {
                arr[i] = arr[i-zeroCount];
                if (arr[i] == 0) {
                    arr[i-1] = 0;
                    i=i-1;
                    zeroCount--;
                }
            }
        }
    }

    public static void main(String[] args) {
        Robbery r = new Robbery();

        int[] houses = {1, 3,1};
        int max = r.rob(houses);
        System.out.println(max);

        MyEnum e = MyEnum.A;
        System.out.println(e);
        System.out.println(Enum.valueOf(MyEnum.class, "B"));
        System.out.println(e.memberProd());

        Character c = '9';
        int cc = c;
        System.out.println(cc);

        String s = "atul";

        Integer[] houseReqs = {1, 5, 4, 8};
        System.out.println(minWaterOperations(houseReqs));
        //Arrays.sort(houseReqs,(int a,int b)-> { return b-a;});
        Comparator<Integer> ccc = (Integer a,Integer b)-> { return b-a;};
        Arrays.sort(houseReqs,ccc);
        System.out.println(minWaterOperations(houseReqs));

        int[] missingInSortedArray = {3, 4, 5, 6, 8, 9};
        System.out.println(r.findMissingInSortedArray(missingInSortedArray));

        missingInSortedArray = new int[]{3, 4, 5, 6, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        System.out.println(r.findMissingInSortedArray(missingInSortedArray));

    }

    //Increment only a single house requirement
    //Double all the house capacity from current state
    public static int minWaterOperations(Integer[] houseReqs) {
        int ops = 0;
        int maxMult = 0;
        for(int houseReq:houseReqs) {
            int incr = 0;
            int mult = 0;
            while (houseReq > 0) {
                if (houseReq % 2 == 0) {
                    mult++;
                    houseReq /= 2;
                } else {
                    houseReq--;
                    incr++;
                }
            }
            if (mult > maxMult) {
                maxMult = mult;
            }
            ops += incr;
        }
        ops += maxMult;
        return ops;
    }

    Map<Integer, Integer> memo;

    public int rob(int[] nums) {
        memo = new HashMap<>();
        int max = bestRobbery(nums, false, 0);
        return max;
    }


    private int bestRobbery(int[] nums, boolean lastConsecutive, int idx) {
        //base condition
        if (idx == nums.length-1) {
            if (lastConsecutive) {
                return 0;
            } else {
                return nums[idx];
            }
        } else if ( idx > nums.length - 1) {
            return 0;
        }

        int key = lastConsecutive ? idx: idx * -1;
        if (!memo.containsKey(key)) {
            int max = 0;
            if (lastConsecutive) {
                max = bestRobbery(nums, false, idx+1);
            } else {
                int inclusive = nums[idx] + bestRobbery(nums, true, idx+1) ;
                int exclusive = bestRobbery(nums, false, idx+1);
                max = Math.max(inclusive, exclusive);
            }
            memo.put(key, max);
        }

        //return max;
        return memo.get(key);
    }
}

enum MyEnum {
    A(1,2),
    B(2,3),
    ;

    private final int val1;
    private final int val2;

    MyEnum(int i, int i1) {
        this.val1 = i;
        this.val2 = i1;
    }

    int memberSum() {
        return val1 + val2;
    }

    int memberProd() {
        return val1*val2;
    }
}
