package logic;

import java.util.HashMap;
import java.util.Map.Entry;

import core.Editor;
import logic.AbstractCharacter;
import logic.Arma;
import logic.Player;
import logic.Proiettile;
import logic.Vector2d;



public class Player extends AbstractCharacter {
		
	
	public HashMap<Integer,Arma>arms;
		
	public int selectArm ;
		
	private long timeLastBulletARMA1;
	private long timeLastBulletARMA2;
	private long timeLastBulletARMA3;
		
	public long timeLastDamage;
		

	public Player(final Vector2d topLeft, final Vector2d topRight, final Vector2d bottomLeft,
		final Vector2d bottomRight, final Vector2d centro,int width,int height, final double direction,
		final double orientation, final double speedMax, final double speedCurr, int health,int score,
		int caricatore1, int caricatore2,int caricatore3,int selectArm, long timeLastBulletARMA1,
		long timeLastBulletARMA2,long timeLastBulletARMA3,long timeLastDamage) {
		
		super(topLeft, topRight, bottomLeft, bottomRight, centro, width, height,
				direction, orientation, speedMax,speedCurr, health, score);
		
		
		this.arms = new HashMap<Integer, Arma>();	
		
		arms.put(1,new Arma(Mondo.ARMA1));
		arms.put(2,new Arma(Mondo.ARMA2));
		arms.put(3,new Arma(Mondo.ARMA3));
			
		arms.get(1).caricatore = caricatore1;
		arms.get(2).caricatore = caricatore2;
		arms.get(3).caricatore = caricatore3;
		
		
			this.selectArm = selectArm;
			
			this.timeLastBulletARMA1 = timeLastBulletARMA1;
			this.timeLastBulletARMA2 = timeLastBulletARMA2;
			this.timeLastBulletARMA3 = timeLastBulletARMA3;	
			this.timeLastDamage = timeLastDamage;
	}
	

	public Player(final Vector2d topLeft, final int width, final int height, final double direction,
			final double speed) {
		
	super(topLeft, width, height, direction, speed, Editor.HEALTH_PLAYER, 0);
		
		
		
	this.arms = new HashMap<Integer, Arma>();	
	
	arms.put(1,new Arma(Mondo.ARMA1));
	arms.put(2,new Arma(Mondo.ARMA2));
	arms.put(3,new Arma(Mondo.ARMA3));

	
	for (Entry<Integer, Arma> a : arms.entrySet()) {
		a.getValue().caricatore=0;
	}
		
		selectArm = -1;
		
		timeLastBulletARMA1=0;
		timeLastBulletARMA2=0;
		timeLastBulletARMA3=0;	
		timeLastDamage=0;
	}		
	
	public Player(Player player) {
		
		super(player);
		arms = new HashMap<Integer,Arma>();
		
		for(Entry<Integer,Arma> ea : player.arms.entrySet()) {
			
			arms.put(ea.getKey(),new Arma(ea.getValue()));
			
		}
		
		selectArm = player.selectArm;
			
		timeLastBulletARMA1=player.timeLastBulletARMA1;
		timeLastBulletARMA2=player.timeLastBulletARMA2;
		timeLastBulletARMA3=player.timeLastBulletARMA3;
			
		timeLastDamage = player.timeLastDamage;
	}


	public void addScore(int scor) {
		this.score += scor;
	}

	
		public void addArma(Arma a){
			if(a==Mondo.ARMA1){
				arms.get(1).caricatore += a.caricatore;
				if(selectArm==-1)
					selectArm=1;
			}
			else if(a==Mondo.ARMA2){
				arms.get(2).caricatore += a.caricatore;
				if(selectArm==-1)
					selectArm=2;
			}
			else if(a==Mondo.ARMA3){
				arms.get(3).caricatore += a.caricatore;
				if(selectArm==-1)
					selectArm=3;
			}

			
		}
		
		
	public void selectArmaSuccessiva(){
		if(selectArm != -1){
			
					do{
						if(selectArm==3)
							selectArm=1;
						else
							selectArm++;
				
					}while(arms.get(selectArm).caricatore == 0);

				}
		}
		

	
	
