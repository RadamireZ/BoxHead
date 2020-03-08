package gui;

import java.awt.Image;
import java.util.ArrayList;

public class AnimationImages {

  private boolean ripetibile;
  
  public boolean finita;
  
  private int animPeriod;

  private long animTotalTime;

  
  private int showPeriod;     

  private double seqDuration;   

  private int imPosition;     
  
  private int numImages;
  
  private ArrayList<Image> daAnimare;
  
public float trasparenza;
 
  public int positionStop ;

  public AnimationImages(int periodoUpdate, double totaleDurata, 
                                boolean isRipetibile,int ps,ArrayList<Image> ar) 
  {
    animPeriod = periodoUpdate; 
    seqDuration = totaleDurata;
    ripetibile = isRipetibile;
    daAnimare = ar;
    positionStop = ps;
    
    animTotalTime = 0L;
    
    numImages = daAnimare.size();
    
    imPosition = positionStop;
    
    showPeriod = (int) ( seqDuration / numImages);
    trasparenza = 1;
    finita=false;
  } 




  public void updateTick()
  {  
	      
	if ( animTotalTime+animPeriod>=seqDuration && (!ripetibile))
		finita = true;
	
	  if (!finita) {
		  animTotalTime = (animTotalTime + animPeriod) % (long) (seqDuration);

		  imPosition = (int) (animTotalTime / showPeriod);   // in range 0 to num-1

		  trasparenza -= 0.001;
         }
  
	  
  } 

  public void setArray(ArrayList<Image> a){
	  daAnimare = a;
	  this.stop();
  }
  

  public Image getCurrentImage()
  {
	 if(finita)
		 return null;

	return daAnimare.get(imPosition); 
  } 



  public void stop()
   { 
	  imPosition=positionStop;
	  animTotalTime =0;
	  }



}
	
	

