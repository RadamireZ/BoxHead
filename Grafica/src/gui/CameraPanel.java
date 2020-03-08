package gui;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Line2D;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ListIterator;
import java.util.Map.Entry;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import core.Editor;
import logic.AbstractStaticObject;
import logic.Mondo;
import logic.Pacchetto;
import logic.Player;
import logic.Vector2d;
import logic.Wall;
import logic.Zombie;

import java.sql.*;


public class CameraPanel extends JPanel implements MouseListener{
	
	private Vector2d topLeft;
	

	private Mondo mondo;
	

	private MatriceCam matrix;
	
	private ImageProvider provider;
	
	private volatile boolean north;
	private volatile boolean east;
	private volatile boolean south;
	private volatile boolean west;
	private volatile boolean shoot;
	private volatile boolean successiva;
	private volatile boolean precedente;
	
	private volatile boolean pausa;

	private boolean running;
	

	public final static int PERIOD = 100;
	private final static int PWIDTH = 1200;
	private final static int PHEIGHT = 700;
	
	private Rectangle vita;
	private Rectangle infoArma;
	private Rectangle infoEnemy;

	
	
	private HashMap<String,PlayerSprite> spritesPlayer;
	
	private HashMap<Integer,EnemySprite> spritesZombie;

	
	private ArrayList<EnemySprite> mortiZombie;

	public int stato;
	private PanelSwitcher switcher;
	
	private int distanzaX,distanzaY;
	
	private ArrayList<ClipInfo> clips;
	
	private ArrayList<AbstractStaticObject> ordineStampa;

	public String protagonista;
	
	
	
	
public CameraPanel() {
	 super();
	 
	 this.setBackground(Color.GRAY);
	 setPreferredSize(new Dimension(PWIDTH, PHEIGHT));
	 
	 spritesZombie = new HashMap<>();

	 
	 mortiZombie = new ArrayList<>();
	 

	 ordineStampa = new ArrayList<>();
	 
	 
	 spritesPlayer = new HashMap<>();
	
	 
		 distanzaX = ((PWIDTH - MatriceCam.MWIDTH) /2);
		 distanzaY = ((PHEIGHT - MatriceCam.MHEIGHT) /2);
		 
	 setKeyBindings();
	addMouseListener(this);
		
clips = new ArrayList<>();
	clips.add(new ClipInfo("Raligun.wav"));
	 clips.add(new ClipInfo("UZI.wav"));
		 clips.add(new ClipInfo("Shotgun.wav")); 
	 
	 pausa=false;	
		
		stato = 0;
}
	
	
	

