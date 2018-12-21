package com.example.demo.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.FutureTask;
class CallThread implements Callable{
	public Integer call() {
		return 1+2;
	}
}

public class Test {

	public static void main(String[] args)throws Exception{
			CallThread ct=new CallThread();
			FutureTask<Integer> task=new FutureTask<Integer>(ct); 
			new Thread(task).start();
			System.out.println("做自己的事，计算1+2+3+4交给另一个线程完成\n");
			System.out.println("返回获取结果 "+task.get());
	}
     public static void main1(String[] args) {   
         final CountDownLatch latch = new CountDownLatch(2);
          
         new Thread(){
             public void run() {
                 try {
                     System.out.println("子线程"+Thread.currentThread().getName()+"正在执行");
                    Thread.sleep(3000);
                    System.out.println("子线程"+Thread.currentThread().getName()+"执行完毕");
                    latch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
             };
         }.start();
          
         new Thread(){
             public void run() {
                 try {
                     System.out.println("子线程"+Thread.currentThread().getName()+"正在执行");
                     Thread.sleep(3000);
                     System.out.println("子线程"+Thread.currentThread().getName()+"执行完毕");
                     latch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
             };
         }.start();
          
         try {
             System.out.println("等待2个子线程执行完毕...");
            latch.await();
            System.out.println("2个子线程已经执行完毕");
            System.out.println("继续执行主线程");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
     }
}