package com.example.demo.socket.nio;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {
	private static int serverPort=223344;
	public static ServerSocket server;
	static {
		try {
			server=new ServerSocket(serverPort);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
