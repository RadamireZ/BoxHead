package core;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;

import intelligenza.Grafo;
import intelligenza.Node;
import logic.*;

public class Editor {

	public int width;
	public int height;

	public ArrayList<AbstractStaticObject> oggettiPresentiNellaMappa;

	public Player playerDentro = null;
	public int porteDentroCount = 0;

	public final static int HEALTH_PLAYER = 1000;
	public final static int SPEED_PLAYER = 5;

	public final static int WIDTH_MURO = 75;
	public final static int HEIGHT_MURO = 120;

	public static final int WIDTH_AMBULANCE = 350;
	public static final int HEIGHT_AMBULANCE = 100;

	public final static int WIDTH_CAMION = 570;
	public final static int HEIGHT_CAMION = 83;

	public final static int WIDTH_CAMPER = 450;
	public final static int HEIGHT_CAMPER = 70;

	public final static int WIDTH_EDIFICIO1 = 365;
	public final static int HEIGHT_EDIFICIO1 = 600;

	public final static int WIDTH_EDIFICIO2 = 400;
	public final static int HEIGHT_EDIFICIO2 = 578;

	public final static int WIDTH_MACCHINA2 = 250;
	public final static int HEIGHT_MACCHINA2 = 84;

	public final static int WIDTH_ZOMBIE = 68;
	public final static int HEIGHT_ZOMBIE = 35;

	public final static int WIDTH_PLAYER = 70;
	public final static int HEIGHT_PLAYER = 40;

	public final static int WIDTH_PORTA = 75;
	public final static int HEIGHT_PORTA = 120;

	public static final int WIDTH_PACCHETTO = 32;
	public static final int HEIGHT_PACCHETTO = 32;


	public Editor(int a, int b) {
		width = a;
		height = b;
		this.adattaDimensionePerMuriPerimetrali();
		oggettiPresentiNellaMappa = new ArrayList<AbstractStaticObject>();
		this.muriPerimetrali();
	}

	public Editor(Editor edit) {
		this.width = edit.width;
		this.height = edit.height;

		this.oggettiPresentiNellaMappa = edit.oggettiPresentiNellaMappa;

		this.playerDentro = edit.playerDentro;
		this.porteDentroCount = edit.porteDentroCount;

	}

	public void resizeAndClear(int x, int y) {
		width = (int) x;
		height = (int) y;
		this.adattaDimensionePerMuriPerimetrali();
		oggettiPresentiNellaMappa.clear();
		playerDentro = null;
		this.muriPerimetrali();
	}

	public void resize(int a, int b) {
		width = a;
		height = b;
		ArrayList<AbstractStaticObject> oggettiDiPrima = new ArrayList<AbstractStaticObject>(oggettiPresentiNellaMappa);
		oggettiPresentiNellaMappa.clear();

		this.adattaDimensionePerMuriPerimetrali();
		this.muriPerimetrali();
		for (int i = 0; i < oggettiDiPrima.size(); i++) {
			if (oggettiDiPrima.get(i).toString() != "MUROPERIMETRALEORIZZONTALE"
					|| oggettiDiPrima.get(i).toString() != "MUROPERIMETRALEVERTICALE")
				insert(oggettiDiPrima.get(i).topLeft.x, oggettiDiPrima.get(i).topLeft.y,
						oggettiDiPrima.get(i).toString());
		}

		if (playerDentro != null) {
			Vector2d point = new Vector2d(playerDentro.topLeft);
			playerDentro = null;
			insert(point.x, point.y, "PLAYER");
		}

	}

