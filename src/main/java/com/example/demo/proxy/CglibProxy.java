package com.example.demo.proxy;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class CglibProxy implements MethodInterceptor {
	private Object target;
	public CglibProxy(Object obj) {
		this.target=obj;
	}
	public Object getInstance() {
		Enhancer en=new Enhancer();
		en.setSuperclass(target.getClass());
		en.setCallback(this);
		return en.create();
	}
	@Override
	public Object intercept(Object arg0, Method method, Object[] arg2, MethodProxy arg3) throws Throwable {
		return method.invoke(arg0, arg2);
	}

}
