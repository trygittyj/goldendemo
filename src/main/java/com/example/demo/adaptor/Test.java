package com.example.demo.adaptor;

public class Test {
	public static void main(String args[]) {
		ISmaller transfer=new HalfOfBiggerAdaptor(10);
		System.out.println(transfer.halfSize(50));
	}
}
