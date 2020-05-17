package Graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class EndGame implements ActionListener {
	private JFrame frame;
	private JButton restart, exit;
	private JLabel title;  
	private JPanel p;

	public EndGame() {
		frame = new JFrame("Game Over");
		frame.setPreferredSize(new Dimension(300, 300));
		
		restart = new JButton();
		restart.setBackground(new Color(69, 143, 152));
		restart.setFont(new Font(Font.MONOSPACED,Font.BOLD,40));
		restart.setText("Restart");
		
		exit = new JButton();
		exit.setBackground(new Color(69, 143, 152));
		exit.addActionListener(this);
		exit.setFont(new Font(Font.MONOSPACED,Font.BOLD,40));
		exit.setText("Exit");
		
		title = new JLabel("Game Over");
		title.setFont(new Font(Font.MONOSPACED,Font.BOLD,40));
		title.setHorizontalAlignment(JLabel.CENTER);
		
		p= new JPanel();
		p.setLayout(new GridLayout(3,1));
		p.add(title);
		p.add(restart);
		p.add(exit);
		
		frame.setLayout(new BorderLayout());
		frame.add(p,BorderLayout.CENTER);
		frame.pack();
		frame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(exit)) {
			frame.dispose();
		}
		if(e.getSource().equals(restart)) {
			
		}

	}
}
