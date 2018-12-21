package com.example.demo.other;

public class GrandPa {
	static {
		System.out.println("grandpa static content:life is meizizi");
	}
	public static void staticmeth(){
		System.out.println("grandpa's static method");
	}
	{
		System.out.println("grandpa is init block");
	}
	public static int houses=7;
	private int wifies=2;
	public GrandPa() {
		System.out.println("grandpa's no param construstor method");
	}
	public GrandPa(String wife) {
		//this.wifies=wife;
		super();
		System.out.println("grandpa init:house"+houses);
		System.out.println("grandpa init:"+wifies);
	}
	public void getsons() {
		System.out.println("grandpa can own more than 5 sons");
	}
	public static void main() {
		System.out.println("grandpa's static main method");
	}
}
