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
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ClientPanel extends JPanel implements ActionListener {

	private JTextField portText;
	private JLabel labelPort;
	private JTextField playerText;
	private JLabel labelPlayer;
	private JTextField ipText;
	private JLabel labelIp;
	private JButton conferma;
	private MainFrame mainFrame;
	private boolean bip;
	private boolean bnome;
	private boolean bporta;
	public String ip;
	public int port;
	public String name;
	private ImageProvider provider;

	public ClientPanel(MainFrame f) {
		super();
		this.mainFrame = f;

		setPreferredSize(new Dimension(700, 400));

		provider = f.provider;

		setLayout(new BorderLayout());

		bnome = false;

		bip = false;

		bporta = false;

		bip = true;

		bporta = true;

		ip = "127.0.0.1";
		port = 8189;

		playerText = new JTextField();

		labelPlayer = new JLabel("NAME PLAYER");
		labelPlayer.setFont(new Font("Serif", Font.PLAIN, 14));
		labelPlayer.setForeground(Color.RED);

		labelPlayer.setLabelFor(playerText);

		portText = new JTextField(5);

		portText.setText("8189");

		labelPort = new JLabel("PORT COMMUNICATION");
		labelPort.setFont(new Font("Serif", Font.PLAIN, 14));
		labelPort.setForeground(Color.RED);

		labelPort.setLabelFor(portText);

		ipText = new JTextField(20);

		ipText.setText("127.0.0.1");

		labelIp = new JLabel("IP SERVER");
		labelIp.setFont(new Font("Serif", Font.PLAIN, 14));
		labelIp.setForeground(Color.RED);

		labelIp.setLabelFor(ipText);

		conferma = new JButton("CONFIRM");

		conferma.setEnabled(false);

		conferma.setActionCommand("partecipa");
		conferma.addActionListener(this);

		playerText.setActionCommand("nome");
		playerText.addActionListener(this);

		portText.setActionCommand("port");
		portText.addActionListener(this);

		ipText.setActionCommand("ip");
		ipText.addActionListener(this);

		JPanel p1 = new JPanel();
		p1.setLayout(new GridBagLayout());

		p1.setOpaque(false);

		GridBagConstraints c = new GridBagConstraints();

		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.0;
		c.gridwidth = 0;
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(0, 30, 0, 0);
		p1.add(labelPlayer, c);
		c.weightx = 0.0;
		c.gridwidth = 0;
		c.gridx = 0;
		c.gridy = 1;
		c.insets = new Insets(10, 30, 0, 0);
		p1.add(playerText, c);

		add(p1, BorderLayout.LINE_START);

		JPanel p2 = new JPanel();

		p2.setOpaque(false);

		p2.setLayout(new GridBagLayout());

		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.0;
		c.gridwidth = 0;
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(0, 0, 0, 0);
		p2.add(labelPort, c);
		c.weightx = 0.0;
		c.gridwidth = 0;
		c.gridx = 0;
		c.gridy = 1;
		c.insets = new Insets(10, 0, 0, 0);
		p2.add(portText, c);

		c.weightx = 0.0;
		c.gridx = 0;
		c.gridy = 2;
		c.insets = new Insets(30, 0, 0, 0);
		p2.add(labelIp, c);

		c.weightx = 0.0;
		c.gridx = 0;
		c.gridy = 3;
		c.insets = new Insets(10, 0, 0, 0);
		p2.add(ipText, c);

		add(p2, BorderLayout.CENTER);

		JPanel p3 = new JPanel();

		p3.setOpaque(false);

		p3.setLayout(new GridBagLayout());

		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.0;
		c.gridwidth = 0;
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(0, 0, 0, 0);
		c.ipadx = 70;

		p3.add(conferma, c);

		add(p3, BorderLayout.LINE_END);

		revalidate();

		conferma.setOpaque(false);
		conferma.setContentAreaFilled(false);
		conferma.setBorderPainted(false);
		conferma.setBorder(null);
		conferma.setForeground(Color.RED);

		portText.setBackground(Color.BLACK);
		portText.setForeground(Color.RED);

		playerText.setBackground(Color.BLACK);
		playerText.setForeground(Color.RED);

		ipText.setBackground(Color.BLACK);
		ipText.setForeground(Color.RED);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand() == "nome") {
			name = playerText.getText();
			bnome = true;
			if (bnome && bporta && bip) {

				mainFrame.gamePanel.protagonista = name;
				conferma.setEnabled(true);

			}
		} else if (e.getActionCommand() == "port") {
			String s = portText.getText();
			port = Integer.parseInt(s);
			bporta = true;
			if (bnome && bporta && bip) {

				mainFrame.gamePanel.protagonista = name;
				conferma.setEnabled(true);

			}
		} else if (e.getActionCommand() == "ip") {
			ip = ipText.getText();
			bip = true;
			if (bnome && bporta && bip) {

				mainFrame.gamePanel.protagonista = name;
				conferma.setEnabled(true);

			}
		} else if (e.getActionCommand() == "partecipa") {

			try {
				connectToServer();
			} catch (UnknownHostException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			conferma.setEnabled(false);
		}

	}

	public void connectToServer() throws UnknownHostException, IOException {
		Socket s = new Socket(ip, port);

		ConnectionManager c = new ConnectionManager(s, name, mainFrame);
		c.setup();
		c.dispatch(name);
		new Thread(c, "CONNECTION MANAGER " + name).start();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(provider.backgroundMenu, 0, 0, null);
		g.drawImage(provider.iconaGame, 300, 10, 100, 100, null);

	}

};