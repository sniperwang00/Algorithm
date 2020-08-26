package com.luke.algorithm.tree;

import java.util.*;

public class HuffmanTree {
	public static void main(String[] args) {
		String source = "i like like like java do you like a java";
		List<Node> nodes = getNodes(source.getBytes());
//		System.out.println(nodes);

		Node root = createHuffmanTree(nodes);
//		root.preOrder();
		getCodes(root);
//		for (Map.Entry<Byte, String> entry : huffmanCodes.entrySet()) {
//			System.out.println(entry);
//		}
		byte[] zipped = zip(source.getBytes(), huffmanCodes);
		System.out.println(Arrays.toString(zipped));
	}

	//把源字符串转换为字节数组
	private static byte[] zip(byte[] bytes, Map<Byte, String> huffmanCodes) {
		StringBuilder sb = new StringBuilder();
		for (byte b : bytes) {
			sb.append(huffmanCodes.get(b));
		}

		int len = (sb.length() + 7) / 8;

		byte[] zip = new byte[len];
		int count = 0;
		for (int i = 0; i < sb.length(); i += 8) {
			String subByte;
			if (i + 8 > sb.length()) {
				subByte = sb.substring(i);
			}else{
				subByte = sb.substring(i, i + 8);
			}
			zip[count] = (byte) Integer.parseInt(subByte);
			count++;
		}
		return zip;
	}

	static Map<Byte, String> huffmanCodes = new HashMap<>();
	private static Map<Byte, String> getCodes(Node node) {
		getCodes(node, "", new StringBuilder(""));
		return huffmanCodes;
	}
	/**
	 *
	 * @param node
	 * @param code
	 * @param stringBuilder
	 */
	private static void getCodes(Node node, String code, StringBuilder stringBuilder) {
		StringBuilder stringBuilder1 = new StringBuilder(stringBuilder);
		stringBuilder1.append(code);
		if (node != null) {
			if (node.data == null) {
				if (node.leftNode != null) {
					getCodes(node.leftNode, "0", stringBuilder1);
				}
				if (node.rightNode != null) {
					getCodes(node.rightNode, "1", stringBuilder1);
				}
			} else {
				huffmanCodes.put(node.data, stringBuilder1.toString());
			}
		}
	}

	public static List<Node> getNodes(byte[] bytes) {
		Map<Byte, Integer> counts = new HashMap<>();

		for (byte b : bytes) {
			Integer count = counts.get(b);
			if (count == null) {
				counts.put(b, 1);
			} else {
				counts.put(b, count + 1);
			}
		}

		List<Node> nodes = new ArrayList<>();
		for (Map.Entry<Byte, Integer> entry : counts.entrySet()) {
			Node node = new Node(entry.getKey(), entry.getValue());
			nodes.add(node);
		}
		return nodes;
	}

	public static Node createHuffmanTree(List<Node> nodes) {
		while (nodes.size() > 1) {
			Collections.sort(nodes);
			Node leftNode = nodes.get(0);
			Node rightNode = nodes.get(1);
			Node parentNode = new Node(null, leftNode.weight + rightNode.weight);
			parentNode.setLeftNode(leftNode);
			parentNode.setRightNode(rightNode);
			nodes.remove(leftNode);
			nodes.remove(rightNode);
			nodes.add(parentNode);
			Collections.sort(nodes);
		}
		return nodes.get(0);
	}

}

class Node implements Comparable<Node> {
	Byte data;
	int weight;

	public Node getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(Node leftNode) {
		this.leftNode = leftNode;
	}

	public Node getRightNode() {
		return rightNode;
	}

	public void setRightNode(Node rightNode) {
		this.rightNode = rightNode;
	}

	Node leftNode;
	Node rightNode;

	Node(Byte data, int weight) {
		this.data = data;
		this.weight = weight;
	}

	public void preOrder() {
		System.out.println(this);
		if (this.leftNode != null) {
			this.leftNode.preOrder();
		}
		if (this.rightNode != null) {
			this.rightNode.preOrder();
		}
	}

	@Override
	public String toString() {
		return "Node=[data=" + this.data + ", weight=" + this.weight + "]";
	}

	@Override
	public int compareTo(Node o) {
		return this.weight - o.weight;
	}
}