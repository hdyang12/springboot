package com.yh.applet.thread;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.junit.Test;

public class ReadWriteLockTest {
	
	@Test
	public void getResult(){
        final ReadWriteData a = new ReadWriteData(); 
        Thread t0 = new Thread() {  
            public void run() {  
                while (true) {  
                    a.get();  
                }  
            }  

        };
        
        Thread t1 = new Thread() {  
            public void run() {  
                while (true) {  
                    a.get();  
                }  
            }  

        };
        
        Thread t2 = new Thread() {  
            public void run() {  
                while (true) {  
                    a.get();  
                }  
            }  

        };
        
        Thread t3 = new Thread() {  
            public void run() {  
                while (true) {  
                    a.put(new Random().nextInt(10000));  
                }  
            }  

        };
        
        t0.start();
        t1.start();
        t2.start();
        t3.start();
        
        try {
        	t0.join();
			t1.join();
			t2.join();
			t3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}
  
	class ReadWriteData {  
	    private Object data = null;// 共享数据，只能有一个线程能写该数据，但可以有多个线程同时读该数据。  
	    ReadWriteLock rwl = new ReentrantReadWriteLock();  
	  
	    public void get() {  
	        rwl.readLock().lock();  
	        try {  
	            System.out.println(Thread.currentThread().getName()  
	                    + " be ready to read data!");  
	            Thread.sleep(1000);  
	            System.out.println(new Date() + Thread.currentThread().getName()  
	                    + "have read data :" + data);  
	        } catch (InterruptedException e) {  
	            e.printStackTrace();  
	        } finally {  
	            rwl.readLock().unlock();  
	        }  
	    }  
	  
	    public void put(Object data) {  
	  
	        rwl.writeLock().lock();  
	        try {  
	            System.out.println(Thread.currentThread().getName()  
	                    + " be ready to write data!");  
	            Thread.sleep(1000);  
	            this.data = data;  
	            System.out.println(new Date() + Thread.currentThread().getName()  
	                    + " have write data: " + data);  
	        } catch (InterruptedException e) {  
	            e.printStackTrace();  
	        } finally {  
	            rwl.writeLock().unlock();  
	        }  
	  
	    } 
	}
}
