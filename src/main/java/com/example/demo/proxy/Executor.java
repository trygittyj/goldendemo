package com.example.demo.proxy;

public class Executor {
	public static void main(String args[]) {
		BeingStaticProxyed bsp=new BeingStaticProxyed();
		/*StaticProxy pro=new StaticProxy(bsp);
		pro.findBF();*/
		System.out.println(bsp.getClass());
		IStaticProxy proxy=(IStaticProxy)new ProxyFactory(bsp).getProxyInstance();
		System.out.println(bsp.getClass());
		proxy.findBF();
	}
}
