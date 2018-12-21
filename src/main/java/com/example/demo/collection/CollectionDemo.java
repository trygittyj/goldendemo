package com.example.demo.collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class CollectionDemo {
	public static void main(String args[]) {
		fun2();
	}
	public static void fun6() {
		List<String> aList = new ArrayList<String>();
		aList.add("b");
		aList.add("a");
		aList.add("a");
		aList.add("b");
		aList.add("c");
		aList.add("c");
		Set<String> hSet = new LinkedHashSet<String>();
		hSet.addAll(aList);
		aList.clear();
		aList.addAll(hSet);
		System.out.println(aList);
	}
	/**
	 * LinkedHashSet 特点: 有序的(怎么存的可以怎么取出来)
	 * 底层实现是链表实现
	 * 同样具有Set的去重的特点
	 */
	public static void fun3() {
	    LinkedHashSet<String> lSet = new LinkedHashSet<String>();
	    lSet.add("c");
	    lSet.add("a");
	    lSet.add("a");
	    lSet.add("c");
	    lSet.add("b");
	    lSet.add("b");
	    lSet.add("d");
	    lSet.add("d");
	    for (String string : lSet) {
	        System.out.println(string);
	    }
	}
	/**
	 * 去除对象 --- 需要重写HashCode() 和 equals()
	 */
	public static void fun2() {
	    HashSet<Person> hSet = new HashSet<Person>();
	    hSet.add(new Person("科比" , 22));
	    hSet.add(new Person("加索尔" , 19));
	    hSet.add(new Person("费舍尔" , 20));
	    hSet.add(new Person("科比" , 22));
	    for (Person personCopy : hSet) {
	        System.out.println(personCopy.getName());
	    }
	}
}