	public void start(MainFrame f) {

		this.mondo = f.mondo ;
			running = true;
			pausa = false;
		 setFocusable(true);
		 requestFocus();
		 this.switcher = f;
		 this.provider = f.provider;
		 
		 stato=1;

	
		
		 for(Entry<String,Player> p : mondo.players.entrySet()){
			 spritesPlayer.put(p.getKey(), new PlayerSprite(provider));			 
		 }
		 

		 
		 matrix = new MatriceCam(mondo.players.get(protagonista));
		 

		 
		topLeft = new Vector2d();
		
			topLeft.x = matrix.topLeft.x - distanzaX;
			topLeft.y = matrix.topLeft.y - distanzaY;


			
		if( topLeft.x < 0 )
			topLeft.x = 0;

				
		if( topLeft.y < 0 )
			topLeft.y = 0;
			

		if( matrix.topLeft.x < topLeft.x )
			matrix.topLeft.x = mondo.players.get(protagonista).topLeft.x;


		if( matrix.topLeft.y < topLeft.y )
			matrix.topLeft.y = mondo.players.get(protagonista).topLeft.y;	

			

		
	vita = new Rectangle(PWIDTH/8, PHEIGHT-40, 200, 30);
	infoArma = new Rectangle(PWIDTH/8-50, PHEIGHT-30, 40, 20);
	infoEnemy = new Rectangle((int) (PWIDTH/8+vita.getWidth() + 10), PHEIGHT-30, 30,20);
	


		

	
	new Thread() {
		public void run(){
			while(running){
				if(!pausa){
					
//				mondo.players.get(protagonista).speedCurr = mondo.players.get(protagonista).speedMax;

					
					
				if(north && west && !south && !east){
					mondo.players.get(protagonista).directionAngle=225;	
//					System.out.println("PLAYER NORD WEST");
					mondo.players.get(protagonista).speedCurr = mondo.players.get(protagonista).speedMax;

				}
				else if(north && east && !south && !west){
					mondo.players.get(protagonista).directionAngle=315;
//					System.out.println("PLAYER NORD EST");
					mondo.players.get(protagonista).speedCurr = mondo.players.get(protagonista).speedMax;
	
				}
				else if(south && east && !north && !west){
					mondo.players.get(protagonista).directionAngle=45;
//					System.out.println("PLAYER SUD EST");
					mondo.players.get(protagonista).speedCurr = mondo.players.get(protagonista).speedMax;

				}
				else if(south && west && !north && !east){
					mondo.players.get(protagonista).directionAngle=135;
//					System.out.println("PLAYER SUD WEST");					
					mondo.players.get(protagonista).speedCurr = mondo.players.get(protagonista).speedMax;

				}
				else if(north && !west && !east && !south){
					mondo.players.get(protagonista).directionAngle=270;
//					System.out.println("PLAYER NORD");
					mondo.players.get(protagonista).speedCurr = mondo.players.get(protagonista).speedMax;

				}
				else if(south && !west && !east && !north){
					mondo.players.get(protagonista).directionAngle=90;
//					System.out.println("PLAYER SUD");
					mondo.players.get(protagonista).speedCurr = mondo.players.get(protagonista).speedMax;

				}
				else if(east && !north && !south && !west){
					mondo.players.get(protagonista).directionAngle=0;
//					System.out.println("PLAYER EST");
					mondo.players.get(protagonista).speedCurr = mondo.players.get(protagonista).speedMax;

				}
				else if(west && !north && !south && !east){
					mondo.players.get(protagonista).directionAngle=180;
//					System.out.println("PLAYER WEST");
					mondo.players.get(protagonista).speedCurr = mondo.players.get(protagonista).speedMax;
					
				}
				else
					mondo.players.get(protagonista).speedCurr = 0;
					
				
				if(successiva && !precedente){
					mondo.players.get(protagonista).selectArmaSuccessiva();
					successiva=false;
				}
				
				else if(precedente && !successiva){
					mondo.players.get(protagonista).selectArmaPrecedente();
					precedente=false;
				}
				
				if(shoot){
					if(mondo.canShoot(protagonista)) {
						soundSparo( mondo.players.get(protagonista).selectArm );
						mondo.shoot(protagonista);
						}
				}

//		System.out.println("SPEED CURR PLAYER "+mondo.players.get(protagonista).speedCurr);		
				mondo.update();

				if(mondo.isGameOver()){
					stopGame();
					System.out.println("GAME OVER");
				}
				
				update();
				
				
				repaint();

				}
				
				try {
					Thread.sleep(PERIOD);
				} catch (final InterruptedException e) {
					// ignore
				}
			}
		}
	}.start();
		
	}

	
public void startNetwork(MainFrame f) {
		

	this.mondo = f.mondo ;
		running = true;
	 setFocusable(true);
	 requestFocus();
	 this.switcher = f;
	 this.provider = f.provider;
	 
	 stato=1;


	
	 for(Entry<String,Player> p : mondo.players.entrySet()) {
		 spritesPlayer.put( p.getKey() , new PlayerSprite(provider));	 
	 }
	 
	 
	 
	 matrix = new MatriceCam(mondo.players.get(protagonista));
	 

	 
	topLeft = new Vector2d();
	
		topLeft.x = matrix.topLeft.x - distanzaX;
		topLeft.y = matrix.topLeft.y - distanzaY;


		
	if( topLeft.x < 0 )
		topLeft.x = 0;

			
	if( topLeft.y < 0 )
		topLeft.y = 0;
		

	if( matrix.topLeft.x < topLeft.x )
		matrix.topLeft.x = mondo.players.get(protagonista).topLeft.x;


	if( matrix.topLeft.y < topLeft.y )
		matrix.topLeft.y = mondo.players.get(protagonista).topLeft.y;	

		

	
vita = new Rectangle(PWIDTH/8, PHEIGHT-40, 200, 30);
infoArma = new Rectangle(PWIDTH/8-50, PHEIGHT-30, 40, 20);
infoEnemy = new Rectangle((int) (PWIDTH/8+vita.getWidth() + 10), PHEIGHT-30, 30,20);





	}

		
public String gestoreEventi() {

			resumeGame();
	
					
					StringBuilder sb =new StringBuilder();

				sb.append(protagonista);
				sb.append(":");
					
				if(north && west && !south && !east){
					sb.append(225);

				}
				
				else if(north && east && !south && !west){
					sb.append(315);
				}
				
				else if(south && east && !north && !west){
					sb.append(45);
				}
				
				else if(south && west && !north && !east){
					sb.append(135);
				}
				
				else if(north && !west && !east && !south){
					sb.append(270);
				}
				
				else if(south && !west && !east && !north){
					sb.append(90);
				}
				
				else if(east && !north && !south && !west){
					sb.append(0);
				}
				
				else if(west && !north && !south && !east){
					sb.append(180);
				}
				

				
				else { 
					sb.append(-1);
				}
				
				sb.append(":");

				
				if(successiva && !precedente){
					sb.append(1);
				
					successiva=false;
				}
				
				else if(precedente && !successiva){
					sb.append(-1);
					
					precedente=false;
				}
				else
					sb.append(0);

				sb.append(":");

				if(shoot){
					sb.append(true);
					}
				else
					sb.append(false);				
				

						
			return sb.toString();
	}	
	

public void soundSparo(int select) {
	if( select!=-1 ) {
		clips.get( select-1 ).stop();
		clips.get( select-1 ).play();
		
		}
}
	

private Vector2d puntoPiuAlto(AbstractStaticObject o) {
	Vector2d point = o.topLeft;
	if(point.y > o.topRight.y)
		point = o.topRight;
	if(point.y > o.bottomLeft.y)
		point = o.bottomLeft;
	if(point.y > o.bottomRight.y)
		point = o.bottomRight;
	return point;
}


private int partition(ArrayList<AbstractStaticObject> arr, int left, int right)
{

	      int i = left, j = right;
	      AbstractStaticObject tmp;
	      double pivot = puntoPiuAlto( arr.get((int)((left + right) / 2)) ).y;
   

	      while (i <= j) {

	            while ( puntoPiuAlto(arr.get(i)).y < pivot)

	                  i++;

	            while ( puntoPiuAlto(arr.get(j)).y > pivot)

	                  j--;

	            if (i <= j) {

	                  tmp = arr.get(i);

	                  arr.set(i,arr.get(j));

	                  
	                  arr.set(j,tmp);

	                  i++;

	                  j--;

	            }

	      };

      return i;

	}

void quickSort(ArrayList<AbstractStaticObject> arr, int left, int right) {

    int index = partition(arr, left, right);

    if (left < index - 1)

          quickSort(arr, left, index - 1);

    if (index < right)

          quickSort(arr, index, right);

}


public void update() {



	
	//camera
	matrix.updatePosition(mondo.players.get(protagonista));
	updatePosition();

//controllo su tutti gli oggetti che si muovono se collidono col panel li aggiunge per draw
	ordineStampa.clear();
	
	AbstractStaticObject panel = new AbstractStaticObject(topLeft,PWIDTH,PHEIGHT) {};
	
	
	//sprite player
	for( Entry<String,Player> p : mondo.players.entrySet() ) {
	String name =p.getKey();
	Player player = p.getValue();
		
	spritesPlayer.get(name).updateSprite(player.orientationAngle,player.selectArm, (player.speedCurr==0) );

	AbstractStaticObject o = new AbstractStaticObject(player.centro.add
	(spritesPlayer.get(name).topLeft),spritesPlayer.get(name).animation.getCurrentImage().getWidth(null),
	spritesPlayer.get(name).animation.getCurrentImage().getHeight(null)){};							

	if(o.collide(panel)) 
		ordineStampa.add(player);//manca collisione grafica degli altri player online
	
	}
	

	
	if( mondo.nuovoLivello ) {
		System.out.println("NEW LEVEL");

		for( int i=0;i<mondo.porte.size();i++ ) {
			for( Zombie z : mondo.codaPorte.get(i) ) 
				spritesZombie.put(z.id,new EnemySprite(provider));
			}
		mondo.nuovoLivello = false;
	}
	
	else if (mondo.devonoEntrareNemici) {
		for( int i=0;i<mondo.porte.size();i++ ) {
			for( Zombie z : mondo.codaPorte.get(i) ) {
					spritesZombie.get(z.id).updateSprite(z.orientationAngle,(z.speedCurr==0));

					//per draw
			AbstractStaticObject o = new AbstractStaticObject(z.centro.add
				(spritesZombie.get(z.id).topLeft),spritesZombie.get(z.id).width,spritesZombie.get(z.id).height){};							
			if(o.collide(panel))
					ordineStampa.add(z);
			}
		}
	}
	
	for(Zombie z : mondo.zombies){
		//sprite
		if (z.morto)
			mortiZombie.add(new EnemySprite(provider,z.orientationAngle,z.centro));
		else if(z.getAttack())
			spritesZombie.get(z.id).updateSpriteAttack(z.orientationAngle);
		else
			spritesZombie.get(z.id).updateSprite(z.orientationAngle, (z.speedCurr==0) );	
		
		//per la stampa
		AbstractStaticObject o = new AbstractStaticObject(z.centro.add
		(spritesZombie.get(z.id).topLeft),spritesZombie.get(z.id).width,spritesZombie.get(z.id).height){};						
		if( o.collide(panel) ) 
			ordineStampa.add(z);
	}
	

	for (ListIterator<EnemySprite> iterator = mortiZombie.listIterator(); iterator.hasNext();) {
		EnemySprite e = (EnemySprite) iterator.next();
		
		e.animation.updateTick();
	
		if( e.collide(panel) ) {
			ordineStampa.add(e);
		}
		if(e.animation.finita){

		iterator.set(new EnemySprite(provider, e.posizionePrecedente, e.topLeft , 10));
		iterator.previous();
		}
		else if(e.animation.trasparenza<=0) {

			iterator.remove();
			}
		}

	
	for (Pacchetto p : mondo.getPacchi()) {
		AbstractStaticObject o = new AbstractStaticObject(p.topLeft.add(new Vector2d(MapPanel.PACCHETTOARMI.topLeft)),MapPanel.PACCHETTOARMI.width,MapPanel.PACCHETTOARMI.height) {};
		if(o.collide(panel))
			ordineStampa.add(p);
	
	}
	
	for (Wall w : mondo.oggettiFermi) {
		AbstractStaticObject o =null;
		switch(w.toString()){
	case "AMBULANCE":
		o = new AbstractStaticObject(w.topLeft.add
	(new Vector2d(MapPanel.AMBULANCE.topLeft)),MapPanel.AMBULANCE.width,MapPanel.AMBULANCE.height) {};
		break;
	case "CAMION":
		o = new AbstractStaticObject(w.topLeft.add
	(new Vector2d(MapPanel.CAMION.topLeft)),MapPanel.CAMION.width,MapPanel.CAMION.height) {};
		break;
	case "CAMPER":
		o = new AbstractStaticObject(w.topLeft.add
	(new Vector2d(MapPanel.CAMPER.topLeft)),MapPanel.CAMPER.width,MapPanel.CAMPER.height) {};
		break;
	case "EDIFICIO1a":
		o = new AbstractStaticObject(w.topLeft.add
	(new Vector2d(MapPanel.EDIFICIO1.topLeft)),MapPanel.EDIFICIO1.width,MapPanel.EDIFICIO1.height) {};
		break;
	case "EDIFICIO1b":
		o = new AbstractStaticObject(w.topLeft.add
	(new Vector2d(MapPanel.EDIFICIO1.topLeft)),MapPanel.EDIFICIO1.width,MapPanel.EDIFICIO1.height) {};
		break;
	case "EDIFICIO1c":
		o = new AbstractStaticObject(w.topLeft.add
	(new Vector2d(MapPanel.EDIFICIO1.topLeft)),MapPanel.EDIFICIO1.width,MapPanel.EDIFICIO1.height) {};
		break;
	case "EDIFICIO1d":
		o = new AbstractStaticObject(w.topLeft.add
	(new Vector2d(MapPanel.EDIFICIO1.topLeft)),MapPanel.EDIFICIO1.width,MapPanel.EDIFICIO1.height) {};
		break;
	case "EDIFICIO2a":
		o = new AbstractStaticObject(w.topLeft.add
	(new Vector2d(MapPanel.EDIFICIO2.topLeft)),MapPanel.EDIFICIO2.width,MapPanel.EDIFICIO2.height) {};
		break;
	case "EDIFICIO2b":
		o = new AbstractStaticObject(w.topLeft.add
	(new Vector2d(MapPanel.EDIFICIO2.topLeft)),MapPanel.EDIFICIO2.width,MapPanel.EDIFICIO2.height) {};
		break;
	case "EDIFICIO2c":
		o = new AbstractStaticObject(w.topLeft.add
	(new Vector2d(MapPanel.EDIFICIO2.topLeft)),MapPanel.EDIFICIO2.width,MapPanel.EDIFICIO2.height) {};
		break;
	case "MACCHINA2":
		o = new AbstractStaticObject(w.topLeft.add
	(new Vector2d(MapPanel.MACCHINA2.topLeft)),MapPanel.MACCHINA2.width,MapPanel.MACCHINA2.height) {};
		break;
		}

		if(o.collide(panel)) {
			
			ordineStampa.add(w);						
		}
	}


	
	
	 quickSort(ordineStampa, 0, ordineStampa.size()-1);

	
}



@Override
protected void paintComponent(Graphics g) {
	super.paintComponent(g);
	if(stato!=0)
		paintComponent2(g);
	if(stato==2){
		g.setColor(Color.RED);
		String s = "GAME OVER";
		g.setFont(new Font("SansSerif", Font.BOLD, 50));
		g.drawString(s,PWIDTH/2- g.getFontMetrics().stringWidth(s)/2,PHEIGHT/2-50/2);
	}
	if(stato==3){
		g.setColor(Color.RED);
		String s = "PAUSA";
		g.setFont(new Font("SansSerif", Font.BOLD, 50));
		g.drawString(s,PWIDTH/2- g.getFontMetrics().stringWidth(s)/2,PHEIGHT/2-50/2);
	}
}



private void paintComponent2(Graphics g) {

	Graphics2D g2 = (Graphics2D) g ;
		
		

		
//		g.setColor(Color.YELLOW);
//
//	g2.draw(new Line2D.Double(matrix.topLeft.x - topLeft.x, matrix.topLeft.y - topLeft.y, matrix.topLeft.x+matrix.MWIDTH - topLeft.x, matrix.topLeft.y - topLeft.y));
//	g2.draw(new Line2D.Double(matrix.topLeft.x - topLeft.x, matrix.topLeft.y - topLeft.y, matrix.topLeft.x - topLeft.x, matrix.topLeft.y+matrix.MHEIGHT - topLeft.y));
//	g2.draw(new Line2D.Double(matrix.topLeft.x+matrix.MWIDTH - topLeft.x, matrix.topLeft.y - topLeft.y, matrix.topLeft.x+matrix.MWIDTH - topLeft.x, matrix.topLeft.y+matrix.MHEIGHT - topLeft.y));
//	g2.draw(new Line2D.Double(matrix.topLeft.x - topLeft.x, matrix.topLeft.y+matrix.MHEIGHT - topLeft.y, matrix.topLeft.x+matrix.MWIDTH - topLeft.x, matrix.topLeft.y+matrix.MHEIGHT - topLeft.y));
		

	for (Wall w : mondo.muriPerimetrali) {
		if(w.toString().equals("MUROPERIMETRALEORIZZONTALE") )
			draw(g2,provider.wallOrizzontale,w);
		else if(w.toString().equals("MUROPERIMETRALEVERTICALE") )
			draw(g2,provider.wallVerticale,w);
	}

//	for (Proiettile p : mondo.proiettili) {
//		g2.setColor(Color.BLACK);
//		g2.draw(new Line2D.Double(p.topLeft.x - topLeft.x, p.topLeft.y - topLeft.y, p.topRight.x - topLeft.x, p.topRight.y - topLeft.y));
//		g2.draw(new Line2D.Double(p.topLeft.x - topLeft.x, p.topLeft.y - topLeft.y, p.bottomLeft.x - topLeft.x, p.bottomLeft.y - topLeft.y));
//		g2.draw(new Line2D.Double(p.topRight.x - topLeft.x, p.topRight.y - topLeft.y, p.bottomRight.x - topLeft.x, p.bottomRight.y - topLeft.y));
//		g2.draw(new Line2D.Double(p.bottomLeft.x - topLeft.x, p.bottomLeft.y - topLeft.y, p.bottomRight.x - topLeft.x, p.bottomRight.y - topLeft.y));
//	}
		


for (int i = 0; i < ordineStampa.size(); i++) {
	
	
	AbstractStaticObject o = ordineStampa.get(i);

		switch (o.toString()) {
		case "ARMA1":
		case "ARMA2":
		case "ARMA3":
			draw(g2,provider.pacchetto,new AbstractStaticObject(o.topLeft.add(MapPanel.PACCHETTOARMI.topLeft),MapPanel.PACCHETTOARMI.width,MapPanel.PACCHETTOARMI.height){} );
//			g2.setColor(Color.YELLOW);
//			g2.draw(new Line2D.Double(o.topLeft.x - topLeft.x, o.topLeft.y -topLeft.y, o.topLeft.add(new Vector2d(o.width,0)).x - topLeft.x, o.topLeft.y - topLeft.y));
//			g2.draw(new Line2D.Double(o.topLeft.x - topLeft.x, o.topLeft.y -topLeft.y, o.topLeft.x - topLeft.x, o.topLeft.add(new Vector2d(0,o.height)).y - topLeft.y));
//			g2.draw(new Line2D.Double(o.topLeft.add(new Vector2d(o.width,0)).x - topLeft.x, o.topLeft.y -topLeft.y, o.topLeft.add(new Vector2d(o.width,0)).x - topLeft.x, o.topLeft.add(new Vector2d(0,o.height)).y -topLeft.y));
//			g2.draw(new Line2D.Double(o.topLeft.x - topLeft.x, o.topLeft.add(new Vector2d(0,o.height)).y -topLeft.y, o.topLeft.add(new Vector2d(o.width,0)).x - topLeft.x, o.topLeft.add(new Vector2d(0,o.height)).y -topLeft.y));

			break;
		case "AMBULANCE":
			draw(g2,provider.ambulance,new AbstractStaticObject(o.topLeft.add(MapPanel.AMBULANCE.topLeft),MapPanel.AMBULANCE.width,MapPanel.AMBULANCE.height){} );
//			g2.setColor(Color.YELLOW);
//			g2.draw(new Line2D.Double(o.topLeft.x - topLeft.x, o.topLeft.y -topLeft.y, o.topLeft.add(new Vector2d(o.width,0)).x - topLeft.x, o.topLeft.y - topLeft.y));
//			g2.draw(new Line2D.Double(o.topLeft.x - topLeft.x, o.topLeft.y -topLeft.y, o.topLeft.x - topLeft.x, o.topLeft.add(new Vector2d(0,o.height)).y - topLeft.y));
//			g2.draw(new Line2D.Double(o.topLeft.add(new Vector2d(o.width,0)).x - topLeft.x, o.topLeft.y -topLeft.y, o.topLeft.add(new Vector2d(o.width,0)).x - topLeft.x, o.topLeft.add(new Vector2d(0,o.height)).y -topLeft.y));
//			g2.draw(new Line2D.Double(o.topLeft.x - topLeft.x, o.topLeft.add(new Vector2d(0,o.height)).y -topLeft.y, o.topLeft.add(new Vector2d(o.width,0)).x - topLeft.x, o.topLeft.add(new Vector2d(0,o.height)).y -topLeft.y));

			break;
		case "CAMION":
			draw(g2,provider.camion,new AbstractStaticObject(o.topLeft.add(MapPanel.CAMION.topLeft),MapPanel.CAMION.width,MapPanel.CAMION.height){} );
//			g2.setColor(Color.YELLOW);
//			g2.draw(new Line2D.Double(o.topLeft.x - topLeft.x, o.topLeft.y -topLeft.y, o.topLeft.add(new Vector2d(o.width,0)).x - topLeft.x, o.topLeft.y - topLeft.y));
//			g2.draw(new Line2D.Double(o.topLeft.x - topLeft.x, o.topLeft.y -topLeft.y, o.topLeft.x - topLeft.x, o.topLeft.add(new Vector2d(0,o.height)).y - topLeft.y));
//			g2.draw(new Line2D.Double(o.topLeft.add(new Vector2d(o.width,0)).x - topLeft.x, o.topLeft.y -topLeft.y, o.topLeft.add(new Vector2d(o.width,0)).x - topLeft.x, o.topLeft.add(new Vector2d(0,o.height)).y -topLeft.y));
//			g2.draw(new Line2D.Double(o.topLeft.x - topLeft.x, o.topLeft.add(new Vector2d(0,o.height)).y -topLeft.y, o.topLeft.add(new Vector2d(o.width,0)).x - topLeft.x, o.topLeft.add(new Vector2d(0,o.height)).y -topLeft.y));

			break;
		case "CAMPER":
			draw(g2,provider.camper,new AbstractStaticObject(o.topLeft.add(MapPanel.CAMPER.topLeft),MapPanel.CAMPER.width,MapPanel.CAMPER.height){} );
//			g2.setColor(Color.YELLOW);
//			g2.draw(new Line2D.Double(o.topLeft.x - topLeft.x, o.topLeft.y -topLeft.y, o.topLeft.add(new Vector2d(o.width,0)).x - topLeft.x, o.topLeft.y - topLeft.y));
//			g2.draw(new Line2D.Double(o.topLeft.x - topLeft.x, o.topLeft.y -topLeft.y, o.topLeft.x - topLeft.x, o.topLeft.add(new Vector2d(0,o.height)).y - topLeft.y));
//			g2.draw(new Line2D.Double(o.topLeft.add(new Vector2d(o.width,0)).x - topLeft.x, o.topLeft.y -topLeft.y, o.topLeft.add(new Vector2d(o.width,0)).x - topLeft.x, o.topLeft.add(new Vector2d(0,o.height)).y -topLeft.y));
//			g2.draw(new Line2D.Double(o.topLeft.x - topLeft.x, o.topLeft.add(new Vector2d(0,o.height)).y -topLeft.y, o.topLeft.add(new Vector2d(o.width,0)).x - topLeft.x, o.topLeft.add(new Vector2d(0,o.height)).y -topLeft.y));

			break;
		case "EDIFICIO1a":
			draw(g2,provider.edificio1a,new AbstractStaticObject(o.topLeft.add(MapPanel.EDIFICIO1.topLeft),MapPanel.EDIFICIO1.width,MapPanel.EDIFICIO1.height){} );
//			g2.setColor(Color.YELLOW);
//			g2.draw(new Line2D.Double(o.topLeft.x - topLeft.x, o.topLeft.y -topLeft.y, o.topLeft.add(new Vector2d(o.width,0)).x - topLeft.x, o.topLeft.y - topLeft.y));
//			g2.draw(new Line2D.Double(o.topLeft.x - topLeft.x, o.topLeft.y -topLeft.y, o.topLeft.x - topLeft.x, o.topLeft.add(new Vector2d(0,o.height)).y - topLeft.y));
//			g2.draw(new Line2D.Double(o.topLeft.add(new Vector2d(o.width,0)).x - topLeft.x, o.topLeft.y -topLeft.y, o.topLeft.add(new Vector2d(o.width,0)).x - topLeft.x, o.topLeft.add(new Vector2d(0,o.height)).y -topLeft.y));
//			g2.draw(new Line2D.Double(o.topLeft.x - topLeft.x, o.topLeft.add(new Vector2d(0,o.height)).y -topLeft.y, o.topLeft.add(new Vector2d(o.width,0)).x - topLeft.x, o.topLeft.add(new Vector2d(0,o.height)).y -topLeft.y));

			break;
		case "EDIFICIO1b":
			draw(g2,provider.edificio1b,new AbstractStaticObject(o.topLeft.add(MapPanel.EDIFICIO1.topLeft),MapPanel.EDIFICIO1.width,MapPanel.EDIFICIO1.height){} );
//			g2.setColor(Color.YELLOW);
//			g2.draw(new Line2D.Double(o.topLeft.x - topLeft.x, o.topLeft.y -topLeft.y, o.topLeft.add(new Vector2d(o.width,0)).x - topLeft.x, o.topLeft.y - topLeft.y));
//			g2.draw(new Line2D.Double(o.topLeft.x - topLeft.x, o.topLeft.y -topLeft.y, o.topLeft.x - topLeft.x, o.topLeft.add(new Vector2d(0,o.height)).y - topLeft.y));
//			g2.draw(new Line2D.Double(o.topLeft.add(new Vector2d(o.width,0)).x - topLeft.x, o.topLeft.y -topLeft.y, o.topLeft.add(new Vector2d(o.width,0)).x - topLeft.x, o.topLeft.add(new Vector2d(0,o.height)).y -topLeft.y));
//			g2.draw(new Line2D.Double(o.topLeft.x - topLeft.x, o.topLeft.add(new Vector2d(0,o.height)).y -topLeft.y, o.topLeft.add(new Vector2d(o.width,0)).x - topLeft.x, o.topLeft.add(new Vector2d(0,o.height)).y -topLeft.y));

			break;
		case "EDIFICIO1c":
			draw(g2,provider.edificio1c,new AbstractStaticObject(o.topLeft.add(MapPanel.EDIFICIO1.topLeft),MapPanel.EDIFICIO1.width,MapPanel.EDIFICIO1.height){} );
//			g2.setColor(Color.YELLOW);
//			g2.draw(new Line2D.Double(o.topLeft.x - topLeft.x, o.topLeft.y -topLeft.y, o.topLeft.add(new Vector2d(o.width,0)).x - topLeft.x, o.topLeft.y - topLeft.y));
//			g2.draw(new Line2D.Double(o.topLeft.x - topLeft.x, o.topLeft.y -topLeft.y, o.topLeft.x - topLeft.x, o.topLeft.add(new Vector2d(0,o.height)).y - topLeft.y));
//			g2.draw(new Line2D.Double(o.topLeft.add(new Vector2d(o.width,0)).x - topLeft.x, o.topLeft.y -topLeft.y, o.topLeft.add(new Vector2d(o.width,0)).x - topLeft.x, o.topLeft.add(new Vector2d(0,o.height)).y -topLeft.y));
//			g2.draw(new Line2D.Double(o.topLeft.x - topLeft.x, o.topLeft.add(new Vector2d(0,o.height)).y -topLeft.y, o.topLeft.add(new Vector2d(o.width,0)).x - topLeft.x, o.topLeft.add(new Vector2d(0,o.height)).y -topLeft.y));

			break;
		case "EDIFICIO1d":
			draw(g2,provider.edificio1d,new AbstractStaticObject(o.topLeft.add(MapPanel.EDIFICIO1.topLeft),MapPanel.EDIFICIO1.width,MapPanel.EDIFICIO1.height){} );
//			g2.setColor(Color.YELLOW);
//			g2.draw(new Line2D.Double(o.topLeft.x - topLeft.x, o.topLeft.y -topLeft.y, o.topLeft.add(new Vector2d(o.width,0)).x - topLeft.x, o.topLeft.y - topLeft.y));
//			g2.draw(new Line2D.Double(o.topLeft.x - topLeft.x, o.topLeft.y -topLeft.y, o.topLeft.x - topLeft.x, o.topLeft.add(new Vector2d(0,o.height)).y - topLeft.y));
//			g2.draw(new Line2D.Double(o.topLeft.add(new Vector2d(o.width,0)).x - topLeft.x, o.topLeft.y -topLeft.y, o.topLeft.add(new Vector2d(o.width,0)).x - topLeft.x, o.topLeft.add(new Vector2d(0,o.height)).y -topLeft.y));
//			g2.draw(new Line2D.Double(o.topLeft.x - topLeft.x, o.topLeft.add(new Vector2d(0,o.height)).y -topLeft.y, o.topLeft.add(new Vector2d(o.width,0)).x - topLeft.x, o.topLeft.add(new Vector2d(0,o.height)).y -topLeft.y));

			break;
		case "EDIFICIO2a":
			draw(g2,provider.edificio2a,new AbstractStaticObject(o.topLeft.add(MapPanel.EDIFICIO2.topLeft),MapPanel.EDIFICIO2.width,MapPanel.EDIFICIO2.height){} );
//			g2.setColor(Color.YELLOW);
//			g2.draw(new Line2D.Double(o.topLeft.x - topLeft.x, o.topLeft.y -topLeft.y, o.topLeft.add(new Vector2d(o.width,0)).x - topLeft.x, o.topLeft.y - topLeft.y));
//			g2.draw(new Line2D.Double(o.topLeft.x - topLeft.x, o.topLeft.y -topLeft.y, o.topLeft.x - topLeft.x, o.topLeft.add(new Vector2d(0,o.height)).y - topLeft.y));
//			g2.draw(new Line2D.Double(o.topLeft.add(new Vector2d(o.width,0)).x - topLeft.x, o.topLeft.y -topLeft.y, o.topLeft.add(new Vector2d(o.width,0)).x - topLeft.x, o.topLeft.add(new Vector2d(0,o.height)).y -topLeft.y));
//			g2.draw(new Line2D.Double(o.topLeft.x - topLeft.x, o.topLeft.add(new Vector2d(0,o.height)).y -topLeft.y, o.topLeft.add(new Vector2d(o.width,0)).x - topLeft.x, o.topLeft.add(new Vector2d(0,o.height)).y -topLeft.y));

			break;
		case "EDIFICIO2b":
			draw(g2,provider.edificio2b,new AbstractStaticObject(o.topLeft.add(MapPanel.EDIFICIO2.topLeft),MapPanel.EDIFICIO2.width,MapPanel.EDIFICIO2.height){} );
//			g2.setColor(Color.YELLOW);
//			g2.draw(new Line2D.Double(o.topLeft.x - topLeft.x, o.topLeft.y -topLeft.y, o.topLeft.add(new Vector2d(o.width,0)).x - topLeft.x, o.topLeft.y - topLeft.y));
//			g2.draw(new Line2D.Double(o.topLeft.x - topLeft.x, o.topLeft.y -topLeft.y, o.topLeft.x - topLeft.x, o.topLeft.add(new Vector2d(0,o.height)).y - topLeft.y));
//			g2.draw(new Line2D.Double(o.topLeft.add(new Vector2d(o.width,0)).x - topLeft.x, o.topLeft.y -topLeft.y, o.topLeft.add(new Vector2d(o.width,0)).x - topLeft.x, o.topLeft.add(new Vector2d(0,o.height)).y -topLeft.y));
//			g2.draw(new Line2D.Double(o.topLeft.x - topLeft.x, o.topLeft.add(new Vector2d(0,o.height)).y -topLeft.y, o.topLeft.add(new Vector2d(o.width,0)).x - topLeft.x, o.topLeft.add(new Vector2d(0,o.height)).y -topLeft.y));

			break;
		case "EDIFICIO2c":
			draw(g2,provider.edificio2c,new AbstractStaticObject(o.topLeft.add(MapPanel.EDIFICIO2.topLeft),MapPanel.EDIFICIO2.width,MapPanel.EDIFICIO2.height){} );
//			g2.setColor(Color.YELLOW);
//			g2.draw(new Line2D.Double(o.topLeft.x - topLeft.x, o.topLeft.y -topLeft.y, o.topLeft.add(new Vector2d(o.width,0)).x - topLeft.x, o.topLeft.y - topLeft.y));
//			g2.draw(new Line2D.Double(o.topLeft.x - topLeft.x, o.topLeft.y -topLeft.y, o.topLeft.x - topLeft.x, o.topLeft.add(new Vector2d(0,o.height)).y - topLeft.y));
//			g2.draw(new Line2D.Double(o.topLeft.add(new Vector2d(o.width,0)).x - topLeft.x, o.topLeft.y -topLeft.y, o.topLeft.add(new Vector2d(o.width,0)).x - topLeft.x, o.topLeft.add(new Vector2d(0,o.height)).y -topLeft.y));
//			g2.draw(new Line2D.Double(o.topLeft.x - topLeft.x, o.topLeft.add(new Vector2d(0,o.height)).y -topLeft.y, o.topLeft.add(new Vector2d(o.width,0)).x - topLeft.x, o.topLeft.add(new Vector2d(0,o.height)).y -topLeft.y));

			break;
		case "MACCHINA2":
			draw(g2,provider.macchina2,new AbstractStaticObject(o.topLeft.add(MapPanel.MACCHINA2.topLeft),MapPanel.MACCHINA2.width,MapPanel.MACCHINA2.height){} );
//			g2.setColor(Color.YELLOW);
//			g2.draw(new Line2D.Double(o.topLeft.x - topLeft.x, o.topLeft.y -topLeft.y, o.topLeft.add(new Vector2d(o.width,0)).x - topLeft.x, o.topLeft.y - topLeft.y));
//			g2.draw(new Line2D.Double(o.topLeft.x - topLeft.x, o.topLeft.y -topLeft.y, o.topLeft.x - topLeft.x, o.topLeft.add(new Vector2d(0,o.height)).y - topLeft.y));
//			g2.draw(new Line2D.Double(o.topLeft.add(new Vector2d(o.width,0)).x - topLeft.x, o.topLeft.y -topLeft.y, o.topLeft.add(new Vector2d(o.width,0)).x - topLeft.x, o.topLeft.add(new Vector2d(0,o.height)).y -topLeft.y));
//			g2.draw(new Line2D.Double(o.topLeft.x - topLeft.x, o.topLeft.add(new Vector2d(0,o.height)).y -topLeft.y, o.topLeft.add(new Vector2d(o.width,0)).x - topLeft.x, o.topLeft.add(new Vector2d(0,o.height)).y -topLeft.y));

			break;
		case "ZOMBIE":
			
			Zombie z = (Zombie) o;

			
			draw(g2, spritesZombie.get(z.id).animation.getCurrentImage(),
					new AbstractStaticObject(z.centro.add(spritesZombie.get(z.id).topLeft),
					spritesZombie.get(z.id).width,spritesZombie.get(z.id).height) {});

//			g2.setColor(Color.RED);
//
//			g2.draw(new Line2D.Double(z.topLeft.x - topLeft.x,z.topLeft.y -topLeft.y, z.topRight.x - topLeft.x, z.topRight.y -topLeft.y));
//			
//			g.setColor(Color.WHITE);
////			g2.draw(new Line2D.Double(z.topLeft.x - topLeft.x,z.topLeft.y -topLeft.y, z.topRight.x - topLeft.x, z.topRight.y -topLeft.y));
//			g2.draw(new Line2D.Double(z.topLeft.x - topLeft.x,z.topLeft.y -topLeft.y, z.bottomLeft.x - topLeft.x, z.bottomLeft.y -topLeft.y));
//			g2.draw(new Line2D.Double(z.topRight.x - topLeft.x,z.topRight.y -topLeft.y, z.bottomRight.x - topLeft.x, z.bottomRight.y -topLeft.y));
//			g2.draw(new Line2D.Double(z.bottomLeft.x - topLeft.x,z.bottomLeft.y -topLeft.y, z.bottomRight.x - topLeft.x, z.bottomRight.y -topLeft.y));
//
//				//diagonali
//				g2.setColor(Color.RED);
//				g2.draw(new Line2D.Double(z.topLeft.x - topLeft.x, z.topLeft.y - topLeft.y, z.bottomRight.x - topLeft.x, z.bottomRight.y - topLeft.y));
//				g2.draw(new Line2D.Double(z.topRight.x - topLeft.x, z.topRight.y - topLeft.y, z.bottomLeft.x - topLeft.x, z.bottomLeft.y - topLeft.y));
//			
//				
//		g.setColor(Color.GREEN);
//		g2.draw(new Line2D.Double(z.centro.x-300-topLeft.x, z.centro.y-300-topLeft.y, z.centro.x+300-topLeft.x, z.centro.y-300-topLeft.y));
//		g2.draw(new Line2D.Double(z.centro.x-300-topLeft.x, z.centro.y-300-topLeft.y, z.centro.x-300-topLeft.x, z.centro.y+300-topLeft.y));
//		g2.draw(new Line2D.Double(z.centro.x-300-topLeft.x, z.centro.y+300-topLeft.y, z.centro.x+300-topLeft.x, z.centro.y+300-topLeft.y));
//		g2.draw(new Line2D.Double(z.centro.x+300-topLeft.x, z.centro.y+300-topLeft.y, z.centro.x+300-topLeft.x, z.centro.y-300-topLeft.y));
//
			
			break;
		case "MORTO":
			EnemySprite z4 = (EnemySprite) o;
			draw(g2, z4.animation.getCurrentImage(),new AbstractStaticObject((z4.topLeft),z4.width,z4.height) {});
			break;
		case "CADAVERE":
			EnemySprite z3 = (EnemySprite) o;
			drawFadedImage(g2, z3.animation.getCurrentImage(),new AbstractStaticObject((z3.topLeft),z3.width,z3.height){}, z3.animation.trasparenza) ;
			break;
		case "PLAYER":
			Player player = (Player) o;
			String name = null;
			for( Entry<String,Player> p : mondo.players.entrySet())
				if(player == p.getValue())
					name = p.getKey();
			draw(g2, spritesPlayer.get(name).animation.getCurrentImage(), new AbstractStaticObject(player.centro.add(spritesPlayer.get(name).topLeft),spritesPlayer.get(name).width,spritesPlayer.get(name).height) {} );
						
//			g.setColor(Color.RED);
//			
//			g2.draw(new Line2D.Double(player.topLeft.x - topLeft.x, player.topLeft.y -topLeft.y, player.topRight.x - topLeft.x, player.topRight.y -topLeft.y));
//
//			g.setColor(Color.YELLOW);
//			
//			g2.draw(new Line2D.Double(player.topLeft.x - topLeft.x, player.topLeft.y -topLeft.y, player.bottomLeft.x - topLeft.x, player.bottomLeft.y -topLeft.y));
//			
//
////			g2.draw(new Line2D.Double(player.topRight.x - topLeft.x, player.topRight.y -topLeft.y, player.bottomRight.x - topLeft.x, player.bottomRight.y -topLeft.y));
//
//			
//			g.setColor(Color.WHITE);
//
////			g2.draw(new Line2D.Double(player.topLeft.x - topLeft.x, player.topLeft.y -topLeft.y, player.topRight.x - topLeft.x, player.topRight.y -topLeft.y));
////			g2.draw(new Line2D.Double(player.topLeft.x - topLeft.x, player.topLeft.y -topLeft.y, player.bottomLeft.x - topLeft.x, player.bottomLeft.y -topLeft.y));
//			g2.draw(new Line2D.Double(player.topRight.x - topLeft.x, player.topRight.y -topLeft.y, player.bottomRight.x - topLeft.x, player.bottomRight.y -topLeft.y));
//			g2.draw(new Line2D.Double(player.bottomLeft.x - topLeft.x, player.bottomLeft.y -topLeft.y, player.bottomRight.x - topLeft.x, player.bottomRight.y -topLeft.y));
//			//diagonali
//			g2.setColor(Color.RED);
//			g2.draw(new Line2D.Double(player.topLeft.x - topLeft.x, player.topLeft.y - topLeft.y, player.bottomRight.x - topLeft.x, player.bottomRight.y - topLeft.y));
//			g2.draw(new Line2D.Double(player.topRight.x - topLeft.x, player.topRight.y - topLeft.y, player.bottomLeft.x - topLeft.x, player.bottomLeft.y - topLeft.y));
//
			
	break;
			
		default:
			break;
		}
	}
	


	g.setColor(Color.WHITE);

g2.draw(new Line2D.Double(vita.getX(), vita.getY(), vita.getX()+vita.getWidth(), vita.getY() ));
g2.draw(new Line2D.Double(vita.getX(), vita.getY(), vita.getX(), vita.getY()+vita.getHeight() ));
g2.draw(new Line2D.Double(vita.getX(), vita.getY()+vita.getHeight(), vita.getX()+vita.getWidth(), vita.getY()+vita.getHeight() ));
g2.draw(new Line2D.Double(vita.getX()+vita.getWidth(), vita.getY(), vita.getX()+vita.getWidth(),vita.getY()+vita.getHeight() ));


g.setColor(Color.RED);
g.fillRect((int) vita.getX(),(int) vita.getY(),(int)(vita.getWidth()/Editor.HEALTH_PLAYER*mondo.players.get(protagonista).health),(int) vita.getHeight());

if(mondo.players.get(protagonista).selectArm!=-1){
		g.setColor(Color.YELLOW);	
		g.fillRect((int) infoArma.getX(),(int) infoArma.getY(),(int)infoArma.getWidth(),(int)infoArma.getHeight());
		g.setColor(Color.BLACK);
		String s = " "+mondo.players.get(protagonista).arms.get(mondo.players.get(protagonista).selectArm).caricatore+" ";
		g.setFont(new Font("SansSerif", Font.BOLD, 20));
		g.drawString(s,(int)infoArma.getX() ,(int) infoArma.getY()+g.getFontMetrics().getHeight()/2+g.getFontMetrics().getHeight()/4);
		}

g.setColor(Color.BLUE);	
g.fillRect((int) infoEnemy.getX(),(int) infoEnemy.getY(),(int)infoEnemy.getWidth(),(int)infoEnemy.getHeight());
g.setColor(Color.BLACK);
String s = " "+mondo.zombies.size()+" ";
g.setFont(new Font("SansSerif", Font.BOLD, 20));
g.drawString(s,(int)infoEnemy.getX() ,(int) infoEnemy.getY()+g.getFontMetrics().getHeight()/2+g.getFontMetrics().getHeight()/4);

}


private void draw(Graphics2D g, Image im , AbstractStaticObject o) {
	//topLeft Wall interno al panel
	if( (o.topLeft.x >= topLeft.x && o.topLeft.x <= topLeft.x+PWIDTH)
			&& (o.topLeft.y >= topLeft.y && o.topLeft.y <= topLeft.y+PHEIGHT) )
		
		g.drawImage(im,(int) (o.topLeft.x - topLeft.x) ,(int)  (o.topLeft.y - topLeft.y), null);
	else{
		int dx1=0,dy1=0,dx2=0,dy2=0,sx1=0,sy1=0,sx2=0,sy2=0;
		if( topLeft.y > o.topLeft.y ){


			
		if(o.topLeft.x > topLeft.x ) {
			dx1 = (int) (o.topLeft.x - topLeft.x);
			dy1 = 0;
			sy1 = (int) (topLeft.y - o.topLeft.y);
			sx1 = 0;
				if(o.topLeft.x+o.width < topLeft.x+PWIDTH){
					dx2 = (int) (o.topLeft.x + o.width - topLeft.x);
					sx2 = o.width;
					dy2 = (int) (o.topLeft.y + o.height - topLeft.y);
					sy2 = o.height;	
					g.drawImage(im, dx1, dy1, dx2, dy2, sx1, sy1, sx2, sy2, null);

					}
				else{
					dx2 = PWIDTH;
					sx2 = (int) (topLeft.x + PWIDTH - o.topLeft.x);
					dy2 = (int) (o.topLeft.y + o.height - topLeft.y);
					sy2 = o.height;
					g.drawImage(im, dx1, dy1, dx2, dy2, sx1, sy1, sx2, sy2, null);
				}
			}
		
		else {
			dx1 = 0;
			dy1 = 0;
			dx2 = (int) (o.topLeft.x + o.width - topLeft.x);
			dy2 = (int) (o.topLeft.y + o.height - topLeft.y);
			sx1 = (int) (topLeft.x - o.topLeft.x);
			sy1 = (int) (topLeft.y - o.topLeft.y);
			sx2 = o.width;
			sy2 = o.height;
			g.drawImage(im, dx1, dy1, dx2, dy2, sx1, sy1, sx2, sy2, null);
		}
		

	}
	if (o.topLeft.y >= topLeft.y && o.topLeft.y <= topLeft.y+PHEIGHT) {
		
		dx1 = 0;
		sx1 = (int) (topLeft.x - o.topLeft.x);
		dy1 = (int) (o.topLeft.y - topLeft.y);
		sy1 = 0;
		
		if( o.topLeft.y + o.height > topLeft.y + PHEIGHT){
			dx2 = (int) (o.topLeft.x + o.width - topLeft.x);
			dy2 = PHEIGHT;
			sx2 = o.width;
			sy2 = (int) (topLeft.y + PHEIGHT - o.topLeft.y);
			
		
			g.drawImage(im, dx1, dy1, dx2, dy2, sx1, sy1, sx2, sy2, null);
		}	
		else {
			sx2 = o.width;
			sy2 = o.height;
			dx2 = (int) (o.topLeft.x + o.width - topLeft.x);
			dy2 = (int) (o.topLeft.y + o.height - topLeft.y);
			g.drawImage(im, dx1, dy1, dx2, dy2, sx1, sy1, sx2, sy2, null);
		}
		
		
	}
	
	}
}

	
private void updatePosition() {
	
	if( (matrix.direction==270)	&&
		(!(matrix.topLeft.y + MatriceCam.MHEIGHT - topLeft.y > PHEIGHT-distanzaY) ) )
			topLeft = topLeft.add(new Vector2d(0,-mondo.players.get(protagonista).speedCurr));

	else if( (matrix.direction==225) &&
		(!(matrix.topLeft.y + MatriceCam.MHEIGHT - topLeft.y > PHEIGHT-distanzaY) && !(matrix.topLeft.x + MatriceCam.MWIDTH - topLeft.x > PWIDTH-distanzaX) ) )
			topLeft = topLeft.add(new Vector2d(-mondo.players.get(protagonista).speedCurr,-mondo.players.get(protagonista).speedCurr));

	else if( (matrix.direction==315) &&
		(!(matrix.topLeft.y + MatriceCam.MHEIGHT - topLeft.y > PHEIGHT-distanzaY) && !(matrix.topLeft.x - topLeft.x < 0+distanzaX) ) )
		topLeft = topLeft.add(new Vector2d(mondo.players.get(protagonista).speedCurr,-mondo.players.get(protagonista).speedCurr));

	else if( (matrix.direction==0) &&
		(!(matrix.topLeft.x + MatriceCam.MWIDTH - topLeft.x < 0 + distanzaX) ) )
		topLeft = topLeft.add(new Vector2d(mondo.players.get(protagonista).speedCurr,0));
	
	else if( (matrix.direction==45) &&
		(!(matrix.topLeft.y  - topLeft.y < 0+distanzaY) && !(matrix.topLeft.x - topLeft.x < 0+distanzaX) ) )
		topLeft = topLeft.add(new Vector2d(mondo.players.get(protagonista).speedCurr,mondo.players.get(protagonista).speedCurr));
		
	else if( (matrix.direction==135) &&
		(!(matrix.topLeft.y - topLeft.y < 0+distanzaY) && !(matrix.topLeft.x + MatriceCam.MWIDTH - topLeft.x > PWIDTH-distanzaX) ) )
		topLeft = topLeft.add(new Vector2d(-mondo.players.get(protagonista).speedCurr,mondo.players.get(protagonista).speedCurr));
	
	else if( (matrix.direction==180) &&
		(!(matrix.topLeft.x + MatriceCam.MWIDTH - topLeft.x > PWIDTH-distanzaX) ) )
		topLeft = topLeft.add(new Vector2d(-mondo.players.get(protagonista).speedCurr,0));


	else if( (matrix.direction==90) &&
		(!(matrix.topLeft.y - topLeft.y < 0 + distanzaY) ) )
		topLeft = topLeft.add(new Vector2d(0,mondo.players.get(protagonista).speedCurr));

	
	matrix.direction=-1;
	
	if(topLeft.x <0)
		topLeft.x=0;
	if(topLeft.y <0)
		topLeft.y =0;
	if(topLeft.x + PWIDTH > mondo.width)
		topLeft.x = mondo.width - PWIDTH;
	if(topLeft.y + PHEIGHT > mondo.height)
		topLeft.y = mondo.height - PHEIGHT;
		
}


public void resumeGame() {
	if(stato==3) {
	pausa = false;
	stato=1;
	}
}


public void pauseGame() {
	if(stato!=2) {
	north = false;
	east = false;
	south = false;
	west = false;
	shoot = false;
	successiva=false;
	precedente=false;
	pausa = true;
	stato=3;
	repaint();

	}
}

public void stopGame() {
	if(running) { 
	running =false;
	
	stato = 2;
	repaint();
	
	   Connection conn = null;
	   try{
	      Class.forName("com.mysql.jdbc.Driver");

	      conn = DriverManager.getConnection(RankPanel.DB_URL, RankPanel.USER, RankPanel.PASS);

	      
	      String nome = protagonista;
	      int punti = mondo.players.get(protagonista).score;
	      
	      System.out.println("Nome "+ nome +"  punti "+punti);
	      
	      PreparedStatement statement = conn.prepareStatement("INSERT INTO punteggio VALUES (?, ?)");
	      statement.setString(1, nome);
	      statement.setInt(2, punti);
	      statement.execute();
	      
	     
	   }catch(SQLException se){

	      se.printStackTrace();
	   }catch(Exception e){

	      e.printStackTrace();
	   }finally{

		try{
	         if(conn!=null)
	            conn.close();
	      }catch(SQLException se){
	         se.printStackTrace();
	      }
	   }
	}
}

private void drawFadedImage(Graphics2D g2d, Image im, 
              AbstractStaticObject o, float alpha)

{

if (alpha < 0.0f) {
alpha = 0.0f;
}
else if (alpha > 1.0f) {
alpha = 1.0f;
}

Composite c = g2d.getComposite();

g2d.setComposite( AlphaComposite.getInstance(
      AlphaComposite.SRC_OVER, alpha)); 
draw(g2d,im,o);

g2d.setComposite(c);
}


private void setKeyBindings() {

	InputMap inMap = getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
	ActionMap actMap = getActionMap();

//-------------------------UP-----------------------------------------------------
	
		 inMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0, false), "UP" + "pressed");
		 inMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0, true), "UP" + "released");
		 
		actMap.put( "UP" + "pressed", new AbstractAction() {

        private static final long serialVersionUID = 1L;

        @Override
        public void actionPerformed(ActionEvent e) {
            //directionMap.put(direction, true);
        	north=true;
        }

    });
    actMap.put("UP" + "released", new AbstractAction() {

        private static final long serialVersionUID = 1L;

        @Override
        public void actionPerformed(ActionEvent e) {
            //directionMap.put(direction, false);
        	north=false;
        }
    });
    
