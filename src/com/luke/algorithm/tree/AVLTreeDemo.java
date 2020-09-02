package com.luke.algorithm.tree;

public class AVLTreeDemo {
	public static void main(String[] args) {
		AVLTree tree = new AVLTree(null);
		int[] arr = {4,3,6,5,7,8};
		tree.createBSTree(arr);


		System.out.println(tree.getRoot().height());
	}
}

class AVLTree {
	AVLNode root;

	AVLTree(AVLNode root) {
		this.root = root;
	}

	public AVLNode getRoot() {
		return root;
	}

	public void createBSTree(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			add(new AVLNode(arr[i]));
		}
	}

	public void add(AVLNode node) {
		if (root == null) {
			root = node;
		}else{
			root.add(node);
		}
	}

	public AVLNode search(int value) {
		if (root == null) {
			return null;
		}else{
			return root.search(value);
		}
	}
}

class AVLNode{
	int value;
	AVLNode left;
	AVLNode right;

	AVLNode(int value) {
		this.value = value;
	}

	public int leftHeight() {
		if (this.left == null) {
			return 0;
		}
		return this.left.height();
	}

	public int rightHeight() {
		if (this.right == null) {
			return 0;
		}
		return this.right.height();
	}

	//返回当前节点树的高度
	public int height() {
		return Math.max(this.left == null ? 0 : this.left.height(), this.right == null ? 0 : this.right.height()) + 1;
	}

	/**
	 * 左旋转
	 */
	public void leftRotate() {
		AVLNode newNode = new AVLNode(value);
		newNode.left = left;
		newNode.right = right.left;
		value = right.value;
		right = right.right;
		left = newNode;
	}

	public void rightRotate() {
		AVLNode newNode = new AVLNode(value);
		newNode.right = right;
		newNode.left = left.right;
		value = left.value;
		left = left.left;
		right = newNode;
	}


	public void add(AVLNode node) {
		if (node == null) {
			return;
		}

		if (node.value < this.value) {
			if (this.left == null) {
				this.left = node;
			}else{
				this.left.add(node);
			}
		}else{
			if (this.right == null) {
				this.right = node;
			}else{
				this.right.add(node);
			}
		}

		if (rightHeight() - leftHeight() > 1) {
			if (right != null && right.leftHeight() > right.rightHeight()) {
				leftRotate();
			} else {
				rightRotate();
			}
			return;
		}

		if (leftHeight() - rightHeight() > 1) {
			if (left != null && left.rightHeight() > left.leftHeight()) {
				rightRotate();
			} else {
				leftRotate();
			}
		}
	}
	/**
	 * 查找指定的节点
	 * @param value
	 * @return
	 */
	public AVLNode search(int value) {
		if (this.value == value) {
			return this;
		}
		if (value < this.value) {
			if (this.left == null) {
				return null;
			} else {
				return this.left.search(value);
			}
		}else{
			if (this.right == null) {
				return null;
			}else{
				return this.right.search(value);
			}
		}
	}

}