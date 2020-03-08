package logic;

import logic.AbstractStaticObject;
import logic.Vector2d;

public class Wall extends AbstractStaticObject{

public String cosaE ;
	
	
public Wall(Vector2d TopLeft, int width, int height,String tipo) {

		super(TopLeft, width, height);
		cosaE=tipo;
	}
	



@Override
	public String toString() {
		return cosaE;
		
	}

public StringBuilder statusToStringBuilder() {
	
	StringBuilder sb = new StringBuilder();
	
	sb.append(super.statusToStringBuilder());
	sb.append(":");
	sb.append(cosaE);
	
	return sb;
}


}
