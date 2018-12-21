package com.example.demo.other;

public class ClassInit {
	private int a=1;
	private int b=a+1;
	public  ClassInit(int c) {
		StringBuffer sb=new StringBuffer(10);
		System.out.println("len:"+sb.length());
		System.out.println("init_a:"+a);
		System.out.println("init_b:"+b);
		this.a=c;
		System.out.println("inite_a:"+a);
		System.out.println("inite_b:"+b);
	}
	{
		b=b+3;
	}
	public static void main(String args[]) {
		new ClassInit(8);
	}
}