package com.personal.sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketAddress;

public class ClientSocket {

	public static void main(String[] args) {
		try {
			Socket cs = new Socket("localhost", 8080);
			PrintWriter pw = new PrintWriter(cs.getOutputStream());
			BufferedReader br = new BufferedReader(new InputStreamReader(cs.getInputStream()));
			pw.write("hello server ");
			System.out.println(br.readLine());
			pw.close();
			br.close();
			cs.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
