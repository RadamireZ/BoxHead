package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JPanel;

public class LoadPanel extends JPanel implements ActionListener{

	private  JButton start;
	private JPanel sotto;
	private ImageProvider load;
	private PanelSwitcher switcher;
	private boolean finito =false;
	private int stato=0;

	
	public LoadPanel(PanelSwitcher switcher,ImageProvider p) {
		this.switcher = switcher;
		
		this.load = p;
		
		setPreferredSize(new Dimension(1200, 600));
		start = new JButton("START");

		setLayout(new BorderLayout());
		this.setFocusable(true);	
		
		
		sotto = new JPanel();
		this.add( sotto ,BorderLayout.PAGE_END);
		
		sotto.add(start);
		sotto.setBackground(Color.BLACK);
		
		start.setActionCommand("parte");
		 
		setBackground(Color.BLACK);
		
		start.addActionListener(this);


		start.setContentAreaFilled(false);
		start.setBorder(null);		
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		
		g.setColor(Color.RED);
		g.drawRect(100, this.getHeight()/2, 1000, 100);
		
		g.fillRect(100,  this.getHeight()/2, 1000/load.totaleImmagini * load.caricate, 100);

		if(stato!=0){
		String s = "LOADING...";
		g.setFont(new Font("SansSerif", Font.BOLD, 50));
		g.drawString(s,this.getWidth()/2- g.getFontMetrics().stringWidth(s)/2,this.getHeight()/2-50/2);
		}
	}


	@Override
	public void actionPerformed(ActionEvent e) {

		if("parte".equals(e.getActionCommand())) {
			stato=1;
			start.setEnabled(false);
	        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
	       

			new Thread(){
				public void run() {
					while(!finito){
					
						finito = load.caricaUnImmagine();
						
						if(finito)
							done();
							
						repaint();
					}
					
				}
				
			}.start();
			

		}	
			
	}

	
	private void done() {
			Toolkit.getDefaultToolkit().beep();
            setCursor(null);
            switcher.showMenu();
	}
	
	
};