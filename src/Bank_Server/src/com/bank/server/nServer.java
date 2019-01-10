package com.bank.server;

import java.io.IOException;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class nServer implements Runnable {

	Thread t;
	ServerSocket svrskt;
	boolean flag;
	private static nServer ref = null;
	Socket clnt = null;

	private nServer() throws Exception { // private constructor so we cant
											// create object from outside//so we
											// create get instance method call
											// that method
		super();
		flag = true;
		svrskt = new ServerSocket(1234);

		t = new Thread(this);
		t.start();
	}

	public static nServer checkInstance() {
		return ref;
	}

	public static nServer getInstance() throws Exception {

		if (ref == null) {
			ref = new nServer();
		}
		return ref;
	}

	public void run() {
		flag = true;
		System.out.println("Server Started");
		getConnections();
	}

	void getConnections() {
		try {
			Socket clnt;
			while (true) {
				try {
					System.out.println("Waiting on accept");
					clnt = svrskt.accept();
					System.out.println("Connection received from "
							+ clnt.getInetAddress().getHostName());

					System.out.println("Client Connection Accepted");
					new processClient(clnt);
				} catch (SocketTimeoutException e) {
				}
			}

			// svrskt.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void CloseInstance() {
		try {
			svrskt.close();
			ref = null;
		} catch (IOException ex) {
			Logger.getLogger(nServer.class.getName()).log(Level.SEVERE, null,
					ex);
		}
	}
}
