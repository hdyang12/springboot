package com.yh.applet.thread;

import java.util.concurrent.CountDownLatch;

import org.junit.Test;

public class CountDownLatchTest {
	
	@Test
	public void getResult () throws InterruptedException {
		CountDownLatch latch = new CountDownLatch(3);  
		  
		Waiter      waiter      = new Waiter(latch);  
		Decrementer decrementer = new Decrementer(latch);  
		  
		Thread t1 = new Thread(waiter);
		Thread t2 = new Thread(decrementer);
		
		t1.start();  
		t2.start();  
		  
		t1.join();
		t2.join();
	}
	
	class Waiter implements Runnable{  
		  
	    CountDownLatch latch = null;  
	  
	    public Waiter(CountDownLatch latch) {  
	        this.latch = latch;  
	    }  
	  
	    public void run() {  
	        try {  
	            latch.await();  
	        } catch (InterruptedException e) {  
	            e.printStackTrace();  
	        }  
	  
	        System.out.println("Waiter Released");  
	    }  
	}  
	  
	class Decrementer implements Runnable {  
	  
	    CountDownLatch latch = null;  
	  
	    public Decrementer(CountDownLatch latch) {  
	        this.latch = latch;  
	    }  
	  
	    public void run() {  
	  
	        try {  
	            Thread.sleep(1000);  
	            this.latch.countDown();  
	  
	            Thread.sleep(1000);  
	            this.latch.countDown();  
	  
	            Thread.sleep(1000);  
	            this.latch.countDown();  
	        } catch (InterruptedException e) {  
	            e.printStackTrace();  
	        }  
	    }  
	}
}
