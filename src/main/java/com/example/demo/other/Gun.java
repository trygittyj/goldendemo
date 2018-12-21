package com.example.demo.other;

import java.util.ArrayList;
import java.util.List;

import org.objenesis.Objenesis;
import org.objenesis.ObjenesisStd;

class Weapon{
	private final void run() {
		System.out.println("weapon");
	}
}
public class Gun {
	
	public static void main(String args[]) {
		//new Gun().run();
		String a="maimai";
		String b="maimai";
		char c[]= {'m','a','i','m','a','i'};
		/*System.out.println(a.equals(b));
		System.out.println(b.equals(c));
		System.out.println(a==b);
		System.out.println(b.equals(new String("maimai")));*/
		List<Integer> list=new ArrayList<Integer>();
		list.add(2);
		list.add(4);
		list.add(1);
		list.add(3);
		list.add(5);
		for(int i=0;i<list.size();i++) {
			int v=list.get(i);
			System.out.println(v);
			if(v%2==0) {
				System.out.println("before remove:"+v+":"+list);
				list.remove(v);
				System.out.println("after remove:"+v+":"+list);
			}
		}
		System.out.println(list);
		/*boolean bb=Integer.MAX_VALUE+1<Integer.MAX_VALUE;
		System.out.println(bb);*/
	}
	private final void run() {
		System.out.println("Gun");
	}
}
