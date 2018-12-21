package com.example.demo.proxy;

public class Client {
	 public static void main1(String[] args) {
	        //张三先登录系统创建了一个订单
	        IOrder order = new OrderProxy(new Order("设计模式",20,"张三"));
	        //李四想要来修改，那就会报错
	        order.setOrderNum(76, "李四");
	        //输出order
	        System.out.println("李四修改后订单记录没有变化："+order);
	        //张三修改就不会有问题
	        order.setOrderNum(88, "张三");
	        //再次输出order
	        System.out.println("张三修改后，订单记录："+order);
	    }
	 
	 public static void main(String[] args) {
	        //张三先登录系统创建了一个订单
	        Order order = new Order("设计模式",77,"张三");
	        //创建一个动态代理
	        DynamicProxy dynamicProxy = new DynamicProxy();     
	        //然后把订单和动态代理关联起来
	        IOrder orderApi = dynamicProxy.getProxcyInterface(order);

	        //以下就需要使用被代理过的接口来操作了
	        //李四想要来修改，那就会报错
	        orderApi.setOrderNum(88, "李四");
	        //输出order
	        System.out.println("李四修改后订单记录没有变化："+orderApi);
	        //张三修改就不会有问题
	        orderApi.setOrderNum(99, "张三");
	        //再次输出order
	        System.out.println("张三修改后，订单记录："+orderApi);
	    }

}
