package com.personal.trees;

public class LCA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private TreeNode lca(TreeNode root, int val1, int val2) {
		if (root == null) {
			return null;
		}
		if ( root.getData() == val1 || root.getData() == val2) {
			return root;
		}
		
		TreeNode leftParent = lca(root.getLeft(), val1, val2);
		TreeNode rightParent = lca(root.getRight(), val1, val2);
		
		if (leftParent != null && rightParent != null) {
			return root;
		} else if (leftParent != null){
			return leftParent;
		} else if (rightParent != null) {
			return rightParent;
		} else {
			return null;
		}
		
	}

}
