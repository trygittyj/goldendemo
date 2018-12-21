package com.example.demo.socket.bio;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;
import java.text.SimpleDateFormat;

public class SocketClient {
	public static String _pattern = "yyyy-MM-dd HH:mm:ss SSS";
	public static SimpleDateFormat format = new SimpleDateFormat(_pattern);
	// 设置超时间
	public static int _sec = 5;
	public static void main(String args[]) {
		Socket socket=null;
		try {
			socket=new Socket("127.0.0.1",8001);
			Writer writer=new OutputStreamWriter(socket.getOutputStream());
			writer.write("did u accept what i have send?");
			Thread.sleep(10000);
			writer.flush();
			BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			System.out.println(br.readLine());
		}catch(Exception e){
			
		}finally {
			
		}
	}
}
