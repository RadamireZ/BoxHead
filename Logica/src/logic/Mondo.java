package logic;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Random;

import java.util.Map.Entry;

import core.Editor;
import intelligenza.Grafo;
import intelligenza.Node;

public class Mondo {
	
	public Grafo grafo;
	public Map<String,Player> players;
	
	private ArrayList <Pacchetto> pacchi;
	public LinkedList<Zombie> zombies;
	
	public int numeroZombie;
	public boolean nuovoLivello;
	
	public ArrayList <Wall> porte;
	public Map<Integer, Queue<Zombie>> codaPorte;
	
	public ArrayList<Wall> oggettiFermi;
	
	public ArrayList<Wall> muriPerimetrali;
	public LinkedList<Proiettile> proiettili;
	
	private static final long TIME_TRA_LIVELLI=5000;
	
	private long timeIniziale;
	
	public boolean devonoEntrareNemici;
	
	private int numPacchettiMinimo; 
	
	private boolean startThread=false;
	
	public int width;
	
	public int height;

	
	public static final Arma ARMA1 = new Arma(25,8,600,45,1200,10,10);
	
	public static final Arma ARMA2 = new Arma(10,20,300,60,700,10,14);
	
	public static final Arma ARMA3 = new Arma(50,4,400,30,3000,10,18);


	
	public final static int HEALTH_ZOMBIE = 100;
	public final static double SPEED_ZOMBIE = 2;
	public final static int SCORE_ZOMBIE = 100;
	public final static int POWER_ZOMBIE = 1;
	public final static int RANGE_ZOMBIE = 18;
	
	public final static long TIMERIGENERATE_PLAYER = 30000;

	public boolean isEasy;
	
	
	
	public Mondo() {

		width=1;
		height=1;

		oggettiFermi = new ArrayList<Wall>();
			
		porte = new ArrayList<>();
		
		zombies = new LinkedList<>();

		players = new HashMap<String,Player>();
		
		pacchi = new ArrayList<Pacchetto>();

		muriPerimetrali = new ArrayList<Wall>();
		
		proiettili = new LinkedList<Proiettile>(); 
		
		
		timeIniziale = 0;
		

		codaPorte = new HashMap <Integer, Queue<Zombie> >();
		
		nuovoLivello = false;
		
		grafo = new Grafo();
		
	}
	
	
	public Mondo(Mondo mondo) {
		
		width = mondo.width;
		
		height = mondo.height;
		
		players = new HashMap<>();
		
		players.putAll(mondo.players);
		
		pacchi = new ArrayList <Pacchetto>() ;

		pacchi.addAll(mondo.getPacchi());
		
		zombies = new LinkedList<>();		
				
		porte = new ArrayList<>();
		
		porte.addAll(mondo.porte);
		
		codaPorte = new HashMap<Integer, Queue<Zombie> >();
		
		
		oggettiFermi = new ArrayList<>();
		
		oggettiFermi.addAll(mondo.oggettiFermi);
		
		
		muriPerimetrali = new ArrayList<>();
		
		muriPerimetrali.addAll(mondo.muriPerimetrali);
		
		
		proiettili = new LinkedList<>();
		
		timeIniziale = 0;
				
		
		nuovoLivello = false;

		isEasy = mondo.isEasy;
		
		grafo = new Grafo(mondo.grafo);
	}

	

	public void setDimensione(int x,int y){
		width=x;
		height=y;

	}

