package com.example.demo.web;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Compare {
 public static void main(String args[]) {
	 List ps=new ArrayList<Person>();
	 Person  p1=new Person(1);
	 ps.add(p1);
	 Person  p2=new Person(3);
	 ps.add(p2);
	 Collections.sort(ps);
	 for(int i = 0; i < ps.size(); i++){
		 Person p = (Person)(ps.get(i));
		 System.out.println(p.age);
	 }
 }
 static class Person implements Comparable{
	 public Person(int age) {
		 this.age=age;
	 }
	 
	 int age;

	 public int compareTo(Object obj) {
		 Person p=(Person)obj;
		 if(this.age > p.age) {
			 return -1;
		 }else if(this.age==p.age) {
			 return 0;
		 }else {
			 return 1;
		 }
	 }
 }
}
