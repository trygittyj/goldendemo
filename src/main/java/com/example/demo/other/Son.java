package com.example.demo.other;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.PriorityQueue;

public class Son extends Father implements Comparable{
	private int age;
	public static int houses=1;
	private int wifes=0;
	public Son(String wifes) {
		super(wifes);
		System.out.println("son dont have any wifes"+wifes);
	}
	public Son(int age) {
		this.age=age;
	}
	public Son() {
		super();
		System.out.println("no param constructor method");
	}
	public void getsons() {
		System.out.println("son cant own any son yet");
	}
	static {
		System.out.println("son static i can have nothing");
	}
	public static void main1(String args[]) {
		List l=new ArrayList();
		ListIterator it=l.listIterator(0);
		System.out.println("son main entrance when to ini");
		Son s=new Son(3);
		Son s2=new Son(10);
		Son s3=new Son(7);
		PriorityQueue<Son> pq=new PriorityQueue<Son>();
		pq.offer(s);pq.offer(s2);pq.offer(s3);
		System.out.println(pq);
		/*synchronized(s) {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			s.getsons();
		}*/
		
	}
	public static void main(String args[]) {
		boolean a;
		if(true) {
			a=false;
		}
		System.out.println(a);
	}
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	private final void aa() {
		System.out.println("son aa");
	}
}
