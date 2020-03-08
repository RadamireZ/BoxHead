package gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


import logic.AbstractStaticObject;


public class FrameEditor extends JFrame implements ActionListener,WindowListener{
    
    private Mediator mediator;
    
    private JMenuBar menuBar;
    private JMenu file;
    private JMenu edit;
    
    private JMenuItem load;
    private JMenuItem save;
    
    private JMenuItem clear;
    private JMenuItem resize;
    
    private JPanel principale;
    private PanelSwitcher switcher;

    public FrameEditor(ImageProvider provider, PanelSwitcher switcher){
    	
        super();
        mediator= new Mediator (); 
        this.switcher = switcher;
        
        principale = new PanelEditor(mediator,provider);

        this.setContentPane(principale);
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d= tk.getScreenSize();
        

        
        this.setSize(d.width,d.height-50);
        this.setResizable(false);
        this.setVisible(true);
        
        this.setTitle("EDITOR");
        
        


            menuBar = new JMenuBar();
            file = new JMenu("FILE");
            edit = new JMenu("EDIT");
            
            load = new JMenuItem("LOAD");
            save = new JMenuItem("SAVE");
            
            clear  = new JMenuItem("CLEAR");
            resize = new JMenuItem("RESIZE");

            
            menuBar.add(file);
            menuBar.add(edit);
            
            file.add(load);
            file.add(save);
            

            edit.add(clear);
            edit.add(resize);
     

            this.setJMenuBar(menuBar);
            
            save.addActionListener(this);
            load.addActionListener(this);
            clear.addActionListener(this);
            resize.addActionListener(this);
            

            
	this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(this);
    }
    
    

@Override
public void paintComponents(Graphics g) {
	super.paintComponents(g);

}

@Override
public void actionPerformed(ActionEvent e) { 

	JMenuItem source = (JMenuItem)(e.getSource());
	
	if(source.getText()=="SAVE"){
		if(mediator.editor.playerDentro==null)
			JOptionPane.showMessageDialog(this,"Non e' stato inserito il player","IMPOSSIBILE SALVARE",JOptionPane.ERROR_MESSAGE);
		else if(mediator.editor.porteDentroCount<=0)
			JOptionPane.showMessageDialog(this,"Non e' stata inserita nemmeno una porta","IMPOSSIBILE SALVARE",JOptionPane.ERROR_MESSAGE);
		else if(!mediator.editor.isPossibleSave())
			JOptionPane.showMessageDialog(this,"Da una o piu' porte inserite non si può raggiungere il player","IMPOSSIBILE SALVARE",JOptionPane.ERROR_MESSAGE);
		else{
	    JFileChooser fc = new JFileChooser("resource/map");		
		fc.setDialogTitle("SALVA LA TUA MAPPA");
		int n= fc.showSaveDialog(this);
		if(n==JFileChooser.APPROVE_OPTION){
			File f = fc.getSelectedFile();
			PrintWriter output = null;

			try {
				output=new PrintWriter(new FileWriter(f));
				output.write(mediator.editor.width+" "+mediator.editor.height+"\n");
					for (int i = 0; i < mediator.editor.oggettiPresentiNellaMappa.size(); i++) {
						
					AbstractStaticObject o = mediator.editor.oggettiPresentiNellaMappa.get(i);
					output.write((int)o.topLeft.x+" "+(int)o.topLeft.y+" ");
					output.write(o.toString());	
					output.println();
					output.flush();
				}
				output.close();
					
			} catch (IOException e1) {
				e1.printStackTrace();
			}	
		}	
		}
	}

	
	else if(source.getText()=="LOAD"){
	    JFileChooser fc = new JFileChooser("resource/map");
		fc.setDialogTitle("CARICA UNA MAPPA");
		int n = fc.showOpenDialog(this);
		if( n==JFileChooser.APPROVE_OPTION ){
			File f = fc.getSelectedFile();
			Scanner input = null;
			try {
				input= new Scanner(new BufferedReader(new FileReader(f)));
				
				int x=input.nextInt();
				int y=input.nextInt();
				mediator.editor.resizeAndClear(x,y);
				
				String s;
				while( input.hasNext()){
					x=input.nextInt();
					y=input.nextInt();
					s= input.next();
					mediator.editor.insert(x, y, s);
					
				}
				input.close();
						
			} catch (IOException e1) {
				e1.printStackTrace();
			
			}
		}
		repaint();

	}
	else if(source.getText()=="CLEAR"){
		mediator.editor.resizeAndClear(mediator.editor.width,mediator.editor.height);
		repaint();
	}
	else if(source.getText()=="RESIZE"){

		DialogResize dialog = new DialogResize(this.getWidth(),this.getHeight(),mediator.editor.width,mediator.editor.height);
		while(!dialog.chiuso()){
		dialog.setAlwaysOnTop(true);
		dialog.setFocusable(true);

		
			if(dialog.getResult())
				mediator.editor.resize(dialog.getNwidth(),dialog.getNheight());
		}

		repaint();
	}


}


@Override
public void windowActivated(WindowEvent arg0) {
}

@Override
public void windowClosed(WindowEvent arg0) {
}



@Override
public void windowClosing(WindowEvent arg0) {
	setVisible(false);
	switcher.showMenu();
}

@Override
public void windowDeactivated(WindowEvent arg0) {
}

@Override
public void windowDeiconified(WindowEvent arg0) {
}

@Override
public void windowIconified(WindowEvent arg0) {
}

@Override
public void windowOpened(WindowEvent arg0) {
}


};