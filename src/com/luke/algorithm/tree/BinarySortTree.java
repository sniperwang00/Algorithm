package com.luke.algorithm.tree;

public class BinarySortTree {
	static BTSNode root;
	public static void main(String[] args) {
		int[] arr = {7, 3, 10, 12, 5, 1, 9};
		for (int i : arr) {
			add(new BTSNode(i));
		}
//		root.infixOrder();
	}

	public static void add(BTSNode node) {
		if (root == null) {
			root = node;
		}else{
			root.add(node); //每次都是从root开始
		}
	}

	public static BTSNode search(int value) {
		if (root == null) {
			return null;
		}else{
			return root.search(value);
		}
	}

	public static BTSNode searchParent(int value) {
		if (root == null) {
			return null;
		}else{
			return root.searchParent(value);
		}
	}

}

class BTSNode{
	int value;
	BTSNode left;
	BTSNode right;

	BTSNode(int value) {
		this.value = value;
	}

	public void add(BTSNode node) {
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
	}

	public void infixOrder() {
		if (this.left != null) {
			this.left.infixOrder();
		}
		System.out.println(this.value);
		if (this.right != null) {
			this.right.infixOrder();
		}
	}

	/**
	 * 查找指定的节点
	 * @param value
	 * @return
	 */
	public BTSNode search(int value) {
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
	/**
	 * 查找指定节点的父节点
	 * @param value
	 * @return
	 */
	public BTSNode searchParent(int value) {
		if ((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value)) {
			return this;
		}

		if (value < this.value && this.left != null) {
			return this.left.searchParent(value);
		} else if (value >= this.value && this.right != null) {
			return this.right.searchParent(value);
		}else{
			return null;
		}
	}

	public void deleteNode(int value) {
		
	}

	@Override
	public String toString() {
		return "BTSNode=[" + this.value + "]";
	}
}