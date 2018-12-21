package com.example.demo.thread;

import java.util.concurrent.Semaphore;
/**
 * 该类用于控制信号量的个数，构造时传入个数。总数就是控制并发的数量。
 * 假如是5，程序执行前用acquire()方法获得信号，则可用信号变为4，程序执行完通过release()方法归还信号量，
 * 可用信号又变为5.如果可用信号为0，acquire就会造成阻塞，等待release释放信号。
 * acquire和release方法可以不在同一个线程使用。Semaphore实现的功能就类似厕所有5个坑，
 * 假如有10个人要上厕所，那么同时只能有多少个人去上厕所呢？同时只能有5个人能够占用，
 * 当5个人中 的任何一个人让开后，其中等待的另外5个人中又有一个人可以占用了。
 * 另外等待的5个人中可以是随机获得优先机会，也可以是按照先来后到的顺序获得机会，
 * 这取决于构造Semaphore对象时传入的参数选项。单个信号量的Semaphore对象可以实现互斥锁的功能，
 * 并且可以是由一个线程获得了“锁”，再由另一个线程释放“锁”，这可应用于死锁恢复的一些场合
 *
 */
public class SamePhoreTest2 implements Runnable{
	private   Semaphore sema;
	private  int s;
	public SamePhoreTest2(Semaphore sema,int i){
	  this.sema=sema;
	  s=i;
	}
	@Override  
	public void run(){  //线程同步用了synchronized否则无法保证s的正确性
		try{
			sema.acquire();  //获取一个控制信号 
			System.out.println(s+"队准备完毕");
			s--;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			 sema.release(); //释放信号
		}
	}
	public static void main(String[] args) throws Exception {
		Semaphore sema = new Semaphore(2);
		for(int j=0;j<4;j++){
			new Thread(new SamePhoreTest2(sema,j)).start();   //开启5个线程，5个线程分别获得一个信号量，然后释放
		}
		System.out.println("the ending");
	}
}