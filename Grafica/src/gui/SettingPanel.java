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
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import core.Editor;
import logic.Mondo;
import logic.Pacchetto;
import logic.Player;
import logic.Vector2d;
import logic.Wall;

public class SettingPanel extends JPanel implements ActionListener{

	
	public JTextField tf;
	private JLabel lab;
	private JButton map;
	private JButton conferma;
	private Mondo mondo;
	private boolean mappa;
	private boolean nome;
	private String name;
	private ImageProvider provider;
	private MainFrame mainFrame;
	
	private JRadioButton easy;
	private JRadioButton hard;
	
	
	public SettingPanel(MainFrame f) {
		super();
		this.mondo = f.mondo;
		this.mainFrame = f;

		name="valoreFittizio";
		
		setPreferredSize(new Dimension(700,400));
		
		provider = f.provider;
		
		
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		



		mappa=false;
		
		nome=false;
		
		tf = new JTextField("nome");
		
		tf.setBackground(Color.BLACK);
		tf.setForeground(Color.RED);
		
		tf.requestFocus();
		
		lab  = new JLabel("NAME PLAYER");
		lab.setFont(new Font("Serif", Font.PLAIN, 14));
		lab.setForeground(Color.RED);
		
		map = new JButton("SELECT MAP");
		
		conferma = new JButton("CONFIRM");
		
		conferma.setEnabled(false);
		
		map.addActionListener(this);
		
		map.setActionCommand("mappa");
		
		conferma.setActionCommand("CONFERMA");
		conferma.addActionListener(this);
		
		tf.setActionCommand("nome");
		tf.addActionListener(this);
		tf.setColumns(7);
		
		easy = new JRadioButton("EASY");
		hard = new JRadioButton("HARD");
		
		easy.setSelected(true);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(easy);
		bg.add(hard);
		
		
			
//		c.fill=GridBagConstraints.HORIZONTAL;
		c.weightx = 0.0;
		c.gridwidth = 1;
		c.gridheight =1;
		c.gridx = 1;
		c.gridy = 0;
		add(lab,c);
        
		c.weightx = 0.0;
		c.gridx = 1;
		c.gridy = 1;
		c.insets = new Insets(10,0,0,0);
		add(tf,c);
		
		
		c.weightx = 0.0;
		c.gridx = 1;
		c.insets = new Insets(10,0,0,0);
		c.gridy = 2;
		
		add(map,c);
		
		
		c.weightx = 0.0;
		c.gridx = 1;
		c.insets = new Insets(10,0,0,0);
		c.gridy = 3;
		add(conferma,c);

		c.weightx = 0.0;
		c.gridx = 2;
		c.gridy = 2;
		add(easy,c);

		c.weightx = 0.0;
		c.gridx = 2;
		c.gridy = 3;
		add(hard,c);
		
		revalidate();
		
		map.setOpaque(false);
		map.setContentAreaFilled(false);
		map.setBorderPainted(false);
		map.setBorder(null);	
		map.setForeground(Color.RED);
		map.setFocusPainted(false);

		
		conferma.setOpaque(false);
		conferma.setContentAreaFilled(false);
		conferma.setBorderPainted(false);
		conferma.setBorder(null);	
		conferma.setForeground(Color.RED);
		conferma.setFocusPainted(false);

		easy.setOpaque(false);
		easy.setContentAreaFilled(false);
		easy.setBorderPainted(false);
		easy.setBorder(null);	
		easy.setForeground(Color.RED);
		easy.setFocusPainted(false);
		
		hard.setOpaque(false);
		hard.setContentAreaFilled(false);
		hard.setBorderPainted(false);
		hard.setBorder(null);	
		hard.setForeground(Color.RED);
		hard.setFocusPainted(false);		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getActionCommand()=="mappa"){
			    JFileChooser fc = new JFileChooser("resource/map");
				fc.setDialogTitle("CARICA UNA MAPPA");
				int n = fc.showOpenDialog(this);
				if( n==JFileChooser.APPROVE_OPTION ){
					mondo.clear();
					File f = fc.getSelectedFile();
					//BufferedReader input = null;
					Scanner input = null;
					try {
						input= new Scanner(new BufferedReader(new FileReader(f)));
						
						int x=input.nextInt();
						int y=input.nextInt();
						
						mondo.setDimensione(x,y);
						
						String s;
						while( input.hasNext()){
							x=input.nextInt();
							y=input.nextInt();
							s= input.next();
							switch (s) {
							case "PLAYER":
								mondo.players.put(name,(new Player(new Vector2d(x,y),
								Editor.WIDTH_PLAYER,Editor.HEIGHT_PLAYER,
								270,Editor.SPEED_PLAYER)));
								break;
							case "ARMA1":
								mondo.getPacchi().add(new Pacchetto(new Vector2d(x,y),Editor.WIDTH_PACCHETTO,Editor.HEIGHT_PACCHETTO,Mondo.ARMA1));
								break;
							case "ARMA2":
								mondo.getPacchi().add(new Pacchetto(new Vector2d(x, y),Editor.WIDTH_PACCHETTO,Editor.HEIGHT_PACCHETTO,Mondo.ARMA2));
								break;
							case "ARMA3":
								mondo.getPacchi().add(new Pacchetto(new Vector2d(x, y),Editor.WIDTH_PACCHETTO,Editor.HEIGHT_PACCHETTO,Mondo.ARMA3));
								break;
							case "MUROPERIMETRALEORIZZONTALE":
								mondo.muriPerimetrali.add(new Wall(new Vector2d(x, y),Editor.WIDTH_MURO,Editor.HEIGHT_MURO,"MUROPERIMETRALEORIZZONTALE"));
								break;
							case "MUROPERIMETRALEVERTICALE":
								mondo.muriPerimetrali.add(new Wall(new Vector2d(x, y),Editor.WIDTH_MURO,Editor.HEIGHT_MURO,"MUROPERIMETRALEVERTICALE"));
								break;
							case "AMBULANCE":
								mondo.oggettiFermi.add(new Wall(new Vector2d(x,y),Editor.WIDTH_AMBULANCE,Editor.HEIGHT_AMBULANCE,"AMBULANCE"));
								break;
							case "CAMION":
								mondo.oggettiFermi.add(new Wall(new Vector2d(x,y),Editor.WIDTH_CAMION,Editor.HEIGHT_CAMION,"CAMION"));
								break;
							case "CAMPER":
								mondo.oggettiFermi.add(new Wall(new Vector2d(x,y),Editor.WIDTH_CAMPER,Editor.HEIGHT_CAMPER,"CAMPER"));
								break;
							case "EDIFICIO1a":
								mondo.oggettiFermi.add(new Wall(new Vector2d(x,y),Editor.WIDTH_EDIFICIO1,Editor.HEIGHT_EDIFICIO1,"EDIFICIO1a"));
								break;							
							case "EDIFICIO1b":
								mondo.oggettiFermi.add(new Wall(new Vector2d(x,y),Editor.WIDTH_EDIFICIO1,Editor.HEIGHT_EDIFICIO1,"EDIFICIO1b"));
								break;									
							case "EDIFICIO1c":
								mondo.oggettiFermi.add(new Wall(new Vector2d(x,y),Editor.WIDTH_EDIFICIO1,Editor.HEIGHT_EDIFICIO1,"EDIFICIO1c"));
								break;									
							case "EDIFICIO1d":
								mondo.oggettiFermi.add(new Wall(new Vector2d(x,y),Editor.WIDTH_EDIFICIO1,Editor.HEIGHT_EDIFICIO1,"EDIFICIO1d"));
								break;	
							case "EDIFICIO2a":
								mondo.oggettiFermi.add(new Wall(new Vector2d(x,y),Editor.WIDTH_EDIFICIO2,Editor.HEIGHT_EDIFICIO2,"EDIFICIO2a"));
								break;	
							case "EDIFICIO2b":
								mondo.oggettiFermi.add(new Wall(new Vector2d(x,y),Editor.WIDTH_EDIFICIO2,Editor.HEIGHT_EDIFICIO2,"EDIFICIO2b"));
								break;	
							case "EDIFICIO2c":
								mondo.oggettiFermi.add(new Wall(new Vector2d(x,y),Editor.WIDTH_EDIFICIO2,Editor.HEIGHT_EDIFICIO2,"EDIFICIO2c"));
								break;	
							case "MACCHINA2":
								mondo.oggettiFermi.add(new Wall(new Vector2d(x,y),Editor.WIDTH_MACCHINA2,Editor.HEIGHT_MACCHINA2,"MACCHINA2"));
								break;			
							case "PORTA":
								mondo.porte.add(new Wall(new Vector2d(x,y), Editor.WIDTH_PORTA, Editor.HEIGHT_PORTA,"PORTA"));
								break;
							default:
								break;
							}						
						}
						input.close();
						mondo.init();
						mappa = true;
						if(nome && mappa){
							
							mainFrame.gamePanel.protagonista = name;
							if(mondo.players.containsKey("valoreFittizio")){
								mondo.players.put(name, mondo.players.get("valoreFittizio") );
								mondo.players.remove("valoreFittizio");
								}
							
							conferma.setEnabled(true);
						
							}
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		}
		
	}
		
		else if(e.getActionCommand()=="nome"){
			name = tf.getText();
			nome=true;
			if(nome && mappa){
				if(!name.equals("valoreFittizio")) {
				mainFrame.gamePanel.protagonista = name;
				
				if(mondo.players.containsKey("valoreFittizio")){
					mondo.players.put(name, mondo.players.get("valoreFittizio") );
					mondo.players.remove("valoreFittizio");
					}
				}
				
				conferma.setEnabled(true);
				
				}
		}
		else if(e.getActionCommand()=="CONFERMA") {
			
			if(easy.isSelected())
				mainFrame.mondo.isEasy=true;
			else
				mainFrame.mondo.isEasy=false;
			
			mainFrame.showGame();
		}
		

	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(provider.backgroundMenu,0,0, null);
		g.drawImage(provider.iconaGame,300,10, 100,100, null);
		
	}
	
	
	
};
