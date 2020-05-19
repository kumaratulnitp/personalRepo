package com.personal.arrays;

import java.util.ArrayList;
import java.util.List;

/*
 * You have a rod of x length
 * You sell rods at certain prices according to length
 * You have to find out what is the maximum profit you can get by selling appropriate lengths of rod
 */
public class RodCut {
	
	public static void main(String[] args) {
		List<Integer> prices = new ArrayList<Integer>();
		prices.add(5);
		prices.add(6);
		RodCut rc = new RodCut();
		
		System.out.println(rc.maxProfit(prices, 2));

	}
	
	/*
	 * Iterate through each length price and call recursively for remaining length 
	 */
	public int maxProfit(List<Integer> prices, int rodLength) {
		if (rodLength <= 0 ) {
			return 0;
		}
		
		int maxProfit = Integer.MIN_VALUE;
		for (int i=0; i< prices.size(); i++) {
			if ( i + 1 > rodLength ) { 
				break;
			}
			int currentProfit = prices.get(i) + maxProfit(prices, rodLength - i - 1);
			if (currentProfit > maxProfit ) {
				 maxProfit = currentProfit;
			}
		}
		return maxProfit;
	}

}

/*
 * [5, 6], rodlength = 2
 * 5+5 = 10
 */
