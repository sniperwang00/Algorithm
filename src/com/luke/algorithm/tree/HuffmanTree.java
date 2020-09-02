package com.luke.algorithm.tree;

import java.io.*;
import java.util.*;

public class HuffmanTree {
	public static void main(String[] args) {
//		String source = "i like like like java do you like a java";
//
//		byte[] zipped = huffmanZip(source.getBytes());
//
//		byte[] bytes = decode(huffmanCodes, zipped);
//
//		System.out.println(new String(bytes));

//		zipFile("D:\\src.bmp", "D:\\dst.zip");

		unzipFile("D:\\dst.zip", "D:\\unzipped.bmp");
	}

	private static void unzipFile(String srcFile, String dstFile) {
		InputStream is = null;
		ObjectInputStream ois = null;
		FileOutputStream os = null;

		try {
			is = new FileInputStream(srcFile);
			ois = new ObjectInputStream(is);
			os = new FileOutputStream(dstFile);
			byte[] huffmanBytes = (byte[]) ois.readObject();
			Map<Byte, String> huffmanCodes1 = (Map<Byte, String>) ois.readObject();

			byte[] unzipped = decode(huffmanCodes1, huffmanBytes);
			os.write(unzipped);
			System.out.println("解压完毕");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				is.close();
				os.close();
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static void zipFile(String srcFile, String dstFile) {
		FileInputStream is = null;
		FileOutputStream os = null;
		ObjectOutputStream oos = null;
		try {
			is = new FileInputStream(srcFile);
			os = new FileOutputStream(dstFile);
			oos = new ObjectOutputStream(os);

			byte[] b = new byte[is.available()];
			is.read(b);

			byte[] zipped = huffmanZip(b);
			oos.writeObject(zipped);
			oos.writeObject(huffmanCodes);
			System.out.println("压缩完毕");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try{
				is.close();
				os.close();
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	/**
	 * 哈夫曼压缩方法
	 * @param bytes
	 * @return
	 */
	private static byte[] huffmanZip(byte[] bytes) {
		List<Node> nodes = getNodes(bytes);

		Node root = createHuffmanTree(nodes);

		getCodes(root);

		byte[] zipped = zip(bytes, huffmanCodes);

		return zipped;
	}

	/**
	 *
	 * @param huffmanCodes 哈夫曼编码表
	 * @param huffmanBytes 哈夫曼压缩数组
	 * @return
	 */
	private static byte[] decode(Map<Byte, String> huffmanCodes, byte[] huffmanBytes) {

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < huffmanBytes.length; i++) {
			byte b = huffmanBytes[i];
			boolean flag = (i == huffmanBytes.length - 1);
			sb.append(byteToBitString(!flag, b));
		}
//		System.out.println("sb = " + sb.toString());
//		System.out.println("sb.length = " + sb.length());

		//翻转编码表
		Map<String, Byte> reverseCodes = new HashMap<>();
		for (Map.Entry<Byte, String> entry : huffmanCodes.entrySet()) {
			reverseCodes.put(entry.getValue(), entry.getKey());
		}

		List<Byte> list = new ArrayList<>();
		for (int i = 0; i < sb.length();) {
			int count = 1;
			boolean flag = true;
			Byte b = null;
			while (flag) {
				String key = sb.substring(i, i + count);
				b = reverseCodes.get(key);
				if (b == null) {
					count++;
				}else{
					flag = false;
				}
			}
			list.add(b);
			i += count;
		}

		byte[] bytes = new byte[list.size()];
		for (int i = 0; i < list.size(); i++) {
			bytes[i] = list.get(i);
		}
		return bytes;
	}

	/**
	 * 把一个字节转换为二进制string
	 * @param flag 是否需要补高位， 最后一个byte不需要不高位
	 * @param b
	 * @return
	 */
	private static String byteToBitString(boolean flag, byte b) {
		int temp = b;
		if (flag) {//如果是正数需要补高位
			temp |= 256;  // 1|= 256 ==> 1 0000 0000 | 0000 0001 = 1 0000 0001 ==> 取后八位=> 0000 0001 = 1
		}

		String str = Integer.toBinaryString(temp);
		if (flag) {
			return str.substring(str.length() - 8);
		}else{
			return str;
		}
	}

	//把源字符串转换为字节数组
	private static byte[] zip(byte[] bytes, Map<Byte, String> huffmanCodes) {
		StringBuilder sb = new StringBuilder();
		for (byte b : bytes) {
			sb.append(huffmanCodes.get(b));
		}
//		System.out.println("压缩后的string: " + sb.toString());
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
			zip[count] = (byte) Integer.parseInt(subByte, 2);
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
			counts.merge(b, 1, Integer::sum);
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

	public void setLeftNode(Node leftNode) {
		this.leftNode = leftNode;
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