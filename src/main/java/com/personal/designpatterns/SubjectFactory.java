package com.personal.designpatterns;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;

public class SubjectFactory {
	public Subject getSubject(String implType) {
		if (implType.equals("hashmap")) {
			return new Subject(new HashMap<Integer, Integer>(), new ArrayList<String>());
		} else if (implType.equals("linkedlist")) {
			return new Subject(new HashMap<Integer, Integer>(), new LinkedList<String>());
		}
		return new Subject(new Hashtable<Integer, Integer>(), new ArrayList<String>());
	}
}
