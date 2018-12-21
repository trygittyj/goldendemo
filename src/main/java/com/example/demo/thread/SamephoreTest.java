package com.example.demo.thread;

import java.util.concurrent.Semaphore;

public class SamephoreTest {
	public static void main(String args[]) {
		Semaphore s=new Semaphore(3);
		for(int i=0;i<5;i++) {
			Worker w=new Worker(s,i);
			new Thread(w).run();
		}
	}
}
class Worker implements Runnable{
	private Semaphore sp;
	private int flag;
	public Worker(Semaphore sp,int flag) {
		this.sp=sp;
		this.flag=flag;
	}
	
	@Override
	public void run() {
		try {
			sp.acquire();
			System.out.println("thread worker:"+flag+"is working");
			Thread.sleep(1000);
			sp.release();
			System.out.println("thread worker:"+flag+"stopped");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}