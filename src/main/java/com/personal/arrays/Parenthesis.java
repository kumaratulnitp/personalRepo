package com.personal.arrays;

import java.util.Stack;

public class Parenthesis {


	public static void main(String[] args) {
		String a = "(((())";
		System.out.println(isBalanced(a));
		a = "(())(())()";
		System.out.println(isBalanced(a));
		a = "({})" ;
		System.out.println(isBalanced(a));
		a = "({(}))" ;
		System.out.println(isBalanced(a));

	}

	public static boolean isBalanced(String a) {
		Stack<Character> stack = new Stack<Character>();

		for(int index = 0; index < a.length(); index++) {
			char bracket = a.charAt(index);
			if (bracket == '(' || bracket == '{') {
				stack.push(bracket);
			} else if (bracket == ')' ) {
				if (stack.peek().equals('(') ) {
					stack.pop();
				} else {
					return false;
				}
			} else if (bracket == '}' ) {
				if (stack.peek().equals('{') ) {
					stack.pop();
				} else {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}
}
