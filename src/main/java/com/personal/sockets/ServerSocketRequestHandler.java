package com.personal.sockets;

import java.io.BufferedReader;
import java.net.ServerSocket;
import java.util.Stack;

public class ServerSocketRequestHandler implements Runnable{

	private ServerSocket serverSocket;
	
	public ServerSocketRequestHandler(ServerSocket socket) {
		this.serverSocket = socket;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Received a connection");
		//BufferedReader input = serverSocket.get
		Stack<String> s = new Stack<String>();
	}

}
