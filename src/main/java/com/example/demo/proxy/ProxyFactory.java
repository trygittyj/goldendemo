package com.example.demo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {
	private Object target;
	public ProxyFactory(Object tar) {
		this.target=tar;
	}
	public Object getProxyInstance() {
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
			public Object invoke(Object proxy,Method method,Object[] args)throws Throwable {
				System.out.println("start ..");
				Object returnValue=method.invoke(target, args);
				System.out.println("commit..");
				return returnValue;
			}
		});
	}
}
