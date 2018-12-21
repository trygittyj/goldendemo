package com.example.demo.mode;

public class Test {
	public static void main(String args[]) {
		Client c1=new Client("redisclient");
		Client c2=new Client("kafkaclient");
		Client c3=new Client("fastdfs");
		IServer s=new Server();
		
		s.reserve("come",c1);
		s.reserve("come",c2);
		s.reserve("come",c3);
		
		s.reserve("update", null);
	}
}
