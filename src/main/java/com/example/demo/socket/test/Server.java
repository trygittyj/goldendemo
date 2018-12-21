package com.example.demo.socket.test;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
	private static ServerSocket server;
	public static int SERVER_PORT=12345;
	private static ExecutorService executor=Executors.newFixedThreadPool(3) ;
	static {
		try {
			server=new ServerSocket(SERVER_PORT);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public  static void acceptClinet() {
		while(true) {
			try {
				Socket s=server.accept();
				executor.submit(new ServerAcceptDealer(s));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