	public void insert(double x, double y, String s) {
		AbstractStaticObject o = null;
		if (s != null && x < width && x >= 0 && y < height && y >= 0) {
			Vector2d pos = new Vector2d(x, y);

			switch (s) {
			case "AMBULANCE":
				o = new Wall(pos, WIDTH_AMBULANCE, HEIGHT_AMBULANCE, "AMBULANCE");
				break;
			case "CAMION":
				o = new Wall(pos, WIDTH_CAMION, HEIGHT_CAMION, "CAMION");
				break;
			case "CAMPER":
				o = new Wall(pos, WIDTH_CAMPER, HEIGHT_CAMPER, "CAMPER");
				break;
			case "EDIFICIO1a":
				o = new Wall(pos, WIDTH_EDIFICIO1, HEIGHT_EDIFICIO1, "EDIFICIO1a");
				break;
			case "EDIFICIO1b":
				o = new Wall(pos, WIDTH_EDIFICIO1, HEIGHT_EDIFICIO1, "EDIFICIO1b");
				break;
			case "EDIFICIO1c":
				o = new Wall(pos, WIDTH_EDIFICIO1, HEIGHT_EDIFICIO1, "EDIFICIO1c");
				break;
			case "EDIFICIO1d":
				o = new Wall(pos, WIDTH_EDIFICIO1, HEIGHT_EDIFICIO1, "EDIFICIO1d");
				break;
			case "EDIFICIO2a":
				o = new Wall(pos, WIDTH_EDIFICIO2, HEIGHT_EDIFICIO2, "EDIFICIO2a");
				break;
			case "EDIFICIO2b":
				o = new Wall(pos, WIDTH_EDIFICIO2, HEIGHT_EDIFICIO2, "EDIFICIO2b");
				break;
			case "EDIFICIO2c":
				o = new Wall(pos, WIDTH_EDIFICIO2, HEIGHT_EDIFICIO2, "EDIFICIO2c");
				break;
			case "MACCHINA2":
				o = new Wall(pos, WIDTH_MACCHINA2, HEIGHT_MACCHINA2, "MACCHINA2");
				break;
			case "ARMA1":
				o = new Pacchetto(pos, WIDTH_PACCHETTO, HEIGHT_PACCHETTO, Mondo.ARMA1);
				break;
			case "ARMA2":
				o = new Pacchetto(pos, WIDTH_PACCHETTO, HEIGHT_PACCHETTO, Mondo.ARMA2);
				break;
			case "ARMA3":
				o = new Pacchetto(pos, WIDTH_PACCHETTO, HEIGHT_PACCHETTO, Mondo.ARMA3);
				break;

			case "PLAYER":
				if (playerDentro != null)
					o = null;
				else {
					o = new Player(pos, WIDTH_PLAYER, HEIGHT_PLAYER, 270, Editor.SPEED_PLAYER);
					;
				}
				break;
			case "PORTA":
				if (inserirePortaAlPostoDelMuro(pos)) 
					porteDentroCount++;
				break;
			case "RIMUOVI":
				rimuoviOggetto(pos);
				break;

			}

			if (o != null && o.toString() != "PORTA")
				if (o.topLeft.x + o.width <= width && (o.topLeft.y + o.height) <= height) {

					boolean collide = false;
					for (Iterator<AbstractStaticObject> iterator2 = oggettiPresentiNellaMappa.iterator(); iterator2
							.hasNext();) {
						AbstractStaticObject o2 = (AbstractStaticObject) iterator2.next();
						if (o2.collide(o))
							collide = true;

					}

					if (!collide) {
						if (o.toString().equals("PLAYER"))
							playerDentro = (Player) o;
						oggettiPresentiNellaMappa.add(o);
					}

				}
		}
	}


	private void adattaDimensionePerMuriPerimetrali() {
		int numeroMuriLungoWidth, numeroMuriLungoHeight;

		if (width % WIDTH_MURO != 0) {
			numeroMuriLungoWidth = width / WIDTH_MURO + 1;
			this.width = numeroMuriLungoWidth * WIDTH_MURO;

		}
		if (height % HEIGHT_MURO != 0) {
			numeroMuriLungoHeight = height / HEIGHT_MURO + 1;
			this.height = numeroMuriLungoHeight * HEIGHT_MURO;
		}

	}

