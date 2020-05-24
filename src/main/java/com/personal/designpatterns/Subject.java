package com.personal.designpatterns;

import java.util.List;
import java.util.Map;

public class Subject {
	private Map<Integer, Integer> someMap;
	private List<String> dictionary;
	
	public Subject(Map<Integer, Integer> someMap, List<String> dictionary) {
		this.someMap = someMap;
		this.dictionary = dictionary;
	}
	
	public void addKeyValue(Integer key, Integer value) {
		
	}
	
	public void printList() {
		dictionary.stream().forEach(s -> {
			System.out.println(s);
		});
	}
	
	public void printMap() {
		someMap.forEach((Integer key, Integer value) -> {
			System.out.println("key = " + key + ", value=" + value);
		});
	}
}
