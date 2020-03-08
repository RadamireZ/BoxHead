package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.sql.*;



public class RankPanel extends JPanel implements ActionListener{
	
	private static class ScoreEntry {
		private final String nome;
		private final BigDecimal score;

		public ScoreEntry(String nome, BigDecimal punti) {
			this.nome = nome;
			this.score = punti;
			}


		@Override
		public String toString() {
			return nome + " " + score ;
		}
	}
	

	private ArrayList<ScoreEntry> scoreboard = new ArrayList<>();
	private JButton closeButton;
	private JButton searchButton;
	private JDialog result;
	private PanelSwitcher switcher;
	private ImageProvider provider;
	
	
	public static final String DB_URL = "jdbc:mysql://localhost/ranking";
	public static final String USER = "root";
	public static final String PASS = "password";
	   
	
	
	public RankPanel(MainFrame f) {
		super();
		this.switcher = f;
		this.provider = f.provider;
		
		setLayout(new GridBagLayout());

		GridBagConstraints c = new GridBagConstraints();
		
		setPreferredSize(new Dimension(700, 400));
		
	searchButton = new JButton("SHOW");
	closeButton = new JButton("INDIETRO");

	result = new JDialog();
	
	this.add(searchButton);
	this.add(closeButton);
	
	JButton closeDialog  = new JButton("close");
	result.setTitle("Scoreboard");
	result.pack();
	
	
	closeDialog.addActionListener( e -> result.dispose() );

	
	searchButton.setActionCommand("search");
	searchButton.addActionListener(this);
	

	closeButton.addActionListener( e -> switcher.showMenu() );
	
	searchButton.setOpaque(false);
	searchButton.setContentAreaFilled(false);
	searchButton.setBorderPainted(false);
	searchButton.setBorder(null);	
	searchButton.setForeground(Color.RED);
	
	closeButton.setOpaque(false);
	closeButton.setContentAreaFilled(false);
	closeButton.setBorderPainted(false);
	closeButton.setBorder(null);	
	closeButton.setForeground(Color.RED);
	
	c.fill=GridBagConstraints.HORIZONTAL;
	c.weightx = 0.0;
	c.gridwidth = 0;
	c.gridx = 1;
	c.gridy = 0;
	add(searchButton,c);
    
	c.weightx = 0.0;
	c.gridx = 1;
	c.gridy = 1;
	c.insets = new Insets(10,0,0,0);
	add(closeButton,c);
	
	this.setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		scoreboard.clear();
		
		if(e.getActionCommand()=="search") {
			Connection conn = null;
			Statement stmt = null;
			   try{
				  Class.forName("com.mysql.jdbc.Driver");

			      conn = DriverManager.getConnection(DB_URL,USER,PASS);

			      stmt = conn.createStatement();
			      String sql;
			 
			      sql = "SELECT * "
			      		+ "FROM Punteggio "
			      		+ "order by punti desc ";
			
			      
			      ResultSet rs = stmt.executeQuery(sql);
			      
			      while(rs.next()){

			         String name = rs.getString("nome");
			         BigDecimal punti = rs.getBigDecimal("punti");
			         
			         scoreboard.add(new ScoreEntry( name, punti));

			         System.out.print("NOME: " + name);
			         System.out.println(", punti: " + punti);
			      }
			      rs.close();
			      stmt.close();
			      conn.close();
			   }catch(SQLException se){
			      //Handle errors for JDBC
			      se.printStackTrace();
			   }catch(Exception e1){
			      //Handle errors for Class.forName
			      e1.printStackTrace();
			   }finally{
			      //finally block used to close resources
			      try{
			         if(stmt!=null)
			            stmt.close();
			      }catch(SQLException se2){
			      }// nothing we can do
			      try{
			         if(conn!=null)
			            conn.close();
			      }catch(SQLException se){
			         se.printStackTrace();
			      }//end finally try
			   }//end try

				JPanel panel = new JPanel(new GridLayout(scoreboard.size()+1, 0));
				int i=1;
				for (ScoreEntry scoreEntry : scoreboard) {
					panel.add(new JLabel(i+scoreEntry.toString()));
					i++;
				}
				result.setTitle("Scoreboard");
				result.setContentPane(panel);
				result.pack();
				result.setLocationRelativeTo(this);

				result.setVisible(true);
		}
		
	}
	
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(provider.backgroundMenu,0,0, null);
		g.drawImage(provider.iconaGame,300,10, 100,100, null);
	}
	
	
}