	private void muriPerimetrali() {
		int numeroMuriLungoWidth, numeroMuriLungoHeight;
		numeroMuriLungoWidth = width / WIDTH_MURO;
		numeroMuriLungoHeight = height / HEIGHT_MURO;
		Vector2d posXALTO = new Vector2d(0, 0);
		Vector2d incrX = new Vector2d(WIDTH_MURO, 0);
		Vector2d posXBASSO = new Vector2d(0, height - HEIGHT_MURO);

		Vector2d posYSINISTRA = new Vector2d(0, 0 + HEIGHT_MURO);
		Vector2d incrY = new Vector2d(0, HEIGHT_MURO);
		Vector2d posYDESTRA = new Vector2d(width - WIDTH_MURO, 0 + HEIGHT_MURO);

		for (int i = 1; i <= numeroMuriLungoWidth; i++) {
			AbstractStaticObject muroAlto = new Wall(posXALTO, WIDTH_MURO, HEIGHT_MURO, "MUROPERIMETRALEORIZZONTALE");
			oggettiPresentiNellaMappa.add(muroAlto);
			posXALTO = posXALTO.add(incrX);
			AbstractStaticObject muroBasso = new Wall(posXBASSO, WIDTH_MURO, HEIGHT_MURO, "MUROPERIMETRALEORIZZONTALE");
			oggettiPresentiNellaMappa.add(muroBasso);
			posXBASSO = posXBASSO.add(incrX);
		}
		for (int j = 1; j <= numeroMuriLungoHeight - 2; j++) {
			AbstractStaticObject muroSinistro = new Wall(posYSINISTRA, WIDTH_MURO, HEIGHT_MURO,
					"MUROPERIMETRALEVERTICALE");
			oggettiPresentiNellaMappa.add(muroSinistro);
			posYSINISTRA = posYSINISTRA.add(incrY);
			AbstractStaticObject muroDestro = new Wall(posYDESTRA, WIDTH_MURO, HEIGHT_MURO, "MUROPERIMETRALEVERTICALE");
			oggettiPresentiNellaMappa.add(muroDestro);
			posYDESTRA = posYDESTRA.add(incrY);
		}
	}

	private void rimuoviOggetto(Vector2d posizioneOggettoDaRimuovere) {
		AbstractStaticObject o = new Wall(posizioneOggettoDaRimuovere, 1, 1, "TEMPORANEO");

		for (int i = 0; i < oggettiPresentiNellaMappa.size(); i++) {
			AbstractStaticObject o1 = oggettiPresentiNellaMappa.get(i);
			if (o1.collide(o)) {
				if (o1.toString() == "PLAYER")
					playerDentro = null;
				else if (o1.toString() == "MUROPERIMETRALEORIZZONTALE" || o1.toString() == "MUROPERIMETRALEVERTICALE") 
					break;// non si puo
				
				else if (o1.toString() == "PORTA") {
					porteDentroCount--;
					if (o1.topLeft.y == 0 || o1.topLeft.y == height - HEIGHT_MURO)
						oggettiPresentiNellaMappa
								.add(new Wall(o1.topLeft, WIDTH_MURO, HEIGHT_MURO, "MUROPERIMETRALEORIZZONTALE"));
					else if (o1.topLeft.x == 0 || o1.topLeft.x == width - WIDTH_MURO)
						oggettiPresentiNellaMappa
								.add(new Wall(o1.topLeft, WIDTH_MURO, HEIGHT_MURO, "MUROPERIMETRALEVERTICALE"));

				}
				oggettiPresentiNellaMappa.remove(o1);
				break;
			}

		}
		o = null;
	}

