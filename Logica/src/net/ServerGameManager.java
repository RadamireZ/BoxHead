package net;

import java.io.IOException;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;

import logic.Mondo;
import logic.Player;

public class ServerGameManager implements Runnable{

	public Set<ClientHandler> clients;
	
	public Mondo mondo;
	
	private String nomeCreatore;

	public void aggiungiClient(ClientHandler c) throws IOException{
		c.setup();
		
		mondo.players.put(c.name, new Player(mondo.players.get(nomeCreatore)) );	
		clients.add(c);
		
	}
	

	
	public ServerGameManager(Mondo mondo) {

		clients = new HashSet<>();
		this.mondo = new Mondo(mondo);
		for(Entry<String, Player> e : mondo.players.entrySet())
			nomeCreatore = e.getKey();
		
	}
	
	

	public void dispatchExceptThisClient(String message, ClientHandler c){
		if(c==null)
			for (ClientHandler cm : clients) {
				cm.dispatch(message);
			}
		else
		for(ClientHandler cm : clients){
			if(cm.name != c.name)
				cm.dispatch(message);
		}
	}
	

	public void start(){
		
		mondo.init();
		
		String start = mondo.startMapStatusToString();
		
		
		dispatchExceptThisClient("START", null);
//		System.out.print("INVIARE LO STATO ");
		dispatchExceptThisClient(start , null);
//		System.out.println(start);

		
		System.out.println("START inviato");
		
		for (ClientHandler c : clients) {
			new Thread(c,c.name).start();
		}
		
	}
		
	@Override
	public void run() {
		
	
		while (true) {

					
					
					if (mondo.isGameOver()) {
						dispatchExceptThisClient("GAME OVER", null);
						for (ClientHandler c : clients) {
							try {
								c.socket.close();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					
						
					}
					else {
					mondo.update();
					
					
					StringBuilder status = new StringBuilder();
					status.append(mondo.statusToString());
					
					
					status.append("#");

					if(mondo.nuovoLivello){
						status.append(true);
					
						mondo.nuovoLivello = false;
					}
					else
						status.append(false);
					
					
					
//					System.out.println("STATUS SERVERMANAGER "+status.toString());
					dispatchExceptThisClient(status.toString(), null);
					
					}
					
					try {
						Thread.sleep(80);
					} catch (final InterruptedException e) {
						// IGNORE
					}
				}
	
		
		
	
		
	}

	
	
	public void received(String comando) {
		
		String[] split = comando.split(":");
		

				
		
		
		Double dir = Double.valueOf(split[1]);
		if(dir!=-1) {
			mondo.players.get(split[0]).directionAngle = dir;
			mondo.players.get(split[0]).speedCurr = mondo.players.get(split[0]).speedMax;
		}
		else
			mondo.players.get(split[0]).speedCurr = 0;
		
		
		Integer changeArm = Integer.parseInt(split[2]);
		if(changeArm == -1)
			mondo.players.get(split[0]).selectArmaPrecedente();
		else if(changeArm == 1)
			mondo.players.get(split[0]).selectArmaSuccessiva();

		
		Boolean fire = Boolean.parseBoolean(split[3]);
		if(fire) {
			if ( mondo.shoot(split[0]) )
				dispatchExceptThisClient("SPARO:"+mondo.players.get(split[0]).selectArm, null);
			}
		
		
	}
	
	
};