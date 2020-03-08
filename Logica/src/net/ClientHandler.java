package net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler implements Runnable{
	
	public Socket socket;
	private ServerGameManager server;
	
	private BufferedReader br;
	
	private PrintWriter pw;
	
	public String name;
	

	public ClientHandler(Socket s, ServerGameManager manager) {
		
		socket = s;
		server = manager;
	
	}
	

	public void setup() throws IOException {
		
		br = new BufferedReader( new InputStreamReader(socket.getInputStream()) );
		pw = new PrintWriter( socket.getOutputStream(),true );
		name = br.readLine();	
	
	}

	
	public void dispatch(String message){
		
		pw.println(message);
	}
	
	
	@Override
	public void run() {
		try {
			while (true) {
				
				final String buffer = br.readLine();
				
				
				
				server.received(buffer);
				
			}
		} catch (final IOException e) {
			e.printStackTrace();
			System.out.println("Client disconnected: " + name);
		}

	}

	
};
