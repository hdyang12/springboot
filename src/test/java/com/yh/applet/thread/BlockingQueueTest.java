package com.yh.applet.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import org.junit.Test;

public class BlockingQueueTest {

	@Test
	public void getResult() throws InterruptedException {
		BlockingQueue<String> bq = new ArrayBlockingQueue<String>(1024);
		Thread t1 = new Thread(new Producer(bq));
		Thread t2 = new Thread(new Consumer(bq));
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println("Test thread is finished");
	}
	
	class Producer implements Runnable {
		BlockingQueue<String> bq = null;
		public Producer(BlockingQueue<String> bq) {
			this.bq = bq;
		}
		@Override
		public void run() {
			int count = 0;
			while (true) {
				try {
					bq.put("" + count++ );
					System.out.println("Producer： " + count);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	class Consumer implements Runnable {
		BlockingQueue<String> bq = null;
		public Consumer(BlockingQueue<String> bq) {
			this.bq = bq;
		}
		@Override
		public void run() {
			try {
				while (true) {
					System.out.println("Consumer: " + bq.take());
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
