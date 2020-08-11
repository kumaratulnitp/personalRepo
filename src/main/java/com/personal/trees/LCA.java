package com.personal.trees;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;

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
		
		Queue<String> q = new LinkedList<String>();
		Comparator<? super String> comp = (String a, String b) -> b.compareToIgnoreCase(a);
		q = new PriorityQueue<String>(11, comp );
		
		q.offer("e");
		q.add("f");
		q.offer("a");
		System.out.println(q.peek());
		System.out.println(q.poll());
		System.out.println(q.poll());
		System.out.println(q.poll());
		
		CopyOnWriteArrayList<String> cw = new CopyOnWriteArrayList<String>();
		cw.add("a");
		cw.add("b");
		
		BlockingQueue<Integer> bq = new LinkedBlockingDeque<Integer>();
		bq.offer(3);
		bq.offer(4);
		bq.offer(1);
		AtomicInteger ai = new AtomicInteger(0);
		int i = ai.get();
		ai.set(i+20);
		Map<Integer, Integer> m = new HashMap<Integer, Integer>();
		ArrayList<String> strings = new ArrayList<String>();
		strings.add("asdf");
		strings.get(0);
		strings.get(10);
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
