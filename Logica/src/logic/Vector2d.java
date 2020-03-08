package logic;



public class Vector2d {

public	double x;
public double y;


	public Vector2d (){
		super();
		x=0;
		y=0;
	}
	
	
	
	public Vector2d(double x,double y){
		super();
		this.x=x;
		this.y=y;
	}
	
		
	
	public Vector2d(Vector2d copy) {
		super();
		this.x= copy.x;
		this.y= copy.y;
	}

	
	public Vector2d(double angleDegree) {
		
		double angleRadiant = angleDegree*Math.PI/180;
		
		this.x = Math.cos(angleRadiant);
		this.y = Math.sin(angleRadiant);
	}
	
	public Vector2d add(Vector2d d){
		return new Vector2d(this.x + d.x, this.y + d.y);
	}

	
	public Vector2d multiply (double m){
		return new Vector2d(this.x*m,this.y*m);	
	}

	public double dotProduct(Vector2d b) {
		return (this.x*b.x + this.y*b.y);
	}
	
	public Vector2d projection(Vector2d b) {
		Vector2d v = new Vector2d();
		v.x = (dotProduct(b)/(b.x*b.x+b.y*b.y)*b.x);
		v.y = (dotProduct(b)/(b.x*b.x+b.y*b.y)*b.y);
		return v;
	}

	public Vector2d normale(boolean left) {
		if(left)
			return new Vector2d(-this.y,this.x);
		else
			return new Vector2d(this.y,-this.x);
	}
	
	public double modulo() {
		return Math.sqrt(x*x + y*y);	
	}
	
	public Vector2d normalize() {
		double mod = this.modulo();
		return new Vector2d(x/mod,y/mod);
	}
	
	public double angolo() {

		double angle = Math.atan2(y, x);
		
		angle = angle * 360 / (2*Math.PI);
		
		if(angle <0)
			angle = angle + 360;

		return angle;
	}
	
	public Vector2d edge(Vector2d p) {
		
		return new Vector2d(p.x-this.x, p.y - this.y);
	}
	
	
	public Vector2d ruotaPunto(double angolo,Vector2d centro){
		Vector2d after = new Vector2d();
		Vector2d before = new Vector2d(this);
		
		double sin = Math.sin(angolo);
		double cos = Math.cos(angolo);
		
		after.x =  (centro.x + (before.x-centro.x)*cos-(before.y-centro.y)*sin);
		after.y =  (centro.y + (before.x-centro.x)*sin+(before.y-centro.y)*cos);
	
		return after;	
	}
	
	
	public double distanzaTraDuePunti(Vector2d p2){
		
		return Math.sqrt( Math.pow( (p2.x-this.x) ,2) + Math.pow( (p2.y-this.y) ,2) );
	}
	
	public StringBuilder statusToStringBuilder(){
		StringBuilder sb = new StringBuilder();
		sb.append(this.x+":"+this.y);
		return sb;
	}

	
	@Override
	public boolean equals(Object o) {
		Vector2d v = (Vector2d) o;
			return (this.x==v.x && this.y==v.y);
		}
	
	
	
	@Override
		public String toString() {
			return x+" "+y;
		}
	
	
	
};