package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class PanelEditor extends JPanel implements ActionListener {

	private Mediator mediator;
	private JScrollPane p;
	private MapPanel mapPanel;
	private JPanel toolPanel;

	public PanelEditor(Mediator mediator, ImageProvider provider) {
		super();
		this.mediator = mediator;

		setLayout(new BorderLayout());

		toolPanel = new PanelTool(mediator, provider);

		add(toolPanel, BorderLayout.WEST);

		mapPanel = new MapPanel(mediator, provider);

		p = new JScrollPane(mapPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		add(p, BorderLayout.CENTER);
	}

	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);

		mapPanel.setPreferredSize(new Dimension(mediator.editor.width, mediator.editor.height));
		mapPanel.revalidate();
		toolPanel.repaint();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		mapPanel.repaint();
		toolPanel.repaint();

	}

};