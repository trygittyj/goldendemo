package com.example.demo.collection;
public class Person {
	private String name;
	private int age;
	public Person(String name, int age) {
		this.name=name;this.age=age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	  //equals已经重写  
	public boolean equals(Object obj){  
		if(!(obj instanceof Person)){   return false;   }  
	    Person p =(Person)obj;  
	    //用来查看equals方法是否被调用  
	    System.out.println(this.name +".......equals......."+ p.name);  
	    //认为名字相同并且年龄一样大的两个对象是一个  
	    return this.name.equals(p.name) && this.age == p.age;  
	}
	public int hashCode(){
		System.out.println(this.name +"......hashCode");
	    return this.name.hashCode() + 29*age;

	}
}
