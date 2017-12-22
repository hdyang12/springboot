package com.yh.applet.thread;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.junit.Test;


public class ReentrantLockTest {
	
	Lock lock = new ReentrantLock();    //注意这个地方
	private ArrayList<Integer> arrayList = new ArrayList<Integer>();
    
    @Test
    public void getResult() {
    	Thread t0 = new Thread(){
            public void run() {
                insert(Thread.currentThread());
            };
        };
        
        Thread t1 = new Thread(){
            public void run() {
                insert(Thread.currentThread());
            };
        };
        
        t0.start();
        t1.start();
        
        try {
			t0.join();
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }

    public void insert(Thread thread) {
        
        lock.lock();
        try {
            System.out.println(thread.getName()+"得到了锁");
            Thread.sleep(1000);
            for(int i=0;i<5;i++) {
                arrayList.add(i);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }finally {
            System.out.println(thread.getName()+"释放了锁");
            lock.unlock();
        }
    }
}
