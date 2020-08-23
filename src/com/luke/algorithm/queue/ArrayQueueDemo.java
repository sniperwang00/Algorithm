package com.luke.algorithm.queue;

import java.util.Scanner;

public class ArrayQueueDemo {
	public static void main(String[] args) {
		ArrayQueue arrQueue = new ArrayQueue(3);

		Scanner scanner = new Scanner(System.in);
		boolean loop = true;
		char key = ' ';

		while (loop) {
			System.out.println("s(show): 显示队列");
			System.out.println("e(exit): 退出队列");
			System.out.println("a(add): 添加数据到队列");
			System.out.println("g(get): 从队列获取数据");
			System.out.println("h(head): 查看队列头部数据");

			key = scanner.next().charAt(0);
			switch (key){
				case 's':
					arrQueue.showQueue();
					break;
				case 'a':
					System.out.println("输入一个数:");
					int val = scanner.nextInt();
					arrQueue.addQueue(val);
					break;
				case 'g':
					System.out.printf("取出的数是%d\n", arrQueue.getQueue());
					break;
				case 'e':
					loop = false;
					System.out.println("程序退出~");
					break;
			}
		}

	}
}
