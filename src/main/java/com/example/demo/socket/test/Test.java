package com.example.demo.socket.test;

import java.io.IOException;
import java.util.Random;

public class Test {
 public static void main(String args[]) {
		//运行服务器
		new Thread(new Runnable() {
			@Override
			public void run() {
				 Server.acceptClinet();
			}
		}).start();
		//避免客户端先于服务器启动前执行代码
		try {
			Thread.sleep(100);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		//运行客户端 
		final Random random = new Random(System.currentTimeMillis());
		new Thread(new Runnable() {
			@SuppressWarnings("static-access")
			@Override
			public void run() {
				while(true){
					 Client c=new Client(Server.SERVER_PORT);
					 c.sendMsg();
					try {
						Thread.currentThread().sleep(random.nextInt(10000));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}
 }
