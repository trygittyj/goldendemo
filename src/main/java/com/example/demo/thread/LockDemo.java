package com.example.demo.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {
	private Lock lock=new ReentrantLock();
	public void lockmethod(Thread thread) {
		try {
			lock.lock();
			System.out.println(thread.getName()+":get and lock");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
		
	}
	public static void main(String args[]) {
		Thread t=new Thread(new LockThread());
		t.start();
		Thread t1=new Thread(new LockThread());
		t1.start();
		
	}

}

class LockThread implements Runnable{
	public void run() {
		LockDemo ld=new LockDemo();
		ld.lockmethod(Thread.currentThread());
	}
}