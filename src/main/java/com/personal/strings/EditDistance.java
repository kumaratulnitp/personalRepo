package com.personal.strings;

public class EditDistance {

	public static void main(String[] args) {
		
		EditDistance obj = new EditDistance();
		
		String a = "atul";
		String b= "atula";
		System.out.println(obj.process(a, b, a.length()-1, b.length()-1));
	}
	
	private int process(String a, String b, int aIndex, int bIndex) {
		if (aIndex == 0)
			return bIndex;
		if (bIndex == 0)
			return aIndex;
		
		if (a.charAt(aIndex) == b.charAt(bIndex)) {
			return process(a, b, aIndex-1, bIndex-1);
		}
		
		return 1 + 
				Math.min(
						Math.min(process(a, b, aIndex, bIndex-1), 
								process(a, b, aIndex-1, bIndex-1)), 
						process(a, b, aIndex-1, bIndex-1));
	}
	
	//TODO:DP solution
}
