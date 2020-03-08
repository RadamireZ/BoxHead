package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class MenuConnectionPanel extends JPanel implements ActionListener{
	

	private PanelSwitcher switcher;
	
	private JButton crea;
	private JButton partecipa;

	private ImageProvider provider;
	
	
	public MenuConnectionPanel(MainFrame f) {
		
		super();
		
		this.switcher = f;
		this.provider = f.provider;
		setPreferredSize(new Dimension(700, 400));
		
		
		this.setLayout(new GridBagLayout());
	    
		GridBagConstraints c = new GridBagConstraints();
		
		crea = new JButton("CREA NUOVA PARTITA");
		partecipa  = new JButton("PARTECIPA ALLA PARTITA");	
	


		
		crea.setEnabled(true);
		partecipa.setEnabled(true);
		
		
		crea.setOpaque(false);
		crea.setContentAreaFilled(false);
		crea.setBorderPainted(false);
		crea.setBorder(null);	
		crea.setForeground(Color.RED);
		
		partecipa.setOpaque(false);
		partecipa.setContentAreaFilled(false);
		partecipa.setBorderPainted(false);
		partecipa.setBorder(null);	
		partecipa.setForeground(Color.RED);
		
	
		c.fill=GridBagConstraints.HORIZONTAL;
		c.weightx = 0.0;
		c.gridheight = 0;
		c.gridx = 0;
		c.gridy = 1;
		add(crea,c);
        
		c.weightx = 0.0;
		c.gridx = 2;
		c.gridy = 1;
		c.insets = new Insets(0,40,0,0);
		add(partecipa,c);
	
        
        crea.addActionListener(this);
        crea.setActionCommand("server");
        
        partecipa.addActionListener(this);
        partecipa.setActionCommand("client");
        
		JLabel lab  = new JLabel("NAME PLAYER");
		lab.setFont(new Font("Serif", Font.PLAIN, 14));
		lab.setForeground(Color.RED);
		

		JButton conferma = new JButton("START");
		
		conferma.setEnabled(false);
		
			

		}





	@Override
	public void actionPerformed(ActionEvent e) {
		
		if( e.getActionCommand()=="server" ){
			switcher.showServer();
			}
		else if( e.getActionCommand()=="client"){
			switcher.showClient();
		}
	}

	
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(provider.backgroundMenu,0,0, null);
		g.drawImage(provider.iconaGame,300,10, 100,100, null);
	}
	



};