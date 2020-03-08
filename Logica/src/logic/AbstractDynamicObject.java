package logic;

public abstract class AbstractDynamicObject extends AbstractStaticObject{
	
	
	public double directionAngle;
	public double orientationAngle;
	
	
	public double speedMax;
	
	public double speedCurr;
	

	public AbstractDynamicObject(final Vector2d topLeft,final Vector2d topRight,
		final Vector2d bottomLeft, final Vector2d bottomRight, final Vector2d centro,
		final int width, final int height,double direction,double orientatio,final double speedMax,double speedCurr) {
		
		super(topLeft,topRight,bottomLeft,bottomRight,centro,width,height);
		
		this.speedMax = speedMax;
		
		this.speedCurr = speedCurr;
		
		this.directionAngle = direction;
		this.orientationAngle = orientatio;
		
	}
	

	//costruttore solo con TopLeft che ruota nella direzione

	public AbstractDynamicObject( Vector2d TopLeft, int width,int height,double angleDirection,
		double speedMax){
		super(TopLeft,width,height);
		
		//all'inzio come gli static è verso nord 90°
		
		this.speedMax = speedMax;

		this.orientationAngle = 270;
				
		directionAngle = angleDirection;
		this.rotate();
		
	}
			
	
	
	
	public AbstractDynamicObject( AbstractDynamicObject o ){
		super(o);
		this.speedMax = o.speedMax;
		this.speedCurr = o.speedCurr;
		this.directionAngle = o.directionAngle;
		this.orientationAngle = o.orientationAngle;
	}
	
	


	public void translate(Vector2d d){
		centro = centro.add(d);
		topLeft = topLeft.add(d);
		topRight = topRight.add(d);
		bottomLeft = bottomLeft.add(d);
		bottomRight = bottomRight.add(d);
	}



public void update() {
	
	if(speedCurr>0)	{
		if(orientationAngle==directionAngle)
			translate( new Vector2d(directionAngle).multiply(speedCurr) );
		else
			rotate();
	}
}

public void rotate(){
	if( directionAngle!=orientationAngle ) {
	
	double angle = directionAngle - orientationAngle;
	
		topLeft = topLeft.ruotaPunto(angle*Math.PI/180, centro);
		topRight = topRight.ruotaPunto(angle*Math.PI/180, centro);
		bottomLeft = bottomLeft.ruotaPunto(angle*Math.PI/180, centro);
		bottomRight = bottomRight.ruotaPunto(angle*Math.PI/180, centro);

		orientationAngle = directionAngle;
	}
}

@Override
public String toString() {
	String s = "TL:"+ topLeft.toString()+"/ TR:"+topRight.toString()
	+"/ BL:"+bottomLeft.toString()+"/ BR:"+bottomRight.toString()+"/ C:"+
	centro.toString()+"/ D"+"/ O"+orientationAngle;
	return s;
	

}

public StringBuilder statusToStringBuilder(){
	
	StringBuilder sb = new StringBuilder();

	sb.append(super.statusToStringBuilder());
	sb.append(":");	
	sb.append(topRight.statusToStringBuilder());
	sb.append(":");
	sb.append(bottomLeft.statusToStringBuilder());
	sb.append(":");
	sb.append(bottomRight.statusToStringBuilder());
	sb.append(":");
	sb.append(centro.statusToStringBuilder());
	sb.append(":");
	sb.append(directionAngle);
	sb.append(":");
	sb.append(orientationAngle);
	sb.append(":");
	sb.append(speedMax);
	sb.append(":");
	sb.append(speedCurr);

	
	return sb;
}

	

};