package com.example.demo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy implements InvocationHandler {
	private IOrder iOrder;
	public IOrder getProxcyInterface(Order order) {
		this.iOrder=order;
		IOrder iOrder=(IOrder)Proxy.newProxyInstance(order.getClass().getClassLoader(), order.getClass().getInterfaces(), this);
		return iOrder;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if(method.getName().startsWith("set")) {
			if(iOrder.getOrderUser().equals(args[0])) {
				return method.invoke(iOrder, args);
			}else {
				System.out.println("对不起，"+args[0]+","+args[1]+"，您无权修改本订单中的数据");
			}
		}
		return null;
	}

}
