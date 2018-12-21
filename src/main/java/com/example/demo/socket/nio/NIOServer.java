package com.example.demo.socket.nio;
public class NIOServer {
	private static int DEFAULT_PORT = 12345;
	private static NIOServerHandle serverHandle;
	public static void start(){
		start(DEFAULT_PORT);
	}
	public static synchronized void start(int port){
		if(serverHandle!=null)
			serverHandle.stop();
		serverHandle = new NIOServerHandle(port);
		new Thread(serverHandle,"Server").start();
	}
	public static void main(String[] args){
		start();
	}
}