package com.example.demo.proxy;

public class StaticProxy implements IStaticProxy {
	private IStaticProxy sProxy;
	public StaticProxy(IStaticProxy target) {
		this.sProxy=target;
	}
	public void findBF() {
		//sProxy.findBF();
		System.out.println("i am a statycProxy,and i will find a bf for sb");
	}

}
