package com.personal.trees;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class Balanced {

	private class Response {
		@Override
		public String toString() {
			return ReflectionToStringBuilder.toString(this);
			//return "ReturnData [balanced=" + balanced + ", height=" + height + "]";
		}
		public boolean balanced;
		public int height;
	}
	
	public static void main(String[] args) {
		Balanced obj = new Balanced();
		TreeNode root = new TreeNode(5);
		root.setLeft(new TreeNode(3));
		root.getLeft().setLeft(new TreeNode(1));
		root.getLeft().setRight(new TreeNode(4));
		root.setRight(new TreeNode(7));
		System.out.println(obj.isBalanced(root).balanced);
	}
	
	private Response isBalanced(TreeNode root) {
		Response response = new Response();
		if (root == null) {
			response.balanced = true; 
			response.height = 0;
			System.out.println(root + "," + response);
			return response;
		}
		Response leftTreeResponse = isBalanced(root.getLeft());
		Response rightTreeResponse = isBalanced(root.getRight());
		
		response.height = 1 + 
				(leftTreeResponse.height > rightTreeResponse.height ? 
						leftTreeResponse.height : 
							rightTreeResponse.height);
		
		if (Math.abs(leftTreeResponse.height - rightTreeResponse.height) < 2) {
			response.balanced = true;
			System.out.println(root.getData() + "," + response);
			return response;
		}

		response.balanced = false;
		System.out.println(root.getData() + "," + response);
		return response;
	}

}
