package gui;

import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JPanel;

public class ImageProvider {
	
	public int totaleImmagini;
	
	public int caricate=0;
	
	public Image backgroundMenu;
	public Image iconaGame;

	
	public Image ambulance ;	
	public Image camion ;
	public Image camper ;
	public Image edificio1a ;
	public Image edificio1b ;
	public Image edificio1c ;
	public Image edificio1d ;
	public Image edificio2a ;
	public Image edificio2b ;
	public Image edificio2c ;
	public Image macchina2 ;
	public Image pacchetto ;
	public Image porta ;
	public Image wallOrizzontale ;
	public Image wallVerticale ;

	//zombie
	public ArrayList<Image> zombie_sud;
	private Image ssud1;
	private Image ssud2;
	private Image ssud3;
	private Image ssud4;
	private Image ssud5;
	private Image ssud6;
	private Image ssud7;
		
	
	
	public ArrayList<Image> zombie_sud_est;
	private Image ssud_est1 ;
	private Image ssud_est2 ;
	private Image ssud_est3 ;
	private Image ssud_est4 ;
	private Image ssud_est5 ;
	private Image ssud_est6 ;
	private Image ssud_est7 ;
	
	
	public ArrayList<Image> zombie_sud_ovest;
	private Image ssud_ovest1 ;
	private Image ssud_ovest2 ;
	private Image ssud_ovest3 ;
	private Image ssud_ovest4 ;
	private Image ssud_ovest5 ;
	private Image ssud_ovest6 ;
	private Image ssud_ovest7 ;

	
	public ArrayList<Image> zombie_est;
	private Image sest1 ;
	private Image sest2 ;
	private Image sest3 ;
	private Image sest4 ;
	private Image sest5 ;
	private Image sest6 ;
	private Image sest7 ;
	

	public ArrayList<Image> zombie_ovest;
	private Image sovest1 ;
	private Image sovest2 ;
	private Image sovest3 ;
	private Image sovest4 ;
	private Image sovest5 ;
	private Image sovest6 ;
	private Image sovest7 ;


	public ArrayList<Image> zombie_nord;
	private Image snord1 ;
	private Image snord2 ;
	private Image snord3 ;
	private Image snord4 ;
	private Image snord5 ;
	private Image snord6 ;
	private Image snord7 ;


	public ArrayList<Image> zombie_nord_ovest;
	private Image snord_ovest1 ;
	private Image snord_ovest2 ;
	private Image snord_ovest3 ;
	private Image snord_ovest4 ;
	private Image snord_ovest5 ;
	private Image snord_ovest6 ;
	private Image snord_ovest7 ;


	public ArrayList<Image> zombie_nord_est;
	private Image snord_est1 ;
	private Image snord_est2 ;
	private Image snord_est3 ;
	private Image snord_est4 ;
	private Image snord_est5 ;
	private Image snord_est6 ;
	private Image snord_est7 ;
	
	
	public ArrayList<Image> zombie_attack_sud;
	private Image sasud1;
	private Image sasud2;
	private Image sasud3;
	private Image sasud4;
	
	
	public ArrayList<Image> zombie_attack_sud_est;
	private Image sasud_est1 ;
	private Image sasud_est2 ;
	private Image sasud_est3 ;
	private Image sasud_est4 ;
	
	public ArrayList<Image> zombie_attack_sud_ovest;
	private Image sasud_ovest1 ;
	private Image sasud_ovest2 ;
	private Image sasud_ovest3 ;
	private Image sasud_ovest4 ;
	
	public ArrayList<Image> zombie_attack_est;
	private Image saest1 ;
	private Image saest2 ;
	private Image saest3 ;
	private Image saest4 ;
	

	public ArrayList<Image> zombie_attack_ovest;
	private Image saovest1 ;
	private Image saovest2 ;
	private Image saovest3 ;
	private Image saovest4 ;

	public ArrayList<Image> zombie_attack_nord;
	private Image sanord1 ;
	private Image sanord2 ;
	private Image sanord3 ;
	private Image sanord4 ;

	public ArrayList<Image> zombie_attack_nord_ovest;
	private Image sanord_ovest1 ;
	private Image sanord_ovest2 ;
	private Image sanord_ovest3 ;
	private Image sanord_ovest4 ;

	public ArrayList<Image> zombie_attack_nord_est;
	private Image sanord_est1 ;
	private Image sanord_est2 ;
	private Image sanord_est3 ;
	private Image sanord_est4 ;
	
	public ArrayList<Image> zombie_morto_sud;
	private Image smsud1;
	private Image smsud2;
	
	private Image smestsud_est1;
	private Image smestsud_est2;
	private Image smestsud_est3;
	private Image smestsud_est4;
	private Image smestsud_est5;
	
	private Image smnordnord_est1 ;
	private Image smnordnord_est2 ;
	private Image smnordnord_est3 ;
	private Image smnordnord_est4 ;
	private Image smnordnord_est5 ;
	
	private Image smsudsud_ovest1 ;
	private Image smsudsud_ovest2 ;
	private Image smsudsud_ovest3 ;
	private Image smsudsud_ovest4 ;
	private Image smsudsud_ovest5 ;
	
	private Image smovestnord_ovest1 ;
	private Image smovestnord_ovest2 ;
	private Image smovestnord_ovest3 ;
	private Image smovestnord_ovest4 ;
	private Image smovestnord_ovest5 ;
	
	public ArrayList<Image> zombie_morto_sud_est;
	private Image smsud_est1 ;
	private Image smsud_est2 ;
		
	
	public ArrayList<Image> zombie_morto_sud_ovest;
	private Image smsud_ovest1 ;
	private Image smsud_ovest2 ;
	

	public ArrayList<Image> zombie_morto_est;
	private Image smest1 ;
	private Image smest2 ;
	

	public ArrayList<Image> zombie_morto_ovest;
	private Image smovest1 ;
	private Image smovest2 ;


	public ArrayList<Image> zombie_morto_nord;
	private Image smnord1 ;
	private Image smnord2 ;


	public ArrayList<Image> zombie_morto_nord_ovest;
	private Image smnord_ovest1 ;
	private Image smnord_ovest2 ;

	public ArrayList<Image> zombie_morto_nord_est;
	private Image smnord_est1 ;
	private Image smnord_est2 ;

	
	
	//player
	public ArrayList<Image> player_sud;
	private Image psud1;
	private Image psud2;
	private Image psud3;
	private Image psud4;
	private Image psud5;
	private Image psud6;
	private Image psud7;
	
	
	public ArrayList<Image> player_sud_est;
	private Image psud_est1 ;
	private Image psud_est2 ;
	private Image psud_est3 ;
	private Image psud_est4 ;
	private Image psud_est5 ;
	private Image psud_est6 ;
	private Image psud_est7 ;


	public ArrayList<Image> player_sud_ovest;
	private Image psud_ovest1 ;
	private Image psud_ovest2 ;
	private Image psud_ovest3 ;
	private Image psud_ovest4 ;
	private Image psud_ovest5 ;
	private Image psud_ovest6 ;
	private Image psud_ovest7 ;


	public ArrayList<Image> player_est;
	private Image pest1 ;
	private Image pest2 ;
	private Image pest3 ;
	private Image pest4 ;
	private Image pest5 ;
	private Image pest6 ;
	private Image pest7 ;


	public ArrayList<Image> player_ovest;
	private Image povest1 ;
	private Image povest2 ;
	private Image povest3 ;
	private Image povest4 ;
	private Image povest5 ;
	private Image povest6 ;
	private Image povest7 ;


	public ArrayList<Image> player_nord;
	private Image pnord1 ;
	private Image pnord2 ;
	private Image pnord3 ;
	private Image pnord4 ;
	private Image pnord5 ;
	private Image pnord6 ;
	private Image pnord7 ;


	public ArrayList<Image> player_nord_ovest;
	private Image pnord_ovest1 ;
	private Image pnord_ovest2 ;
	private Image pnord_ovest3 ;
	private Image pnord_ovest4 ;
	private Image pnord_ovest5 ;
	private Image pnord_ovest6 ;
	private Image pnord_ovest7 ;


	public ArrayList<Image> player_nord_est;
	private Image pnord_est1 ;
	private Image pnord_est2 ;
	private Image pnord_est3 ;
	private Image pnord_est4 ;
	private Image pnord_est5 ;
	private Image pnord_est6 ;
	private Image pnord_est7 ;

	
	public ArrayList<Image> player_sud_arma1;
	private Image pArma1sud1 ;
	private Image pArma1sud2 ;
	private Image pArma1sud3 ;
	private Image pArma1sud4 ;
	private Image pArma1sud5 ;
	private Image pArma1sud6 ;
	private Image pArma1sud7 ;

	
	public ArrayList<Image> player_sud_est_arma1;
	private Image pArma1sud_est1 ;
	private Image pArma1sud_est2 ;
	private Image pArma1sud_est3 ;
	private Image pArma1sud_est4 ;
	private Image pArma1sud_est5 ;
	private Image pArma1sud_est6 ;
	private Image pArma1sud_est7 ;

	
	public ArrayList<Image> player_sud_ovest_arma1;
	private Image pArma1sud_ovest1 ;
	private Image pArma1sud_ovest2 ;
	private Image pArma1sud_ovest3 ;
	private Image pArma1sud_ovest4 ;
	private Image pArma1sud_ovest5 ;
	private Image pArma1sud_ovest6 ;
	private Image pArma1sud_ovest7 ;
	
	public ArrayList<Image> player_est_arma1;
	private Image pArma1est1 ;
	private Image pArma1est2 ;
	private Image pArma1est3 ;
	private Image pArma1est4 ;
	private Image pArma1est5 ;
	private Image pArma1est6 ;
	private Image pArma1est7 ;
	
	
	public ArrayList<Image> player_ovest_arma1;
	private Image pArma1ovest1 ;
	private Image pArma1ovest2 ;
	private Image pArma1ovest3 ;
	private Image pArma1ovest4 ;
	private Image pArma1ovest5 ;
	private Image pArma1ovest6 ;
	private Image pArma1ovest7 ;
	
	
	public ArrayList<Image> player_nord_arma1;
	private Image pArma1nord1 ;
	private Image pArma1nord2 ;
	private Image pArma1nord3 ;
	private Image pArma1nord4 ;
	private Image pArma1nord5 ;
	private Image pArma1nord6 ;
	private Image pArma1nord7 ;
	
	
	public ArrayList<Image> player_nord_ovest_arma1;
	private Image pArma1nord_ovest1 ;
	private Image pArma1nord_ovest2 ;
	private Image pArma1nord_ovest3 ;
	private Image pArma1nord_ovest4 ;
	private Image pArma1nord_ovest5 ;
	private Image pArma1nord_ovest6 ;
	private Image pArma1nord_ovest7 ;
	
	
	public ArrayList<Image> player_nord_est_arma1;
	private Image pArma1nord_est1 ;
	private Image pArma1nord_est2 ;
	private Image pArma1nord_est3 ;
	private Image pArma1nord_est4 ;
	private Image pArma1nord_est5 ;
	private Image pArma1nord_est6 ;
	private Image pArma1nord_est7 ;
	
	
	public ArrayList<Image> player_sud_arma2;
	private Image pArma2sud1 ;
	private Image pArma2sud2 ;
	private Image pArma2sud3 ;
	private Image pArma2sud4 ;
	private Image pArma2sud5 ;
	private Image pArma2sud6 ;
	private Image pArma2sud7 ;

	
	public ArrayList<Image> player_sud_est_arma2;
	private Image pArma2sud_est1 ;
	private Image pArma2sud_est2 ;
	private Image pArma2sud_est3 ;
	private Image pArma2sud_est4 ;
	private Image pArma2sud_est5 ;
	private Image pArma2sud_est6 ;
	private Image pArma2sud_est7 ;
	
	
	public ArrayList<Image> player_sud_ovest_arma2;
	private Image pArma2sud_ovest1 ;
	private Image pArma2sud_ovest2 ;
	private Image pArma2sud_ovest3 ;
	private Image pArma2sud_ovest4 ;
	private Image pArma2sud_ovest5 ;
	private Image pArma2sud_ovest6 ;
	private Image pArma2sud_ovest7 ;

	
	public ArrayList<Image> player_est_arma2;
	private Image pArma2est1 ;
	private Image pArma2est2 ;
	private Image pArma2est3 ;
	private Image pArma2est4 ;
	private Image pArma2est5 ;
	private Image pArma2est6 ;
	private Image pArma2est7 ;
	
	
	public ArrayList<Image> player_ovest_arma2;
	private Image pArma2ovest1 ;
	private Image pArma2ovest2 ;
	private Image pArma2ovest3 ;
	private Image pArma2ovest4 ;
	private Image pArma2ovest5 ;
	private Image pArma2ovest6 ;
	private Image pArma2ovest7 ;
	
	
	public ArrayList<Image> player_nord_arma2;
	private Image pArma2nord1 ;
	private Image pArma2nord2 ;
	private Image pArma2nord3 ;
	private Image pArma2nord4 ;
	private Image pArma2nord5 ;
	private Image pArma2nord6 ;
	private Image pArma2nord7 ;
	
	
	public ArrayList<Image> player_nord_ovest_arma2;
	private Image pArma2nord_ovest1 ;
	private Image pArma2nord_ovest2 ;
	private Image pArma2nord_ovest3 ;
	private Image pArma2nord_ovest4 ;
	private Image pArma2nord_ovest5 ;
	private Image pArma2nord_ovest6 ;
	private Image pArma2nord_ovest7 ;
	
	
	public ArrayList<Image> player_nord_est_arma2;
	private Image pArma2nord_est1 ;
	private Image pArma2nord_est2 ;
	private Image pArma2nord_est3 ;
	private Image pArma2nord_est4 ;
	private Image pArma2nord_est5 ;
	private Image pArma2nord_est6 ;
	private Image pArma2nord_est7 ;
	
	
	public ArrayList<Image> player_sud_arma3;
	private Image pArma3sud1 ;
	private Image pArma3sud2 ;
	private Image pArma3sud3 ;
	private Image pArma3sud4 ;
	private Image pArma3sud5 ;
	private Image pArma3sud6 ;
	private Image pArma3sud7 ;
	
	
	public ArrayList<Image> player_sud_est_arma3;
	private Image pArma3sud_est1 ;
	private Image pArma3sud_est2 ;
	private Image pArma3sud_est3 ;
	private Image pArma3sud_est4 ;
	private Image pArma3sud_est5 ;
	private Image pArma3sud_est6 ;
	private Image pArma3sud_est7 ;
	
	
	public ArrayList<Image> player_sud_ovest_arma3;
	private Image pArma3sud_ovest1 ;
	private Image pArma3sud_ovest2 ;
	private Image pArma3sud_ovest3 ;
	private Image pArma3sud_ovest4 ;
	private Image pArma3sud_ovest5 ;
	private Image pArma3sud_ovest6 ;
	private Image pArma3sud_ovest7 ;


