package intelligenza;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;

import core.Editor;
import logic.AbstractDynamicObject;
import logic.Vector2d;
import logic.Wall;

public class Grafo {

	public Vector2d[] nodiFine;
	public Vector2d nodoInizio;
	public HashMap<Vector2d,HashSet<Node>> map;
	
	public Grafo() {
		map = new HashMap<>();
		nodiFine = new Vector2d[4];
	}

	public Grafo(Grafo grafo) {
		map = new HashMap<>(grafo.map);
		nodiFine = new Vector2d[4];
	}

	public void clear() {
		map.clear();
	}
	
	public void clone(Grafo g){
		
		map.clear();
	    for(Entry<Vector2d, HashSet<Node>> entry : g.map.entrySet()){
	        this.map.put(entry.getKey(), new HashSet<Node>(entry.getValue()));
	    }
	}
	

	public void addNewNode(Vector2d v){
			map.put(v, new HashSet<>());
	}

	public void addArco(Vector2d n1, Vector2d n2) {
		
		map.get(n1).add(new Node(n2));
		map.get(n2).add(new Node(n1));
	}
	
	public void addDynamicNode(int index,Vector2d v){
		if(index!=4){
			
		nodiFine[index] = v;
		addNewNode(nodiFine[index]);
	
		}
		else{
			
		nodoInizio = v;
		addNewNode(nodoInizio);			
		}
	}
	
	

	
	public Vector2d aStarFirstNode(int finale){
		
		double min = Double.MAX_VALUE;
		Node take = null;
		LinkedList<Node> open = new LinkedList<>();
		LinkedList<Node> close = new LinkedList<>();
		HashSet<Node> successor = new HashSet<>();
		
		Node start = new Node(nodoInizio);
		start.g = 0;
		open.add(start);
		
		
		while(!open.isEmpty()){
			
			
			min = Double.MAX_VALUE;
			for (Node v : open) {
				if(v.f<min){
					take = v;
					min = v.f;
				}
			}
			
			if(take.vector.equals(nodiFine[finale]))
				return constructPath(take);
			
			
			successor = map.get(take.vector);
			for(Node o : successor){
				
				o.g = take.g + take.vector.distanzaTraDuePunti(o.vector);
				o.h = nodiFine[finale].distanzaTraDuePunti(o.vector);
				o.f = o.g + o.h;
				o.parent = take;
				
				
			Node op = null;
			for (Node ope : open) {
				if(ope.equals(o)){
					op = ope;
					break;
				}
			}
			
			if(op!=null)
				if(op.f <= o.f)
					continue;
			
			
			Node cl = null;

			for (Node clo : close) {
				if(clo.equals(o)){
					cl = clo;
					break;
				}
			}
			if(cl!=null){
			if(cl.f <= o.f)
				continue;
			else
				close.remove(cl);
				open.add(cl);
			}
			else{
				open.add(o);
				
			}
			
			}
			close.add(take);
			open.remove(take);
			}
		
		return null;
}

	private Vector2d constructPath(Node nodo){
		ArrayList<Node> path = new ArrayList<>();
		path.add(nodo);
		  while (nodo.parent!=null) {
		    nodo = nodo.parent;
		    path.add(nodo);
		  }
		  return path.get(path.size()-2).vector;
	}
	
	
	
	public void addEntityInGraph(int index,Vector2d o, ArrayList<Wall> oggettiFermi ,int widthMondo,int heightMondo) {
		addDynamicNode(index, o);
		
		Vector2d centro,topRect;

		for (Entry<Vector2d, HashSet<Node>> v : map.entrySet()) {
			Vector2d n = v.getKey();
	
			centro = new Vector2d((n.x+o.x)/2,(n.y+o.y)/2);

			double dist = n.distanzaTraDuePunti(o);
			
			topRect = new Vector2d(centro.x-Editor.WIDTH_ZOMBIE/2,centro.y-dist/2);
				
			double angolo = (new Vector2d(n.x-o.x, n.y-o.y)).angolo();
				
			AbstractDynamicObject z = new AbstractDynamicObject
				(topRect,Editor.WIDTH_ZOMBIE,(int) dist,angolo,1) {};
				
			boolean aggiungilo = true;
			
			if(!rimaneConfiniMappa(z,widthMondo,heightMondo)){
				aggiungilo=false;
			}
	for (Iterator<Wall> iterator = (Iterator<Wall>) oggettiFermi.iterator(); iterator.hasNext()&&aggiungilo;) {
		Wall w = (Wall) iterator.next();
				if(w.collide(z))
					aggiungilo=false;
		}
			
	if(aggiungilo)
		addArco(n,o);
	
		}
	}
	
	public boolean rimaneConfiniMappa(AbstractDynamicObject o,int width,int height){
		
		if( (o.topLeft.x < Editor.WIDTH_MURO) ||
			(o.topRight.x < Editor.WIDTH_MURO) ||
			(o.bottomLeft.x < Editor.WIDTH_MURO) ||
			(o.bottomRight.x < Editor.WIDTH_MURO) ||
			(o.topLeft.x > width - Editor.WIDTH_MURO) ||
			(o.topRight.x > width - Editor.WIDTH_MURO) ||
			(o.bottomLeft.x > width - Editor.WIDTH_MURO) ||
			(o.bottomRight.x > width - Editor.WIDTH_MURO) ||
			(o.topLeft.y < Editor.HEIGHT_MURO) ||
			(o.topRight.y < Editor.HEIGHT_MURO) ||
			(o.bottomLeft.y < Editor.HEIGHT_MURO) ||
			(o.bottomRight.y < Editor.HEIGHT_MURO) ||
			(o.topLeft.y > height - Editor.HEIGHT_MURO) ||
			(o.topRight.y > height - Editor.HEIGHT_MURO) ||
			(o.bottomLeft.y > height - Editor.HEIGHT_MURO) ||
			(o.bottomRight.y > height - Editor.HEIGHT_MURO) )
			return false;
			
		return true;
	}
		
	
};