//------------------------------------DOWN---------------------------------------------	
	 inMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0, false), "DOWN" + "pressed");
	 inMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0, true), "DOWN" + "released");
	 
	actMap.put( "DOWN" + "pressed", new AbstractAction() {

   private static final long serialVersionUID = 1L;

   @Override
   public void actionPerformed(ActionEvent e) {
       //directionMap.put(direction, true);
   	south=true;
   }

});
actMap.put("DOWN" + "released", new AbstractAction() {

   private static final long serialVersionUID = 1L;

   @Override
   public void actionPerformed(ActionEvent e) {
       //directionMap.put(direction, false);
   	south=false;
   }
});


//-------------------------------LEFT------------------------------------------------
inMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0, false), "LEFT" + "pressed");
inMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0, true), "LEFT" + "released");

actMap.put( "LEFT" + "pressed", new AbstractAction() {

private static final long serialVersionUID = 1L;

@Override
public void actionPerformed(ActionEvent e) {
   //directionMap.put(direction, true);
	west=true;
}

});
actMap.put("LEFT" + "released", new AbstractAction() {

private static final long serialVersionUID = 1L;

@Override
public void actionPerformed(ActionEvent e) {
   //directionMap.put(direction, false);
	west=false;
}
});

//-------------------------------RIGHT------------------------------------------------
inMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0, false), "RIGHT" + "pressed");
inMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0, true), "RIGHT" + "released");

