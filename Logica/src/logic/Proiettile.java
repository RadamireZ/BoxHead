package logic;

import java.util.ArrayList;

public class Proiettile extends AbstractDynamicObject{
	
double range;
int danno;
public String appartenenza; 

public Proiettile(final Vector2d topLeft, final Vector2d topRight, final Vector2d bottomLeft,
		final Vector2d bottomRight, final Vector2d centro, final int width, final int height,
		final double direction,final double orientation, final double speedMax, 
		final double speedCurr, double rangeMassimo, int danno, String appartenenza){

	super(topLeft, topRight, bottomLeft, bottomRight, centro,width, height, direction,
		orientation, speedMax, speedCurr );

	this.range = rangeMassimo;
	this.danno = danno;
	this.appartenenza = appartenenza;
		
}




public Proiettile(Proiettile proiettile) {

	super(proiettile);
	
	this.range = proiettile.range;
	this.danno = proiettile.danno;
	this.appartenenza = proiettile.appartenenza;
}





public Proiettile(Vector2d topLeft, int widthBullet, int heightBullet,
	double direzione, double speedBullet,
	double rangeMassimo, int danno, String appartenenza) {
	super(topLeft,widthBullet,heightBullet,direzione,speedBullet);
	
	this.range = rangeMassimo;
	this.danno = danno;
	this.appartenenza = appartenenza;
	
	speedCurr = speedBullet;
}


public ArrayList<Proiettile> spostamentoProiettile(Proiettile a){

	ArrayList<Proiettile> arrai = new ArrayList<Proiettile>();
	
	speedCurr = height;

	arrai.add( new Proiettile(this) );
	
	while(!this.collide(a)){
		

		this.update();
		
		arrai.add( new Proiettile(this) );		
		
		if(this.range==0)
			break;

		}

	arrai.add( new Proiettile(a) );
	
	return arrai;
	}



@Override
	public void update() {
		if(range-speedCurr>0){
			super.update();
			range -= speedCurr;
		}
		else if (range>0){
			speedCurr = range;
			super.update();
			range -= speedCurr;  // quindi =0
		}
}



public StringBuilder statusToStringBuilder(){
	StringBuilder sb = new StringBuilder();
	
	sb.append( super.statusToStringBuilder() );

	sb.append(":");
	sb.append(range);
	
	sb.append(":");
	sb.append(danno);
	
	sb.append(":");
	sb.append(appartenenza);
	
	
	return sb;
}


};