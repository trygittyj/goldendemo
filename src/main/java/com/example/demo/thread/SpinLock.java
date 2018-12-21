package com.example.demo.thread;

import java.util.concurrent.atomic.AtomicReference;
/**
 * 自旋锁
 * 当一个线程在获取锁的时候，如果锁已经被其它线程获取，那么该线程将循环等待，然后不断的判断锁是否能够被成功获取，直到获取到锁才会退出循环。
 * 获取锁的线程一直处于活跃状态，但是并没有执行任何有效的任务，使用这种锁会造成busy-waiting
 *
 */
public class SpinLock {
  private AtomicReference<Thread> sign =new AtomicReference<Thread>();
  public void lock(){
    Thread current = Thread.currentThread();
    while(!sign .compareAndSet(null, current)){
    }
  }
  public void unlock (){
    Thread current = Thread.currentThread();
    sign .compareAndSet(current, null);
  }
}
