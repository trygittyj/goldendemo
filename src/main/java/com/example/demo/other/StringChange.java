package com.example.demo.other;

import java.lang.reflect.Field;

public class StringChange {
	public static void main(String args[]) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		String s="hello java";
		Field f=String.class.getDeclaredField("value");
		f.setAccessible(true);
		char[] value=(char[])f.get(s);
		value[5]='*';
		System.out.println(s);
	}
}
