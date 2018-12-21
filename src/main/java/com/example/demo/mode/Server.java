package com.example.demo.mode;

import java.util.ArrayList;
import java.util.List;

public class Server implements IServer {
	private List<Client> clients=new ArrayList<Client>();
	public void attach(Client clientName) {
		clients.add(clientName);
		System.out.println(clientName.cname+" is coming in");
	}

	public void detach(Client clientName) {
		clients.remove(clientName);
		System.out.println(clientName.cname+" is living");
	}

	public void notifyClient() {
		for(Client clientName:clients) {
			clientName.update();
			System.out.println(clientName.cname+",please update ur content");
		}
	}
	public void reserve(String action,Client clientName) {
		if(action.equals("come")) {
			this.attach(clientName);
		}
		else if(action.equals("leave")) {
			this.detach(clientName);
		}
		else if(action.equals("update")) {
			this.notifyClient();
		}else {
			System.out.println(clientName.cname+",the action cant be reconized");
		}
	}
}
