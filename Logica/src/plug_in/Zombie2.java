package plug_in;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import core.Editor;
import intelligenza.Grafo;
import logic.Player;
import logic.Vector2d;
import logic.Wall;
import logic.Zombie;

public class Zombie2 extends Zombie {


	boolean raggiunto;
	private Player meta = null;
	private Random r;

	public Zombie2(Vector2d posizioneIniziale, int widthZombie, int heightZombie, double directionAngle,
			double speedMax, int health, int score, int power, double range,int id) {
		
		super(posizioneIniziale, widthZombie, heightZombie, directionAngle, speedMax, health, score,power,range,id);
		
		raggiunto = true;
		attack = false;
		morto = false;
		r = new Random();
		
	}
	

	
	public Zombie2(Vector2d topLeft, Vector2d topRight, Vector2d bottomLeft, Vector2d bottomRight,
		Vector2d centro,int width, int height, double directionAngle, double orientationAngle,
		double speedMax, double speedCurr, int health , int score, int power, double range,
		boolean attack, boolean morto,int id) {
		
		super(topLeft, topRight, bottomLeft, bottomRight, centro, width, height, directionAngle,
			orientationAngle, speedMax, speedCurr, health, score,power,range,attack,morto,id);
		raggiunto = true;
		r = new Random();
		}
	
	public Zombie2(Zombie2 z) {
		super(z);
		raggiunto = true;

		r = new Random();
	}



	public Zombie2 viewAhead(double r) {
		Zombie2 d = new Zombie2(this);
		
		d.topLeft = (new Vector2d(directionAngle).multiply(r)).add(this.topLeft) ;
		d.topRight = (new Vector2d(directionAngle).multiply(r)).add(this.topRight) ;
		
		return d;
	}

	
	@Override
	public void intelligenza(Player target, ArrayList<Wall> oggettiFermi,int widthMondo,int heightMondo) {
		
		boolean random=true;
		int rangeSeek = 250;
		
	if( (target.centro.x >= this.centro.x-rangeSeek) && (target.centro.x <= this.centro.x+rangeSeek) 
		&& (target.centro.y >= this.centro.y-rangeSeek) && (target.centro.y <= this.centro.y+rangeSeek)) {
			
			

			boolean nessunOstacolo = true;
			double distanza = target.centro.distanzaTraDuePunti(centro);

			Zombie copy = new Zombie(this);

			if(!attack(target)){

				copy.seekExecute(target.centro);
				
				nessunOstacolo = true;
				
				
				copy.rotate();
				copy = copy.viewAhead(distanza);
				
				
			for(Iterator<Wall> it2=oggettiFermi.iterator();it2.hasNext() && nessunOstacolo;){
				Wall o = (Wall) it2.next();
				
				if( copy.collide(o) )
					nessunOstacolo=false;
			}

			if(nessunOstacolo) {
				seekExecute(target.centro);
				random=false;
//				System.out.println("INSEGUE PLAYER "+id);
			}
			
			}
			
			else if(attack) {
				speedCurr=0;
				random=false;
			}
		
		}
		
		if (random){
			if(raggiunto){
				boolean collision = true;
				Grafo grafoCopia = new Grafo(grafo);
				while(collision){
					collision= false;
					int xr = r.nextInt(widthMondo-Editor.WIDTH_MURO-Editor.WIDTH_ZOMBIE) + Editor.WIDTH_MURO+Editor.HEIGHT_ZOMBIE;
					int yr = r.nextInt(heightMondo-Editor.HEIGHT_MURO-Editor.WIDTH_ZOMBIE) + Editor.HEIGHT_MURO+Editor.HEIGHT_ZOMBIE;
					meta = new Player(new Vector2d(xr,yr),2,2, 0, 0);
//					System.out.println("GENERA META "+id +xr +" : "+yr);
					
					for(Wall w : oggettiFermi){
						if(w.collide(meta))
							collision=true;
					}
					grafoCopia.addEntityInGraph(0, meta.centro, oggettiFermi, widthMondo, heightMondo);
					grafoCopia.addEntityInGraph(4, centro, oggettiFermi, widthMondo, heightMondo);
					Vector2d prossimoNodo = grafoCopia.aStarFirstNode(0);
						if(prossimoNodo!=null)
							break;
						else {
							grafoCopia = new Grafo(grafo);						
							collision=true;
						}
					}
				raggiunto = false;

				}
			if(!raggiunto){
//				System.out.println("SEGUE META "+id);
				boolean nessunOstacolo = true;
				double distanza = meta.centro.distanzaTraDuePunti(centro);
				Zombie copy = new Zombie(this);
				
					copy.seekExecute(meta.centro);
					
					nessunOstacolo = true;
					
					
					copy.rotate();
					copy = copy.viewAhead(distanza);
					
				for(Iterator<Wall> it2=oggettiFermi.iterator();it2.hasNext() && nessunOstacolo;){
					Wall o = (Wall) it2.next();
					
					if( copy.collide(o) )
						nessunOstacolo=false;
				}

				if(nessunOstacolo) {
					seekExecute(meta.centro);
//					System.out.println("SEGUE META NESSUN OSTACOLO");
				}
				else{
					grafo.addEntityInGraph(0, meta.centro, oggettiFermi, widthMondo, heightMondo);
					grafo.addEntityInGraph(4, centro, oggettiFermi, widthMondo, heightMondo);
					Vector2d prossimoNodo = grafo.aStarFirstNode(0);
					seekExecute(prossimoNodo);
//					System.out.println("SEGUE META A*");
				}
			
				
				if ( this.collide(meta) )
					raggiunto = true;
			}
		}
	}

	
};