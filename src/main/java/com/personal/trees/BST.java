package com.personal.trees;

public class BST {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.setLeft(new TreeNode(3));
		root.getLeft().setLeft(new TreeNode(1));
		root.getLeft().setRight(new TreeNode(4));
		root.setRight(new TreeNode(7));

		BST obj = new BST();
		
		System.out.println(obj.isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
	}
	
	private boolean isBST(TreeNode root, int minValue, int maxValue) {
		if (root == null) {
			//System.out.println("null");
			return true;
		}
		//System.out.println("isBST" + root.getData() + "," + minValue + "," + maxValue);
		
		if (root.getData() < minValue || root.getData() > maxValue) {
			//System.out.println("fail" + root.getData() + "," + minValue + "," + maxValue);
			return false;
		}
		return isBST(root.getLeft(), minValue, root.getData()) && isBST(root.getRight(), root.getData(), maxValue);
	}

}
