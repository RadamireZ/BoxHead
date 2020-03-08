package logic;


public abstract class AbstractStaticObject {

	public Vector2d topLeft;
	
	public Vector2d topRight;
	public Vector2d bottomLeft;
	public Vector2d bottomRight;
	
	public Vector2d centro;
	
	public int width ;//base
	public int height ;//altezza
	
	
	public AbstractStaticObject( Vector2d topLeft, int  width, int height ) {
		
		this.topLeft = new Vector2d(topLeft);
		this.topRight = new Vector2d(topLeft.x+width,topLeft.y);
		this.bottomLeft = new Vector2d(topLeft.x,topLeft.y+height);
		this.bottomRight = new Vector2d(topLeft.x+width,topLeft.y+height);

		centro = new Vector2d(topLeft.x+width/2,topLeft.y+height/2);
		
		this.width=width;
		this.height=height;
		
	}

	
	public AbstractStaticObject( Vector2d topLeft,Vector2d topRight,Vector2d bottomLeft,
			Vector2d bottomRight,Vector2d centro, int  width, int height ) {
		
		this.topLeft = new Vector2d(topLeft);
		this.topRight = new Vector2d(topRight);
		this.bottomLeft = new Vector2d(bottomLeft);
		this.bottomRight = new Vector2d(bottomRight);
		
		this.centro = new Vector2d(centro);
		
		this.width=width;
		this.height=height;
		
	}

	public AbstractStaticObject(AbstractStaticObject s) {
		
		topLeft = new Vector2d(s.topLeft);
		topLeft = new Vector2d(s.topLeft);
		topRight = new Vector2d(s.topRight);
		bottomLeft = new Vector2d(s.bottomLeft);
		bottomRight = new Vector2d(s.bottomRight);
		
		centro = new Vector2d(s.centro);
		
		width=s.width;
		height=s.height;
	}



	
	public AbstractStaticObject() {
		
		topLeft = new Vector2d();
		topRight = new Vector2d();
		bottomLeft = new Vector2d();
		bottomRight = new Vector2d();
		
		centro = new Vector2d();
		
		width = 0;
		height = 0;
	}


	public boolean collide(AbstractStaticObject b) {
		
		
		Vector2d axes[] = new Vector2d[4];
		
		axes[0] = (topLeft.edge(topRight)).normale(false).normalize();
		axes[1] = (topLeft.edge(bottomLeft)).normale(false).normalize();
		
		axes[2] = (b.topLeft.edge(b.topRight)).normale(false).normalize();
		axes[3] = (b.topLeft.edge(b.bottomLeft)).normale(false).normalize();
		
		
		for(int i=0 ;i<4;i++) {
			
			Vector2d projectionA = this.project(axes[i]);
			Vector2d projectionB = b.project(axes[i]);
			
			double d1 = projectionA.x - projectionB.y;
			double d2 = projectionB.x - projectionA.y;
			
			if( (d1>=0) || (d2>=0) )
				return false;
		}
		return true;
	}

	
	
	private Vector2d project(Vector2d axis) {//x = min , y = max
			Vector2d proj= new Vector2d();
			double min, max, p;
			
			p = topLeft.dotProduct(axis);
			min = p;
			max = p;
			
			p = topRight.dotProduct(axis);
			
			if(p < min)
				min = p;
			if(p > max)
				max = p;
			
			p = bottomLeft.dotProduct(axis);
			
			if(p < min)
				min = p;
			if(p > max)
				max = p;
						
			p = bottomRight.dotProduct(axis);
			
			if(p < min)
				min = p;
			if(p > max)
				max = p;
			
			
			proj.x = min;
			proj.y = max;
			
			return proj;
		}
	
	
	public StringBuilder statusToStringBuilder(){
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(topLeft.statusToStringBuilder());
		sb.append(":");
		sb.append(width);
		sb.append(":");
		sb.append(height);
		
		return sb;
	}

		

};