package com.luke.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CurrentChatTest {

	//定义一个CountDownLatch
	CountDownLatch countDownLatch = new CountDownLatch(150);

	public void countDownLatch() {
//		ExecutorService executorService = Executors.newFixedThreadPool(10);
//		for (int i = 0; i < 10; i++) {
//			executorService.submit(createThread(countDownLatch));
//		}
		for (int i = 0; i < 10; i++) {
			createThread(countDownLatch).start();
		}

		//计数器减一
//		countDownLatch.countDown();
		for(int i=150; i>0; i--){
			System.out.println("倒计时： " + i);
			countDownLatch.countDown();
		}


	}

	//创建线程
	private Thread createThread(CountDownLatch countDownLatch) {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					System.out.println("Thread: "+Thread.currentThread().getName()+", 准备...");
					countDownLatch.await();
					//do something
					print(Thread.currentThread().getName());
					System.out.println("Thread: "+Thread.currentThread().getName()+", 开始...");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		return thread;
	}

	public synchronized void print(String name){
		for(int i=0 ; i<=300; i++){
			System.out.println("Thread: " + name + " , 正在疯狂输出, 第" + i +"次");
		}
	}

	public static void main(String[] args) {
		CurrentChatTest currentChatTest = new CurrentChatTest();
		currentChatTest.countDownLatch();

	}
}