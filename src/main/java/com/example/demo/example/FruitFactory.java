package com.example.demo.example;

public class FruitFactory {
//	public static Fruit create(String type) {
//		Fruit f;
//		if(type.equals("apple")) {
//			f=new Apple();
//		}else {
//			f=new Watermalon();
//		}
//		return f;
//	}
	public static Fruit create(String type) {
		Fruit f=null;
		try {
			f=(Fruit)Class.forName(type).newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return f;
	}
}
