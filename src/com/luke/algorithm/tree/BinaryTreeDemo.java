package com.luke.algorithm.tree;

public class BinaryTreeDemo {
	public static void main(String[] args) {
		BinaryTreeNode root = new BinaryTreeNode(1);
		BinaryTreeNode node2 = new BinaryTreeNode(2);
		BinaryTreeNode node3 = new BinaryTreeNode(3);
		BinaryTreeNode node4 = new BinaryTreeNode(4);
		BinaryTreeNode node5 = new BinaryTreeNode(5);

		root.setLeft(node2);
		root.setRight(node3);
		node3.setRight(node4);
		node3.setLeft(node5);
//		System.out.println("preOrder: ");
//		root.preOrder();
//		System.out.println("infixOrder: ");
//		root.infixOrder();
//		System.out.println("postOrder: ");
//		root.postOrder();
		System.out.print("preSearch: ");
		BinaryTreeNode resNode = root.preSearch(5);
		if (resNode == null) {
			System.out.println("没找到对应的节点");
		}else{
			System.out.println("找到了no=[" + resNode.getNo() + "]的节点");
		}

		System.out.print("infixSearch: ");
		BinaryTreeNode resNode1 = root.infixSearch(5);
		if (resNode1 == null) {
			System.out.println("没找到对应的节点");
		}else{
			System.out.println("找到了no=[" + resNode1.getNo() + "]的节点");
		}

		System.out.print("postSearch: ");
		BinaryTreeNode resNode2 = root.postSearch(15);
		if (resNode2 == null) {
			System.out.println("没找到对应的节点");
		}else{
			System.out.println("找到了no=[" + resNode2.getNo() + "]的节点");
		}
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

	public int getNo() {
		return this.no;
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

	public BinaryTreeNode preSearch(int no) {
		if (this.no == no) {
			return this;
		}
		BinaryTreeNode resNode = null;
		if (this.left != null) {
			resNode = this.left.preSearch(no);
		}
		if (resNode != null) {
			return resNode;
		}
		if (this.right != null) {
			resNode = this.right.preSearch(no);
		}
		return resNode;
	}

	public BinaryTreeNode infixSearch(int no) {
		BinaryTreeNode resNode = null;
		if (this.left != null) {
			resNode = this.left.infixSearch(no);
		}
		if (resNode != null) {
			return resNode;
		}
		if (this.no == no) {
			return this;
		}
		if (this.right != null) {
			resNode = this.right.infixSearch(no);
		}
		return resNode;
	}

	public BinaryTreeNode postSearch(int no) {

		BinaryTreeNode resNode = null;
		if (this.left != null) {
			resNode = this.left.postSearch(no);
		}
		if (resNode != null) {
			return resNode;
		}
		if (this.right != null) {
			resNode = this.right.postSearch(no);
		}
		if (resNode != null) {
			return resNode;
		}
		System.out.println("进入后序查找");
		if (this.no == no) {
			return this;
		} else {
			return null;
		}
	}

	public String toString(){
		return "no=" + this.no;
	}
}