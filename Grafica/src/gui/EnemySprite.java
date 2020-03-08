package gui;

import java.awt.Image;
import java.util.ArrayList;

import logic.AbstractStaticObject;
import logic.Vector2d;

public class EnemySprite extends AbstractStaticObject {

	
	
	private boolean inAttacco;

	private ImageProvider provider;
	
	public AnimationImages animation;

	public double posizionePrecedente;
		
	public String tipo;
	
	//normal
	public EnemySprite(ImageProvider provider) {
		super(new Vector2d(0,0),0,0);
		this.provider = provider;
		
		tipo="VIVO";
		animation = new AnimationImages(CameraPanel.PERIOD,1400,false,0,provider.zombie_nord);
		
		posizionePrecedente = -1;	
		
		inAttacco =false;
		
	}
	
	
	private double semplificaAngoli(double angle) {
		if(angle > 349 || angle < 11)
			return 0;
		else if(angle >= 11 && angle <= 79)
			return 45;
		else if(angle > 79 && angle < 101)
			return 90;
		else if(angle >= 101 && angle <= 169 ) 
			return 135;
		else if(angle > 169 && angle < 191 )
			return 180;	
		else if(angle >= 191 && angle <= 256 )
			return 225;		
		else if(angle > 256 && angle < 281 )
			return 270;
		else
			return 315;
	}
	
