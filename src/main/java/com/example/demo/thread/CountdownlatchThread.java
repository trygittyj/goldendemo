package com.example.demo.thread;

import java.util.concurrent.CountDownLatch;
public class CountdownlatchThread{
	public static void main(String args[]) throws InterruptedException {
		final  CountDownLatch cdl=new CountDownLatch(3);
		new Thread(new CdlThread(cdl,"1")).start();
		new Thread(new CdlThread(cdl,"2")).start();
		new Thread(new CdlThread(cdl,"3")).start();
		cdl.await();
		System.out.println(Thread.currentThread().getName()+" exe");
	}
}

 class CdlThread implements Runnable{
	private  CountDownLatch cdl;
	private String threadName;
	public CdlThread(CountDownLatch cdl,String threadname) {
		this.cdl=cdl;
		this.threadName=threadname;
	}
	public void run() {
		System.out.println(threadName+"running");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		cdl.countDown();
		System.out.println(threadName+" finish");
	}
	
}
