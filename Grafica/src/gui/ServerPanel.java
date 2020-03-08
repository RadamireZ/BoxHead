package gui;

import java.awt.BorderLayout;
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
import net.Server;

public class ServerPanel extends JPanel implements ActionListener{

	private JTextField portText;
	private JLabel labelPort;
	private JTextField playerText;
	private JLabel labelPlayer;
	private JTextField numberText;
	private JLabel labelNumber;
	private JButton map;
	private JButton conferma;
	private MainFrame mainFrame;
	private boolean mappa;
	private boolean porta;
	private boolean number;
	private boolean nome;
	private String name;
	private int port;
	private int totaleGiocatori;
	private ImageProvider provider;
	
	private JRadioButton easy;
	private JRadioButton hard;

	
	public ServerPanel(MainFrame f) {
		super();

		this.mainFrame = f;

		name="valoreFittizio";

		setPreferredSize(new Dimension(700,400));
		
		provider = f.provider;
		
		
		setLayout(new BorderLayout());

		mappa=false;
		
		nome=false;
		
//		number=false;
//		
//		porta=false;
		
		number=true;
		
		porta=true;
		
		port=8189;
		totaleGiocatori = 2;
		
		
		playerText = new JTextField();
		
		labelPlayer  = new JLabel("NAME PLAYER");
		labelPlayer.setFont(new Font("Serif", Font.PLAIN, 14));
		labelPlayer.setForeground(Color.RED);
		
		labelPlayer.setLabelFor(playerText);
		
		portText = new JTextField(5);
		
		portText.setText("8189");
		
		labelPort  = new JLabel("PORT NUMBER");
		labelPort.setFont(new Font("Serif", Font.PLAIN, 14));
		labelPort.setForeground(Color.RED);
		
		labelPort.setLabelFor(portText);
		
		numberText = new JTextField(2);
		
		numberText.setText("2");
		
		labelNumber  = new JLabel("NUMERO GIOCATORI");
		labelNumber.setFont(new Font("Serif", Font.PLAIN, 14));
		labelNumber.setForeground(Color.RED);
		
		labelNumber.setLabelFor(numberText);
		
		map = new JButton("SELECT MAP");

		conferma = new JButton("CONFIRM");
		
		conferma.setEnabled(false);
		
		map.addActionListener(this);
		
		map.setActionCommand("mappa");
		
		conferma.setActionCommand("crea");
		conferma.addActionListener(this);
		
		playerText.setActionCommand("nome");
		playerText.addActionListener(this);
		
		portText.setActionCommand("port");
		portText.addActionListener(this);
		
		numberText.setActionCommand("number");
		numberText.addActionListener(this);
		
		JPanel p1 = new JPanel();
		p1.setLayout(new GridBagLayout());
		
		p1.setOpaque(false);
		
		easy = new JRadioButton("EASY");
		hard = new JRadioButton("HARD");
		
		easy.setSelected(true);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(easy);
		bg.add(hard);
		
		
		GridBagConstraints c = new GridBagConstraints();
		
		c.fill=GridBagConstraints.HORIZONTAL;
		c.weightx = 0.0;
		c.gridwidth = 0;
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(0,30,0,0);
		p1.add(labelPlayer,c);     
		c.weightx = 0.0;
		c.gridwidth = 0;
		c.gridx = 0;
		c.gridy = 1;
		c.insets = new Insets(10,30,0,0);
		p1.add(playerText,c);
		
		c.weightx = 0.0;
		c.gridx = 0;
		c.gridy = 2;
		c.insets = new Insets(10,30,0,0);
		p1.add(map,c);
		
		
		add(p1,BorderLayout.LINE_START);
		
		
		JPanel p2 = new JPanel();
		
		p2.setOpaque(false);
		
		p2.setLayout(new GridBagLayout());
		
		
		c.fill=GridBagConstraints.HORIZONTAL;
		c.weightx = 0.0;
		c.gridwidth = 0;
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(0,0,0,0);
		p2.add(labelPort,c);     
		c.weightx = 0.0;
		c.gridwidth = 0;
		c.gridx = 0;
		c.gridy = 1;
		c.insets = new Insets(10,0,0,0);
		p2.add(portText,c);
		
		c.weightx = 0.0;
		c.gridx = 0;
		c.gridy = 2;
		c.insets = new Insets(30,0,0,0);
		p2.add(labelNumber,c);
		
		c.weightx = 0.0;
		c.gridx = 0;
		c.gridy = 3;
		c.insets = new Insets(10,0,0,0);
		p2.add(numberText,c);
		

		add(p2,BorderLayout.CENTER);
		
		JPanel p3 = new JPanel();
		
		p3.setOpaque(false);
		
		p3.setLayout(new GridBagLayout());
		
		

		c.fill=GridBagConstraints.HORIZONTAL;
		c.weightx = 0.0;
		c.gridwidth = 0;
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(0,0,0,0);
		c.ipadx = 70; 
		
		p3.add(easy,c);

		c.fill=GridBagConstraints.HORIZONTAL;
		c.weightx = 0.0;
		c.gridwidth = 0;
		c.gridx = 0;
		c.gridy = 1;
		c.insets = new Insets(0,0,0,0);
		c.ipadx = 70; 
		
		p3.add(hard,c);

		
		c.fill=GridBagConstraints.HORIZONTAL;
		c.weightx = 0.0;
		c.gridwidth = 0;
		c.gridx = 0;
		c.gridy = 2;
		c.insets = new Insets(0,0,0,0);
		c.ipadx = 70; 
		
		p3.add(conferma,c);
		
		add(p3,BorderLayout.LINE_END);
		
		
		revalidate();
		
		map.setOpaque(false);
		map.setContentAreaFilled(false);
		map.setBorderPainted(false);
		map.setBorder(null);	
		map.setForeground(Color.RED);
		
		conferma.setOpaque(false);
		conferma.setContentAreaFilled(false);
		conferma.setBorderPainted(false);
		conferma.setBorder(null);	
		conferma.setForeground(Color.RED);


		portText.setBackground(Color.BLACK);
		portText.setForeground(Color.RED);

		playerText.setBackground(Color.BLACK);
		playerText.setForeground(Color.RED);

		numberText.setBackground(Color.BLACK);
		numberText.setForeground(Color.RED);

		
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
					mainFrame.mondo.clear();
					File f = fc.getSelectedFile();
					Scanner input = null;
					try {
						input= new Scanner(new BufferedReader(new FileReader(f)));
						
						int x=input.nextInt();
						int y=input.nextInt();
						
						mainFrame.mondo.setDimensione(x,y);
						
						String s;
						while( input.hasNext()){
							x=input.nextInt();
							y=input.nextInt();
							s= input.next();
							switch (s) {
							case "PLAYER":
								mainFrame.mondo.players.put(name,(new Player(new Vector2d(x,y),
								Editor.WIDTH_PLAYER,Editor.HEIGHT_PLAYER,270,Editor.SPEED_PLAYER)));
								break;
							case "ARMA1":
								mainFrame.mondo.getPacchi().add(new Pacchetto(new Vector2d(x,y),Editor.WIDTH_PACCHETTO,Editor.HEIGHT_PACCHETTO,Mondo.ARMA1));
								break;
							case "ARMA2":
								mainFrame.mondo.getPacchi().add(new Pacchetto(new Vector2d(x, y),Editor.WIDTH_PACCHETTO,Editor.HEIGHT_PACCHETTO,Mondo.ARMA2));
								break;
							case "ARMA3":
								mainFrame.mondo.getPacchi().add(new Pacchetto(new Vector2d(x, y),Editor.WIDTH_PACCHETTO,Editor.HEIGHT_PACCHETTO,Mondo.ARMA3));
								break;
							case "MUROPERIMETRALEORIZZONTALE":
								mainFrame.mondo.muriPerimetrali.add(new Wall(new Vector2d(x, y),Editor.WIDTH_MURO,Editor.HEIGHT_MURO,"MUROPERIMETRALEORIZZONTALE"));
								break;
							case "MUROPERIMETRALEVERTICALE":
								mainFrame.mondo.muriPerimetrali.add(new Wall(new Vector2d(x, y),Editor.WIDTH_MURO,Editor.HEIGHT_MURO,"MUROPERIMETRALEVERTICALE"));
								break;
							case "AMBULANCE":
								mainFrame.mondo.oggettiFermi.add(new Wall(new Vector2d(x,y),Editor.WIDTH_AMBULANCE,Editor.HEIGHT_AMBULANCE,"AMBULANCE"));
								break;
							case "CAMION":
								mainFrame.mondo.oggettiFermi.add(new Wall(new Vector2d(x,y),Editor.WIDTH_CAMION,Editor.HEIGHT_CAMION,"CAMION"));
								break;
							case "CAMPER":
								mainFrame.mondo.oggettiFermi.add(new Wall(new Vector2d(x,y),Editor.WIDTH_CAMPER,Editor.HEIGHT_CAMPER,"CAMPER"));
								break;
							case "EDIFICIO1a":
								mainFrame.mondo.oggettiFermi.add(new Wall(new Vector2d(x,y),Editor.WIDTH_EDIFICIO1,Editor.HEIGHT_EDIFICIO1,"EDIFICIO1a"));
								break;							
							case "EDIFICIO1b":
								mainFrame.mondo.oggettiFermi.add(new Wall(new Vector2d(x,y),Editor.WIDTH_EDIFICIO1,Editor.HEIGHT_EDIFICIO1,"EDIFICIO1b"));
								break;									
							case "EDIFICIO1c":
								mainFrame.mondo.oggettiFermi.add(new Wall(new Vector2d(x,y),Editor.WIDTH_EDIFICIO1,Editor.HEIGHT_EDIFICIO1,"EDIFICIO1c"));
								break;									
							case "EDIFICIO1d":
								mainFrame.mondo.oggettiFermi.add(new Wall(new Vector2d(x,y),Editor.WIDTH_EDIFICIO1,Editor.HEIGHT_EDIFICIO1,"EDIFICIO1d"));
								break;	
							case "EDIFICIO2a":
								mainFrame.mondo.oggettiFermi.add(new Wall(new Vector2d(x,y),Editor.WIDTH_EDIFICIO2,Editor.HEIGHT_EDIFICIO2,"EDIFICIO2a"));
								break;	
							case "EDIFICIO2b":
								mainFrame.mondo.oggettiFermi.add(new Wall(new Vector2d(x,y),Editor.WIDTH_EDIFICIO2,Editor.HEIGHT_EDIFICIO2,"EDIFICIO2b"));
								break;	
							case "EDIFICIO2c":
								mainFrame.mondo.oggettiFermi.add(new Wall(new Vector2d(x,y),Editor.WIDTH_EDIFICIO2,Editor.HEIGHT_EDIFICIO2,"EDIFICIO2c"));
								break;	
							case "MACCHINA2":
								mainFrame.mondo.oggettiFermi.add(new Wall(new Vector2d(x,y),Editor.WIDTH_MACCHINA2,Editor.HEIGHT_MACCHINA2,"MACCHINA2"));
								break;			
							case "PORTA":
								mainFrame.mondo.porte.add(new Wall(new Vector2d(x,y), Editor.WIDTH_PORTA, Editor.HEIGHT_PORTA,"PORTA"));
								break;
							default:
								break;
							}						
						}
						input.close();
						mainFrame.mondo.init();
						mappa = true;
						if(nome && mappa && porta && number){
							
							
							if(!name.equals("valoreFittizio")) {
								mainFrame.gamePanel.protagonista = name;
								
								if(mainFrame.mondo.players.containsKey("valoreFittizio")){
									mainFrame.mondo.players.put(name, mainFrame.mondo.players.get("valoreFittizio") );
									mainFrame.mondo.players.remove("valoreFittizio");
									}
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
			name = playerText.getText();
			nome=true;
			if(nome && mappa && porta && number){
				
				mainFrame.gamePanel.protagonista = name;
				conferma.setEnabled(true);
				
				}
		}
		else if(e.getActionCommand()=="port"){
			String s = portText.getText();
			port = Integer.parseInt(s);
			porta=true;
			if(nome && mappa && porta && number){
				
				mainFrame.gamePanel.protagonista = name;
				conferma.setEnabled(true);
				
				}
		}	
		else if(e.getActionCommand()=="number"){
			String s = numberText.getText();
			totaleGiocatori = Integer.parseInt(s);
			number=true;
			if(nome && mappa && porta && number){
				
				mainFrame.gamePanel.protagonista = name;
				conferma.setEnabled(true);
				
				}
		}
		else if(e.getActionCommand()=="crea"){
			mainFrame.mondo.isEasy = easy.isSelected();

			Server s = new Server(port, totaleGiocatori, mainFrame.mondo);
			try {
				
				mainFrame.clientPanel.ip = "127.0.0.1";
				mainFrame.clientPanel.name = name;
				mainFrame.clientPanel.port = port;
				
				new Thread(s,"SERVER").start();

				mainFrame.clientPanel.connectToServer();
				

			} catch (IOException e1) {
				e1.printStackTrace();
			}
			conferma.setEnabled(false);
		}
		

	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(provider.backgroundMenu,0,0, null);
		g.drawImage(provider.iconaGame,300,10, 100,100, null);
		
	}
	
	
	

}
