package com.example.demo.proxy;

public class BeingStaticProxyed implements IStaticProxy {

	@Override
	public void findBF() {
		System.out.println("i am the proxyObject,i find a bf by myself");

	}

}
