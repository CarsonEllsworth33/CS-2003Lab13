package button;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class ButtonFrame extends JFrame {
	private JPanel buttonPanel;
	private ColorAction changeColor;
	private ResetAction resetColor;
	private CloseAction closer;
	private JTextArea numtext;
	private static final int DEFAULT_WIDTH = 300;
	
	private static final int DEFAULT_HEIGHT = 200;
	
	public ButtonFrame() {
		setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
		
		//create buttons
		JButton resetButton = new JButton("Reset");
		JButton changeButton = new JButton("Change");
		JButton closeButton = new JButton("Close");
		numtext = new JTextArea();
		numtext.setText("0");
		numtext.setBackground(Color.BLACK);
		
		buttonPanel = new JPanel();
		
		//add buttons to panel
		buttonPanel.add(resetButton);
		buttonPanel.add(changeButton);
		buttonPanel.add(closeButton);
		buttonPanel.add(numtext);
		
		//add panel to frame
		this.add(buttonPanel);
		
		//create button actions
		
		changeColor = new ColorAction(Color.BLACK);//temp need to change
		resetColor = new ResetAction();
		closer = new CloseAction();
		//associate actions with buttons
		resetButton.addActionListener(resetColor);
		changeButton.addActionListener(changeColor);
		closeButton.addActionListener(closer);	
	}
	
	/* An action listener that sets the panel's background color */
	private class ColorAction implements ActionListener
	{
		private int numClicks;
		private Color[] colorArray = {Color.BLACK,Color.GREEN,Color.ORANGE,Color.PINK};
		public ColorAction(Color c)
		{
			buttonPanel.setBackground(c);
		}
		
		public void actionPerformed(ActionEvent event)
		{
			numClicks++;
			numClicks = numClicks%4;
			buttonPanel.setBackground(colorArray[numClicks]);
			numtext.setText(String.format("%d", numClicks));
			numtext.setBackground(colorArray[numClicks]);
		}
		private void reset() {
			numClicks = 0;
			buttonPanel.setBackground(colorArray[numClicks]);
			numtext.setText(String.format("%d", numClicks));
			numtext.setBackground(colorArray[numClicks]);
		}
	}
	
	private class ResetAction implements ActionListener
	{
		public ResetAction() {
			
		}
		public void actionPerformed(ActionEvent arg0) {
			changeColor.reset();
		}
		
	}
	private class CloseAction implements ActionListener
	{	
		public CloseAction() {
			
		}
		public void actionPerformed(ActionEvent arg0) {
			System.exit(0);
		}
		
	}
	
	
}
