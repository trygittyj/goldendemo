package com.example.demo.thread;

import java.util.concurrent.Exchanger;
/**
 * 这个类用于交换数据，只能用于两个线程。当一个线程运行到exchange()方法时会阻塞，另一个线程运行到exchange()时，二者交换数据，然后执行后面的程序
 *
 */
public class JUCTest implements Runnable{
	private  Exchanger<String> exchange ;
	private  String name;
	private	 String str;
	public JUCTest(Exchanger<String> exchange,String name,String str){
		this.exchange=exchange;
		this.name=name;
		this.str=str;
	}
	@Override  
	public void run(){  //线程同步用了synchronized否则无法保证s的正确性
		try{		
			System.out.println(name+"线程自己的数据时："+str);
			String s=exchange.exchange(str);    //交换数据
			System.out.println(name+"获取另一个线程的数据："+s);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void main(String[] args) throws Exception {
		Exchanger<String> ex=new Exchanger<String>();
		new Thread(new JUCTest(ex,"zhou","Hello")).start();   
		new Thread(new JUCTest(ex,"yu","World")).start();   
	}
}