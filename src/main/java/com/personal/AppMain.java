package com.personal;

import java.util.ArrayList;
import java.util.List;

public class AppMain {

	public static void main(String[] args) {
		List<String> l = new ArrayList<String>();
		l.add("atul");
		l.add("ksfsa");
		l.add("bbas");
		l.add("eew");
		l.add("eeasdksf");
		
		l.stream().filter(s -> s.startsWith("e")).forEach(s -> System.out.println(s));
		
	}

}
