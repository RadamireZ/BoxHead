package net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


import logic.Mondo;


public class Server implements Runnable{

	private ServerSocket server;
	private int port;
	
	private int totaleGiocatori;
	
	private ServerGameManager manager;
	
	public Server(int port,int numGiocatori,Mondo mondo) {

		this.port = port;
		this.totaleGiocatori = numGiocatori;
		
		manager = new ServerGameManager(mondo);
		
	}
	
	
	
	public void run(){
		
		try {
	
			server = new ServerSocket(port);
	
			System.out.println("SERVER RUN");
	
		for(int i=0;i<totaleGiocatori;i++){
			
			Socket s = server.accept();
			
			ClientHandler c = new ClientHandler(s,manager);
			manager.aggiungiClient(c);
			System.out.println("SI é CONNESSO "+c.name);
		}
		
		manager.start();
		new Thread(manager,"ON").start();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}