package com.example.demo.socket.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	private int serverPort;
	private String ip="127.0.0.1";
	public Client(int serverPort) {
		this.serverPort=serverPort;
	}
	private static Socket socket;
	public void sendMsg() {
		try {
			socket=new Socket(ip,serverPort);
			PrintWriter pw=new PrintWriter(socket.getOutputStream());
			pw.write("msg send from client\r\n");
			pw.flush();
			InputStream is=socket.getInputStream();
			InputStreamReader isr=new InputStreamReader(is);
			BufferedReader br=new BufferedReader(isr);
			String received;
			try {
				received = br.readLine();
				System.out.println(socket.getInetAddress()+":"+socket.getPort()+"*****"+received);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
