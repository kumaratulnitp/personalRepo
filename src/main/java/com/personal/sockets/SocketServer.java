package com.personal.sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class SocketServer {

	public static void main(String[] args) {
		ServerSocket s;
		try {
			s = new ServerSocket(8080);
			Socket ss = s.accept();
			PrintWriter pw = new PrintWriter( ss.getOutputStream());
			BufferedReader br = new BufferedReader(new InputStreamReader(ss.getInputStream()));
			System.out.println(br.readLine());
			pw.write("I received your message at " + new Date());
			System.out.println("kkk");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
