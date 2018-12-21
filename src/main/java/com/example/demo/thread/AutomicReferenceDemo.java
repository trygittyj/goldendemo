package com.example.demo.thread;

import java.util.concurrent.atomic.AtomicReference;

public class AutomicReferenceDemo {
	public static void main(String args[]) {
		Person p1=new Person(3);
		Person p2=new Person(5);
		AtomicReference<Person> ar=new AtomicReference<Person>(p1);
		ar.compareAndSet(p1,p2);
		Person p3 = (Person)ar.get();
        System.out.println("p3 is "+p3);
        System.out.println("p3.equals(p1)="+p3.equals(p1));
	}
}
class  Person {
	volatile int id;
	public Person(int id) {
		this.id=id;
	}
	public String toString() {
        return "id:"+id;
    }
}