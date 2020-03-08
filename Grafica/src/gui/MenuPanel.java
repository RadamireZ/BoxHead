package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;


public class MenuPanel extends JPanel implements ActionListener{

	private PanelSwitcher switcher;
	
	private JButton singlePlayer;
	private JButton multiplayer;
	private JButton editor;
	private JButton ranking;
	
	private ImageProvider provider;
	
	
	
	public MenuPanel(MainFrame f) {
		super();
		this.switcher = f;
		this.provider = f.provider;
		setPreferredSize(new Dimension(700, 400));
		
		
		this.setLayout( new GridBagLayout());
	    
		GridBagConstraints c = new GridBagConstraints();
		
		singlePlayer = new JButton("SINGLE-PLAYER");
		multiplayer  = new JButton("MULTI-PLAYER");	
		editor = new JButton("EDITOR");
		ranking = new JButton("RANKING");


		
		singlePlayer.setOpaque(false);
		singlePlayer.setContentAreaFilled(false);
		singlePlayer.setBorderPainted(false);
		singlePlayer.setBorder(null);
		singlePlayer.setFocusPainted(false);
		singlePlayer.setForeground(Color.RED);
		
		multiplayer.setOpaque(false);
		multiplayer.setContentAreaFilled(false);
		multiplayer.setBorderPainted(false);
		multiplayer.setBorder(null);	
		multiplayer.setFocusPainted(false);		
		multiplayer.setForeground(Color.RED);
		
		editor.setOpaque(false);
		editor.setContentAreaFilled(false);
		editor.setBorderPainted(false);
		editor.setBorder(null);	
		editor.setFocusPainted(false);
		editor.setForeground(Color.RED);
		
		ranking.setOpaque(false);
		ranking.setContentAreaFilled(false);
		ranking.setBorderPainted(false);
		ranking.setBorder(null);	
		ranking.setForeground(Color.RED);
		ranking.setFocusPainted(false);
		
		c.fill=GridBagConstraints.HORIZONTAL;
		c.weightx = 0.0;
		c.gridwidth = 0;
		c.gridx = 1;
		c.gridy = 0;
		add(singlePlayer,c);
        
		c.weightx = 0.0;
		c.gridx = 1;
		c.gridy = 1;
		c.insets = new Insets(10,0,0,0);
		add(multiplayer,c);
		
		
		c.weightx = 0.0;
		c.gridx = 1;
		c.insets = new Insets(10,0,0,0);
		c.gridy = 2;
		add(editor,c);
		
		
		c.weightx = 0.0;
		c.gridx = 1;
		c.insets = new Insets(10,0,0,0);
		c.gridy = 3;
		add(ranking,c);
		

        
        editor.addActionListener(this);
        editor.setActionCommand("edit");
        

        ranking.addActionListener(this);
        ranking.setActionCommand("rank");
        
        
        singlePlayer.addActionListener(this);
        singlePlayer.setActionCommand("set");
        

        multiplayer.addActionListener(this);
        multiplayer.setActionCommand("multi");
        

		}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		if( e.getActionCommand()=="set" ){
			switcher.showSetting();
			}
		else if( e.getActionCommand()=="edit"){
			new FrameEditor(provider,switcher);
		}
		else if( e.getActionCommand()=="rank")
				switcher.showRanking();
		else if( e.getActionCommand()=="multi")
			switcher.showMenuConnection();
		}

	
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(provider.backgroundMenu,0,0, null);
		g.drawImage(provider.iconaGame,300,10, 100,100, null);
	}
	
}