actMap.put( "RIGHT" + "pressed", new AbstractAction() {

private static final long serialVersionUID = 1L;

@Override
public void actionPerformed(ActionEvent e) {
 //directionMap.put(direction, true);
	east=true;
}

});
actMap.put("RIGHT" + "released", new AbstractAction() {

private static final long serialVersionUID = 1L;

@Override
public void actionPerformed(ActionEvent e) {
 //directionMap.put(direction, false);
	east=false;
}
});


//-------------------------------SPACE------------------------------------------------
inMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0, false), "SPACE" + "pressed");
inMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0,true), "SPACE" + "released");

actMap.put( "SPACE" + "pressed", new AbstractAction() {

private static final long serialVersionUID = 1L;

@Override
public void actionPerformed(ActionEvent e) {
 //directionMap.put(direction, true);
	shoot=true;
}

});
actMap.put("SPACE" + "released", new AbstractAction() {

private static final long serialVersionUID = 1L;

@Override
public void actionPerformed(ActionEvent e) {
 //directionMap.put(direction, false);
	shoot=false;
}
});



//-------------------------------X------------------------------------------------
inMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_X, 0, false), "SUCCESSIVA" + "pressed");
inMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_X, 0,true), "SUCCESSIVA" + "released");

actMap.put( "SUCCESSIVA" + "pressed", new AbstractAction() {

private static final long serialVersionUID = 1L;

@Override
public void actionPerformed(ActionEvent e) {
	successiva=true;
//	mondo.players.get(protagonista).selectArmaSuccessiva();
}

});


