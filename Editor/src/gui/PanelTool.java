package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class PanelTool extends JPanel implements ActionListener{

	
	private final JButton ambulanceButton;
	private final JButton camionButton;
	private final JButton camperButton;
	private final JButton edificio1aButton;
	private final JButton edificio1bButton;
	private final JButton edificio1cButton;
	private final JButton edificio1dButton;
	private final JButton edificio2aButton;
	private final JButton edificio2bButton;
	private final JButton edificio2cButton;
	private final JButton macchina2Button;
	private final JButton arma1Button;
	private final JButton arma2Button;
	private final JButton arma3Button;
	private final JButton playerButton;
	private final JButton rimuoviButton;
	private final JButton portaButton;

		
		private Mediator mediator;


	    
	public PanelTool(Mediator mediator, ImageProvider provider) {
		super();
		this.mediator= mediator;
		
		setBackground(Color.BLACK);
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
	    
		ambulanceButton = new JButton(new ImageIcon(provider.ambulance.getScaledInstance(80,40,0)));
		ambulanceButton.setHorizontalAlignment(SwingConstants.LEFT);
		ambulanceButton.setOpaque(false);
		ambulanceButton.setContentAreaFilled(false);
		ambulanceButton.setBorder(null);		
		ambulanceButton.addActionListener(this);
	    this.add(ambulanceButton);
	    
		camionButton = new JButton(new ImageIcon(provider.camion.getScaledInstance(80,40,0)));
		camionButton.setHorizontalAlignment(SwingConstants.LEFT);
		camionButton.setOpaque(false);
		camionButton.setContentAreaFilled(false);
		camionButton.setBorder(null);		
		camionButton.addActionListener(this);
	    this.add(camionButton);
	    
		camperButton = new JButton(new ImageIcon(provider.camper.getScaledInstance(80,40,0)));
		camperButton.setHorizontalAlignment(SwingConstants.LEFT);
		camperButton.setOpaque(false);
		camperButton.setContentAreaFilled(false);
		camperButton.setBorder(null);		
		camperButton.addActionListener(this);
	    this.add(camperButton);
	    
	    edificio1aButton = new JButton(new ImageIcon(provider.edificio1a.getScaledInstance(80,40,0)));
		edificio1aButton.setHorizontalAlignment(SwingConstants.LEFT);
		edificio1aButton.setOpaque(false);
		edificio1aButton.setContentAreaFilled(false);
		edificio1aButton.setBorder(null);		
		edificio1aButton.addActionListener(this);
	    this.add(edificio1aButton);
	    
	    edificio1bButton = new JButton(new ImageIcon(provider.edificio1b.getScaledInstance(80,40,0)));
		edificio1bButton.setHorizontalAlignment(SwingConstants.LEFT);
		edificio1bButton.setOpaque(false);
		edificio1bButton.setContentAreaFilled(false);
		edificio1bButton.setBorder(null);		
		edificio1bButton.addActionListener(this);
	    this.add(edificio1bButton);
	    
	    edificio1cButton = new JButton(new ImageIcon(provider.edificio1c.getScaledInstance(80,40,0)));
		edificio1cButton.setHorizontalAlignment(SwingConstants.LEFT);
		edificio1cButton.setOpaque(false);
		edificio1cButton.setContentAreaFilled(false);
		edificio1cButton.setBorder(null);		
		edificio1cButton.addActionListener(this);
	    this.add(edificio1cButton);
	    
	    edificio1dButton = new JButton(new ImageIcon(provider.edificio1d.getScaledInstance(80,40,0)));
		edificio1dButton.setHorizontalAlignment(SwingConstants.LEFT);
		edificio1dButton.setOpaque(false);
		edificio1dButton.setContentAreaFilled(false);
		edificio1dButton.setBorder(null);		
		edificio1dButton.addActionListener(this);
	    this.add(edificio1dButton);
	    
	    edificio2aButton = new JButton(new ImageIcon(provider.edificio2a.getScaledInstance(80,40,0)));
		edificio2aButton.setHorizontalAlignment(SwingConstants.LEFT);
		edificio2aButton.setOpaque(false);
		edificio2aButton.setContentAreaFilled(false);
		edificio2aButton.setBorder(null);		
		edificio2aButton.addActionListener(this);
	    this.add(edificio2aButton);

	    edificio2bButton = new JButton(new ImageIcon(provider.edificio2b.getScaledInstance(80,40,0)));
		edificio2bButton.setHorizontalAlignment(SwingConstants.LEFT);
		edificio2bButton.setOpaque(false);
		edificio2bButton.setContentAreaFilled(false);
		edificio2bButton.setBorder(null);		
		edificio2bButton.addActionListener(this);
	    this.add(edificio2bButton);
	    
	    edificio2cButton = new JButton(new ImageIcon(provider.edificio2c.getScaledInstance(80,40,0)));
		edificio2cButton.setHorizontalAlignment(SwingConstants.LEFT);
		edificio2cButton.setOpaque(false);
		edificio2cButton.setContentAreaFilled(false);
		edificio2cButton.setBorder(null);		
		edificio2cButton.addActionListener(this);
	    this.add(edificio2cButton);
	    

		macchina2Button = new JButton(new ImageIcon(provider.macchina2.getScaledInstance(80,40,0)));
		macchina2Button.setHorizontalAlignment(SwingConstants.LEFT);
		macchina2Button.setOpaque(false);
		macchina2Button.setContentAreaFilled(false);
		macchina2Button.setBorder(null);		
        macchina2Button.addActionListener(this);
        this.add(macchina2Button);
        
		arma1Button = new JButton(new ImageIcon(provider.pacchetto.getScaledInstance(80,40,0)));
		arma1Button.setHorizontalAlignment(SwingConstants.LEFT);
		arma1Button.setOpaque(false);
		arma1Button.setContentAreaFilled(false);
		arma1Button.setBorder(null);		
        arma1Button.addActionListener(this);
        this.add(arma1Button);
        
		arma2Button = new JButton(new ImageIcon(provider.pacchetto.getScaledInstance(80,40,0)));
		arma2Button.setHorizontalAlignment(SwingConstants.LEFT);
		arma2Button.setOpaque(false);
		arma2Button.setContentAreaFilled(false);
		arma2Button.setBorder(null);		
        arma2Button.addActionListener(this);
        this.add(arma2Button);
        
		arma3Button = new JButton(new ImageIcon(provider.pacchetto.getScaledInstance(80,40,0)));
		arma3Button.setHorizontalAlignment(SwingConstants.LEFT);
		arma3Button.setOpaque(false);
		arma3Button.setContentAreaFilled(false);
		arma3Button.setBorder(null);		
        arma3Button.addActionListener(this);
        this.add(arma3Button);
        
        playerButton = new JButton(new ImageIcon(provider.player_nord.get(2).getScaledInstance(80,40,0)));
		playerButton.setHorizontalAlignment(SwingConstants.LEFT);
		playerButton.setOpaque(false);
		playerButton.setContentAreaFilled(false);
		playerButton.setBorder(null);		
		playerButton.addActionListener(this);
        this.add(playerButton);
        
        portaButton = new JButton(new ImageIcon(provider.porta.getScaledInstance(80,40,0)));
		portaButton.setHorizontalAlignment(SwingConstants.LEFT);
		portaButton.setOpaque(false);
		portaButton.setContentAreaFilled(false);
		portaButton.setBorder(null);		
		portaButton.addActionListener(this);
        this.add(portaButton);
        
 
        rimuoviButton = new JButton("RIMUOVI");
        rimuoviButton.setHorizontalAlignment(SwingConstants.LEFT);
        rimuoviButton.addActionListener(this);
        this.add(rimuoviButton);
  
	}


	public void actionPerformed(ActionEvent e) {
		
		System.out.println("CLICK PANEL TOOL");
		
		if(e.getSource()==ambulanceButton)
			mediator.setSelected("AMBULANCE");
		else if(e.getSource()==camionButton)
			mediator.setSelected("CAMION");
		else if(e.getSource()==camperButton)
			mediator.setSelected("CAMPER");	
		else if(e.getSource()==edificio1aButton)
			mediator.setSelected("EDIFICIO1a");
		else if(e.getSource()==edificio1bButton)
			mediator.setSelected("EDIFICIO1b");
		else if(e.getSource()==edificio1cButton)
			mediator.setSelected("EDIFICIO1c");
		else if(e.getSource()==edificio1dButton)
			mediator.setSelected("EDIFICIO1d");
		else if(e.getSource()==edificio2aButton)
			mediator.setSelected("EDIFICIO2a");
		else if(e.getSource()==edificio2bButton)
			mediator.setSelected("EDIFICIO2b");
		else if(e.getSource()==edificio2cButton)
			mediator.setSelected("EDIFICIO2c");
		else if(e.getSource()==macchina2Button)
			mediator.setSelected("MACCHINA2");		
		else if(e.getSource()==arma1Button)
			mediator.setSelected("ARMA1");
		else if(e.getSource()==arma2Button)
			mediator.setSelected("ARMA2");
		else if(e.getSource()==arma3Button)
			mediator.setSelected("ARMA3");
		else if(e.getSource()==portaButton)
			mediator.setSelected("PORTA");
		else if(e.getSource()==playerButton)
			mediator.setSelected("PLAYER");
		else if(e.getSource()==rimuoviButton)
				mediator.setSelected("RIMUOVI");
		else
			mediator.setSelected(null);
		repaint();	
	}

	
};