package com.example.demo.mode;

public class Client implements IClient {
	public String cname;
	public Client(String cname) {
		this.cname=cname;
	}
	@Override
	public void update() {
		System.out.println(cname+" sth happened....");
	}

}