	private boolean inserirePortaAlPostoDelMuro(Vector2d pos) {

		AbstractStaticObject o = new AbstractStaticObject(pos, 1, 1) {
		};

		Wall w = new Wall(pos, WIDTH_PORTA, HEIGHT_PORTA, "PORTA");

		Vector2d altosin = new Vector2d(0, 0);
		Vector2d altodes = new Vector2d(width - WIDTH_MURO, 0);
		Vector2d bassosin = new Vector2d(0, height - HEIGHT_MURO);
		Vector2d bassodes = new Vector2d(width - WIDTH_MURO, height - HEIGHT_MURO);

		for (int i = 0; i < oggettiPresentiNellaMappa.size(); i++) {
			AbstractStaticObject o1 = oggettiPresentiNellaMappa.get(i);
			if ((o1.toString().equals("MUROPERIMETRALEORIZZONTALE") || o1.toString().equals("MUROPERIMETRALEVERTICALE"))
					&& o1.collide(o) && !o1.topLeft.equals(altosin) && !o1.topLeft.equals(altodes)
					&& !o1.topLeft.equals(bassodes) && !o1.topLeft.equals(bassosin)) {

				w.topLeft.x = (o1.topLeft.x);
				w.topLeft.y = (o1.topLeft.y);

				oggettiPresentiNellaMappa.remove(o1);

				oggettiPresentiNellaMappa.add(w);
				return true;
			}
		}
		return false;
	}
	
	

public boolean isPossibleSave(){
	
	for (AbstractStaticObject o : oggettiPresentiNellaMappa) {
		if(o.toString().equals("PORTA"))
			if(!raggiungePlayer(o))
				return false;
	}
	return true;
}

private boolean raggiungePlayer(AbstractStaticObject p) {

	double angolo = 0;
	Vector2d posizioneIniziale = new Vector2d();

	ArrayList<Wall> oggettiFermi = new ArrayList<>();
	
	for (AbstractStaticObject o : oggettiPresentiNellaMappa) {
		if( (!o.centro.equals(playerDentro.centro)) && 
			(!o.toString().equals("MUROPERIMETRALEORIZZONTALE")) &&
			(!o.toString().equals("MUROPERIMETRALEVERTICALE")) &&
			(!o.toString().equals("ARMA1")) &&
			(!o.toString().equals("ARMA2")) &&
			(!o.toString().equals("ARMA3")) &&			
			(!o.toString().equals("PORTA")) ) {
			oggettiFermi.add((Wall) o);
		}
	}
	
	
	if(p.topLeft.x == 0){
		posizioneIniziale.y = p.topLeft.y;
		posizioneIniziale = posizioneIniziale.ruotaPunto(90*Math.PI/180,new Vector2d(posizioneIniziale.add(new Vector2d(Editor.HEIGHT_ZOMBIE/2,Editor.WIDTH_ZOMBIE/2))));
		posizioneIniziale.x = Editor.WIDTH_PORTA+Editor.WIDTH_ZOMBIE;
		}
	else if(p.topLeft.x == width-Editor.WIDTH_MURO){
		posizioneIniziale.y = p.topLeft.y;
		posizioneIniziale = posizioneIniziale.ruotaPunto(90*Math.PI/180,new Vector2d(posizioneIniziale.add(new Vector2d(Editor.HEIGHT_ZOMBIE/2,Editor.WIDTH_ZOMBIE/2))));
		posizioneIniziale.x = width - Editor.WIDTH_PORTA-Editor.WIDTH_ZOMBIE;
		angolo = 180;
		}
	else if(p.topLeft.y == 0){
		posizioneIniziale.x = p.topLeft.x;
		posizioneIniziale.y = Editor.HEIGHT_PORTA+Editor.WIDTH_ZOMBIE;
		angolo = 90;
		}
	else if(p.topLeft.y == height - Editor.HEIGHT_MURO){
		posizioneIniziale.x = p.topLeft.x;
		posizioneIniziale.y = height - Editor.HEIGHT_PORTA-Editor.WIDTH_ZOMBIE;
		angolo = 270;
		}
	
	Zombie z = new Zombie(posizioneIniziale, Editor.WIDTH_ZOMBIE, Editor.HEIGHT_ZOMBIE,
			angolo, Mondo.SPEED_ZOMBIE,Mondo.HEALTH_ZOMBIE,Mondo.SCORE_ZOMBIE, Mondo.POWER_ZOMBIE,Mondo.RANGE_ZOMBIE,0);
	
	Grafo grafo = new Grafo();
	
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
					
				angolo = (new Vector2d(n1.x-n2.x, n1.y-n2.y)).angolo();
					
				AbstractDynamicObject z2 = new AbstractDynamicObject
					(topRect,Editor.WIDTH_ZOMBIE,(int) dist,angolo,1) {};
					
				boolean aggiungilo = true;
				
				if(!grafo.rimaneConfiniMappa(z2,width,height))
					aggiungilo=false;
				
		for (Iterator iterator = oggettiFermi.iterator(); iterator.hasNext()&&aggiungilo;) {
			Wall w = (Wall) iterator.next();
					if(w.collide(z2))
						aggiungilo=false;
			}
				
		if(aggiungilo)
			grafo.addArco(n1,n2);
				}
			}
		}

		grafo.addEntityInGraph(0, playerDentro.topLeft, oggettiFermi, width, height);
		grafo.addEntityInGraph(1, playerDentro.topRight, oggettiFermi, width, height);
		grafo.addEntityInGraph(2, playerDentro.bottomLeft, oggettiFermi, width, height);
		grafo.addEntityInGraph(3, playerDentro.bottomRight, oggettiFermi, width, height);

		grafo.addEntityInGraph(4, z.centro, oggettiFermi, width, height);
		
		
		for(int i=0;i<4;i++) {
		Vector2d prossimoNodo = grafo.aStarFirstNode(i);
			if(prossimoNodo!=null){
				return true;
			}
		}
	
			return false;
}

};