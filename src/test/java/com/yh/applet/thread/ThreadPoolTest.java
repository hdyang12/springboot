package com.yh.applet.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import org.junit.Before;
import org.junit.Test;

public class ThreadPoolTest {
	
	private ThreadPoolExecutor pool = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
	private List<Integer> list = new ArrayList<Integer>();
	
	@Before
	public void init() {
		for (int i = 0; i < 10000; i++) {
			list.add(i);
		}
	}
	
	@Test
	public void threadtest() {
		for (final Integer i : list) {
			pool.submit(new Runnable() {
				@Override
				public void run() {
					try {
						System.out.println(i);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			
		}
	}

}
