package com.personal.sockets;

import java.io.IOException;
import java.net.ServerSocket;

public class TcpSocketServer implements Runnable{

	private int port = 8001;
	private ServerSocket serverSocket;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void run() {
		try {
			serverSocket = new ServerSocket(port);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
