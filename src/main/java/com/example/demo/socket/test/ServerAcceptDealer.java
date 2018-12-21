package com.example.demo.socket.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerAcceptDealer implements Runnable{
	private Socket socket;
	public ServerAcceptDealer(Socket socket) {
		this.socket=socket;
	}
	@Override
	public void run() {
		while(true) {
		try {
			InputStream is=socket.getInputStream();
			InputStreamReader isr=new InputStreamReader(is);
			BufferedReader br=new BufferedReader(isr);
			String received;
			try {
				if((received = br.readLine())==null) {
					break;
				}
				System.out.println(socket.getInetAddress()+":"+socket.getPort()+"*****"+received);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			PrintWriter sendout=new PrintWriter(socket.getOutputStream());
			sendout.println(socket.getInetAddress()+":"+socket.getPort()+":got msg from u!\r\n");
			sendout.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
}
