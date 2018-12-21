package com.example.demo.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
public class CallableThreadTest implements Callable{
	
     public Integer call() {
 		int j=10;
 		int a=0;
 		for(int i=0;i<100;i++) {
 			System.out.println(i*j);
 			a=j+i;
 		}
 		return a;
 	}  
     
    public static void main(String args[]) {
    	FutureTask<Integer> ft=new FutureTask<Integer>(new CallableThreadTest());
    	Executor execu=Executors.newSingleThreadExecutor();
    	execu.execute(ft);
    	try {
			System.out.println(ft.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
    }
}


