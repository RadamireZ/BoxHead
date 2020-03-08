package logic;

import logic.Arma;

public class Arma {

	public int power;
	public int caricatore;
	public double range;
	
	public double speedBullet;
	public long timeBetweenBullet;

	public int widthBullet;
	public int heightBullet;
	
	public Arma(int power, int caricatore, double range,double speedBullet, long timeBetweenBullet,int widthBullet,int heightBullet ) {
		this.power= power;
		this.caricatore= caricatore;
		this.range= range;
		this.speedBullet = speedBullet;
		this.timeBetweenBullet= timeBetweenBullet;
		this.heightBullet= heightBullet;
		this.widthBullet= widthBullet;
		
		
	}
	
	public Arma(Arma a) {
		this.power=a.power;
		this.caricatore=a.caricatore;
		this.range=a.range;	
		this.speedBullet=a.speedBullet;
		this.timeBetweenBullet=a.timeBetweenBullet;
		this.heightBullet=a.heightBullet;
		this.widthBullet=a.widthBullet;	

		}
	
};