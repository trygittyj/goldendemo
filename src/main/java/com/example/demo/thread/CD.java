package com.example.demo.thread;
import java.util.concurrent.CountDownLatch;
/**
 * 这个类是一个同步计数器，主要用于线程间的控制，当CountDownLatch的count计数>0时，await()会造成阻塞，直到count变为0，await()结束阻塞，
 * 使用countDown()会让count减1。CountDownLatch的构造函数可以设置count值，当count=1时，它的作用类似于wait()和notify()的作用。
 * 如果我想让其他线程执行完指定程序，其他所有程序都执行结束后我再执行，这时可以用CountDownLatch，但计数无法被重置，如果需要重置计数，请考虑使用 CyclicBarrier 
 */
public class CD implements Runnable{
  private   CountDownLatch begin ;
  private   CountDownLatch end;
  private String name;
  private  int s;
  public CD(CountDownLatch begin,CountDownLatch end,String name){
	  this.begin=begin;
	  this.end=end;
	  this.s=3;
	  this.name=name;
  }
  @Override  
  public synchronized void run(){  //线程同步用了synchronized否则无法保证s的正确性
	try{                       //注意：await用在synchronized可能导致死锁，如果换成CyclicBarrier类会导致死锁
		begin.await();    //等待begin统一
		System.out.println("beginvalue:"+begin.getCount()+","+end.getCount()+","+s+" 次");
		s--;
		//do something
	}
	catch(Exception e){
		e.printStackTrace();
	}
	finally{
		end.countDown();
	} 
  }
  public static void main(String[] args) throws Exception {
	  CountDownLatch begin = new CountDownLatch(1);
	  CountDownLatch end = new CountDownLatch(3);
	  CD juc=new CD(begin,end,Thread.currentThread().getName());   
	  for(int j=0;j<3;j++){
		 new Thread(juc).start();   //开启10个线程，10个线程分别倒数1次，并让end减一次
	  }
	  //开始倒数计时，开启begin的countDown()方法
	  System.out.println("开始倒数计数!。。。3次");
	  System.out.println("before:"+begin.getCount());
	  begin.countDown();  //begin减到0，则开始10个线程里面的await()方法后面的程序
	  System.out.println("after:"+begin.getCount());
	  System.out.println("end before:"+end.getCount());
	  end.await(); 		  //阻塞程序，知道end减为0
	  System.out.println("end start:"+end.getCount());
	  System.out.println("倒数结束。。。后面的程序开始运行");
	  //do others
  }
}