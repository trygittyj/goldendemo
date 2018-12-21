package com.example.demo.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JustRun {
	public static void main(String args[]) {
		/*Fruit f=FruitFactory.create("com.example.demo.example.Apple");
		f.juicy();*/
		/*try {
			String s=Class.forName("java.lang.Integer").getName();
			System.out.println(s);
			Integer i1=3;
			System.out.println(i1.getClass().getName());
			System.out.println(Integer.class.getName());
			
			Class<?> c=Integer.class;
			Constructor<?> cs[]=c.getDeclaredConstructors();
			for (Constructor<?> constructor : cs) {
				System.out.println(constructor);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		List<Student> a=new ArrayList<Student>();
		Student s=new Student();
		s.setScore(10);
		Student s1=new Student();
		s.setScore(13);
		a.add(s);
		a.add(s1);
		Collections.sort(a,new SortedByScore());
	}
}
