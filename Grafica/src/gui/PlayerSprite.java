package gui;

import logic.Vector2d;


public class PlayerSprite {


	public Vector2d topLeft;
	
	private ImageProvider provider;
	
	public AnimationImages animation;

	private double posizionePrecedente;
	
	private int armaPrecedente;
	
	public int width,height;
	
	public PlayerSprite(ImageProvider provider) {

		super();
		
		this.provider = provider;

		armaPrecedente = -1;
		
		animation = new AnimationImages(CameraPanel.PERIOD,700,true,2,provider.player_nord);

		posizionePrecedente = -1;	
		
		
		topLeft = new Vector2d(-1000,-1000);

	}
	
	
	

	public void updateSprite(double orientation,int selectedArm,boolean fermo) {


		if(armaPrecedente!=selectedArm || orientation!=posizionePrecedente){
			posizionePrecedente = orientation;
			armaPrecedente = selectedArm;
			
		switch (selectedArm) {
			
		case -1:
			animation.positionStop = 2;

			if(orientation==270) {
				animation.setArray(provider.player_nord);
				topLeft.x = -35;
				topLeft.y = -105;
				}
			else if(orientation==90) {
				animation.setArray(provider.player_sud);
				topLeft.x = -35;
				topLeft.y = -105;
				}	
			else if(orientation==315) {
				animation.setArray(provider.player_nord_est);
				topLeft.x = -40;
				topLeft.y = -110;
				}
			else if(orientation==135) {
				animation.setArray(provider.player_sud_ovest);
				topLeft.x = -38;
				topLeft.y = -115;
				}				
			else if(orientation==225) {
				animation.setArray(provider.player_nord_ovest);
				topLeft.x =	-37;
				topLeft.y = -110;
				}
			else if(orientation==45) {
				animation.setArray(provider.player_sud_est);
				topLeft.x = -43;
				topLeft.y = -112;
				}

			else if(orientation==0) {
				animation.setArray(provider.player_est);
				topLeft.x = -27;
				topLeft.y = -107;
				}
			else if(orientation==180) {
				animation.setArray(provider.player_ovest);
				topLeft.x = -24;
				topLeft.y = -107;
				}

			
			break;
		case 1:
			animation.positionStop = 5;


			if(orientation==270) {
				animation.setArray(provider.player_nord_arma1);
				topLeft.x = -35;
				topLeft.y = -105;
				}
			else if(orientation==90) {
				animation.setArray(provider.player_sud_arma1);
				topLeft.x = -35;
				topLeft.y = -105;
				}	
			else if(orientation==315) {
				animation.setArray(provider.player_nord_est_arma1);
				topLeft.x = -35;
				topLeft.y = -111;
				}
			else if(orientation==135) {
				animation.setArray(provider.player_sud_ovest_arma1);
				topLeft.x = -80;
				topLeft.y = -112;
				}				
			else if(orientation==225) {
				animation.setArray(provider.player_nord_ovest_arma1);
				topLeft.x =	-39;
				topLeft.y = -112;
				}
			else if(orientation==45) {
				animation.setArray(provider.player_sud_est_arma1);
				topLeft.x = -37;
				topLeft.y = -111;
				}
			else if(orientation==0) {
				animation.setArray(provider.player_est_arma1);
				topLeft.x = -18;
				topLeft.y = -107;
				}
			else if(orientation==180) {
				animation.setArray(provider.player_ovest_arma1);
				topLeft.x = -84;
				topLeft.y = -107;
				}
			
			
			break;
		case 2:
			animation.positionStop = 5;

			if(orientation==270) {
				animation.setArray(provider.player_nord_arma2);
				topLeft.x = -35;
				topLeft.y = -109;
				}
			else if(orientation==90) {
				animation.setArray(provider.player_sud_arma2);
				topLeft.x = -35;
				topLeft.y = -105;
				}	
			else if(orientation==315) {
				animation.setArray(provider.player_nord_est_arma2);
				topLeft.x = -37;
				topLeft.y = -114;
				}
			else if(orientation==135) {
				animation.setArray(provider.player_sud_ovest_arma2);
				topLeft.x = -80;
				topLeft.y = -113;
				}				
			else if(orientation==225) {
				animation.setArray(provider.player_nord_ovest_arma2);
				topLeft.x =	-37;
				topLeft.y = -114;
				}
			else if(orientation==45) {
				animation.setArray(provider.player_sud_est_arma2);
				topLeft.x = -38;
				topLeft.y = -110;
				}
			else if(orientation==0) {
				animation.setArray(provider.player_est_arma2);
				topLeft.x = -22;
				topLeft.y = -107;
				}
			else if(orientation==180) {
				animation.setArray(provider.player_ovest_arma2);
				topLeft.x = -76;
				topLeft.y = -107;
				}
			
			break;	
		case 3:
			animation.positionStop = 5;

			
			if(orientation==270) {
				animation.setArray(provider.player_nord_arma3);
				topLeft.x = -35;
				topLeft.y = -105;
				}
			else if(orientation==90) {
				animation.setArray(provider.player_sud_arma3);
				topLeft.x = -35;
				topLeft.y = -105;
				}	
			else if(orientation==315) {
				animation.setArray(provider.player_nord_est_arma3);
				topLeft.x = -34;
				topLeft.y = -110;
				}
			else if(orientation==135) {
				animation.setArray(provider.player_sud_ovest_arma3);
				topLeft.x = -80;
				topLeft.y = -115;
				}				
			else if(orientation==225) {
				animation.setArray(provider.player_nord_ovest_arma3);
				topLeft.x =	-39;
				topLeft.y = -112;
				}
			else if(orientation==45) {
				animation.setArray(provider.player_sud_est_arma3);
				topLeft.x = -38;
				topLeft.y = -113;
				}
			else if(orientation==0) {
				animation.setArray(provider.player_est_arma3);
				topLeft.x = -20;
				topLeft.y = -107;
				}
			else if(orientation==180) {
				animation.setArray(provider.player_ovest_arma3);
				topLeft.x = -84;
				topLeft.y = -107;
				}

			
			break;
		default:
			break;
			}
		}	

		if(fermo )
			animation.stop();
		else if(armaPrecedente == selectedArm && orientation == posizionePrecedente){
			animation.updateTick();
			
			}
		width = animation.getCurrentImage().getWidth(null);
		height = animation.getCurrentImage().getHeight(null);
	}

	
	
	
	
	
}
