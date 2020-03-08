package intelligenza;

import logic.Vector2d;

public class Node {

	public double g;
	public double h;
	public double f;
	public Vector2d vector;
	public Node parent;

	
	public Node(Vector2d a) {
		g = 0;
		h=0;
		f=0;
		vector = a;
	}
	

	public boolean equals(Node n) {
		return this.vector.equals(n.vector);
	}
	
	
	public StringBuilder statusToStringBuilder(){
		StringBuilder sb = new StringBuilder();
		
		sb.append(vector.statusToStringBuilder());
		sb.append(":");
		sb.append("f");
		sb.append(":");
		sb.append("g");
		sb.append(":");
		sb.append("h");
		sb.append(":");
		if(parent!=null)
		sb.append(parent.statusToStringBuilder());
		
		return sb;
	}
}