	//when dead
	public EnemySprite(ImageProvider provider,double orientamento,Vector2d topLeftOriginale){
		super(topLeftOriginale,1,1);
		
		orientamento = semplificaAngoli(orientamento);
		
		tipo="MORTO";
		this.provider = provider;

		posizionePrecedente = orientamento;
		
		if(orientamento == 270) {
			animation = new AnimationImages(CameraPanel.PERIOD,1400,false,0,provider.zombie_morto_nord);
			topLeft.x += -34;
			topLeft.y += -103;
			width = 97;
			height = 135;
		}
		else if(orientamento == 315) {
			animation = new AnimationImages(CameraPanel.PERIOD,1400,false,0,provider.zombie_morto_nord_est);
			topLeft.x += -24;
			topLeft.y += -107;
			width = 97;
			height = 135;
		}
		else if(orientamento == 225) {
			animation = new AnimationImages(CameraPanel.PERIOD,1400,false,0,provider.zombie_morto_nord_ovest);
			topLeft.x += -45;
			topLeft.y += -100;
			width = 147;
			height = 130;
			}
		else if(orientamento == 90) {
			animation = new AnimationImages(CameraPanel.PERIOD,1400,false,0,provider.zombie_morto_sud);
			topLeft.x += -32;
			topLeft.y += -94;
			width = 96;
			height = 148;
			}
		else if(orientamento == 45) {
			animation = new AnimationImages(CameraPanel.PERIOD,1400,false,0,provider.zombie_morto_sud_est);
			topLeft.x += -60;
			topLeft.y += -105;
			width = 149;
			height = 137;
			}
		else if(orientamento == 135) {
			animation = new AnimationImages(CameraPanel.PERIOD,1400,false,0,provider.zombie_morto_sud_ovest);
			topLeft.x += -73;
			topLeft.y += -105;
			width = 96;
			height = 148;
			}
		else if(orientamento == 0) {
			animation = new AnimationImages(CameraPanel.PERIOD,1400,false,0,provider.zombie_morto_est);
			topLeft.x += -60;
			topLeft.y += -105;
			width = 149;
			height = 137;
			}
		else if(orientamento == 180) {
			animation = new AnimationImages(CameraPanel.PERIOD,1400,false,0,provider.zombie_morto_ovest);
			topLeft.x += -67;
			topLeft.y += -110;
			width = 147;
			height = 130;
			}
		topRight.x = topLeft.x + width;
		topRight.y = topLeft.y;
		bottomLeft.x = topLeft.x;
		bottomLeft.y = topLeft.y + height;
		bottomRight.x = topLeft.x + width;
		bottomRight.y = topLeft.y + height;
	}
	
	
	//cadavere
	public EnemySprite(ImageProvider provider,double orientamento,Vector2d topLeftOriginale,float t){
			super(topLeftOriginale,1,1);
			tipo="CADAVERE";
			this.provider = provider;

			posizionePrecedente = orientamento;

			ArrayList<Image> singolo = new ArrayList<>();

			if(orientamento == 270) {
				singolo.add(provider.zombie_morto_nord.get(provider.zombie_morto_nord.size()-1));
				animation = new AnimationImages(CameraPanel.PERIOD,CameraPanel.PERIOD,true,0,singolo);
				width = 97;
				height = 135;
			}
			else if(orientamento == 315) {
				singolo.add(provider.zombie_morto_nord_est.get(provider.zombie_morto_nord_est.size()-1));
				animation = new AnimationImages(CameraPanel.PERIOD,CameraPanel.PERIOD,true,0,singolo);
				width = 97;
				height = 135;
			}
			else if(orientamento == 225) {
				singolo.add(provider.zombie_morto_nord_ovest.get(provider.zombie_morto_nord_ovest.size()-1));
				animation = new AnimationImages(CameraPanel.PERIOD,CameraPanel.PERIOD,true,0,singolo);
				width = 147;
				height = 130;
				}
			else if(orientamento == 90) {
				singolo.add(provider.zombie_morto_sud.get(provider.zombie_morto_sud.size()-1));
				animation = new AnimationImages(CameraPanel.PERIOD,CameraPanel.PERIOD,true,0,singolo);
				width = 96;
				height = 148;
			}
			else if(orientamento == 45) {
				singolo.add(provider.zombie_morto_sud_est.get(provider.zombie_morto_sud_est.size()-1));
				animation = new AnimationImages(CameraPanel.PERIOD,CameraPanel.PERIOD,true,0,singolo);
				width = 149;
				height = 137;
			}
			else if(orientamento == 135) {
				singolo.add(provider.zombie_morto_sud_ovest.get(provider.zombie_morto_sud_ovest.size()-1));
				animation = new AnimationImages(CameraPanel.PERIOD,CameraPanel.PERIOD,true,0,singolo);
				width = 96;
				height = 148;
			}
			else if(orientamento == 0) {
				singolo.add(provider.zombie_morto_est.get(provider.zombie_morto_est.size()-1));
				animation = new AnimationImages(CameraPanel.PERIOD,CameraPanel.PERIOD,true,0,singolo);
				width = 149;
				height = 137;
			}
			else if(orientamento == 180) {
				singolo.add(provider.zombie_morto_ovest.get(provider.zombie_morto_ovest.size()-1));
				animation = new AnimationImages(CameraPanel.PERIOD,CameraPanel.PERIOD,true,0,singolo);
				width = 147;
				height = 130;
			}		

		topRight.x = topLeft.x + width;
		topRight.y = topLeft.y;
		bottomLeft.x = topLeft.x;
		bottomLeft.y = topLeft.y + height;
		bottomRight.x = topLeft.x + width;
		bottomRight.y = topLeft.y + height;
	}	

		
	