	public void selectArmaPrecedente(){
			if(selectArm != -1){
					do{	
						if(selectArm==1)
							selectArm=3;
						else
							selectArm--;
					
			
					}while(arms.get(Math.abs(selectArm)).caricatore == 0);
			}
	}
		
	
	public void selectPrimaArmaCheTrova(){
		selectArm=-1;
		for(int i=1;i<=3;i++)
			if(arms.get(i).caricatore != 0)
				selectArm=i;
	}
		
	
	public Proiettile spara(String name){
			Proiettile p = null;
			
	
			
	if(selectArm!=-1){
		
		switch (selectArm) {
		case 1:
			if(System.currentTimeMillis()-timeLastBulletARMA1 < arms.get(selectArm).timeBetweenBullet)  
				return p;
			break;
		case 2:
			if(System.currentTimeMillis()-timeLastBulletARMA2 < arms.get(selectArm).timeBetweenBullet)  
				return p;
			break;
		case 3:
			if(System.currentTimeMillis()-timeLastBulletARMA3 < arms.get(selectArm).timeBetweenBullet)  
				return p;
			break;
		}
		
	
	if(orientationAngle== 0)//EST
		p= new Proiettile( this.topRight,
		arms.get(selectArm).widthBullet, arms.get(selectArm).heightBullet, orientationAngle,
		arms.get(selectArm).speedBullet, arms.get(selectArm).range, 
		arms.get(selectArm).power,name);

	if(orientationAngle==180)//OVEST
		p= new Proiettile(this.topRight, arms.get(selectArm).widthBullet,
		arms.get(selectArm).heightBullet, orientationAngle, 
		arms.get(selectArm).speedBullet, 
		arms.get(selectArm).range, arms.get(selectArm).power, name);

	if(orientationAngle==270)//NORD
		p= new Proiettile(this.topRight,
		arms.get(selectArm).widthBullet, arms.get(selectArm).heightBullet, orientationAngle,
		arms.get(selectArm).speedBullet, arms.get(selectArm).range,
		arms.get(selectArm).power, name);

	if(orientationAngle==90)//SUD
		p= new Proiettile(this.topRight, arms.get(selectArm).widthBullet,
		arms.get(selectArm).heightBullet, orientationAngle, arms.get(selectArm).speedBullet,
		arms.get(selectArm).range, arms.get(selectArm).power, name);

	if(orientationAngle==315)//NORD EST
		p= new Proiettile(this.topRight,
		arms.get(selectArm).widthBullet, arms.get(selectArm).heightBullet, orientationAngle,
		arms.get(selectArm).speedBullet, arms.get(selectArm).range,
		arms.get(selectArm).power, name);		

	if(orientationAngle==225)//NORD OVEST
		p= new Proiettile(this.topRight,
		arms.get(selectArm).widthBullet, arms.get(selectArm).heightBullet, orientationAngle,
		arms.get(selectArm).speedBullet, arms.get(selectArm).range,
		arms.get(selectArm).power, name);		

	if(orientationAngle==45)//SUD EST
		p= new Proiettile(this.topRight, arms.get(selectArm).widthBullet,
		arms.get(selectArm).heightBullet, orientationAngle,
		arms.get(selectArm).speedBullet, arms.get(selectArm).range,
		arms.get(selectArm).power, name);		

	if(orientationAngle==135)//SUD OVEST
		p= new Proiettile(this.topRight, arms.get(selectArm).widthBullet,
		arms.get(selectArm).heightBullet, orientationAngle, arms.get(selectArm).speedBullet,
		arms.get(selectArm).range ,arms.get(selectArm).power, name);


//	p.speedCurr = p.speedMax;
	
	arms.get(selectArm).caricatore--;
		if(arms.get(selectArm).caricatore==0)
				selectPrimaArmaCheTrova();
					
		
		switch (selectArm) {
		case 1:
			timeLastBulletARMA1=System.currentTimeMillis();
			break;
		case 2:
			timeLastBulletARMA2=System.currentTimeMillis();
			break;
		case 3:
			timeLastBulletARMA3=System.currentTimeMillis();
			break;
		}
		
	}			
			
			return p;
		}
		
	
	public void rigeneraHealt(long time) {
		if(health <Editor.HEALTH_PLAYER) {
		if(time - timeLastDamage >= Mondo.TIMERIGENERATE_PLAYER)
			health+=1;
		}
	}
	
	
	public StringBuilder statusToStringBuilder(){
		
		StringBuilder sb = new StringBuilder();
		
		sb.append( super.statusToStringBuilder() );
		
		sb.append(":");
		
		sb.append(arms.get(1).caricatore);
		
		sb.append(":");
		
		sb.append(arms.get(2).caricatore);
		
		sb.append(":");
		
		sb.append(arms.get(3).caricatore);
		
		sb.append(":");
		
		sb.append(selectArm);
		
		sb.append(":");
		
		sb.append(timeLastBulletARMA1);
		
		sb.append(":");
		
		sb.append(timeLastBulletARMA2);
		
		sb.append(":");
		
		sb.append(timeLastBulletARMA3);

		sb.append(":");
		
		sb.append(timeLastDamage);
		
		return sb;
		
	}

	
@Override
public String toString() {
return "PLAYER";
}




}
