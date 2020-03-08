package gui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


import logic.Mondo;

public class MainFrame extends JFrame implements PanelSwitcher,WindowListener{
	
	public Mondo mondo;
	public CameraPanel gamePanel;
	private final JPanel container = new JPanel();
	private final MenuPanel menuPanel;
	private final LoadPanel loadPanel;
	private final RankPanel rankPanel;
	private final MenuConnectionPanel menuconnectionPanel;
	private final ServerPanel serverPanel;
	public ClientPanel clientPanel;

	private final SettingPanel settingPanel;
	public ImageProvider provider;
	
	
	public MainFrame() {
		
		super();
		Dimension thisScreen = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(thisScreen.width/8 , thisScreen.height/2-300);

		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		mondo = new Mondo();
		
		provider = new ImageProvider();
		rankPanel = new RankPanel(this);
		menuPanel = new MenuPanel(this);
		loadPanel = new LoadPanel(this,provider);
		serverPanel = new ServerPanel(this);
		clientPanel = new ClientPanel(this);

		menuconnectionPanel = new MenuConnectionPanel(this);
		
		setContentPane(container);
		

		gamePanel = new CameraPanel();
		setResizable(false);

	    addWindowListener( this );

		setVisible(true);
		settingPanel = new SettingPanel(this);

		
	}
	
	

	@Override
	public void setVisible(final boolean b) {
		if(b){
		super.setVisible(b);
		showLoad();
		}
	}

	@Override
	public void showGame() {
		gamePanel.start(this);
		switchTo( gamePanel);
	}
	
	@Override
	public void showGameNetwork() {
		gamePanel.startNetwork(this);
		switchTo( gamePanel);
	}

	@Override
	public void showMenu() {
		switchTo(menuPanel);
	}



	private void switchTo(final JPanel component) {
		container.removeAll();
		container.add(component);
		container.updateUI();
		component.requestFocus();
		pack();
		setLocationRelativeTo(null);
		if(component instanceof SettingPanel)
			settingPanel.tf.requestFocus();
		
	}


	
	@Override
	public void showLoad() {
		switchTo(loadPanel);
		
	}



	@Override
	public void showSetting() {

		switchTo(settingPanel);
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		gamePanel.resumeGame();
	}



	@Override
	public void windowClosing(WindowEvent arg0) {
		showExitConfirm();
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		gamePanel.pauseGame();
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		gamePanel.resumeGame();
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		gamePanel.pauseGame();
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// NOTHING	
	}
	
	@Override
	public void windowClosed(WindowEvent arg0) {
		//NOTHING
	}
	
	private void showExitConfirm() {
		gamePanel.pauseGame();
		int option = JOptionPane.showConfirmDialog(MainFrame.this,
				"Do you really want to exit?", "Exit",
				JOptionPane.YES_NO_OPTION);
		if (option == JOptionPane.YES_OPTION) {
			gamePanel.stopGame();
			System.exit(0);
		}
	}

	@Override
	public void showRanking() {
		switchTo(rankPanel);
	}
	

	@Override
	public void showMenuConnection() {
		switchTo(menuconnectionPanel);
	}

	@Override
	public void showServer() {
		switchTo(serverPanel);
	}

	@Override
	public void showClient() {
		switchTo(clientPanel);
	}
	
	
	
	public static void main(final String[] args) {
		new MainFrame();

	}
}
