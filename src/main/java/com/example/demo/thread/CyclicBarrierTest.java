package com.example.demo.thread;

import java.util.concurrent.CyclicBarrier;
/**
 * 
	该类从字面理解为循环屏障，它可以协同多个线程，让多个线程在这个屏障前等到，直到所有线程都到达了这个屏障时，再一起执行后面的操作。
	假如每个线程各有一个await，任何一个线程运行到await方法时就阻塞，直到最后一个线程运行到await时才同时返回。和之前的CountDownLatch相比，
	它只有await方法，而CountDownLatch是使用countDown()方法将计数器减到0，它创建的参数就是countDown的数量；CyclicBarrier创建时的int参数是await的数量。
	将上面的例子改为CyclicBarrier：小心与synchronized和Lock互斥锁公用，可能会导致死锁，await()方法不会释放锁。我一开始编的就发生了死锁。
 *
 */
public class CyclicBarrierTest implements Runnable{
  private   CyclicBarrier end;
  private  int s;
  public CyclicBarrierTest(CyclicBarrier end,int i){
	  this.end=end;
	  s=i;
  }
  @Override  
  public  void run(){  //线程同步用了synchronized否则无法保证s的正确性
	try{
		System.out.println("end"+end.getNumberWaiting()+","+s+"队准备完毕");
		s--;
		end.await(); 
	}
	catch(Exception e){
		e.printStackTrace();
	}
  }
  public static void main(String[] args) throws Exception {
	  CyclicBarrier end = new CyclicBarrier(11);  //await为10+1=11个
	  for(int j=0;j<10;j++){
		 new Thread(new CyclicBarrierTest(end,j)).start();   //开启10个线程
	  }
	  end.await(); 		  //阻塞程序，直到10个子线程全部运行的await处
	  System.out.println("\n10队全部准备结束。。。后面的程序开始运行");
	  //do others
  }
}