	public void clear(){
		nuovoLivello = false;

		oggettiFermi.clear();
		
		zombies.clear();
		
		porte.clear();
		
		players.clear();
		
		codaPorte.clear();
		
		getPacchi().clear();

		muriPerimetrali.clear();
		
		proiettili.clear();
		
		grafo.clear();
	}

	
	public void init() {	
		
		int area;
		
		if(width*height > Integer.MAX_VALUE || width*height <=0)
			area = Integer.MAX_VALUE;
		else
			area = width*height;
		
		numPacchettiMinimo  = area / 300000;
		
		System.out.println("Width "+width+" Height"+height+" numero Pacchetti minimo: "+numPacchettiMinimo);
		numeroZombie = 0;

		
		for (int i = 0; i < porte.size(); i++)
			codaPorte.put(i, new LinkedList<Zombie>());
		
		timeIniziale = System.currentTimeMillis();
		
		new Thread() {
			@Override
			public void run() {
				super.run();
				
				while(true) {
					
					
					if(startThread) {
						if(getPacchi().size()<numPacchettiMinimo)
							generaPacchettoRandom();

					startThread=false;	
					}
					try {
						Thread.sleep(50000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

			}
		}.start();
			
		initGrafo();
	}

	
	private synchronized void generaPacchettoRandom(){
		int i;
		
		Random r =new Random();
		i=r.nextInt(3)+1;


		Arma armaPacco = null;
		switch (i) {
		case 1:
			armaPacco= (ARMA1);
			break;
		case 2:
			armaPacco= (ARMA2);
			break;
		case 3:
			armaPacco= (ARMA3);
			break;


		}

		Vector2d pos = new Vector2d();
		Pacchetto nuovo = null;
		
		boolean collide=true;
		
		while(collide){
			
		
			collide=false;
			
			int x = r.nextInt(width-2*Editor.WIDTH_MURO-Editor.WIDTH_PACCHETTO)+Editor.WIDTH_MURO;
			int y = r.nextInt(height-2*Editor.HEIGHT_MURO-Editor.HEIGHT_PACCHETTO)+Editor.HEIGHT_MURO;
			
			pos.x = x;
			pos.y = y;
			
			nuovo = new Pacchetto(pos,Editor.WIDTH_PACCHETTO,Editor.HEIGHT_PACCHETTO,armaPacco);

			
			
			for (final Entry<String, Player> ps : players.entrySet()) {
				Player playertmp = ps.getValue();
			if(playertmp.collide(nuovo)) {
				collide=true;
			}
			}
			
			
			for(Wall w :oggettiFermi)
				if(nuovo.collide(w)){
					collide=true;
					break;
					}
					

			for(Pacchetto p :getPacchi())
				if(nuovo.collide(p) ){
					collide=true;
					break;
					}

			}			
			getPacchi().add(nuovo);

	}
	
	
	
	public synchronized ArrayList<Pacchetto> getPacchi(){
		return pacchi;
	}
	
	
	
	public boolean isGameOver(){
		for(Entry<String,Player> p : players.entrySet()){
			if(p.getValue().health<=0)
				return true;
		}
		return false;
	}


	public boolean canShoot(String nome){
		Player copy = new Player(players.get(nome) );
		
		Proiettile p = copy.spara(nome);
		
		if(p != null) 
			return true;
		
		return false;	
	}


	public boolean shoot(String nome) {
		Proiettile p = players.get(nome).spara(nome);
		if(p != null) {
			proiettili.add(p);
			return true;
		}
		return false;
	}

	private boolean rimaneConfiniMappa(AbstractDynamicObject o){
		
		if( (o.topLeft.x < Editor.WIDTH_MURO) ||
			(o.topRight.x < Editor.WIDTH_MURO) ||
			(o.bottomLeft.x < Editor.WIDTH_MURO) ||
			(o.bottomRight.x < Editor.WIDTH_MURO) ||
			(o.topLeft.x > width - Editor.WIDTH_MURO) ||
			(o.topRight.x > width - Editor.WIDTH_MURO) ||
			(o.bottomLeft.x > width - Editor.WIDTH_MURO) ||
			(o.bottomRight.x > width - Editor.WIDTH_MURO) ||
			(o.topLeft.y < Editor.HEIGHT_MURO) ||
			(o.topRight.y < Editor.HEIGHT_MURO) ||
			(o.bottomLeft.y < Editor.HEIGHT_MURO) ||
			(o.bottomRight.y < Editor.HEIGHT_MURO) ||
			(o.topLeft.y > height - Editor.HEIGHT_MURO) ||
			(o.topRight.y > height - Editor.HEIGHT_MURO) ||
			(o.bottomLeft.y > height - Editor.HEIGHT_MURO) ||
			(o.bottomRight.y > height - Editor.HEIGHT_MURO) )
			return false;
			
		return true;
	}
	
	
	public void update() {	

		startThread=true;
		
		for (final Entry<String, Player> ps : players.entrySet()) {
			Player player = ps.getValue();
	
		AbstractDynamicObject playerIniziale = new AbstractDynamicObject(player) {};

		player.update();
		
		boolean playerCollide =false;

		if(!rimaneConfiniMappa(player))
			playerCollide = true;


		for (int i = 0; i < oggettiFermi.size() && !playerCollide; i++)
			if(player.collide(oggettiFermi.get(i))) {
				playerCollide=true;
			}

		for (int i = 0; i < porte.size() && !playerCollide; i++) {
			if( codaPorte.get(i).peek() != null )
				if( codaPorte.get(i).peek().collide(player) ) {
					playerCollide=true;
				}
		}

		for (Iterator<Zombie> iterator = zombies.iterator(); iterator.hasNext() && !playerCollide;) {
			Zombie z = (Zombie) iterator.next();
				if(player.collide(z)) {
					playerCollide=true;
				}
		}

		
		
		if(playerCollide){
			player.topLeft = playerIniziale.topLeft;
			player.topRight = playerIniziale.topRight;
			player.bottomLeft = playerIniziale.bottomLeft;
			player.bottomRight = playerIniziale.bottomRight;
			player.centro = playerIniziale.centro;
			player.directionAngle = playerIniziale.directionAngle;
			player.orientationAngle = playerIniziale.orientationAngle;
			player.speedCurr = 0;
			}



		else{	//pacchetti se il player ci collide ne ottiene l'arma

		for (Iterator<Pacchetto> itpacc = getPacchi().iterator(); itpacc.hasNext();) {
				Pacchetto p = (Pacchetto) itpacc.next();
				if( player.collide(p)) {
					player.addArma(p.arma);
					itpacc.remove();
					}
		}


		}
		
		player.rigeneraHealt(System.currentTimeMillis());
		
}//end update player



		


	//update Zombie

	//nuovo Livello
	if( !zombies.isEmpty()  ){
		timeIniziale = System.currentTimeMillis();
		}
	else if( zombies.isEmpty()  )
		if (!devonoEntrareNemici)
		if (System.currentTimeMillis() > timeIniziale + TIME_TRA_LIVELLI) {  // fine livello
			devonoEntrareNemici = true;
			nuovoLivello = true;
			numeroZombie ++;
	
			int indicePorte = 0;
			
			for(int x= 0;x<numeroZombie;x++){
							
				Vector2d posizioneIniziale = new Vector2d();
				Wall p = porte.get(indicePorte);
				double angolo = 0;
				
				if(p.topLeft.x == 0){
					posizioneIniziale.y = p.topLeft.y;
					posizioneIniziale = posizioneIniziale.ruotaPunto(90*Math.PI/180,new Vector2d(posizioneIniziale.add(new Vector2d(Editor.HEIGHT_ZOMBIE/2,Editor.WIDTH_ZOMBIE/2))));
					posizioneIniziale.x = 0 - Editor.WIDTH_ZOMBIE;
					}
				else if(p.topLeft.x == width-Editor.WIDTH_MURO){
					posizioneIniziale.y = p.topLeft.y;
					posizioneIniziale = posizioneIniziale.ruotaPunto(90*Math.PI/180,new Vector2d(posizioneIniziale.add(new Vector2d(Editor.HEIGHT_ZOMBIE/2,Editor.WIDTH_ZOMBIE/2))));
					posizioneIniziale.x = width;
					angolo = 180;
					}
				else if(p.topLeft.y == 0){
					posizioneIniziale.x = p.topLeft.x;
					posizioneIniziale.y = 0 - Editor.HEIGHT_ZOMBIE;
					angolo = 90;
					}
				else if(p.topLeft.y == height - Editor.HEIGHT_MURO){
					posizioneIniziale.x = p.topLeft.x;
					posizioneIniziale.y = height ;
					angolo = 270;
					}
				Zombie z =null;
				if(isEasy){
					//add REFLECTION
					Class<?> c;
					try {
						c = Class.forName("plug_in.Zombie2");
						Constructor<?> constructor = c.getConstructor(logic.Vector2d.class,int.class,int.class,
							double.class, double.class, int.class, int.class, int.class, double.class,int.class);
						z = (Zombie) constructor.newInstance(posizioneIniziale, Editor.WIDTH_ZOMBIE, Editor.HEIGHT_ZOMBIE,
							angolo, SPEED_ZOMBIE,HEALTH_ZOMBIE,SCORE_ZOMBIE, POWER_ZOMBIE,RANGE_ZOMBIE,x);
						} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
								| InvocationTargetException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (NoSuchMethodException | SecurityException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (ClassNotFoundException e) {
						e.printStackTrace();
					}
				}
				else{
					z = new Zombie(posizioneIniziale, Editor.WIDTH_ZOMBIE, Editor.HEIGHT_ZOMBIE,
						angolo, SPEED_ZOMBIE,HEALTH_ZOMBIE,SCORE_ZOMBIE, POWER_ZOMBIE,RANGE_ZOMBIE,x);
				}

				z.grafo = new Grafo(grafo);
			
				codaPorte.get(indicePorte).add(z);

				indicePorte = (indicePorte+1) % porte.size();
			}	
	}
	
	if(devonoEntrareNemici) {
	
		devonoEntrareNemici=false;
		for (int i = 0; i < porte.size(); i++) {
			
			if( codaPorte.get(i).peek() != null ){
				devonoEntrareNemici = true;
		
				if(codaPorte.get(i).peek().speedCurr==0)
					codaPorte.get(i).peek().speedCurr = SPEED_ZOMBIE;				
	
				AbstractDynamicObject zombieCopy = new AbstractDynamicObject(codaPorte.get(i).peek()) {}; 
				
				boolean collide = false;
				
				codaPorte.get(i).peek().update();
	
				for (final Entry<String, Player> ps : players.entrySet()) {
					Player player = ps.getValue();
						
				if( codaPorte.get(i).peek().collide(player) )
					collide = true;
				
				}
				
				
				for (int j = 0; j < zombies.size() && !collide ; j++) 
						if(codaPorte.get(i).peek().collide(zombies.get(j)))
							collide = true; 
				
	
				if(collide){
					codaPorte.get(i).peek().topLeft = zombieCopy.topLeft;
					codaPorte.get(i).peek().topRight = zombieCopy.topRight;
					codaPorte.get(i).peek().bottomLeft = zombieCopy.bottomLeft;
					codaPorte.get(i).peek().bottomRight = zombieCopy.bottomRight;
					codaPorte.get(i).peek().centro = zombieCopy.centro;
					codaPorte.get(i).peek().speedCurr = 0;
					}
				
			
				else {
		if( (codaPorte.get(i).peek().directionAngle==0
				|| codaPorte.get(i).peek().directionAngle==180)
				&& ( codaPorte.get(i).peek().bottomLeft.x > Editor.WIDTH_PORTA+Editor.WIDTH_ZOMBIE  
				&& codaPorte.get(i).peek().topLeft.x < width - Editor.WIDTH_PORTA-Editor.WIDTH_ZOMBIE ) )
						zombies.add( (Zombie) codaPorte.get(i).poll() );
			
			
		
		else if( ( codaPorte.get(i).peek().directionAngle==270
				|| codaPorte.get(i).peek().directionAngle==90)
				&& ( (codaPorte.get(i).peek().topLeft.y > Editor.HEIGHT_PORTA+Editor.WIDTH_ZOMBIE) 
				&& (codaPorte.get(i).peek().bottomLeft.y < height - Editor.HEIGHT_PORTA-Editor.WIDTH_ZOMBIE ) ) )
						zombies.add( (Zombie) codaPorte.get(i).poll() );
			
				}
			}
		}			
	}

	
	////zombie in gioco
	for (Iterator<Zombie> it = zombies.iterator() ; it.hasNext(); ) {
		Zombie z = (Zombie) it.next();
			
			if(z.morto){
				it.remove();
				continue;
			}
		
		double distanzaMinima = Double.MAX_VALUE;
		Player target =null;
		for(Entry<String,Player> p : players.entrySet()){
			double d = p.getValue().centro.distanzaTraDuePunti(z.centro);
			
		if(distanzaMinima>d){
			distanzaMinima = d;
			target = p.getValue();
			}
		
		}
		
		z.grafo.clone(grafo);

		z.intelligenza(target, oggettiFermi, width, height);
			

		if(z.getAttack()){
			target.health -= z.getPower();
			target.timeLastDamage = System.currentTimeMillis();
		}
		
		z.update();
	}
	//end zombie




	// update proiettili unito a collision 

	boolean proiettileCollide =false;

	for (Iterator<Proiettile> iterator = proiettili.iterator(); iterator.hasNext();) {
		Proiettile proiettile = (Proiettile) iterator.next();
	
		Proiettile da = new Proiettile(proiettile);
		
		proiettile.update();
		
		ArrayList<Proiettile> arraiCollision = new ArrayList<>( da.spostamentoProiettile(proiettile) );
		
		proiettileCollide = false;
		
			for (Proiettile p : arraiCollision) {
				
				if(!rimaneConfiniMappa(p))
						proiettileCollide=true;
				
				
				//oggetti FERMI
				for (int i = 0; i < oggettiFermi.size() && !proiettileCollide; i++)
					if(p.collide(oggettiFermi.get(i)))
						proiettileCollide=true;
				
				//zombie
				for (Iterator<Zombie> it = zombies.iterator() ; it.hasNext() && !proiettileCollide;) {
					Zombie z = (Zombie) it.next();
					if(p.collide(z)){
						z.health -= p.danno;
						if(z.health <= 0){
							z.morto=true;
							players.get(p.appartenenza).addScore(z.score);
							}
				
						proiettileCollide=true;
					}
				}
				
				//players
				Iterator<?> it = players.entrySet().iterator();
				while( it.hasNext() && !proiettileCollide ) {
					Map.Entry<String, Player> pair = (Entry<String, Player>) it.next();
					if( !p.appartenenza.equals(pair.getKey()) && p.collide(pair.getValue()) )
							proiettileCollide=true;
				}
				
					
							
			}
			
				if( (proiettileCollide) || (proiettile.range==0) ){
					iterator.remove();
					break;
					}
				
	}//end update proiettili
	
	}


	private void initGrafo(){
		for (Wall o : oggettiFermi) {
			
			
		double diagonaleZombie = Math.sqrt(
			Math.pow(Editor.WIDTH_ZOMBIE,2)+Math.pow(Editor.HEIGHT_ZOMBIE,2));
			
		Vector2d a = new Vector2d(o.topLeft.x-diagonaleZombie/2,o.topLeft.y-diagonaleZombie/2);
		Vector2d b = new Vector2d(o.topRight.x+diagonaleZombie/2,o.topRight.y-diagonaleZombie/2);
		Vector2d c = new Vector2d(o.bottomLeft.x-diagonaleZombie/2,o.bottomLeft.y+diagonaleZombie/2);
		Vector2d d = new Vector2d(o.bottomRight.x+diagonaleZombie/2,o.bottomRight.y+diagonaleZombie/2);
				
		grafo.addNewNode(a);
		grafo.addNewNode(b);
		grafo.addNewNode(c);
		grafo.addNewNode(d);
				
		}
		Vector2d centro,topRect;
		
		for (Entry<Vector2d, HashSet<Node>> v1 : grafo.map.entrySet()) {
			for (Entry<Vector2d, HashSet<Node>> v2 : grafo.map.entrySet()) {
				Vector2d n1 = v1.getKey();
				Vector2d n2 = v2.getKey();
				
				if(!n1.equals(n2)){
						
				centro = new Vector2d((n1.x+n2.x)/2,(n1.y+n2.y)/2);

				double dist = n1.distanzaTraDuePunti(n2);
				topRect = new Vector2d(centro.x-Editor.WIDTH_ZOMBIE/2,centro.y-dist/2);
					
				double angolo = (new Vector2d(n1.x-n2.x, n1.y-n2.y)).angolo();
					
				AbstractDynamicObject z = new AbstractDynamicObject
					(topRect,Editor.WIDTH_ZOMBIE,(int) dist,angolo,1) {};
					
				boolean aggiungilo = true;
				
				if(!rimaneConfiniMappa(z))
					aggiungilo=false;
				
		for (Iterator<Wall> iterator = oggettiFermi.iterator(); iterator.hasNext()&&aggiungilo;) {
			Wall w = (Wall) iterator.next();
					if(w.collide(z))
						aggiungilo=false;
			}
				
		if(aggiungilo)
			grafo.addArco(n1,n2);
				}
			}
		}

	}


	public void parseStatusFromString(String status){
			
			final String[] elements = status.split("#");
					
			final String[] gamers = elements[0].split("/");
			final String[] boxs = elements[1].split("/");
			final String[] bullets = elements[2].split("/");	
			final String[] enemiesIn = elements[3].split("/");
			final String[] enemiesOut = elements[4].split("/");
			
	
			
			players.clear();
			for (final String s : gamers) {
	
			final String[] split = s.split(":");
			players.put(split[26], new Player(
			new Vector2d(Double.parseDouble(split[0]),Double.parseDouble(split[1])),
			new Vector2d(Double.parseDouble(split[4]),Double.parseDouble(split[5])),
			new Vector2d(Double.parseDouble(split[6]),Double.parseDouble(split[7])),
			new Vector2d(Double.parseDouble(split[8]),Double.parseDouble(split[9])),
			new Vector2d(Double.parseDouble(split[10]),Double.parseDouble(split[11])),
			Integer.parseInt(split[2]), Integer.parseInt(split[3]),
			Double.parseDouble(split[12]), Double.parseDouble(split[13]), Double.parseDouble(split[14]),
			Double.parseDouble(split[15]), Integer.parseInt(split[16]), Integer.parseInt(split[17]),
			Integer.parseInt(split[18]), Integer.parseInt(split[19]), Integer.parseInt(split[20]),
			Integer.parseInt(split[21]), Long.parseLong(split[22]),Long.parseLong(split[23]),
			Long.parseLong(split[24]), Long.parseLong(split[25])) );
			
	
			}
			
			getPacchi().clear();
			if ( !boxs[0].equals("_") )
			for (final String s : boxs) {
				final String[] split = s.split(":");
				Pacchetto p = new Pacchetto(new Vector2d(Double.parseDouble(split[0]),Double.parseDouble(split[1])),
					Integer.parseInt(split[2]), Integer.parseInt(split[3]), ARMA3);
				int arma = Integer.parseInt(split[4]);
				if(arma==1)
					p.arma=ARMA1;
				else if(arma==2)
					p.arma=ARMA2;
				getPacchi().add( p );
				
	
			}
			
			proiettili.clear();
			if ( !bullets[0].equals("_") )
			for (final String s : bullets) {
				final String[] split = s.split(":");
				proiettili.add(new Proiettile(
				new Vector2d(Double.parseDouble(split[0]),Double.parseDouble(split[1])),
				new Vector2d(Double.parseDouble(split[4]),Double.parseDouble(split[5])),
				new Vector2d(Double.parseDouble(split[6]),Double.parseDouble(split[7])),
				new Vector2d(Double.parseDouble(split[8]),Double.parseDouble(split[9])),
				new Vector2d(Double.parseDouble(split[10]),Double.parseDouble(split[11])),
				Integer.parseInt(split[2]) , Integer.parseInt(split[3]) ,
				Double.parseDouble(split[12]),Double.parseDouble(split[13]),
				Double.parseDouble(split[14]),Double.parseDouble(split[15]),Double.parseDouble(split[16]),
				Integer.parseInt(split[17]) , split[18] ) );
				
	
				}
			
			for(int i=0;i<porte.size();i++){
					codaPorte.get(i).clear();
				}
	
			if( !enemiesIn[0].equals("_") ) {
	
			for (final String s : enemiesIn){
				final String[] split = s.split(":");
				
			
				codaPorte.get( Integer.parseInt(split[23]) ).offer(new Zombie(
				new Vector2d(Double.parseDouble(split[0]),Double.parseDouble(split[1])),
				new Vector2d(Double.parseDouble(split[4]),Double.parseDouble(split[5])),
				new Vector2d(Double.parseDouble(split[6]),Double.parseDouble(split[7])),
				new Vector2d(Double.parseDouble(split[8]),Double.parseDouble(split[9])),
				new Vector2d(Double.parseDouble(split[10]),Double.parseDouble(split[11])),
				Integer.parseInt(split[2]),Integer.parseInt(split[3]),
				Double.parseDouble(split[12]),Double.parseDouble(split[13]),Double.parseDouble(split[14]),
				Double.parseDouble(split[15]), Integer.valueOf(split[16]),Integer.valueOf(split[17]),
				Integer.valueOf(split[18]), Double.parseDouble(split[19]), Boolean.parseBoolean(split[20]),
				Boolean.parseBoolean(split[21]),Integer.parseInt(split[22]) ) ) ;
				
	
				}
			}
	
			zombies.clear();
			
			if( !enemiesOut[0].equals("_") ){
			for (final String s : enemiesOut){
				final String[] split = s.split(":");
				zombies.add(new Zombie(
					new Vector2d(Double.parseDouble(split[0]),Double.parseDouble(split[1])),
					new Vector2d(Double.parseDouble(split[4]),Double.parseDouble(split[5])),
					new Vector2d(Double.parseDouble(split[6]),Double.parseDouble(split[7])),
					new Vector2d(Double.parseDouble(split[8]),Double.parseDouble(split[9])),
					new Vector2d(Double.parseDouble(split[10]),Double.parseDouble(split[11])),
					Integer.parseInt(split[2]),Integer.parseInt(split[3]),
					Double.parseDouble(split[12]),Double.parseDouble(split[13]),Double.parseDouble(split[14]),
					Double.parseDouble(split[15]), Integer.valueOf(split[16]),Integer.valueOf(split[17]),
					Integer.valueOf(split[18]), Double.parseDouble(split[19]), Boolean.parseBoolean(split[20]),
					Boolean.parseBoolean(split[21]),Integer.parseInt(split[22]) ) ) ;
			}
			}
			
			numeroZombie = Integer.parseInt(elements[5]);
			devonoEntrareNemici = Boolean.parseBoolean(elements[6]);
	
				
				
				
				nuovoLivello = Boolean.parseBoolean(elements[7]);
		}


	public String statusToString(){
		
		StringBuilder sb = new StringBuilder();
		
		for(Entry<String, Player> p : players.entrySet()){
			sb.append( p.getValue().statusToStringBuilder() );
			sb.append(":");
			sb.append(p.getKey());
			sb.append("/");
		}
	
		
		
		sb.append("#");
		if(getPacchi().isEmpty())
			sb.append("_");
		else {
		for(Pacchetto p : getPacchi()){
			sb.append( p.statusToStringBuilder() );
			sb.append("/");
			}
		}
		
		
		
		sb.append("#");
		
		if(proiettili.isEmpty())
			sb.append("_");
		else {
		for(Proiettile p : proiettili){
			sb.append( p.statusToStringBuilder() );
			sb.append("/");
			}
		}
		
		
		sb.append("#");
		boolean codaVuota=true;
		for(Entry<Integer, Queue<Zombie>> cp : codaPorte.entrySet()){
			if(!codaPorte.get( cp.getKey() ).isEmpty())
				codaVuota=false;
		}
		if(codaVuota)
			sb.append("_");
		else{
			for(Entry<Integer, Queue<Zombie>> cp : codaPorte.entrySet()){
				for(Zombie z : cp.getValue()){
					sb.append( z.statusToStringBuilder() );
					sb.append(":");
					sb.append(cp.getKey());
					sb.append("/");
				}
			}
		}
		
		
		sb.append("#");
		if(zombies.isEmpty())
			sb.append("_");
		else{
			for(Zombie z : zombies){
				sb.append( z.statusToStringBuilder() );
				sb.append("/");	
			}
		}
		
	
		sb.append("#");
		
		sb.append(numeroZombie);
		
		sb.append("#");
		
		sb.append(devonoEntrareNemici);
				
	
	
		return sb.toString();
	}


	public String startMapStatusToString(){
	
	StringBuilder sb = new StringBuilder();
	
		sb.append(width);
		
		sb.append("#");
		
		
		sb.append(height);
	
		sb.append("#");
		
		
		for(Wall w : muriPerimetrali){
			sb.append( w.statusToStringBuilder() );
			sb.append("/");
		}
		
		
		sb.append("#");
		
		for(Wall p : porte){
			sb.append( p.statusToStringBuilder() );
			sb.append("/");
		}
		
		
		sb.append("#");
	
		
	
		
		if(oggettiFermi.isEmpty())
			sb.append("_");
		else{
			for(Wall w : oggettiFermi){
				sb.append( w.statusToStringBuilder() );
				sb.append("/");	
			}
		}
		
		sb.append("#");
		
		for(Entry<String, Player> p : players.entrySet()){
			sb.append( p.getValue().statusToStringBuilder() );
			sb.append(":");
			sb.append(p.getKey());
			sb.append("/");
		}
		
		sb.append("#");
		if(getPacchi().isEmpty())
			sb.append("_");
		else{
		for(Pacchetto p : getPacchi()){
			sb.append(p.statusToStringBuilder());
			sb.append("/");
			}
		}
	
		sb.append("#");
		
		sb.append(isEasy);
		
		return sb.toString();
	}


	public void parseStartMapStatusFromString(String status){
		clear();
		
		final String[] elements = status.split("#");
		final String[] muri = elements[2].split("/");
		final String[] doors = elements[3].split("/");
		final String[] statics = elements[4].split("/");
		final String[] gamers = elements[5].split("/");
		final String[] boxs = elements[6].split("/");
		
		width = Integer.parseInt(elements[0]);
		
		height = Integer.parseInt(elements[1]);
		
		
		
		
		for (final String s : muri) {		
		final String[] split = s.split(":");
			muriPerimetrali.add( new Wall(
				new Vector2d(Double.parseDouble(split[0]),Double.parseDouble(split[1])),
				Integer.parseInt(split[2]), Integer.parseInt(split[3]), (split[4].toString()) ) );
		}
		
		
		for (int i=0;i<doors.length;i++) {		
		final String[] split = doors[i].split(":");
			porte.add( new Wall(
				new Vector2d(Double.parseDouble(split[0]),Double.parseDouble(split[1])),
				Integer.parseInt(split[2]), Integer.parseInt(split[3]), (split[4])) );
			
			codaPorte.put(i, new LinkedList<Zombie>());
		}
		
		if ( !statics[0].equals("_") )
		for (final String s : statics) {
			final String[] split = s.split(":");
			oggettiFermi.add( new Wall(
				new Vector2d(Double.parseDouble(split[0]),Double.parseDouble(split[1])),
				Integer.parseInt(split[2]), Integer.parseInt(split[3]), (split[4])) );
			System.out.println("INSERT "+split[4]);
		}
	
		
		for (final String s : gamers) {
			
		final String[] split = s.split(":");
		players.put(split[26], new Player(
		new Vector2d(Double.parseDouble(split[0]),Double.parseDouble(split[1])),
		new Vector2d(Double.parseDouble(split[4]),Double.parseDouble(split[5])),
		new Vector2d(Double.parseDouble(split[6]),Double.parseDouble(split[7])),
		new Vector2d(Double.parseDouble(split[8]),Double.parseDouble(split[9])),
		new Vector2d(Double.parseDouble(split[10]),Double.parseDouble(split[11])),
		Integer.parseInt(split[2]), Integer.parseInt(split[3]),
		Double.valueOf(split[12]),Double.valueOf(split[13]), Double.valueOf(split[14]),
		Double.valueOf(split[15]), Integer.parseInt(split[16]), Integer.parseInt(split[17]),
		Integer.parseInt(split[18]), Integer.parseInt(split[19]), Integer.parseInt(split[20]),
		Integer.parseInt(split[21]), Long.parseLong(split[22]),Long.parseLong(split[23]),
		Long.parseLong(split[24]), Long.parseLong(split[25])) );
		
		}
		
		if ( !statics[0].equals("_") )
		for (final String s : statics) {
			final String[] split = s.split(":");
			oggettiFermi.add( new Wall(
				new Vector2d(Double.parseDouble(split[0]),Double.parseDouble(split[1])),
				Integer.parseInt(split[2]), Integer.parseInt(split[3]), split[4]) );
		}
	
		if ( !boxs[0].equals("_") )
		for (final String s : boxs) {
			final String[] split = s.split(":");
			Pacchetto p = new Pacchetto(new Vector2d(Double.parseDouble(split[0]),Double.parseDouble(split[1])),
			Integer.parseInt(split[2]), Integer.parseInt(split[3]), ARMA3 );
			int arma = Integer.parseInt(split[4]);
			if(arma==1)
				p.arma=ARMA1;
			else if(arma==2)
				p.arma=ARMA2;
			getPacchi().add( p );
			
	
		}
		
		isEasy = Boolean.parseBoolean(elements[7]);
	
	}
	
	
};