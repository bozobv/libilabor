package Graphics;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.*;

public class EndGame {
	private JFrame frame;
	private JLabel iras;
	public EndGame() {
		
		
		
		
		frame=new JFrame("Eskibros");
		frame.setPreferredSize(new Dimension(500,500));
		frame.pack();
	    frame.setVisible(true);
	    frame.getContentPane().setBackground(new Color(179, 228, 233));
	    frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
	    frame.setResizable(false);
	}
}