actMap.put("SUCCESSIVA" + "released", new AbstractAction() {

private static final long serialVersionUID = 1L;

@Override
public void actionPerformed(ActionEvent e) {
 //directionMap.put(direction, false);
	successiva=false;
}
});


//-------------------------------Z------------------------------------------------
inMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_Z, 0, false), "PRECEDENTE" + "pressed");
inMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_Z, 0,true), "PRECEDENTE" + "released");

actMap.put( "PRECEDENTE" + "pressed", new AbstractAction() {

private static final long serialVersionUID = 1L;

@Override
public void actionPerformed(ActionEvent e) {
	precedente=true;
	//	mondo.players.get(protagonista).selectArmaPrecedente();
}

});

actMap.put("PRECEDENTE" + "released", new AbstractAction() {

private static final long serialVersionUID = 1L;

@Override
public void actionPerformed(ActionEvent e) {
 //directionMap.put(direction, false);
	precedente=false;
}
});


//-------------------------------P------------------------------------------------
inMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_P, 0, false), "PAUSA" + "pressed");

actMap.put( "PAUSA" + "pressed", new AbstractAction() {

private static final long serialVersionUID = 1L;

@Override
public void actionPerformed(ActionEvent e) {

	if(pausa)
		resumeGame();
	else
		pauseGame();
}

});

}


@Override
public void mouseClicked(MouseEvent e) {
	if(stato==2 && e != null)
			switcher.showMenu();
}


@Override
public void mouseEntered(MouseEvent e) {
	// TODO Auto-generated method stub
	
}


@Override
public void mouseExited(MouseEvent e) {
	// TODO Auto-generated method stub
	
}


@Override
public void mousePressed(MouseEvent e) {
	// TODO Auto-generated method stub
	
}


@Override
public void mouseReleased(MouseEvent e) {
	// TODO Auto-generated method stub
	
}





}