package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Iterator;
import javax.swing.JPanel;

import logic.AbstractStaticObject;
import logic.Vector2d;

public class MapPanel extends JPanel implements MouseListener{

	

private Mediator mediator;
private ImageProvider provider;




public static final AbstractStaticObject AMBULANCE = new AbstractStaticObject(new Vector2d(0,-80),350,180) {}  ;
public static final AbstractStaticObject CAMION =new AbstractStaticObject(new Vector2d(0,-100),570,184) {}  ;
public static final AbstractStaticObject CAMPER =new AbstractStaticObject(new Vector2d(0,-77),450,148) {}  ;
public static final AbstractStaticObject EDIFICIO1 =new AbstractStaticObject(new Vector2d(0,-100),365,700) {};
public static final AbstractStaticObject EDIFICIO2 =new AbstractStaticObject(new Vector2d(0,-200),400,778) {};
public static final AbstractStaticObject MACCHINA2 =new AbstractStaticObject(new Vector2d(0,-25),250,108) {};
public static final AbstractStaticObject PACCHETTOARMI =new AbstractStaticObject(new Vector2d(0,0),32,32) {};


	
public MapPanel(Mediator m,ImageProvider provider) {
	super();
	
	mediator=m;
	this.provider = provider;
	setBackground(Color.GRAY);
	
	this.setPreferredSize(new Dimension(mediator.editor.width*10, mediator.editor.height*10));
	
	
	addMouseListener(this);
	
	this.setFocusable(true);
	this.revalidate();

	}


protected void paintComponent(Graphics g) {
        super.paintComponent(g);
     g.drawRect(0, 0, (int)(mediator.editor.width), (int)(mediator.editor.height));
     for (Iterator<?> iterator = mediator.editor.oggettiPresentiNellaMappa.iterator(); iterator.hasNext();) {
		AbstractStaticObject o =  (AbstractStaticObject) iterator.next();

               
		   		if (o.toString()== "MUROPERIMETRALEORIZZONTALE") 
		   			g.drawImage(provider.wallOrizzontale,(int)(o.topLeft.x),(int)(o.topLeft.y),(int)(o.width),(int)(o.height), null);
		   		else if (o.toString()== "MUROPERIMETRALEVERTICALE") 
		   			g.drawImage(provider.wallVerticale,(int)(o.topLeft.x),(int)(o.topLeft.y),(int)(o.width),(int)(o.height), null);
                else if(o.toString() == "AMBULANCE")
               	 	g.drawImage(provider.ambulance,(int)(o.topLeft.add(MapPanel.AMBULANCE.topLeft).x) , (int)(o.topLeft.add(MapPanel.AMBULANCE.topLeft).y),(int)(MapPanel.AMBULANCE.width),(int)(MapPanel.AMBULANCE.height), null);
                else if(o.toString() == "CAMION")
                	g.drawImage(provider.camion,(int)(o.topLeft.add(MapPanel.CAMION.topLeft).x),(int)(o.topLeft.add(MapPanel.CAMION.topLeft).y),(int)(MapPanel.CAMION.width),(int)(MapPanel.CAMION.height),null);
                else if(o.toString() == "CAMPER")
                	g.drawImage(provider.camper,(int)(o.topLeft.add(MapPanel.CAMPER.topLeft).x),(int)(o.topLeft.add(MapPanel.CAMPER.topLeft).y),(int)(MapPanel.CAMPER.width),(int)(MapPanel.CAMPER.height),null);
                else if(o.toString() == "EDIFICIO1a")
                	g.drawImage(provider.edificio1a,(int)(o.topLeft.add(MapPanel.EDIFICIO1.topLeft).x),(int)(o.topLeft.add(MapPanel.EDIFICIO1.topLeft).y),(int)(MapPanel.EDIFICIO1.width),(int)(MapPanel.EDIFICIO1.height),null);
                else if(o.toString() == "EDIFICIO1b")
                	g.drawImage(provider.edificio1b,(int)(o.topLeft.add(MapPanel.EDIFICIO1.topLeft).x),(int)(o.topLeft.add(MapPanel.EDIFICIO1.topLeft).y),(int)(MapPanel.EDIFICIO1.width),(int)(MapPanel.EDIFICIO1.height),null);
                else if(o.toString() == "EDIFICIO1c")
                	g.drawImage(provider.edificio1c,(int)(o.topLeft.add(MapPanel.EDIFICIO1.topLeft).x),(int)(o.topLeft.add(MapPanel.EDIFICIO1.topLeft).y),(int)(MapPanel.EDIFICIO1.width),(int)(MapPanel.EDIFICIO1.height),null);
                else if(o.toString() == "EDIFICIO1d")
                	g.drawImage(provider.edificio1d,(int)(o.topLeft.add(MapPanel.EDIFICIO1.topLeft).x),(int)(o.topLeft.add(MapPanel.EDIFICIO1.topLeft).y),(int)(MapPanel.EDIFICIO1.width),(int)(MapPanel.EDIFICIO1.height),null);
                else if(o.toString() == "EDIFICIO2a")
                	g.drawImage(provider.edificio2a,(int)(o.topLeft.add(MapPanel.EDIFICIO2.topLeft).x),(int)(o.topLeft.add(MapPanel.EDIFICIO2.topLeft).y),(int)(MapPanel.EDIFICIO2.width),(int)(MapPanel.EDIFICIO2.height),null);
                else if(o.toString() == "EDIFICIO2b")
                	g.drawImage(provider.edificio2b,(int)(o.topLeft.add(MapPanel.EDIFICIO2.topLeft).x),(int)(o.topLeft.add(MapPanel.EDIFICIO2.topLeft).y),(int)(MapPanel.EDIFICIO2.width),(int)(MapPanel.EDIFICIO2.height),null);
                else if(o.toString() == "EDIFICIO2c")
                	g.drawImage(provider.edificio2c,(int)(o.topLeft.add(MapPanel.EDIFICIO2.topLeft).x),(int)(o.topLeft.add(MapPanel.EDIFICIO2.topLeft).y),(int)(MapPanel.EDIFICIO2.width),(int)(MapPanel.EDIFICIO2.height),null);
                else if(o.toString() == "MACCHINA2")
                	g.drawImage(provider.macchina2,(int)(o.topLeft.add(MapPanel.MACCHINA2.topLeft).x),(int)(o.topLeft.add(MapPanel.MACCHINA2.topLeft).y),(int)(MapPanel.MACCHINA2.width),(int)(MapPanel.MACCHINA2.height),null);
                else if(o.toString()=="ARMA1" || o.toString()=="ARMA2" || o.toString()=="ARMA3" )
                	g.drawImage(provider.pacchetto, (int)(o.topLeft.add(MapPanel.PACCHETTOARMI.topLeft).x),(int)(o.topLeft.add(MapPanel.PACCHETTOARMI.topLeft).y),(int)(MapPanel.PACCHETTOARMI.width), (int)(MapPanel.PACCHETTOARMI.height), null);
                else if(o.toString() == "PORTA")
                	g.drawImage(provider.porta,(int) (o.topLeft.x),(int)(o.topLeft.y),(int)(o.width),(int)(o.height),null);
                else if(o.toString()=="PLAYER")
                	g.drawImage(provider.player_nord.get(2),(int)(o.topLeft.x),(int)(o.topLeft.y),(int)(o.width),(int)(o.height),null);
            }
}


@Override
public void mouseClicked(MouseEvent arg0) {
}


@Override
public void mouseEntered(MouseEvent arg0) {
}


@Override
public void mouseExited(MouseEvent arg0) {
}


@Override
public void mousePressed(MouseEvent e) {
	
mediator.editor.insert(e.getX(),e.getY(), mediator.getSelected());

repaint();

}
@Override
public void mouseReleased(MouseEvent arg0) {
}  


}