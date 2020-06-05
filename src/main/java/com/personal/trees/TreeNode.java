package com.personal.trees;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TreeNode {
	public int data;
	public TreeNode left;
	public TreeNode right;
	
	public TreeNode(int data) {
		this.data = data;
	}
}
