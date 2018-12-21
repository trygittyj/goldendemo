package com.example.demo.other;

public class Father extends GrandPa{
	public static int houses=1;
	private static int tail=1;
	private int wifes=1;
	public Father() {
		super();
		System.out.println("father no param method");
	}
	public Father(String wife) {
		super();
		System.out.println("father extended wife:"+wife);
		System.out.println("father init can only own 1wife:"+wifes);
	}
	public void getsons() {
		System.out.println("fathser can own only 1 son");
	}
	static {
		System.out.println("father static content.one son one wife");
	}
	private final void aa() {
		System.out.println("father aa");
	}
}