	public ArrayList<Image> player_est_arma3;
	private Image pArma3est1 ;
	private Image pArma3est2 ;
	private Image pArma3est3 ;
	private Image pArma3est4 ;
	private Image pArma3est5 ;
	private Image pArma3est6 ;
	private Image pArma3est7 ;
	
	
	public ArrayList<Image> player_ovest_arma3;
	private Image pArma3ovest1 ;
	private Image pArma3ovest2 ;
	private Image pArma3ovest3 ;
	private Image pArma3ovest4 ;
	private Image pArma3ovest5 ;
	private Image pArma3ovest6 ;
	private Image pArma3ovest7 ;
	
	
	public ArrayList<Image> player_nord_arma3;
	private Image pArma3nord1 ;
	private Image pArma3nord2 ;
	private Image pArma3nord3 ;
	private Image pArma3nord4 ;
	private Image pArma3nord5 ;
	private Image pArma3nord6 ;
	private Image pArma3nord7 ;

	
	public ArrayList<Image> player_nord_ovest_arma3;
	private Image pArma3nord_ovest1 ;
	private Image pArma3nord_ovest2 ;
	private Image pArma3nord_ovest3 ;
	private Image pArma3nord_ovest4 ;
	private Image pArma3nord_ovest5 ;
	private Image pArma3nord_ovest6 ;
	private Image pArma3nord_ovest7 ;
	
	
	public ArrayList<Image> player_nord_est_arma3;
	private Image pArma3nord_est1 ;
	private Image pArma3nord_est2 ;
	private Image pArma3nord_est3 ;
	private Image pArma3nord_est4 ;
	private Image pArma3nord_est5 ;
	private Image pArma3nord_est6 ;
	private Image pArma3nord_est7 ;

	
	
	
	public ImageProvider() {
		totaleImmagini=362;
		
		caricate=0;
		
		zombie_sud = new ArrayList<>();
		zombie_sud_est = new ArrayList<>();
		zombie_sud_ovest = new ArrayList<>();
		zombie_est = new ArrayList<>();
		zombie_nord_est = new ArrayList<>();
		zombie_nord = new ArrayList<>();
		zombie_nord_ovest = new ArrayList<>();
		zombie_ovest = new ArrayList<>();
		
		zombie_attack_sud = new ArrayList<>();
		zombie_attack_sud_est = new ArrayList<>();
		zombie_attack_sud_ovest = new ArrayList<>();
		zombie_attack_est = new ArrayList<>();
		zombie_attack_nord_est = new ArrayList<>();
		zombie_attack_nord = new ArrayList<>();
		zombie_attack_nord_ovest = new ArrayList<>();
		zombie_attack_ovest = new ArrayList<>();

		
		zombie_morto_sud = new ArrayList<>();
		zombie_morto_sud_est = new ArrayList<>();
		zombie_morto_sud_ovest = new ArrayList<>();
		zombie_morto_est = new ArrayList<>();
		zombie_morto_nord_est = new ArrayList<>();
		zombie_morto_nord = new ArrayList<>();
		zombie_morto_nord_ovest = new ArrayList<>();
		zombie_morto_ovest = new ArrayList<>();
		
		
		player_sud = new ArrayList<>();
		player_sud_est = new ArrayList<>();
		player_sud_ovest = new ArrayList<>();
		player_est = new ArrayList<>();
		player_nord_est = new ArrayList<>();
		player_nord = new ArrayList<>();
		player_nord_ovest = new ArrayList<>();
		player_ovest = new ArrayList<>();
		
		player_sud_arma1 = new ArrayList<>();
		player_sud_est_arma1 = new ArrayList<>();
		player_sud_ovest_arma1 = new ArrayList<>();
		player_est_arma1 = new ArrayList<>();
		player_nord_est_arma1 = new ArrayList<>();
		player_nord_arma1 = new ArrayList<>();
		player_nord_ovest_arma1 = new ArrayList<>();
		player_ovest_arma1 = new ArrayList<>();
		
		player_sud_arma2 = new ArrayList<>();
		player_sud_est_arma2 = new ArrayList<>();
		player_sud_ovest_arma2 = new ArrayList<>();
		player_est_arma2 = new ArrayList<>();
		player_nord_est_arma2 = new ArrayList<>();
		player_nord_arma2 = new ArrayList<>();
		player_nord_ovest_arma2 = new ArrayList<>();
		player_ovest_arma2 = new ArrayList<>();
		
		player_sud_arma3 = new ArrayList<>();
		player_sud_est_arma3 = new ArrayList<>();
		player_sud_ovest_arma3 = new ArrayList<>();
		player_est_arma3 = new ArrayList<>();
		player_nord_est_arma3 = new ArrayList<>();
		player_nord_arma3 = new ArrayList<>();
		player_nord_ovest_arma3 = new ArrayList<>();
		player_ovest_arma3 = new ArrayList<>();
	
	}
	
	
	public int count=0;
	
public boolean caricaUnImmagine(){

	

		if(ambulance==null){
			ambulance=loadImage("resource/statici/Ambulance.png");
			caricate++;
			return false;
		}
		if( camion ==null ){
			camion=loadImage("resource/statici/Camion.png");
			caricate++;
			return false;
			}
		if( camper==null ){
			camper=loadImage("resource/statici/Camper_ribaltato.png");
			caricate++;
			return false;
			}
		if(edificio1a==null){
			edificio1a=loadImage("resource/statici/Edificio1.1.png");
			caricate++;
			return false;
		}
		if( edificio1b == null ){
			edificio1b =loadImage("resource/statici/Edificio1.2.png");
			caricate++;
			return false;
			}
		if( edificio1c==null ){
			edificio1c=loadImage("resource/statici/Edificio1.3.png");
			caricate++;
			return false;
			}
		if( edificio1d==null ){
			edificio1d=loadImage("resource/statici/Edificio1.4.png");
			caricate++;
			return false;
			}
		if(edificio2a==null){
			edificio2a=loadImage("resource/statici/Edificio2.1.png");
			caricate++;
			return false;
		}
		if( edificio2b ==null ){
			edificio2b=loadImage("resource/statici/Edificio2.2.png");
			caricate++;
			return false;
			}
		if( edificio2c==null ){
			edificio2c=loadImage("resource/statici/Edificio2.3.png");
			caricate++;
			return false;
			}
		if( macchina2==null ){
			macchina2=loadImage("resource/statici/Macchina2.png");
			caricate++;
			return false;
			}
		if(pacchetto==null){
			pacchetto=loadImage("resource/statici/PacchettoArmi.png");
			caricate++;
			return false;
		}
		if(porta == null){
			porta = loadImage("resource/statici/porta.png");
			caricate++;
			return false;
		}
		if( wallOrizzontale==null ){
			wallOrizzontale=loadImage("resource/statici/wallOrizzontale.png");
			caricate++;
			return false;
			}
		if( wallVerticale==null ){
			wallVerticale=loadImage("resource/statici/wallVerticale.png");
			caricate++;
			return false;
			}
		

		
				
		
//----------------------------------------SUD SENZA ARMA-----------------------------------------------
		if( psud1==null ){
			psud1=loadImage("resource/Player/Walk_SenzaArma/Sud1.png");
			player_sud.add(psud1);
			caricate++;
			return false;
			}
		if( psud2==null ){
			psud2=loadImage("resource/Player/Walk_SenzaArma/Sud2.png");
			player_sud.add(psud2);
			caricate++;
			return false;
			}
		if( psud3==null ){
			psud3=loadImage("resource/Player/Walk_SenzaArma/Sud3.png");
			player_sud.add(psud3);
			caricate++;
			return false;
			}
		if( psud4==null ){
			psud4=loadImage("resource/Player/Walk_SenzaArma/Sud4.png");
			player_sud.add(psud4);
			caricate++;
			return false;
			}
		if( psud5==null ){
			psud5=loadImage("resource/Player/Walk_SenzaArma/Sud5.png");
			player_sud.add(psud5);
			caricate++;
			return false;
			}
		if( psud6==null ){
			psud6=loadImage("resource/Player/Walk_SenzaArma/Sud6.png");
			player_sud.add(psud6);
			caricate++;
			return false;
			}
		if( psud7==null ){
			psud7=loadImage("resource/Player/Walk_SenzaArma/Sud7.png");
			player_sud.add(psud7);
			caricate++;
			return false;
			}
		
		
		
//------------------------------------SUD EST SENZA ARMA---------------------------------------------------		
		if( psud_est1==null ){
			psud_est1=loadImage("resource/Player/Walk_SenzaArma/Sud_Est1.png");
			player_sud_est.add(psud_est1);
			caricate++;
			return false;
			}
		if( psud_est2==null ){
			psud_est2=loadImage("resource/Player/Walk_SenzaArma/Sud_Est2.png");
			player_sud_est.add(psud_est2);
			caricate++;
			return false;
			}
		if( psud_est3==null ){
			psud_est3=loadImage("resource/Player/Walk_SenzaArma/Sud_Est3.png");
			player_sud_est.add(psud_est3);
			caricate++;
			return false;
			}
		if( psud_est4==null ){
			psud_est4=loadImage("resource/Player/Walk_SenzaArma/Sud_Est4.png");
			player_sud_est.add(psud_est4);
			caricate++;
			return false;
			}
		if( psud_est5==null ){
			psud_est5=loadImage("resource/Player/Walk_SenzaArma/Sud_Est5.png");
			player_sud_est.add(psud_est5);
			caricate++;
			return false;
			}
		if( psud_est6==null ){
			psud_est6=loadImage("resource/Player/Walk_SenzaArma/Sud_Est6.png");
			player_sud_est.add(psud_est6);
			caricate++;
			return false;
			}
		if( psud_est7==null ){
			psud_est7=loadImage("resource/Player/Walk_SenzaArma/Sud_Est7.png");
			player_sud_est.add(psud_est7);
			caricate++;
			return false;
			}
		

			
//------------------------------------------SUD OVEST SENZA ARMA ---------------------------------------------
		if( psud_ovest1==null ){
			psud_ovest1=loadImage("resource/Player/Walk_SenzaArma/Sud_Ovest1.png");
			player_sud_ovest.add(psud_ovest1);
			caricate++;
			return false;
			}
		if( psud_ovest2==null ){
			psud_ovest2=loadImage("resource/Player/Walk_SenzaArma/Sud_Ovest2.png");
			player_sud_ovest.add(psud_ovest2);
			caricate++;
			return false;
			}
		if( psud_ovest3==null ){
			psud_ovest3=loadImage("resource/Player/Walk_SenzaArma/Sud_Ovest3.png");
			player_sud_ovest.add(psud_ovest3);
			caricate++;
			return false;
			}
		if( psud_ovest4==null ){
			psud_ovest4=loadImage("resource/Player/Walk_SenzaArma/Sud_Ovest4.png");
			player_sud_ovest.add(psud_ovest4);
			caricate++;
			return false;
			}
		if( psud_ovest5==null ){
			psud_ovest5=loadImage("resource/Player/Walk_SenzaArma/Sud_Ovest5.png");
			player_sud_ovest.add(psud_ovest5);
			caricate++;
			return false;
			}
		if( psud_ovest6==null ){
			psud_ovest6=loadImage("resource/Player/Walk_SenzaArma/Sud_Ovest6.png");
			player_sud_ovest.add(psud_ovest6);
			caricate++;
			return false;
			}
		if( psud_ovest7==null ){
			psud_ovest7=loadImage("resource/Player/Walk_SenzaArma/Sud_Ovest7.png");
			player_sud_ovest.add(psud_ovest7);
			caricate++;
			return false;
			}		




//----------------------------------------------EST SENZA ARMA ------------------------------------------------
		if( pest1==null ){
			pest1=loadImage("resource/Player/Walk_SenzaArma/Est1.png");
			player_est.add(pest1);
			caricate++;
			return false;
			}
		if( pest2==null ){
			pest2=loadImage("resource/Player/Walk_SenzaArma/Est2.png");
			player_est.add(pest2);
			caricate++;
			return false;
			}
		if( pest3==null ){
			pest3=loadImage("resource/Player/Walk_SenzaArma/Est3.png");
			player_est.add(pest3);
			caricate++;
			return false;
			}
		if( pest4==null ){
			pest4=loadImage("resource/Player/Walk_SenzaArma/Est4.png");
			player_est.add(pest4);
			caricate++;
			return false;
			}
		if( pest5==null ){
			pest5=loadImage("resource/Player/Walk_SenzaArma/Est5.png");
			player_est.add(pest5);
			caricate++;
			return false;
			}
		if( pest6==null ){
			pest6=loadImage("resource/Player/Walk_SenzaArma/Est6.png");
			player_est.add(pest6);
			caricate++;
			return false;
			}
		if( pest7==null ){
			pest7=loadImage("resource/Player/Walk_SenzaArma/Est7.png");
			player_est.add(pest7);
			caricate++;
			return false;
			}		




//--------------------------------------------- OVEST SENZA ARMA ----------------------------------------------
		if( povest1==null ){
			povest1=loadImage("resource/Player/Walk_SenzaArma/Ovest1.png");
			player_ovest.add(povest1);
			caricate++;
			return false;
			}
		if( povest2==null ){
			povest2=loadImage("resource/Player/Walk_SenzaArma/Ovest2.png");
			player_ovest.add(povest2);
			caricate++;
			return false;
			}
		if( povest3==null ){
			povest3=loadImage("resource/Player/Walk_SenzaArma/Ovest3.png");
			player_ovest.add(povest3);
			caricate++;
			return false;
			}
		if( povest4==null ){
			povest4=loadImage("resource/Player/Walk_SenzaArma/Ovest4.png");
			player_ovest.add(povest4);
			caricate++;
			return false;
			}
		if( povest5==null ){
			povest5=loadImage("resource/Player/Walk_SenzaArma/Ovest5.png");
			player_ovest.add(povest5);
			caricate++;
			return false;
			}
		if( povest6==null ){
			povest6=loadImage("resource/Player/Walk_SenzaArma/Ovest6.png");
			player_ovest.add(povest6);
			caricate++;
			return false;
			}
		if( povest7==null ){
			povest7=loadImage("resource/Player/Walk_SenzaArma/Ovest7.png");
			player_ovest.add(povest7);
			caricate++;
			return false;
			}		
		
		
		
		
//-------------------------------------------- NORD  SENZA ARMA ----------------------------------------------
		if( pnord1==null ){
			pnord1=loadImage("resource/Player/Walk_SenzaArma/Nord1.png");
			player_nord.add(pnord1);
			caricate++;
			return false;
			}
		if( pnord2==null ){
			pnord2=loadImage("resource/Player/Walk_SenzaArma/Nord2.png");
			player_nord.add(pnord2);
			caricate++;
			return false;
			}
		if( pnord3==null ){
			pnord3=loadImage("resource/Player/Walk_SenzaArma/Nord3.png");
			player_nord.add(pnord3);
			caricate++;
			return false;
			}
		if( pnord4==null ){
			pnord4=loadImage("resource/Player/Walk_SenzaArma/Nord4.png");
			player_nord.add(pnord4);
			caricate++;
			return false;
			}
		if( pnord5==null ){
			pnord5=loadImage("resource/Player/Walk_SenzaArma/Nord5.png");
			player_nord.add(pnord5);
			caricate++;
			return false;
			}
		if( pnord6==null ){
			pnord6=loadImage("resource/Player/Walk_SenzaArma/Nord6.png");
			player_nord.add(pnord6);
			caricate++;
			return false;
			}
		if( pnord7==null ){
			pnord7=loadImage("resource/Player/Walk_SenzaArma/Nord7.png");
			player_nord.add(pnord7);
			caricate++;
			return false;
			}				

		
		
		
//--------------------------------------------------- NORD OVEST  SENZA ARMA -----------------------------------
		if( pnord_ovest1==null ){
			pnord_ovest1=loadImage("resource/Player/Walk_SenzaArma/Nord_Ovest1.png");
			player_nord_ovest.add(pnord_ovest1);
			caricate++;
			return false;
			}
		if( pnord_ovest2==null ){
			pnord_ovest2=loadImage("resource/Player/Walk_SenzaArma/Nord_Ovest2.png");
			player_nord_ovest.add(pnord_ovest2);
			caricate++;
			return false;
			}
		if( pnord_ovest3==null ){
			pnord_ovest3=loadImage("resource/Player/Walk_SenzaArma/Nord_Ovest3.png");
			player_nord_ovest.add(pnord_ovest3);
			caricate++;
			return false;
			}
		if( pnord_ovest4==null ){
			pnord_ovest4=loadImage("resource/Player/Walk_SenzaArma/Nord_Ovest4.png");
			player_nord_ovest.add(pnord_ovest4);
			caricate++;
			return false;
			}
		if( pnord_ovest5==null ){
			pnord_ovest5=loadImage("resource/Player/Walk_SenzaArma/Nord_Ovest5.png");
			player_nord_ovest.add(pnord_ovest5);
			caricate++;
			return false;
			}
		if( pnord_ovest6==null ){
			pnord_ovest6=loadImage("resource/Player/Walk_SenzaArma/Nord_Ovest6.png");
			player_nord_ovest.add(pnord_ovest6);
			caricate++;
			return false;
			}
		if( pnord_ovest7==null ){
			pnord_ovest7=loadImage("resource/Player/Walk_SenzaArma/Nord_Ovest7.png");
			player_nord_ovest.add(pnord_ovest7);
			caricate++;
			return false;
			}	


		
		
//---------------------------------------------------- NORD EST  SENZA ARMA ---------------------------------------------
		if( pnord_est1==null ){
			pnord_est1=loadImage("resource/Player/Walk_SenzaArma/Nord_Est1.png");
			player_nord_est.add(pnord_est1);
			caricate++;
			return false;
			}
		if( pnord_est2==null ){
			pnord_est2=loadImage("resource/Player/Walk_SenzaArma/Nord_Est2.png");
			player_nord_est.add(pnord_est2);
			caricate++;
			return false;
			}
		if( pnord_est3==null ){
			pnord_est3=loadImage("resource/Player/Walk_SenzaArma/Nord_Est3.png");
			player_nord_est.add(pnord_est3);
			caricate++;
			return false;
			}
		if( pnord_est4==null ){
			pnord_est4=loadImage("resource/Player/Walk_SenzaArma/Nord_Est4.png");
			player_nord_est.add(pnord_est4);
			caricate++;
			return false;
			}
		if( pnord_est5==null ){
			pnord_est5=loadImage("resource/Player/Walk_SenzaArma/Nord_Est5.png");
			player_nord_est.add(pnord_est5);
			caricate++;
			return false;
			}
		if( pnord_est6==null ){
			pnord_est6=loadImage("resource/Player/Walk_SenzaArma/Nord_Est6.png");
			player_nord_est.add(pnord_est6);
			caricate++;
			return false;
			}
		if( pnord_est7==null ){
			pnord_est7=loadImage("resource/Player/Walk_SenzaArma/Nord_Est7.png");
			player_nord_est.add(pnord_est7);
			caricate++;
			return false;
			}	


		
//-------------------------------------------------- SUD  ARMA1 -------------------------------------------------------
		if( pArma1sud1==null ){
			pArma1sud1=loadImage("resource/Player/Raligun/Sud1.png");
			player_sud_arma1.add(pArma1sud1);
			caricate++;
			return false;
			}
		if( pArma1sud2==null ){
			pArma1sud2=loadImage("resource/Player/Raligun/Sud2.png");
			player_sud_arma1.add(pArma1sud2);
			caricate++;
			return false;
			}
		if( pArma1sud3==null ){
			pArma1sud3=loadImage("resource/Player/Raligun/Sud3.png");
			player_sud_arma1.add(pArma1sud3);
			caricate++;
			return false;
			}
		if( pArma1sud4==null ){
			pArma1sud4=loadImage("resource/Player/Raligun/Sud4.png");
			player_sud_arma1.add(pArma1sud4);
			caricate++;
			return false;
			}
		if( pArma1sud5==null ){
			pArma1sud5=loadImage("resource/Player/Raligun/Sud5.png");
			player_sud_arma1.add(pArma1sud5);
			caricate++;
			return false;
			}
		if( pArma1sud6==null ){
			pArma1sud6=loadImage("resource/Player/Raligun/Sud6.png");
			player_sud_arma1.add(pArma1sud6);
			caricate++;
			return false;
			}
		if( pArma1sud7==null ){
			pArma1sud7=loadImage("resource/Player/Raligun/Sud7.png");
			player_sud_arma1.add(pArma1sud7);
			caricate++;
			return false;
			}
		
		
		
		
//----------------------------------------------------- SUD EST  ARMA 1 ---------------------------------------------
		if( pArma1sud_est1==null ){
			pArma1sud_est1=loadImage("resource/Player/Raligun/SudEst1.png");
			player_sud_est_arma1.add(pArma1sud_est1);
			caricate++;
			return false;
			}
		if( pArma1sud_est2==null ){
			pArma1sud_est2=loadImage("resource/Player/Raligun/SudEst2.png");
			player_sud_est_arma1.add(pArma1sud_est2);
			caricate++;
			return false;
			}
		if( pArma1sud_est3==null ){
			pArma1sud_est3=loadImage("resource/Player/Raligun/SudEst3.png");
			player_sud_est_arma1.add(pArma1sud_est3);
			caricate++;
			return false;
			}
		if( pArma1sud_est4==null ){
			pArma1sud_est4=loadImage("resource/Player/Raligun/SudEst4.png");
			player_sud_est_arma1.add(pArma1sud_est4);
			caricate++;
			return false;
			}
		if( pArma1sud_est5==null ){
			pArma1sud_est5=loadImage("resource/Player/Raligun/SudEst5.png");
			player_sud_est_arma1.add(pArma1sud_est5);
			caricate++;
			return false;
			}
		if( pArma1sud_est6==null ){
			pArma1sud_est6=loadImage("resource/Player/Raligun/SudEst6.png");
			player_sud_est_arma1.add(pArma1sud_est6);
			caricate++;
			return false;
			}
		if( pArma1sud_est7==null ){
			pArma1sud_est7=loadImage("resource/Player/Raligun/SudEst7.png");
			player_sud_est_arma1.add(pArma1sud_est7);
			caricate++;
			return false;
			}
		

		
//------------------------------------------------------ SUD OVEST  ARMA 1 ---------------------------------------
		if( pArma1sud_ovest1==null ){
			pArma1sud_ovest1=loadImage("resource/Player/Raligun/SudOvest1.png");
			player_sud_ovest_arma1.add(pArma1sud_ovest1);
			caricate++;
			return false;
			}
		if( pArma1sud_ovest2==null ){
			pArma1sud_ovest2=loadImage("resource/Player/Raligun/SudOvest2.png");
			player_sud_ovest_arma1.add(pArma1sud_ovest2);
			caricate++;
			return false;
			}
		if( pArma1sud_ovest3==null ){
			pArma1sud_ovest3=loadImage("resource/Player/Raligun/SudOvest3.png");
			player_sud_ovest_arma1.add(pArma1sud_ovest3);
			caricate++;
			return false;
			}
		if( pArma1sud_ovest4==null ){
			pArma1sud_ovest4=loadImage("resource/Player/Raligun/SudOvest4.png");
			player_sud_ovest_arma1.add(pArma1sud_ovest4);
			caricate++;
			return false;
			}
		if( pArma1sud_ovest5==null ){
			pArma1sud_ovest5=loadImage("resource/Player/Raligun/SudOvest5.png");
			player_sud_ovest_arma1.add(pArma1sud_ovest5);
			caricate++;
			return false;
			}
		if( pArma1sud_ovest6==null ){
			pArma1sud_ovest6=loadImage("resource/Player/Raligun/SudOvest6.png");
			player_sud_ovest_arma1.add(pArma1sud_ovest6);
			caricate++;
			return false;
			}
		if( pArma1sud_ovest7==null ){
			pArma1sud_ovest7=loadImage("resource/Player/Raligun/SudOvest7.png");
			player_sud_ovest_arma1.add(pArma1sud_ovest7);
			caricate++;
			return false;
			}
		
		
		
		
//------------------------------------------------------ EST  ARMA 1 ------------------------------------------------
		if( pArma1est1==null ){
			pArma1est1=loadImage("resource/Player/Raligun/Est1.png");
			player_est_arma1.add(pArma1est1);
			caricate++;
			return false;
			}
		if( pArma1est2==null ){
			pArma1est2=loadImage("resource/Player/Raligun/Est2.png");
			player_est_arma1.add(pArma1est2);
			caricate++;
			return false;
			}
		if( pArma1est3==null ){
			pArma1est3=loadImage("resource/Player/Raligun/Est3.png");
			player_est_arma1.add(pArma1est3);
			caricate++;
			return false;
			}
		if( pArma1est4==null ){
			pArma1est4=loadImage("resource/Player/Raligun/Est4.png");
			player_est_arma1.add(pArma1est4);
			caricate++;
			return false;
			}
		if( pArma1est5==null ){
			pArma1est5=loadImage("resource/Player/Raligun/Est5.png");
			player_est_arma1.add(pArma1est5);
			caricate++;
			return false;
			}
		if( pArma1est6==null ){
			pArma1est6=loadImage("resource/Player/Raligun/Est6.png");
			player_est_arma1.add(pArma1est6);
			caricate++;
			return false;
			}
		if( pArma1est7==null ){
			pArma1est7=loadImage("resource/Player/Raligun/Est7.png");
			player_est_arma1.add(pArma1est7);
			caricate++;
			return false;
			}

		


//-------------------------------------------------------- OVEST  ARMA 1 -----------------------------------------------
		if( pArma1ovest1==null ){
			pArma1ovest1=loadImage("resource/Player/Raligun/Ovest1.png");
			player_ovest_arma1.add(pArma1ovest1);
			caricate++;
			return false;
			}
		if( pArma1ovest2==null ){
			pArma1ovest2=loadImage("resource/Player/Raligun/Ovest2.png");
			player_ovest_arma1.add(pArma1ovest2);
			caricate++;
			return false;
			}
		if( pArma1ovest3==null ){
			pArma1ovest3=loadImage("resource/Player/Raligun/Ovest3.png");
			player_ovest_arma1.add(pArma1ovest3);
			caricate++;
			return false;
			}
		if( pArma1ovest4==null ){
			pArma1ovest4=loadImage("resource/Player/Raligun/Ovest4.png");
			player_ovest_arma1.add(pArma1ovest4);
			caricate++;
			return false;
			}
		if( pArma1ovest5==null ){
			pArma1ovest5=loadImage("resource/Player/Raligun/Ovest5.png");
			player_ovest_arma1.add(pArma1ovest5);
			caricate++;
			return false;
			}
		if( pArma1ovest6==null ){
			pArma1ovest6=loadImage("resource/Player/Raligun/Ovest6.png");
			player_ovest_arma1.add(pArma1ovest6);
			caricate++;
			return false;
			}
		if( pArma1ovest7==null ){
			pArma1ovest7=loadImage("resource/Player/Raligun/Ovest7.png");
			player_ovest_arma1.add(pArma1ovest7);
			caricate++;
			return false;
			}

		
		
		
//----------------------------------------------------- NORD  ARMA 1 -----------------------------------------------
		if( pArma1nord1==null ){
			pArma1nord1=loadImage("resource/Player/Raligun/Nord1.png");
			player_nord_arma1.add(pArma1nord1);
			caricate++;
			return false;
			}
		if( pArma1nord2==null ){
			pArma1nord2=loadImage("resource/Player/Raligun/Nord2.png");
			player_nord_arma1.add(pArma1nord2);
			caricate++;
			return false;
			}
		if( pArma1nord3==null ){
			pArma1nord3=loadImage("resource/Player/Raligun/Nord3.png");
			player_nord_arma1.add(pArma1nord3);
			caricate++;
			return false;
			}
		if( pArma1nord4==null ){
			pArma1nord4=loadImage("resource/Player/Raligun/Nord4.png");
			player_nord_arma1.add(pArma1nord4);
			caricate++;
			return false;
			}
		if( pArma1nord5==null ){
			pArma1nord5=loadImage("resource/Player/Raligun/Nord5.png");
			player_nord_arma1.add(pArma1nord5);
			caricate++;
			return false;
			}
		if( pArma1nord6==null ){
			pArma1nord6=loadImage("resource/Player/Raligun/Nord6.png");
			player_nord_arma1.add(pArma1nord6);
			caricate++;
			return false;
			}
		if( pArma1nord7==null ){
			pArma1nord7=loadImage("resource/Player/Raligun/Nord7.png");
			player_nord_arma1.add(pArma1nord7);
			caricate++;
			return false;
			}		
		
		
		
		
//----------------------------------------------- NORD OVEST  ARMA 1 ----------------------------------------------------
		if( pArma1nord_ovest1==null ){
			pArma1nord_ovest1=loadImage("resource/Player/Raligun/NordOvest1.png");
			player_nord_ovest_arma1.add(pArma1nord_ovest1);
			caricate++;
			return false;
			}
		if( pArma1nord_ovest2==null ){
			pArma1nord_ovest2=loadImage("resource/Player/Raligun/NordOvest2.png");
			player_nord_ovest_arma1.add(pArma1nord_ovest2);
			caricate++;
			return false;
			}
		if( pArma1nord_ovest3==null ){
			pArma1nord_ovest3=loadImage("resource/Player/Raligun/NordOvest3.png");
			player_nord_ovest_arma1.add(pArma1nord_ovest3);
			caricate++;
			return false;
			}
		if( pArma1nord_ovest4==null ){
			pArma1nord_ovest4=loadImage("resource/Player/Raligun/NordOvest4.png");
			player_nord_ovest_arma1.add(pArma1nord_ovest4);
			caricate++;
			return false;
			}
		if( pArma1nord_ovest5==null ){
			pArma1nord_ovest5=loadImage("resource/Player/Raligun/NordOvest5.png");
			player_nord_ovest_arma1.add(pArma1nord_ovest5);
			caricate++;
			return false;
			}
		if( pArma1nord_ovest6==null ){
			pArma1nord_ovest6=loadImage("resource/Player/Raligun/NordOvest6.png");
			player_nord_ovest_arma1.add(pArma1nord_ovest6);
			caricate++;
			return false;
			}
		if( pArma1nord_ovest7==null ){
			pArma1nord_ovest7=loadImage("resource/Player/Raligun/NordOvest7.png");
			player_nord_ovest_arma1.add(pArma1nord_ovest7);
			caricate++;
			return false;
			}			

		


//------------------------------------------------------- NORD  EST  ARMA 1 -----------------------------------------
		if( pArma1nord_est1==null ){
			pArma1nord_est1=loadImage("resource/Player/Raligun/NordEst1.png");
			player_nord_est_arma1.add(pArma1nord_est1);
			caricate++;
			return false;
			}
		if( pArma1nord_est2==null ){
			pArma1nord_est2=loadImage("resource/Player/Raligun/NordEst2.png");
			player_nord_est_arma1.add(pArma1nord_est2);
			caricate++;
			return false;
			}
		if( pArma1nord_est3==null ){
			pArma1nord_est3=loadImage("resource/Player/Raligun/NordEst3.png");
			player_nord_est_arma1.add(pArma1nord_est3);
			caricate++;
			return false;
			}
		if( pArma1nord_est4==null ){
			pArma1nord_est4=loadImage("resource/Player/Raligun/NordEst4.png");
			player_nord_est_arma1.add(pArma1nord_est4);
			caricate++;
			return false;
			}
		if( pArma1nord_est5==null ){
			pArma1nord_est5=loadImage("resource/Player/Raligun/NordEst5.png");
			player_nord_est_arma1.add(pArma1nord_est5);
			caricate++;
			return false;
			}
		if( pArma1nord_est6==null ){
			pArma1nord_est6=loadImage("resource/Player/Raligun/NordEst6.png");
			player_nord_est_arma1.add(pArma1nord_est6);
			caricate++;
			return false;
			}
		if( pArma1nord_est7==null ){
			pArma1nord_est7=loadImage("resource/Player/Raligun/NordEst7.png");
			player_nord_est_arma1.add(pArma1nord_est7);
			caricate++;
			return false;
			}	
		
		
				


		
//-------------------------------------------------- SUD  ARMA2 -------------------------------------------------------
		if( pArma2sud1==null ){
			pArma2sud1=loadImage("resource/Player/UZI/VersoSud1.png");
			player_sud_arma2.add(pArma2sud1);
			caricate++;
			return false;
			}
		if( pArma2sud2==null ){
			pArma2sud2=loadImage("resource/Player/UZI/VersoSud2.png");
			player_sud_arma2.add(pArma2sud2);
			caricate++;
			return false;
			}
		if( pArma2sud3==null ){
			pArma2sud3=loadImage("resource/Player/UZI/VersoSud3.png");
			player_sud_arma2.add(pArma2sud3);
			caricate++;
			return false;
			}
		if( pArma2sud4==null ){
			pArma2sud4=loadImage("resource/Player/UZI/VersoSud4.png");
			player_sud_arma2.add(pArma2sud4);
			caricate++;
			return false;
			}
		if( pArma2sud5==null ){
			pArma2sud5=loadImage("resource/Player/UZI/VersoSud5.png");
			player_sud_arma2.add(pArma2sud5);
			caricate++;
			return false;
			}
		if( pArma2sud6==null ){
			pArma2sud6=loadImage("resource/Player/UZI/VersoSud6.png");
			player_sud_arma2.add(pArma2sud6);
			caricate++;
			return false;
			}
		if( pArma2sud7==null ){
			pArma2sud7=loadImage("resource/Player/UZI/VersoSud7.png");
			player_sud_arma2.add(pArma2sud7);
			caricate++;
			return false;
			}
		
		
		
		
//----------------------------------------------------- SUD EST   ARMA 2 ----------------------------------------------
		if( pArma2sud_est1==null ){
			pArma2sud_est1=loadImage("resource/Player/UZI/VersoSud-Est1.png");
			player_sud_est_arma2.add(pArma2sud_est1);
			caricate++;
			return false;
			}
		if( pArma2sud_est2==null ){
			pArma2sud_est2=loadImage("resource/Player/UZI/VersoSud-Est2.png");
			player_sud_est_arma2.add(pArma2sud_est2);
			caricate++;
			return false;
			}
		if( pArma2sud_est3==null ){
			pArma2sud_est3=loadImage("resource/Player/UZI/VersoSud-Est3.png");
			player_sud_est_arma2.add(pArma2sud_est3);
			caricate++;
			return false;
			}
		if( pArma2sud_est4==null ){
			pArma2sud_est4=loadImage("resource/Player/UZI/VersoSud-Est4.png");
			player_sud_est_arma2.add(pArma2sud_est4);
			caricate++;
			return false;
			}
		if( pArma2sud_est5==null ){
			pArma2sud_est5=loadImage("resource/Player/UZI/VersoSud-Est5.png");
			player_sud_est_arma2.add(pArma2sud_est5);
			caricate++;
			return false;
			}
		if( pArma2sud_est6==null ){
			pArma2sud_est6=loadImage("resource/Player/UZI/VersoSud-Est6.png");
			player_sud_est_arma2.add(pArma2sud_est6);
			caricate++;
			return false;
			}
		if( pArma2sud_est7==null ){
			pArma2sud_est7=loadImage("resource/Player/UZI/VersoSud-Est7.png");
			player_sud_est_arma2.add(pArma2sud_est7);
			caricate++;
			return false;
			}
		

		
//------------------------------------------------------ SUD OVEST  ARMA 2 ---------------------------------------
		if( pArma2sud_ovest1==null ){
			pArma2sud_ovest1=loadImage("resource/Player/UZI/VersoSud-Ovest1.png");
			player_sud_ovest_arma2.add(pArma2sud_ovest1);
			caricate++;
			return false;
			}
		if( pArma2sud_ovest2==null ){
			pArma2sud_ovest2=loadImage("resource/Player/UZI/VersoSud-Ovest2.png");
			player_sud_ovest_arma2.add(pArma2sud_ovest2);
			caricate++;
			return false;
			}
		if( pArma2sud_ovest3==null ){
			pArma2sud_ovest3=loadImage("resource/Player/UZI/VersoSud-Ovest3.png");
			player_sud_ovest_arma2.add(pArma2sud_ovest3);
			caricate++;
			return false;
			}
		if( pArma2sud_ovest4==null ){
			pArma2sud_ovest4=loadImage("resource/Player/UZI/VersoSud-Ovest4.png");
			player_sud_ovest_arma2.add(pArma2sud_ovest4);
			caricate++;
			return false;
			}
		if( pArma2sud_ovest5==null ){
			pArma2sud_ovest5=loadImage("resource/Player/UZI/VersoSud-Ovest5.png");
			player_sud_ovest_arma2.add(pArma2sud_ovest5);
			caricate++;
			return false;
			}
		if( pArma2sud_ovest6==null ){
			pArma2sud_ovest6=loadImage("resource/Player/UZI/VersoSud-Ovest6.png");
			player_sud_ovest_arma2.add(pArma2sud_ovest6);
			caricate++;
			return false;
			}
		if( pArma2sud_ovest7==null ){
			pArma2sud_ovest7=loadImage("resource/Player/UZI/VersoSud-Ovest7.png");
			player_sud_ovest_arma2.add(pArma2sud_ovest7);
			caricate++;
			return false;
			}
		
		
		
		
//------------------------------------------------------ EST  ARMA 2 ------------------------------------------------
		if( pArma2est1==null ){
			pArma2est1=loadImage("resource/Player/UZI/VersoEst1.png");
			player_est_arma2.add(pArma2est1);
			caricate++;
			return false;
			}
		if( pArma2est2==null ){
			pArma2est2=loadImage("resource/Player/UZI/VersoEst2.png");
			player_est_arma2.add(pArma2est2);
			caricate++;
			return false;
			}
		if( pArma2est3==null ){
			pArma2est3=loadImage("resource/Player/UZI/VersoEst3.png");
			player_est_arma2.add(pArma2est3);
			caricate++;
			return false;
			}
		if( pArma2est4==null ){
			pArma2est4=loadImage("resource/Player/UZI/VersoEst4.png");
			player_est_arma2.add(pArma2est4);
			caricate++;
			return false;
			}
		if( pArma2est5==null ){
			pArma2est5=loadImage("resource/Player/UZI/VersoEst5.png");
			player_est_arma2.add(pArma2est5);
			caricate++;
			return false;
			}
		if( pArma2est6==null ){
			pArma2est6=loadImage("resource/Player/UZI/VersoEst6.png");
			player_est_arma2.add(pArma2est6);
			caricate++;
			return false;
			}
		if( pArma2est7==null ){
			pArma2est7=loadImage("resource/Player/UZI/VersoEst7.png");
			player_est_arma2.add(pArma2est7);
			caricate++;
			return false;
			}

		


//-------------------------------------------------------- OVEST  ARMA 2 -----------------------------------------------
		if( pArma2ovest1==null ){
			pArma2ovest1=loadImage("resource/Player/UZI/VersoOvest1.png");
			player_ovest_arma2.add(pArma2ovest1);
			caricate++;
			return false;
			}
		if( pArma2ovest2==null ){
			pArma2ovest2=loadImage("resource/Player/UZI/VersoOvest2.png");
			player_ovest_arma2.add(pArma2ovest2);
			caricate++;
			return false;
			}
		if( pArma2ovest3==null ){
			pArma2ovest3=loadImage("resource/Player/UZI/VersoOvest3.png");
			player_ovest_arma2.add(pArma2ovest3);
			caricate++;
			return false;
			}
		if( pArma2ovest4==null ){
			pArma2ovest4=loadImage("resource/Player/UZI/VersoOvest4.png");
			player_ovest_arma2.add(pArma2ovest4);
			caricate++;
			return false;
			}
		if( pArma2ovest5==null ){
			pArma2ovest5=loadImage("resource/Player/UZI/VersoOvest5.png");
			player_ovest_arma2.add(pArma2ovest5);
			caricate++;
			return false;
			}
		if( pArma2ovest6==null ){
			pArma2ovest6=loadImage("resource/Player/UZI/VersoOvest6.png");
			player_ovest_arma2.add(pArma2ovest6);
			caricate++;
			return false;
			}
		if( pArma2ovest7==null ){
			pArma2ovest7=loadImage("resource/Player/UZI/VersoOvest7.png");
			player_ovest_arma2.add(pArma2ovest7);
			caricate++;
			return false;
			}

		
		
		
//----------------------------------------------------- NORD  ARMA 2 -----------------------------------------------
		if( pArma2nord1==null ){
			pArma2nord1=loadImage("resource/Player/UZI/VersoNord1.png");
			player_nord_arma2.add(pArma2nord1);
			caricate++;
			return false;
			}
		if( pArma2nord2==null ){
			pArma2nord2=loadImage("resource/Player/UZI/VersoNord2.png");
			player_nord_arma2.add(pArma2nord2);
			caricate++;
			return false;
			}
		if( pArma2nord3==null ){
			pArma2nord3=loadImage("resource/Player/UZI/VersoNord3.png");
			player_nord_arma2.add(pArma2nord3);
			caricate++;
			return false;
			}
		if( pArma2nord4==null ){
			pArma2nord4=loadImage("resource/Player/UZI/VersoNord4.png");
			player_nord_arma2.add(pArma2nord4);
			caricate++;
			return false;
			}
		if( pArma2nord5==null ){
			pArma2nord5=loadImage("resource/Player/UZI/VersoNord5.png");
			player_nord_arma2.add(pArma2nord5);
			caricate++;
			return false;
			}
		if( pArma2nord6==null ){
			pArma2nord6=loadImage("resource/Player/UZI/VersoNord6.png");
			player_nord_arma2.add(pArma2nord6);
			caricate++;
			return false;
			}
		if( pArma2nord7==null ){
			pArma2nord7=loadImage("resource/Player/UZI/VersoNord7.png");
			player_nord_arma2.add(pArma2nord7);
			caricate++;
			return false;
			}		
		
		
		
		
//--------------------------------------------------------- NORD OVEST   ARMA 2 -----------------------------------
		if( pArma2nord_ovest1==null ){
			pArma2nord_ovest1=loadImage("resource/Player/UZI/VersoNord-Ovest1.png");
			player_nord_ovest_arma2.add(pArma2nord_ovest1);
			caricate++;
			return false;
			}
		if( pArma2nord_ovest2==null ){
			pArma2nord_ovest2=loadImage("resource/Player/UZI/VersoNord-Ovest2.png");
			player_nord_ovest_arma2.add(pArma2nord_ovest2);
			caricate++;
			return false;
			}
		if( pArma2nord_ovest3==null ){
			pArma2nord_ovest3=loadImage("resource/Player/UZI/VersoNord-Ovest3.png");
			player_nord_ovest_arma2.add(pArma2nord_ovest3);
			caricate++;
			return false;
			}
		if( pArma2nord_ovest4==null ){
			pArma2nord_ovest4=loadImage("resource/Player/UZI/VersoNord-Ovest4.png");
			player_nord_ovest_arma2.add(pArma2nord_ovest4);
			caricate++;
			return false;
			}
		if( pArma2nord_ovest5==null ){
			pArma2nord_ovest5=loadImage("resource/Player/UZI/VersoNord-Ovest5.png");
			player_nord_ovest_arma2.add(pArma2nord_ovest5);
			caricate++;
			return false;
			}
		if( pArma2nord_ovest6==null ){
			pArma2nord_ovest6=loadImage("resource/Player/UZI/VersoNord-Ovest6.png");
			player_nord_ovest_arma2.add(pArma2nord_ovest6);
			caricate++;
			return false;
			}
		if( pArma2nord_ovest7==null ){
			pArma2nord_ovest7=loadImage("resource/Player/UZI/VersoNord-Ovest7.png");
			player_nord_ovest_arma2.add(pArma2nord_ovest7);
			caricate++;
			return false;
			}			

		


//----------------------------------------------------------- NORD  EST   ARMA 2 ------------------------------------
		if( pArma2nord_est1==null ){
			pArma2nord_est1=loadImage("resource/Player/UZI/VersoNord-Est1.png");
			player_nord_est_arma2.add(pArma2nord_est1);
			caricate++;
			return false;
			}
		if( pArma2nord_est2==null ){
			pArma2nord_est2=loadImage("resource/Player/UZI/VersoNord-Est2.png");
			player_nord_est_arma2.add(pArma2nord_est2);
			caricate++;
			return false;
			}
		if( pArma2nord_est3==null ){
			pArma2nord_est3=loadImage("resource/Player/UZI/VersoNord-Est3.png");
			player_nord_est_arma2.add(pArma2nord_est3);
			caricate++;
			return false;
			}
		if( pArma2nord_est4==null ){
			pArma2nord_est4=loadImage("resource/Player/UZI/VersoNord-Est4.png");
			player_nord_est_arma2.add(pArma2nord_est4);
			caricate++;
			return false;
			}
		if( pArma2nord_est5==null ){
			pArma2nord_est5=loadImage("resource/Player/UZI/VersoNord-Est5.png");
			player_nord_est_arma2.add(pArma2nord_est5);
			caricate++;
			return false;
			}
		if( pArma2nord_est6==null ){
			pArma2nord_est6=loadImage("resource/Player/UZI/VersoNord-Est6.png");
			player_nord_est_arma2.add(pArma2nord_est6);
			caricate++;
			return false;
			}
		if( pArma2nord_est7==null ){
			pArma2nord_est7=loadImage("resource/Player/UZI/VersoNord-Est7.png");
			player_nord_est_arma2.add(pArma2nord_est7);
			caricate++;
			return false;
			}	
		
		
		
		
//-------------------------------------------------- SUD  ARMA 3 -----------------------------------------------------
		if( pArma3sud1==null ){
			pArma3sud1=loadImage("resource/Player/Shotgun/Sud1.png");
			player_sud_arma3.add(pArma3sud1);
			caricate++;
			return false;
			}
		if( pArma3sud2==null ){
			pArma3sud2=loadImage("resource/Player/Shotgun/Sud2.png");
			player_sud_arma3.add(pArma3sud2);
			caricate++;
			return false;
			}
		if( pArma3sud3==null ){
			pArma3sud3=loadImage("resource/Player/Shotgun/Sud3.png");
			player_sud_arma3.add(pArma3sud3);
			caricate++;
			return false;
			}
		if( pArma3sud4==null ){
			pArma3sud4=loadImage("resource/Player/Shotgun/Sud4.png");
			player_sud_arma3.add(pArma3sud4);
			caricate++;
			return false;
			}
		if( pArma3sud5==null ){
			pArma3sud5=loadImage("resource/Player/Shotgun/Sud5.png");
			player_sud_arma3.add(pArma3sud5);
			caricate++;
			return false;
			}
		if( pArma3sud6==null ){
			pArma3sud6=loadImage("resource/Player/Shotgun/Sud6.png");
			player_sud_arma3.add(pArma3sud6);
			caricate++;
			return false;
			}
		if( pArma3sud7==null ){
			pArma3sud7=loadImage("resource/Player/Shotgun/Sud7.png");
			player_sud_arma3.add(pArma3sud7);
			caricate++;
			return false;
			}
		
		
		
		
//----------------------------------------------------- SUD EST   ARMA 3 ----------------------------------------------
		if( pArma3sud_est1==null ){
			pArma3sud_est1=loadImage("resource/Player/Shotgun/SudEst1.png");
			player_sud_est_arma3.add(pArma3sud_est1);
			caricate++;
			return false;
			}
		if( pArma3sud_est2==null ){
			pArma3sud_est2=loadImage("resource/Player/Shotgun/SudEst2.png");
			player_sud_est_arma3.add(pArma3sud_est2);
			caricate++;
			return false;
			}
		if( pArma3sud_est3==null ){
			pArma3sud_est3=loadImage("resource/Player/Shotgun/SudEst3.png");
			player_sud_est_arma3.add(pArma3sud_est3);
			caricate++;
			return false;
			}
		if( pArma3sud_est4==null ){
			pArma3sud_est4=loadImage("resource/Player/Shotgun/SudEst4.png");
			player_sud_est_arma3.add(pArma3sud_est4);
			caricate++;
			return false;
			}
		if( pArma3sud_est5==null ){
			pArma3sud_est5=loadImage("resource/Player/Shotgun/SudEst5.png");
			player_sud_est_arma3.add(pArma3sud_est5);
			caricate++;
			return false;
			}
		if( pArma3sud_est6==null ){
			pArma3sud_est6=loadImage("resource/Player/Shotgun/SudEst6.png");
			player_sud_est_arma3.add(pArma3sud_est6);
			caricate++;
			return false;
			}
		if( pArma3sud_est7==null ){
			pArma3sud_est7=loadImage("resource/Player/Shotgun/SudEst7.png");
			player_sud_est_arma3.add(pArma3sud_est7);
			caricate++;
			return false;
			}
		

		
//------------------------------------------------------ SUD OVEST  ARMA 3 ---------------------------------------
		if( pArma3sud_ovest1==null ){
			pArma3sud_ovest1=loadImage("resource/Player/Shotgun/SudOvest1.png");
			player_sud_ovest_arma3.add(pArma3sud_ovest1);
			caricate++;
			return false;
			}
		if( pArma3sud_ovest2==null ){
			pArma3sud_ovest2=loadImage("resource/Player/Shotgun/SudOvest2.png");
			player_sud_ovest_arma3.add(pArma3sud_ovest2);
			caricate++;
			return false;
			}
		if( pArma3sud_ovest3==null ){
			pArma3sud_ovest3=loadImage("resource/Player/Shotgun/SudOvest3.png");
			player_sud_ovest_arma3.add(pArma3sud_ovest3);
			caricate++;
			return false;
			}
		if( pArma3sud_ovest4==null ){
			pArma3sud_ovest4=loadImage("resource/Player/Shotgun/SudOvest4.png");
			player_sud_ovest_arma3.add(pArma3sud_ovest4);
			caricate++;
			return false;
			}
		if( pArma3sud_ovest5==null ){
			pArma3sud_ovest5=loadImage("resource/Player/Shotgun/SudOvest5.png");
			player_sud_ovest_arma3.add(pArma3sud_ovest5);
			caricate++;
			return false;
			}
		if( pArma3sud_ovest6==null ){
			pArma3sud_ovest6=loadImage("resource/Player/Shotgun/SudOvest6.png");
			player_sud_ovest_arma3.add(pArma3sud_ovest6);
			caricate++;
			return false;
			}
		if( pArma3sud_ovest7==null ){
			pArma3sud_ovest7=loadImage("resource/Player/Shotgun/SudOvest7.png");
			player_sud_ovest_arma3.add(pArma3sud_ovest7);
			caricate++;
			return false;
			}
		
		
		
		
//------------------------------------------------------ EST  ARMA 3 ------------------------------------------------
		if( pArma3est1==null ){
			pArma3est1=loadImage("resource/Player/Shotgun/Est1.png");
			player_est_arma3.add(pArma3est1);
			caricate++;
			return false;
			}
		if( pArma3est2==null ){
			pArma3est2=loadImage("resource/Player/Shotgun/Est2.png");
			player_est_arma3.add(pArma3est2);
			caricate++;
			return false;
			}
		if( pArma3est3==null ){
			pArma3est3=loadImage("resource/Player/Shotgun/Est3.png");
			player_est_arma3.add(pArma3est3);
			caricate++;
			return false;
			}
		if( pArma3est4==null ){
			pArma3est4=loadImage("resource/Player/Shotgun/Est4.png");
			player_est_arma3.add(pArma3est4);
			caricate++;
			return false;
			}
		if( pArma3est5==null ){
			pArma3est5=loadImage("resource/Player/Shotgun/Est5.png");
			player_est_arma3.add(pArma3est5);
			caricate++;
			return false;
			}
		if( pArma3est6==null ){
			pArma3est6=loadImage("resource/Player/Shotgun/Est6.png");
			player_est_arma3.add(pArma3est6);
			caricate++;
			return false;
			}
		if( pArma3est7==null ){
			pArma3est7=loadImage("resource/Player/Shotgun/Est7.png");
			player_est_arma3.add(pArma3est7);
			caricate++;
			return false;
			}

		


//-------------------------------------------------------- OVEST  ARMA 3 -----------------------------------------------
		if( pArma3ovest1==null ){
			pArma3ovest1=loadImage("resource/Player/Shotgun/Ovest1.png");
			player_ovest_arma3.add(pArma3ovest1);
			caricate++;
			return false;
			}
		if( pArma3ovest2==null ){
			pArma3ovest2=loadImage("resource/Player/Shotgun/Ovest2.png");
			player_ovest_arma3.add(pArma3ovest2);
			caricate++;
			return false;
			}
		if( pArma3ovest3==null ){
			pArma3ovest3=loadImage("resource/Player/Shotgun/Ovest3.png");
			player_ovest_arma3.add(pArma3ovest3);
			caricate++;
			return false;
			}
		if( pArma3ovest4==null ){
			pArma3ovest4=loadImage("resource/Player/Shotgun/Ovest4.png");
			player_ovest_arma3.add(pArma3ovest4);
			caricate++;
			return false;
			}
		if( pArma3ovest5==null ){
			pArma3ovest5=loadImage("resource/Player/Shotgun/Ovest5.png");
			player_ovest_arma3.add(pArma3ovest5);
			caricate++;
			return false;
			}
		if( pArma3ovest6==null ){
			pArma3ovest6=loadImage("resource/Player/Shotgun/Ovest6.png");
			player_ovest_arma3.add(pArma3ovest6);
			caricate++;
			return false;
			}
		if( pArma3ovest7==null ){
			pArma3ovest7=loadImage("resource/Player/Shotgun/Ovest7.png");
			player_ovest_arma3.add(pArma3ovest7);
			caricate++;
			return false;
			}

		
		
		
//----------------------------------------------------- NORD  ARMA 3 -----------------------------------------------
		if( pArma3nord1==null ){
			pArma3nord1=loadImage("resource/Player/Shotgun/Nord1.png");
			player_nord_arma3.add(pArma3nord1);
			caricate++;
			return false;
			}
		if( pArma3nord2==null ){
			pArma3nord2=loadImage("resource/Player/Shotgun/Nord2.png");
			player_nord_arma3.add(pArma3nord2);
			caricate++;
			return false;
			}
		if( pArma3nord3==null ){
			pArma3nord3=loadImage("resource/Player/Shotgun/Nord3.png");
			player_nord_arma3.add(pArma3nord3);
			caricate++;
			return false;
			}
		if( pArma3nord4==null ){
			pArma3nord4=loadImage("resource/Player/Shotgun/Nord4.png");
			player_nord_arma3.add(pArma3nord4);
			caricate++;
			return false;
			}
		if( pArma3nord5==null ){
			pArma3nord5=loadImage("resource/Player/Shotgun/Nord5.png");
			player_nord_arma3.add(pArma3nord5);
			caricate++;
			return false;
			}
		if( pArma3nord6==null ){
			pArma3nord6=loadImage("resource/Player/Shotgun/Nord6.png");
			player_nord_arma3.add(pArma3nord6);
			caricate++;
			return false;
			}
		if( pArma3nord7==null ){
			pArma3nord7=loadImage("resource/Player/Shotgun/Nord7.png");
			player_nord_arma3.add(pArma3nord7);
			caricate++;
			return false;
			}		
		
		
		
		
//--------------------------------------------------------- NORD OVEST  ARMA 3 -----------------------------------
		if( pArma3nord_ovest1==null ){
			pArma3nord_ovest1=loadImage("resource/Player/Shotgun/NordOvest1.png");
			player_nord_ovest_arma3.add(pArma3nord_ovest1);
			caricate++;
			return false;
			}
		if( pArma3nord_ovest2==null ){
			pArma3nord_ovest2=loadImage("resource/Player/Shotgun/NordOvest2.png");
			player_nord_ovest_arma3.add(pArma3nord_ovest2);
			caricate++;
			return false;
			}
		if( pArma3nord_ovest3==null ){
			pArma3nord_ovest3=loadImage("resource/Player/Shotgun/NordOvest3.png");
			player_nord_ovest_arma3.add(pArma3nord_ovest3);
			caricate++;
			return false;
			}
		if( pArma3nord_ovest4==null ){
			pArma3nord_ovest4=loadImage("resource/Player/Shotgun/NordOvest4.png");
			player_nord_ovest_arma3.add(pArma3nord_ovest4);
			caricate++;
			return false;
			}
		if( pArma3nord_ovest5==null ){
			pArma3nord_ovest5=loadImage("resource/Player/Shotgun/NordOvest5.png");
			player_nord_ovest_arma3.add(pArma3nord_ovest5);
			caricate++;
			return false;
			}
		if( pArma3nord_ovest6==null ){
			pArma3nord_ovest6=loadImage("resource/Player/Shotgun/NordOvest6.png");
			player_nord_ovest_arma3.add(pArma3nord_ovest6);
			caricate++;
			return false;
			}
		if( pArma3nord_ovest7==null ){
			pArma3nord_ovest7=loadImage("resource/Player/Shotgun/NordOvest7.png");
			player_nord_ovest_arma3.add(pArma3nord_ovest7);
			caricate++;
			return false;
			}			

		


//----------------------------------------------------------- NORD  EST   ARMA 3 ------------------------------------
		if( pArma3nord_est1==null ){
			pArma3nord_est1=loadImage("resource/Player/Shotgun/NordEst1.png");
			player_nord_est_arma3.add(pArma3nord_est1);
			caricate++;
			return false;
			}
		if( pArma3nord_est2==null ){
			pArma3nord_est2=loadImage("resource/Player/Shotgun/NordEst2.png");
			player_nord_est_arma3.add(pArma3nord_est2);
			caricate++;
			return false;
			}
		if( pArma3nord_est3==null ){
			pArma3nord_est3=loadImage("resource/Player/Shotgun/NordEst3.png");
			player_nord_est_arma3.add(pArma3nord_est3);
			caricate++;
			return false;
			}
		if( pArma3nord_est4==null ){
			pArma3nord_est4=loadImage("resource/Player/Shotgun/NordEst4.png");
			player_nord_est_arma3.add(pArma3nord_est4);
			caricate++;
			return false;
			}
		if( pArma3nord_est5==null ){
			pArma3nord_est5=loadImage("resource/Player/Shotgun/NordEst5.png");
			player_nord_est_arma3.add(pArma3nord_est5);
			caricate++;
			return false;
			}
		if( pArma3nord_est6==null ){
			pArma3nord_est6=loadImage("resource/Player/Shotgun/NordEst6.png");
			player_nord_est_arma3.add(pArma3nord_est6);
			caricate++;
			return false;
			}
		if( pArma3nord_est7==null ){
			pArma3nord_est7=loadImage("resource/Player/Shotgun/NordEst7.png");
			player_nord_est_arma3.add(pArma3nord_est7);
			caricate++;
			return false;
			}	
		
		
		
//----------------------------------------SUD zombie-----------------------------------------------
				if( ssud1==null ){
					ssud1=loadImage("resource/Zombie/Walk/Sud1.png");
					zombie_sud.add(ssud1);
					caricate++;
					return false;
					}
				if( ssud2==null ){
					ssud2=loadImage("resource/Zombie/Walk/Sud2.png");
					zombie_sud.add(ssud2);
					caricate++;
					return false;
					}
				if( ssud3==null ){
					ssud3=loadImage("resource/Zombie/Walk/Sud3.png");
					zombie_sud.add(ssud3);
					caricate++;
					return false;
					}
				if( ssud4==null ){
					ssud4=loadImage("resource/Zombie/Walk/Sud4.png");
					zombie_sud.add(ssud4);
					caricate++;
					return false;
					}
				if( ssud5==null ){
					ssud5=loadImage("resource/Zombie/Walk/Sud5.png");
					zombie_sud.add(ssud5);
					caricate++;
					return false;
					}
				if( ssud6==null ){
					ssud6=loadImage("resource/Zombie/Walk/Sud6.png");
					zombie_sud.add(ssud6);
					caricate++;
					return false;
					}
				if( ssud7==null ){
					ssud7=loadImage("resource/Zombie/Walk/Sud7.png");
					zombie_sud.add(ssud7);
					caricate++;
					return false;
					}
				
				
		//------------------------------------SUD EST Zombie---------------------------------------------------		
				if( ssud_est1==null ){
					ssud_est1=loadImage("resource/Zombie/Walk/SudEst1.png");
					zombie_sud_est.add(ssud_est1);
					caricate++;
					return false;
					}
				if( ssud_est2==null ){
					ssud_est2=loadImage("resource/Zombie/Walk/SudEst2.png");
					zombie_sud_est.add(ssud_est2);
					caricate++;
					return false;
					}
				if( ssud_est3==null ){
					ssud_est3=loadImage("resource/Zombie/Walk/SudEst3.png");
					zombie_sud_est.add(ssud_est3);
					caricate++;
					return false;
					}
				if( ssud_est4==null ){
					ssud_est4=loadImage("resource/Zombie/Walk/SudEst4.png");
					zombie_sud_est.add(ssud_est4);
					caricate++;
					return false;
					}
				if( ssud_est5==null ){
					ssud_est5=loadImage("resource/Zombie/Walk/SudEst5.png");
					zombie_sud_est.add(ssud_est5);
					caricate++;
					return false;
					}
				if( ssud_est6==null ){
					ssud_est6=loadImage("resource/Zombie/Walk/SudEst6.png");
					zombie_sud_est.add(ssud_est6);
					caricate++;
					return false;
					}
				if( ssud_est7==null ){
					ssud_est7=loadImage("resource/Zombie/Walk/SudEst7.png");
					zombie_sud_est.add(ssud_est7);
					caricate++;
					return false;
					}
				
				

					
		//------------------------------------------SUD OVEST Zombie---------------------------------------------
				if( ssud_ovest1==null ){
					ssud_ovest1=loadImage("resource/Zombie/Walk/SudOvest1.png");
					zombie_sud_ovest.add(ssud_ovest1);
					caricate++;
					return false;
					}
				if( ssud_ovest2==null ){
					ssud_ovest2=loadImage("resource/Zombie/Walk/SudOvest2.png");
					zombie_sud_ovest.add(ssud_ovest2);
					caricate++;
					return false;
					}
				if( ssud_ovest3==null ){
					ssud_ovest3=loadImage("resource/Zombie/Walk/SudOvest3.png");
					zombie_sud_ovest.add(ssud_ovest3);
					caricate++;
					return false;
					}
				if( ssud_ovest4==null ){
					ssud_ovest4=loadImage("resource/Zombie/Walk/SudOvest4.png");
					zombie_sud_ovest.add(ssud_ovest4);
					caricate++;
					return false;
					}
				if( ssud_ovest5==null ){
					ssud_ovest5=loadImage("resource/Zombie/Walk/SudOvest5.png");
					zombie_sud_ovest.add(ssud_ovest5);
					caricate++;
					return false;
					}
				if( ssud_ovest6==null ){
					ssud_ovest6=loadImage("resource/Zombie/Walk/SudOvest6.png");
					zombie_sud_ovest.add(ssud_ovest6);
					caricate++;
					return false;
					}
				if( ssud_ovest7==null ){
					ssud_ovest7=loadImage("resource/Zombie/Walk/SudOvest7.png");
					zombie_sud_ovest.add(ssud_ovest7);
					caricate++;
					return false;
					}		




		//----------------------------------------------EST Zombie------------------------------------------------
				if( sest1==null ){
					sest1=loadImage("resource/Zombie/Walk/Est1.png");
					zombie_est.add(sest1);
					caricate++;
					return false;
					}
				if( sest2==null ){
					sest2=loadImage("resource/Zombie/Walk/Est2.png");
					zombie_est.add(sest2);
					caricate++;
					return false;
					}
				if( sest3==null ){
					sest3=loadImage("resource/Zombie/Walk/Est3.png");
					zombie_est.add(sest3);
					caricate++;
					return false;
					}
				if( sest4==null ){
					sest4=loadImage("resource/Zombie/Walk/Est4.png");
					zombie_est.add(sest4);
					caricate++;
					return false;
					}
				if( sest5==null ){
					sest5=loadImage("resource/Zombie/Walk/Est5.png");
					zombie_est.add(sest5);
					caricate++;
					return false;
					}
				if( sest6==null ){
					sest6=loadImage("resource/Zombie/Walk/Est6.png");
					zombie_est.add(sest6);
					caricate++;
					return false;
					}
				if( sest7==null ){
					sest7=loadImage("resource/Zombie/Walk/Est7.png");
					zombie_est.add(sest7);
					caricate++;
					return false;
					}		




		//--------------------------------------------- OVEST Zombie----------------------------------------------
				if( sovest1==null ){
					sovest1=loadImage("resource/Zombie/Walk/Ovest1.png");
					zombie_ovest.add(sovest1);
					caricate++;
					return false;
					}
				if( sovest2==null ){
					sovest2=loadImage("resource/Zombie/Walk/Ovest2.png");
					zombie_ovest.add(sovest2);
					caricate++;
					return false;
					}
				if( sovest3==null ){
					sovest3=loadImage("resource/Zombie/Walk/Ovest3.png");
					zombie_ovest.add(sovest3);
					caricate++;
					return false;
					}
				if( sovest4==null ){
					sovest4=loadImage("resource/Zombie/Walk/Ovest4.png");
					zombie_ovest.add(sovest4);
					caricate++;
					return false;
					}
				if( sovest5==null ){
					sovest5=loadImage("resource/Zombie/Walk/Ovest5.png");
					zombie_ovest.add(sovest5);
					caricate++;
					return false;
					}
				if( sovest6==null ){
					sovest6=loadImage("resource/Zombie/Walk/Ovest6.png");
					zombie_ovest.add(sovest6);
					caricate++;
					return false;
					}
				if( sovest7==null ){
					sovest7=loadImage("resource/Zombie/Walk/Ovest7.png");
					zombie_ovest.add(sovest7);
					caricate++;
					return false;
					}		
				
				
				
				
		//-------------------------------------------- NORD Zombie----------------------------------------------
				if( snord1==null ){
					snord1=loadImage("resource/Zombie/Walk/Nord1.png");
					zombie_nord.add(snord1);
					caricate++;
					return false;
					}
				if( snord2==null ){
					snord2=loadImage("resource/Zombie/Walk/Nord2.png");
					zombie_nord.add(snord2);
					caricate++;
					return false;
					}
				if( snord3==null ){
					snord3=loadImage("resource/Zombie/Walk/Nord3.png");
					zombie_nord.add(snord3);
					caricate++;
					return false;
					}
				if( snord4==null ){
					snord4=loadImage("resource/Zombie/Walk/Nord4.png");
					zombie_nord.add(snord4);
					caricate++;
					return false;
					}
				if( snord5==null ){
					snord5=loadImage("resource/Zombie/Walk/Nord5.png");
					zombie_nord.add(snord5);
					caricate++;
					return false;
					}
				if( snord6==null ){
					snord6=loadImage("resource/Zombie/Walk/Nord6.png");
					zombie_nord.add(snord6);
					caricate++;
					return false;
					}
				if( snord7==null ){
					snord7=loadImage("resource/Zombie/Walk/Nord7.png");
					zombie_nord.add(snord7);
					caricate++;
					return false;
					}				

				
				
				
		//--------------------------------------------------- NORD OVEST Zombie ----------------------------------
				if( snord_ovest1==null ){
					snord_ovest1=loadImage("resource/Zombie/Walk/NordOvest1.png");
					zombie_nord_ovest.add(snord_ovest1);
					caricate++;
					return false;
					}
				if( snord_ovest2==null ){
					snord_ovest2=loadImage("resource/Zombie/Walk/NordOvest2.png");
					zombie_nord_ovest.add(snord_ovest2);
					caricate++;
					return false;
					}
				if( snord_ovest3==null ){
					snord_ovest3=loadImage("resource/Zombie/Walk/NordOvest3.png");
					zombie_nord_ovest.add(snord_ovest3);
					caricate++;
					return false;
					}
				if( snord_ovest4==null ){
					snord_ovest4=loadImage("resource/Zombie/Walk/NordOvest4.png");
					zombie_nord_ovest.add(snord_ovest4);
					caricate++;
					return false;
					}
				if( snord_ovest5==null ){
					snord_ovest5=loadImage("resource/Zombie/Walk/NordOvest5.png");
					zombie_nord_ovest.add(snord_ovest5);
					caricate++;
					return false;
					}
				if( snord_ovest6==null ){
					snord_ovest6=loadImage("resource/Zombie/Walk/NordOvest6.png");
					zombie_nord_ovest.add(snord_ovest6);
					caricate++;
					return false;
					}
				if( snord_ovest7==null ){
					snord_ovest7=loadImage("resource/Zombie/Walk/NordOvest7.png");
					zombie_nord_ovest.add(snord_ovest7);
					caricate++;
					return false;
					}	


				
				
		//---------------------------------------------------- NORD EST Zombie---------------------------------------------
				if( snord_est1==null ){
					snord_est1=loadImage("resource/Zombie/Walk/NordEst1.png");
					zombie_nord_est.add(snord_est1);
					caricate++;
					return false;
					}
				if( snord_est2==null ){
					snord_est2=loadImage("resource/Zombie/Walk/NordEst2.png");
					zombie_nord_est.add(snord_est2);
					caricate++;
					return false;
					}
				if( snord_est3==null ){
					snord_est3=loadImage("resource/Zombie/Walk/NordEst3.png");
					zombie_nord_est.add(snord_est3);
					caricate++;
					return false;
					}
				if( snord_est4==null ){
					snord_est4=loadImage("resource/Zombie/Walk/NordEst4.png");
					zombie_nord_est.add(snord_est4);
					caricate++;
					return false;
					}
				if( snord_est5==null ){
					snord_est5=loadImage("resource/Zombie/Walk/NordEst5.png");
					zombie_nord_est.add(snord_est5);
					caricate++;
					return false;
					}
				if( snord_est6==null ){
					snord_est6=loadImage("resource/Zombie/Walk/NordEst6.png");
					zombie_nord_est.add(snord_est6);
					caricate++;
					return false;
					}
				if( snord_est7==null ){
					snord_est7=loadImage("resource/Zombie/Walk/NordEst7.png");
					zombie_nord_est.add(snord_est7);
					caricate++;
					return false;
					}			

				
//----------------------------------------SUD Zombie ATTACK-----------------------------------------------
				if( sasud1==null ){
					sasud1=loadImage("resource/Zombie/Attack/Sud1.png");
					zombie_attack_sud.add(sasud1);
					caricate++;
					return false;
					}
				if( sasud2==null ){
					sasud2=loadImage("resource/Zombie/Attack/Sud2.png");
					zombie_attack_sud.add(sasud2);
					caricate++;
					return false;
					}
				if( sasud3==null ){
					sasud3=loadImage("resource/Zombie/Attack/Sud3.png");
					zombie_attack_sud.add(sasud3);
					caricate++;
					return false;
					}
				if( sasud4==null ){
					sasud4=loadImage("resource/Zombie/Attack/Sud4.png");
					zombie_attack_sud.add(sasud4);
					caricate++;
					return false;
					}
								
								
//------------------------------------SUD EST Zombie ATTACK ---------------------------------------------------		
				if( sasud_est1==null ){
					sasud_est1=loadImage("resource/Zombie/Attack/Sud-Est1.png");
					zombie_attack_sud_est.add(sasud_est1);
					caricate++;
					return false;
					}
				if( sasud_est2==null ){
					sasud_est2=loadImage("resource/Zombie/Attack/Sud-Est2.png");
					zombie_attack_sud_est.add(sasud_est2);
					caricate++;
					return false;
					}
				if( sasud_est3==null ){
					sasud_est3=loadImage("resource/Zombie/Attack/Sud-Est3.png");
					zombie_attack_sud_est.add(sasud_est3);
					caricate++;
					return false;
					}
				if( sasud_est4==null ){
					sasud_est4=loadImage("resource/Zombie/Attack/Sud-Est4.png");
					zombie_attack_sud_est.add(sasud_est4);
					caricate++;
					return false;
					}

									
//------------------------------------------SUD OVEST Zombie ATTACK---------------------------------------------
				if( sasud_ovest1==null ){
					sasud_ovest1=loadImage("resource/Zombie/Attack/Sud-Ovest1.png");
					zombie_attack_sud_ovest.add(sasud_ovest1);
					caricate++;
					return false;
				}
				if( sasud_ovest2==null ){
					sasud_ovest2=loadImage("resource/Zombie/Attack/Sud-Ovest2.png");
					zombie_attack_sud_ovest.add(sasud_ovest2);
					caricate++;
					return false;
				}
				if( sasud_ovest3==null ){
					sasud_ovest3=loadImage("resource/Zombie/Attack/Sud-Ovest3.png");
					zombie_attack_sud_ovest.add(sasud_ovest3);
					caricate++;
					return false;
				}
				if( sasud_ovest4==null ){
					sasud_ovest4=loadImage("resource/Zombie/Attack/Sud-Ovest4.png");
					zombie_attack_sud_ovest.add(sasud_ovest4);
					caricate++;
					return false;
				}


//----------------------------------------------EST Zombie ATTACK------------------------------------------------
				if( saest1==null ){
					saest1=loadImage("resource/Zombie/Attack/Est1.png");
					zombie_attack_est.add(saest1);
					caricate++;
					return false;
				}
				if( saest2==null ){
					saest2=loadImage("resource/Zombie/Attack/Est2.png");
					zombie_attack_est.add(saest2);
					caricate++;
					return false;
				}
				if( saest3==null ){
					saest3=loadImage("resource/Zombie/Attack/Est3.png");
					zombie_attack_est.add(saest3);
					caricate++;
					return false;
				}
				if( saest4==null ){
					saest4=loadImage("resource/Zombie/Attack/Est4.png");
					zombie_attack_est.add(saest4);
					caricate++;
					return false;
				}




//--------------------------------------------- OVEST Zombie ATTACK----------------------------------------------
				if( saovest1==null ){
					saovest1=loadImage("resource/Zombie/Attack/Ovest1.png");
					zombie_attack_ovest.add(saovest1);
					caricate++;
					return false;
				}
				if( saovest2==null ){
					saovest2=loadImage("resource/Zombie/Attack/Ovest2.png");
					zombie_attack_ovest.add(saovest2);
					caricate++;
					return false;
				}
				if( saovest3==null ){
					saovest3=loadImage("resource/Zombie/Attack/Ovest3.png");
					zombie_attack_ovest.add(saovest3);
					caricate++;
					return false;
				}
				if( saovest4==null ){
					saovest4=loadImage("resource/Zombie/Attack/Ovest4.png");
					zombie_attack_ovest.add(saovest4);
					caricate++;
					return false;
				}								
								
			
				
//-------------------------------------------- NORD Zombie ATTACK----------------------------------------------
				if( sanord1==null ){
					sanord1=loadImage("resource/Zombie/Attack/Nord1.png");
					zombie_attack_nord.add(sanord1);
					caricate++;
					return false;
				}
				if( sanord2==null ){
					sanord2=loadImage("resource/Zombie/Attack/Nord2.png");
					zombie_attack_nord.add(sanord2);
					caricate++;
					return false;
				}
				if( sanord3==null ){
					sanord3=loadImage("resource/Zombie/Attack/Nord3.png");
					zombie_attack_nord.add(sanord3);
					caricate++;
					return false;
				}
				if( sanord4==null ){
					sanord4=loadImage("resource/Zombie/Attack/Nord4.png");
					zombie_attack_nord.add(sanord4);
					caricate++;
					return false;
				}	
				
								
								
//--------------------------------------------------- NORD OVEST Zombie ATTACK ----------------------------------
				if( sanord_ovest1==null ){
					sanord_ovest1=loadImage("resource/Zombie/Attack/NordOvest1.png");
					zombie_attack_nord_ovest.add(sanord_ovest1);
					caricate++;
					return false;
				}
				if( sanord_ovest2==null ){
					sanord_ovest2=loadImage("resource/Zombie/Attack/NordOvest2.png");
					zombie_attack_nord_ovest.add(sanord_ovest2);
					caricate++;
					return false;
				}
				if( sanord_ovest3==null ){
					sanord_ovest3=loadImage("resource/Zombie/Attack/NordOvest3.png");
					zombie_attack_nord_ovest.add(sanord_ovest3);
					caricate++;
					return false;
				}
				if( sanord_ovest4==null ){
					sanord_ovest4=loadImage("resource/Zombie/Attack/NordOvest4.png");
					zombie_attack_nord_ovest.add(sanord_ovest4);
					caricate++;
					return false;
				}
								
								
//---------------------------------------------------- NORD EST Zombie ATTACK ----------------------------------------
				if( sanord_est1==null ){
					sanord_est1=loadImage("resource/Zombie/Attack/NordEst1.png");
					zombie_attack_nord_est.add(sanord_est1);
					caricate++;
					return false;
				}
				if( sanord_est2==null ){
					sanord_est2=loadImage("resource/Zombie/Attack/NordEst2.png");
					zombie_attack_nord_est.add(sanord_est2);
					caricate++;
					return false;
				}
				if( sanord_est3==null ){
					sanord_est3=loadImage("resource/Zombie/Attack/NordEst3.png");
					zombie_attack_nord_est.add(sanord_est3);
					caricate++;
					return false;
				}
				if( sanord_est4==null ){
					sanord_est4=loadImage("resource/Zombie/Attack/NordEst4.png");
					zombie_attack_nord_est.add(sanord_est4);
					caricate++;
					return false;
				}
				
				
//----------------------------------------SUD SOUL DYING-----------------------------------------------
				if( smsud1==null ){
					smsud1=loadImage("resource/Zombie/Dying/Sud_SudOvest/Sud1.png");
					zombie_morto_sud.add(smsud1);
					caricate++;
					return false;
				}
				if( smsud2==null ){
					smsud2=loadImage("resource/Zombie/Dying/Sud_SudOvest/Sud2.png");
					zombie_morto_sud.add(smsud2);
					caricate++;
					return false;
				}
								
								
//------------------------------------SUD EST SOUL DYING---------------------------------------------------		
				if( smsud_est1==null ){
					smsud_est1=loadImage("resource/Zombie/Dying/Est_SudEst/SudEst1.png");
					zombie_morto_sud_est.add(smsud_est1);
					caricate++;
					return false;
				}
				if( smsud_est2==null ){
					smsud_est2=loadImage("resource/Zombie/Dying/Est_SudEst/SudEst2.png");
					zombie_morto_sud_est.add(smsud_est2);
					caricate++;
					return false;
				}
				
									
//------------------------------------------SUD OVEST SOUL DYING---------------------------------------------
				if( smsud_ovest1==null ){
					smsud_ovest1=loadImage("resource/Zombie/Dying/Sud_SudOvest/SudOvest1.png");
					zombie_morto_sud_ovest.add(smsud_ovest1);
					caricate++;
					return false;
				}
				if( smsud_ovest2==null ){
					smsud_ovest2=loadImage("resource/Zombie/Dying/Sud_SudOvest/SudOvest2.png");
					zombie_morto_sud_ovest.add(smsud_ovest2);
					caricate++;
					return false;
				}


//----------------------------------------------EST SOUL Dying------------------------------------------------
				if( smest1==null ){
					smest1=loadImage("resource/Zombie/Dying/Est_SudEst/Est1.png");
					zombie_morto_est.add(smest1);
					caricate++;
					return false;
				}
				if( smest2==null ){
					smest2=loadImage("resource/Zombie/Dying/Est_SudEst/Est2.png");
					zombie_morto_est.add(smest2);
					caricate++;
					return false;
				}
				

//--------------------------------------------- OVEST SOUL Dying----------------------------------------------
				if( smovest1==null ){
					smovest1=loadImage("resource/Zombie/Dying/Ovest_NordOvest/Ovest1.png");
					zombie_morto_ovest.add(smovest1);
					caricate++;
					return false;
				}
				if( smovest2==null ){
					smovest2=loadImage("resource/Zombie/Dying/Ovest_NordOvest/Ovest2.png");
					zombie_morto_ovest.add(smovest2);
					caricate++;
					return false;
				}
				
								
//-------------------------------------------- NORD SOUL Dying----------------------------------------------
				if( smnord1==null ){
					smnord1=loadImage("resource/Zombie/Dying/Nord_NordEst/Nord1.png");
					zombie_morto_nord.add(smnord1);
					caricate++;
					return false;
				}
				if( smnord2==null ){
					smnord2=loadImage("resource/Zombie/Dying/Nord_NordEst/Nord2.png");
					zombie_morto_nord.add(smnord2);
					caricate++;
					return false;
				}
							
								
								
								
//------------------------------------------ NORD OVEST SOUL Dying----------------------------------
				if( smnord_ovest1==null ){
					smnord_ovest1=loadImage("resource/Zombie/Dying/Ovest_NordOvest/NordOvest1.png");
					zombie_morto_nord_ovest.add(smnord_ovest1);
					caricate++;
					return false;
				}
				if( smnord_ovest2==null ){
					smnord_ovest2=loadImage("resource/Zombie/Dying/Ovest_NordOvest/NordOvest2.png");
					zombie_morto_nord_ovest.add(smnord_ovest2);
					caricate++;
					return false;
				}



								
//---------------------------------------------------- NORD EST SOUL Dying----------------------------------------
				if( smnord_est1==null ){
					smnord_est1=loadImage("resource/Zombie/Dying/Nord_NordEst/NordEst1.png");
					zombie_morto_nord_est.add(smnord_est1);
					caricate++;
					return false;
				}
				if( smnord_est2==null ){
					smnord_est2=loadImage("resource/Zombie/Dying/Nord_NordEst/NordEst2.png");
					zombie_morto_nord_est.add(smnord_est2);
					caricate++;
					return false;
				}
					
				
				
				
//----------------------------------------- EST/SUD EST SOUL Dying-------------------------------------
				if( smestsud_est1==null ){
					smestsud_est1=loadImage("resource/Zombie/Dying/Est_SudEst/EstSudEst1.png");
					zombie_morto_est.add(smestsud_est1);
					zombie_morto_sud_est.add(smestsud_est1);
					caricate++;
					return false;
				}
				if( smestsud_est2==null ){
					smestsud_est2=loadImage("resource/Zombie/Dying/Est_SudEst/EstSudEst2.png");
					zombie_morto_est.add(smestsud_est2);
					zombie_morto_sud_est.add(smestsud_est2);
					caricate++;
					return false;
				}
				if( smestsud_est3==null ){
					smestsud_est3=loadImage("resource/Zombie/Dying/Est_SudEst/EstSudEst3.png");
					zombie_morto_est.add(smestsud_est3);
					zombie_morto_sud_est.add(smestsud_est3);
					caricate++;
					return false;
				}
				if( smestsud_est4==null ){
					smestsud_est4=loadImage("resource/Zombie/Dying/Est_SudEst/EstSudEst4.png");
					zombie_morto_est.add(smestsud_est4);
					zombie_morto_sud_est.add(smestsud_est4);
					caricate++;
					return false;
				}
				if( smestsud_est5==null ){
					smestsud_est5=loadImage("resource/Zombie/Dying/Est_SudEst/EstSudEst5.png");
					zombie_morto_est.add(smestsud_est5);
					zombie_morto_sud_est.add(smestsud_est5);
					caricate++;
					return false;
				}

			
//--------------------------------------- NORD/NORD EST SOUL Dying-------------------------------------
				if( smnordnord_est1==null ){
					smnordnord_est1=loadImage("resource/Zombie/Dying/Nord_NordEst/NordNordEst1.png");
					zombie_morto_nord.add(smnordnord_est1);
					zombie_morto_nord_est.add(smnordnord_est1);
					caricate++;
					return false;
				}
				if( smnordnord_est2==null ){
					smnordnord_est2=loadImage("resource/Zombie/Dying/Nord_NordEst/NordNordEst2.png");
					zombie_morto_nord.add(smnordnord_est2);
					zombie_morto_nord_est.add(smnordnord_est2);
					caricate++;
					return false;
				}
				if( smnordnord_est3==null ){
					smnordnord_est3=loadImage("resource/Zombie/Dying/Nord_NordEst/NordNordEst3.png");
					zombie_morto_nord.add(smnordnord_est3);
					zombie_morto_nord_est.add(smnordnord_est3);
					caricate++;
					return false;
				}
				if( smnordnord_est4==null ){
					smnordnord_est4=loadImage("resource/Zombie/Dying/Nord_NordEst/NordNordEst4.png");
					zombie_morto_nord.add(smnordnord_est4);
					zombie_morto_nord_est.add(smnordnord_est4);
					caricate++;
					return false;
				}
				if( smnordnord_est5==null ){
					smnordnord_est5=loadImage("resource/Zombie/Dying/Nord_NordEst/NordNordEst5.png");
					zombie_morto_nord.add(smnordnord_est5);
					zombie_morto_nord_est.add(smnordnord_est5);
					caricate++;
					return false;
				}
				

//--------------------------------------- SUD/SUD OVEST SOUL Dying-------------------------------------
				if( smsudsud_ovest1==null ){
					smsudsud_ovest1=loadImage("resource/Zombie/Dying/Sud_SudOvest/SudSudOvest1.png");
					zombie_morto_sud.add(smsudsud_ovest1);
					zombie_morto_sud_ovest.add(smsudsud_ovest1);
					caricate++;
					return false;
				}
				if( smsudsud_ovest2==null ){
					smsudsud_ovest2=loadImage("resource/Zombie/Dying/Sud_SudOvest/SudSudOvest2.png");
					zombie_morto_sud.add(smsudsud_ovest2);
					zombie_morto_sud_ovest.add(smsudsud_ovest2);
					caricate++;
					return false;
				}
				if( smsudsud_ovest3==null ){
					smsudsud_ovest3=loadImage("resource/Zombie/Dying/Sud_SudOvest/SudSudOvest3.png");
					zombie_morto_sud.add(smsudsud_ovest3);
					zombie_morto_sud_ovest.add(smsudsud_ovest3);
					caricate++;
					return false;
				}
				if( smsudsud_ovest4==null ){
					smsudsud_ovest4=loadImage("resource/Zombie/Dying/Sud_SudOvest/SudSudOvest4.png");
					zombie_morto_sud.add(smsudsud_ovest4);
					zombie_morto_sud_ovest.add(smsudsud_ovest4);
					caricate++;
					return false;
				}
				if( smsudsud_ovest5==null ){
					smsudsud_ovest5=loadImage("resource/Zombie/Dying/Sud_SudOvest/SudSudOvest5.png");
					zombie_morto_sud.add(smsudsud_ovest5);
					zombie_morto_sud_ovest.add(smsudsud_ovest5);
					caricate++;
					return false;
				}				

				
//--------------------------------------- OVEST/NORD OVEST SOUL Dying-------------------------------------
				if( smovestnord_ovest1==null ){
					smovestnord_ovest1=loadImage("resource/Zombie/Dying/Ovest_NordOvest/OvestNordOvest1.png");
					zombie_morto_ovest.add(smovestnord_ovest1);
					zombie_morto_nord_ovest.add(smovestnord_ovest1);
					caricate++;
					return false;
				}
				if( smovestnord_ovest2==null ){
					smovestnord_ovest2=loadImage("resource/Zombie/Dying/Ovest_NordOvest/OvestNordOvest2.png");
					zombie_morto_ovest.add(smovestnord_ovest2);
					zombie_morto_nord_ovest.add(smovestnord_ovest2);
					caricate++;
					return false;
				}
				if( smovestnord_ovest3==null ){
					smovestnord_ovest3=loadImage("resource/Zombie/Dying/Ovest_NordOvest/OvestNordOvest3.png");
					zombie_morto_ovest.add(smovestnord_ovest3);
					zombie_morto_nord_ovest.add(smovestnord_ovest3);
					caricate++;
					return false;
				}
				if( smovestnord_ovest4==null ){
					smovestnord_ovest4=loadImage("resource/Zombie/Dying/Ovest_NordOvest/OvestNordOvest4.png");
					zombie_morto_ovest.add(smovestnord_ovest4);
					zombie_morto_nord_ovest.add(smovestnord_ovest4);
					caricate++;
					return false;
				}
				if( smovestnord_ovest5==null ){
					smovestnord_ovest5=loadImage("resource/Zombie/Dying/Ovest_NordOvest/OvestNordOvest5.png");
					zombie_morto_ovest.add(smovestnord_ovest5);
					zombie_morto_nord_ovest.add(smovestnord_ovest5);
					caricate++;
					return false;
				}				

				
			if(backgroundMenu==null){
				backgroundMenu= loadImage("resource/Menu/background.png");
				caricate++;
				return false;
			}
			if(iconaGame==null){
				iconaGame = loadImage("resource/Menu/boxhead.png");
				caricate++;
				return false;
			}
			
		return true;
	}







	
	private Image loadImage(String fnm) {
		
	    Image image = Toolkit.getDefaultToolkit().getImage(fnm );
	    MediaTracker imageTracker = new MediaTracker( new JPanel() );

	    imageTracker.addImage(image, 0);
	    try {
	      imageTracker.waitForID(0);
	    }
	    catch (InterruptedException e) {
	      return null;
	    }
	    if (image == null)
		      return null;



		    return image;
	} // end of loadImage() using Image


		

	
	
}
