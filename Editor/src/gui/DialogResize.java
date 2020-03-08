package gui;


import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;


public class DialogResize extends JDialog implements ActionListener{

private int width;
private int height;

private boolean result;
private JSpinner widthSpinner;
private JSpinner heightSpinner;

private JButton okButton;
private JButton cancelButton;
private boolean chiuso;

	
public DialogResize(int w,int h,int inizial_width,int inizial_height) {
	chiuso=false;
	result=false;
width=inizial_width;
height= inizial_height;
setTitle("RESIZE DELLA MAPPA");

SpinnerModel model1 = new SpinnerNumberModel(width,1,150000,1);
SpinnerModel model2 = new SpinnerNumberModel(height,1,150000,1);

JPanel panel = new JPanel();

panel.setLayout(new FlowLayout());



setLocation(w/2-(this.getSize().width+200),h/2-(this.getSize().height));


panel.add(new JLabel("WIDTH:"));

widthSpinner = new JSpinner(model1);

widthSpinner.setFocusable(true);

panel.add(widthSpinner);

panel.add(new JLabel("HEIGHT:"));


heightSpinner = new JSpinner(model2);

heightSpinner.setFocusable(true);

panel.add(heightSpinner);

okButton = new JButton("OK");

panel.add(okButton);

okButton.addActionListener(this);


cancelButton = new JButton("CANCEL");

panel.add(cancelButton);

cancelButton.addActionListener(this);

this.setFocusable(true);

panel.setVisible(true);
getContentPane().add(panel);

setSize(350,100);
setFocusable(true);
setModal(true);


}	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		setVisible(true);
		if(e.getSource()==okButton){
			width = (int) widthSpinner.getValue();
			height = (int) heightSpinner.getValue();
			result=true;
			chiuso=true;
			dispose();
		}
		
		else if(e.getSource()==cancelButton)
			result=false;
		chiuso=true;
			dispose();
	}

	public int getNwidth() {
		return width;
	}



	public int getNheight() {
		return height;
	}


			
	public boolean getResult(){

		setVisible(true);
		

		return result;
	}

	public boolean chiuso() {
		return chiuso;
	}



	
	

}
