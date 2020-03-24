package com.ex2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveur {
	public static int port = 13000;
	public static BufferedReader con_br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		ServerSocket ssock = new ServerSocket(port);
		System.out.println("server: Waiting for client to connect");
		Socket csock = ssock.accept();
		System.out.println("server: Connection established from " + csock.getInetAddress());

		BufferedReader csock_br = new BufferedReader(new InputStreamReader(csock.getInputStream()));
		PrintWriter csock_pw = new PrintWriter(csock.getOutputStream(), true);

		Thread chat_server_writer = new ChatWriter("chat_server_writer", csock_pw, con_br);
		chat_server_writer.start();

		String s;
		System.out.print("---------------SERVER----------------");
		while ((s = csock_br.readLine()) != null) {
			System.out.println("\rclient: " + s);
			System.out.print("> ");
		}

		System.out.println("\rserver: Client has disconnected");
		csock.close();
		ssock.close();
	}

}
