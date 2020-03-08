package logic;

import logic.AbstractStaticObject;
import logic.Arma;
import logic.Pacchetto;
import logic.Vector2d;

public class Pacchetto extends AbstractStaticObject {
	
	public Arma arma;	
	
	
	public Pacchetto(final Vector2d posizione, int width, int height,Arma arma) {
		super(posizione, width, height);
		this.arma = arma;
	}


public Pacchetto(Pacchetto o) {
		super(o);
		this.arma = o.arma;
	}

public StringBuilder statusToStringBuilder(){
	StringBuilder sb = new StringBuilder();
	sb.append(super.statusToStringBuilder());
	sb.append(":");
	if(arma==Mondo.ARMA1)
		sb.append(1);
	else if(arma==Mondo.ARMA2)
		sb.append(2);
	else if(arma==Mondo.ARMA3)
		sb.append(3);
	
	return sb;
}
	

@Override
public String toString() {
	if(arma==Mondo.ARMA1)
		return "ARMA1";
	if(arma==Mondo.ARMA2)
		return "ARMA2";
	if(arma==Mondo.ARMA3)
		return "ARMA3";
	return "PACCHETTO"; 
}

}