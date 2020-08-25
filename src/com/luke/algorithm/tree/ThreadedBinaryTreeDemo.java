package com.luke.algorithm.tree;

public class ThreadedBinaryTreeDemo {
	public static void main(String[] args) {
		ThreadedBinaryTree tree = new ThreadedBinaryTree();
		ThreadedBinaryTreeNode root = new ThreadedBinaryTreeNode(1);
		ThreadedBinaryTreeNode node2 = new ThreadedBinaryTreeNode(2);
		ThreadedBinaryTreeNode node3 = new ThreadedBinaryTreeNode(3);
		ThreadedBinaryTreeNode node4 = new ThreadedBinaryTreeNode(4);
		ThreadedBinaryTreeNode node5 = new ThreadedBinaryTreeNode(5);

		root.setLeft(node2);
		root.setRight(node3);
		node3.setRight(node4);
		node3.setLeft(node5);

		tree.setRoot(root);
		tree.infixThreaded();
		System.out.println("root的前驱节点是" + root.left);
		System.out.println("root的后继节点是" + root.right);
		System.out.println("node2的前驱节点是" + node2.left);
		System.out.println("node2的后继节点是" + node2.right);
		System.out.println("node3的前驱节点是" + node3.left);
		System.out.println("node3的后继节点是" + node3.right);
		System.out.println("node4的前驱节点是" + node4.left);
		System.out.println("node4的后继节点是" + node4.right);
		System.out.println("node5的前驱节点是" + node5.left);
		System.out.println("node5的后继节点是" + node5.right);
	}

}

class ThreadedBinaryTree {
	ThreadedBinaryTreeNode root;

	ThreadedBinaryTreeNode pre;

	public void infixThreaded() {
		infixThreaded(root);
	}

	public void infixThreaded(ThreadedBinaryTreeNode node) {
		if (node.left != null) {
			infixThreaded(node.left);
		}
		if (node.left == null) {
			node.left = pre;
			node.setLeftType(1);
		}
		if (pre!=null && pre.right == null) {
			pre.right = node;
			pre.setRightType(1);
		}
		pre = node;
		if (node.right != null) {
			infixThreaded(node.right);
		}
	}

	public void setRoot(ThreadedBinaryTreeNode root) {
		this.root = root;
	}
}

class ThreadedBinaryTreeNode{
	ThreadedBinaryTreeNode left;
	ThreadedBinaryTreeNode right;
	int leftType = 0;
	int rightType = 0;

	private int no;

	public ThreadedBinaryTreeNode(int no) {
		this.no = no;
	}

	public void setLeft(ThreadedBinaryTreeNode left) {
		this.left = left;
	}

	public void setRight(ThreadedBinaryTreeNode right) {
		this.right = right;
	}

	public void setLeftType(int leftType) {
		this.leftType = leftType;
	}

	public void setRightType(int rightType) {
		this.rightType = rightType;
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

//	public BinaryTreeNode preSearch(int no) {
//		if (this.no == no) {
//			return this;
//		}
//		BinaryTreeNode resNode = null;
//		if (this.left != null) {
//			resNode = this.left.preSearch(no);
//		}
//		if (resNode != null) {
//			return resNode;
//		}
//		if (this.right != null) {
//			resNode = this.right.preSearch(no);
//		}
//		return resNode;
//	}
//
//	public BinaryTreeNode infixSearch(int no) {
//		BinaryTreeNode resNode = null;
//		if (this.left != null) {
//			resNode = this.left.infixSearch(no);
//		}
//		if (resNode != null) {
//			return resNode;
//		}
//		if (this.no == no) {
//			return this;
//		}
//		if (this.right != null) {
//			resNode = this.right.infixSearch(no);
//		}
//		return resNode;
//	}
//
//	public BinaryTreeNode postSearch(int no) {
//
//		BinaryTreeNode resNode = null;
//		if (this.left != null) {
//			resNode = this.left.postSearch(no);
//		}
//		if (resNode != null) {
//			return resNode;
//		}
//		if (this.right != null) {
//			resNode = this.right.postSearch(no);
//		}
//		if (resNode != null) {
//			return resNode;
//		}
//		System.out.println("进入后序查找");
//		if (this.no == no) {
//			return this;
//		} else {
//			return null;
//		}
//	}

	public String toString(){
		return "no=" + this.no;
	}
}