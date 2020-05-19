package com.personal.strings;

import java.util.ArrayList;
import java.util.List;

public class WordBreak {

	public static void main(String[] args) {
		List<String> dictionary = new ArrayList<>();
		dictionary.add("there");
		dictionary.add("word");
		dictionary.add("is");
		dictionary.add("the");
		
		String sentence1 = "isword";
		String sentence2 = "there";
		String sentence3 = "therewordisa";
		
		WordBreak obj = new WordBreak();
		System.out.println(obj.isWordBreakPossible(dictionary, sentence1, 0));
		System.out.println(obj.isWordBreakPossible(dictionary, sentence2, 0));
		System.out.println(obj.isWordBreakPossible(dictionary, sentence3, 0));
	}

	public boolean isWordBreakPossible(List<String> dictionary, String sentence, int currentIndex)  {
		//System.out.println("isWordBreakPossible");
		if (currentIndex >= sentence.length()) {
			return true;
		}
		String currentWord = "";
		for(int i = currentIndex; i < sentence.length(); i++) {
			currentWord += sentence.charAt(i);
			boolean returnValue = false;
			if (dictionary.contains(currentWord)) {
				//System.out.println("word matched");
				returnValue = isWordBreakPossible(dictionary, sentence, i + 1);
			}
			if (returnValue == true) {
				return true;
			}
		}
		return false;
	}
}
