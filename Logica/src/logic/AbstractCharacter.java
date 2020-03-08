package logic;


public abstract class AbstractCharacter extends AbstractDynamicObject{

	public int health;
	
	public int score;


public AbstractCharacter(final Vector2d topLeft, final Vector2d topRight,
		final Vector2d bottomLeft, final Vector2d bottomRight, final Vector2d centro,
		final int width, final int height, final double direction, final double orientation,
		final double speedMax, double speedCurr, int health, int score) {
	
	super(topLeft, topRight, bottomLeft, bottomRight, centro,  width, height,
		direction,orientation,speedMax,speedCurr);

	this.health=health;
	this.score=score;
}


public AbstractCharacter(final Vector2d topLeft, final int width, final int height,
		final double direction, final double speed,int health,int score) {
	
	super(topLeft, width, height, direction, speed);

	this.health=health;
	this.score=score;
}


public AbstractCharacter(AbstractCharacter a) {
	super( a);
	this.health = a.health;
	this.score = a.score;
	
}



public StringBuilder statusToStringBuilder(){
	StringBuilder sb = new StringBuilder();
	
	sb.append( super.statusToStringBuilder() );
	
	sb.append(":");
	sb.append(health);
	sb.append(":");
	sb.append(score);
		
	return sb;
}



};