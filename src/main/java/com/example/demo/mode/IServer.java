package com.example.demo.mode;

public interface IServer {
	/*public void attach(IClient clientName);
	public void detach(IClient clientName);
	public void notifyClient();*/
	public void reserve(String action,Client clientName);
}
