package com.example.demo.socket.aio;

public class AIOServer {
	private static int DEFAULT_PORT=12345;
	private static AsyncServerHandler serverHandle;
	public volatile static long clinetCount=0;
	public static void start() {
		start(DEFAULT_PORT);
	}
	public static synchronized void start(int port) {
		if(serverHandle!=null) return;
		serverHandle=new AsyncServerHandler(port);
	}
	public static void main(String args[]) {
		AIOServer.start();
	}
}


