package logic;

import java.util.ArrayList;
import java.util.Iterator;
import intelligenza.Grafo;
import logic.Vector2d;


public class Zombie extends AbstractCharacter {


	public Grafo grafo;

	public int id;
	
	private int power;
	
	protected double range;
	
	protected boolean attack;
	
	public boolean morto;

	

	public Zombie(Vector2d posizioneIniziale, int widthZombie, int heightZombie, double directionAngle,
			double speedMax, int health, int score, int power, double range,int id) {
		
		super(posizioneIniziale, widthZombie, heightZombie, directionAngle, speedMax, health, score);
		

		this.power = power;
		this.range = range;
		attack = false;
		morto = false;
		this.id = id;
		grafo = new Grafo();
	}
	
	public Zombie(Vector2d topLeft, Vector2d topRight, Vector2d bottomLeft, Vector2d bottomRight,
		Vector2d centro,int width, int height, double directionAngle, double orientationAngle,
		double speedMax, double speedCurr, int health , int score, int power, double range,
		boolean attack, boolean morto,int id) {
		
		super(topLeft, topRight, bottomLeft, bottomRight, centro, width, height, directionAngle,
			orientationAngle, speedMax, speedCurr, health, score);
		
		this.power = power;
		this.range = range;
		this.attack = attack;
		this.morto = morto;
		this.id = id;
		grafo = new Grafo();
		}
		
	
	public Zombie(Zombie z) {
		super(z);
		this.id = z.id;
		this.power = z.power;
		
		this.range = z.range;
		
		this.attack = z.attack;
		
		this.morto = z.morto;
		
		grafo = new Grafo(z.grafo);
	}



	public Zombie viewAhead(double r) {
		Zombie d = new Zombie(this);
		
		d.topLeft = (new Vector2d(directionAngle).multiply(r)).add(this.topLeft) ;
		d.topRight = (new Vector2d(directionAngle).multiply(r)).add(this.topRight) ;
		
		return d;
	}
		
	
	public void seekExecute(Vector2d player) {
		Vector2d desiredVelocity = (this.centro.edge(player)).normalize().multiply(speedMax);
		
		speedCurr = desiredVelocity.modulo();		
		
		directionAngle = desiredVelocity.angolo();
	}

	public boolean attack(AbstractDynamicObject player) {
		if(viewAhead(range).collide(player)) {
			attack=true;
			return true;
			}
		attack = false;
		return false;
	}
		
	
	@Override
	public String toString() {
		return "ZOMBIE";
		
	}
	
	
	public void update() {
		
		if(speedCurr>0)	{
			rotate();
				translate( new Vector2d(directionAngle).multiply(speedCurr) );
		}
		
	}
	
	
	public void intelligenza(Player target, ArrayList<Wall> oggettiFermi,int widthMondo,int heightMondo) {
		
		boolean nessunOstacolo = true;
		double distanza = target.centro.distanzaTraDuePunti(centro);

		Zombie view = new Zombie(this);
		
		if(!attack(target)){

			view.seekExecute(target.centro);
			
			nessunOstacolo = true;

			view.rotate();
			view = view.viewAhead(distanza);
						
		for(Iterator<Wall> it2=oggettiFermi.iterator();it2.hasNext() && nessunOstacolo;){
			Wall o = (Wall) it2.next();
			
			if( view.collide(o) )
				nessunOstacolo=false;
		}

		if(nessunOstacolo) {

			seekExecute(target.centro);
			
		}
		else{
			grafo.addEntityInGraph(0, target.topLeft, oggettiFermi, widthMondo, heightMondo);
			grafo.addEntityInGraph(1, target.topRight, oggettiFermi, widthMondo, heightMondo);
			grafo.addEntityInGraph(2, target.bottomLeft, oggettiFermi, widthMondo, heightMondo);
			grafo.addEntityInGraph(3, target.bottomRight, oggettiFermi, widthMondo, heightMondo);

			grafo.addEntityInGraph(4, centro, oggettiFermi, widthMondo, heightMondo);
			
			for(int i=0;i<4;i++) {
			Vector2d prossimoNodo = grafo.aStarFirstNode(i);
				if(prossimoNodo!=null){//if serve solo per il break
					seekExecute(prossimoNodo);
					break;
				}
			}
		}
	
		}
		else if(attack)
			speedCurr=0;

	}

	public boolean getAttack() {
		return attack;
	}

	public int getPower() {
		return power;
	}

	public StringBuilder statusToStringBuilder(){
		
		StringBuilder sb = new StringBuilder();
		
		sb.append( super.statusToStringBuilder() );
		
		sb.append(":");
		
		sb.append(power);
		
		sb.append(":");
		
		sb.append(range);
		
		sb.append(":");
		
		sb.append(attack);
		
		sb.append(":");
		
		sb.append(morto);
	
		sb.append(":");
		
		sb.append(id);
		
		return sb;
		
	}

	
};	