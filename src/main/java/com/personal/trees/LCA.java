package com.personal.trees;

public class LCA {

	public static int count = 2 ;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		
		t1.right = t2;
		t2.right = t3;
		t3.right = t4;
		
		LCA o = new LCA();
		
		System.out.println(o.lca(t1, 2, 13).data);
		
	}
	
	private TreeNode lca(TreeNode root, int val1, int val2) {
		if (root == null) {
			return null;
		}
		if ( root.getData() == val1 || root.getData() == val2) {
			count--;
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