	public void updateSpriteAttack(double orientamento){
		
		orientamento = semplificaAngoli(orientamento);
		
		if(inAttacco){
			animation.updateTick();
			}
		else {
		posizionePrecedente = -1;
		inAttacco = true;
		if(orientamento == 270) {
			animation = new AnimationImages(CameraPanel.PERIOD,800,true,0,provider.zombie_attack_nord);
			topLeft.x = -34;
			topLeft.y = -103;
			width = 79;
			height = 137;
		}
		else if(orientamento == 315) {
			animation = new AnimationImages(CameraPanel.PERIOD,800,true,0,provider.zombie_attack_nord_est);
			topLeft.x = -24;
			topLeft.y = -117;
			width = 103;
			height = 144;
		}
		else if(orientamento == 225) {
			animation = new AnimationImages(CameraPanel.PERIOD,800,true,0,provider.zombie_attack_nord_ovest);
			topLeft.x = -45;
			topLeft.y = -120;
			width = 101;
			height = 144;
		}
		else if(orientamento == 90) {
			animation = new AnimationImages(CameraPanel.PERIOD,800,true,0,provider.zombie_attack_sud);
			topLeft.x = -32;
			topLeft.y = -94;
			width = 84;
			height = 134;
		}
		else if(orientamento == 45) {
			animation = new AnimationImages(CameraPanel.PERIOD,800,true,0,provider.zombie_attack_sud_est);
			topLeft.x = -34;
			topLeft.y = -107;
			width = 100;
			height = 150;
		}
		else if(orientamento == 135) {
			animation = new AnimationImages(CameraPanel.PERIOD,800,true,0,provider.zombie_attack_sud_ovest);
			topLeft.x = -73;
			topLeft.y = -105;
			width = 107;
			height = 150;
		}
		else if(orientamento == 0) {
			animation = new AnimationImages(CameraPanel.PERIOD,800,true,0,provider.zombie_attack_est);
			topLeft.x = -24;
			topLeft.y = -105;
			width = 84;
			height = 136;
			}
		else if(orientamento == 180) {
			animation = new AnimationImages(CameraPanel.PERIOD,800,true,0,provider.zombie_attack_ovest);
			topLeft.x = -67;
			topLeft.y = -110;
			width = 89;
			height = 135;	
			}
		}	

	}
	
	//walk
	public void updateSprite(double orientamento, boolean fermo) {
		inAttacco = false;
		orientamento = semplificaAngoli(orientamento);
		
		if(fermo)
			animation.stop();
		
		
		
		else if( orientamento == posizionePrecedente )
			animation.updateTick();
		

		else{
			posizionePrecedente = orientamento;
			
			if(orientamento == 270) {
				animation = new AnimationImages(CameraPanel.PERIOD,700,true,3,provider.zombie_nord);
				topLeft.x = -34;
				topLeft.y = -103;
				width = 70;
				height = 137;
			}
			else if(orientamento == 315) {
				animation = new AnimationImages(CameraPanel.PERIOD,700,true,3,provider.zombie_nord_est);
				topLeft.x = -24;
				topLeft.y = -117;
				width = 104;
				height = 146;
			}
			else if(orientamento == 225) {
				animation = new AnimationImages(CameraPanel.PERIOD,700,true,3,provider.zombie_nord_ovest);
				topLeft.x = -65;
				topLeft.y = -120;
				width = 101;
				height = 146;
			}
			else if(orientamento == 90) {
				animation = new AnimationImages(CameraPanel.PERIOD,700,true,3,provider.zombie_sud);
				topLeft.x = -32;
				topLeft.y = -94;
				width = 70;
				height = 114;
			}
			else if(orientamento == 45) {
				animation = new AnimationImages(CameraPanel.PERIOD,700,true,3,provider.zombie_sud_est);
				topLeft.x = -34;
				topLeft.y = -107;
				width = 102;
				height = 128;
			}
			else if(orientamento == 135) {
				animation = new AnimationImages(CameraPanel.PERIOD,700,true,3,provider.zombie_sud_ovest);
				topLeft.x = -73;
				topLeft.y = -105;
				width = 108;
				height = 127;
			}
			else if(orientamento == 0) {
				animation = new AnimationImages(CameraPanel.PERIOD,700,true,3,provider.zombie_est);
				topLeft.x = -24;
				topLeft.y = -105;
				width = 86;
				height = 132;
			}
			else if(orientamento == 180) {
				animation = new AnimationImages(CameraPanel.PERIOD,700,true,3,provider.zombie_ovest);
				topLeft.x = -67;
				topLeft.y = -110;
				width = 86;
				height = 133;
			}

			
		}
	}
	
	
	
@Override
public String toString() {
	return tipo;
}
	

	
};