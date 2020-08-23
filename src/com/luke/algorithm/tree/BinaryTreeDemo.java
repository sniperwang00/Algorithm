package com.luke.algorithm.tree;

public class BinaryTreeDemo {
	public static void main(String[] args) {
		BinaryTreeNode root = new BinaryTreeNode(1);
		BinaryTreeNode node2 = new BinaryTreeNode(2);
		BinaryTreeNode node3 = new BinaryTreeNode(3);
		BinaryTreeNode node4 = new BinaryTreeNode(4);

		root.setLeft(node2);
		root.setRight(node3);
		node3.setRight(node4);
		System.out.println("preOrder: ");
		root.preOrder();
		System.out.println("infixOrder: ");
		root.infixOrder();
		System.out.println("postOrder: ");
		root.postOrder();
	}
}

class BinaryTreeNode{
	BinaryTreeNode left;
	BinaryTreeNode right;

	private int no;

	public BinaryTreeNode(int no) {
		this.no = no;
	}

	public void setLeft(BinaryTreeNode left) {
		this.left = left;
	}

	public void setRight(BinaryTreeNode right) {
		this.right = right;
	}

	public void preOrder() {

		System.out.println(this);
		if (this.left != null) {
			this.left.preOrder();
		}
		if (this.right != null) {
			this.right.preOrder();
		}
	}

	public void infixOrder() {
		if (this.left != null) {
			this.left.infixOrder();
		}
		System.out.println(this);
		if (this.right != null) {
			this.right.infixOrder();
		}
	}

	public void postOrder() {
		if (this.left != null) {
			this.left.postOrder();
		}
		if (this.right != null) {
			this.right.postOrder();
		}
		System.out.println(this);
	}

	public String toString(){
		return "no=" + this.no;
	}
}