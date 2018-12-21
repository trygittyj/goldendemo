package com.example.demo.socket.netty;

public class Test {
 public static void main(String args[]) {
	  try {
		new DiscardServer(8765).run();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
 }
