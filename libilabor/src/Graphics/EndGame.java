package Graphics;

import java.awt.*;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class EndGame implements ActionListener {
	private JFrame frame;
	private JButton restart, exit;
	private JLabel title;  
	private JPanel p;
	private Controller.Controller controller;

	public EndGame(Controller.Controller _controller) {
		controller=_controller;
		frame = new JFrame("Game Over");
		frame.setPreferredSize(new Dimension(300, 300));
		
		restart = new JButton();
		restart.setBackground(new Color(69, 143, 152));
		restart.setFont(new Font(Font.MONOSPACED,Font.BOLD,40));
		restart.setText("Restart");
		restart.addActionListener(this);
		
		exit = new JButton();
		exit.setBackground(new Color(69, 143, 152));
		exit.addActionListener(this);
		exit.setFont(new Font(Font.MONOSPACED,Font.BOLD,40));
		exit.setText("Exit");
		
		title = new JLabel("Game Over");
		title.setFont(new Font(Font.MONOSPACED,Font.BOLD,40));
		title.setHorizontalAlignment(JLabel.CENTER);
		
		p= new JPanel();
		p.setLayout(new GridLayout(3,1, 30,30 ));
		p.add(title);
		p.add(restart);
		p.add(exit);
		
		frame.setLayout(new BorderLayout());
		frame.add(p,BorderLayout.CENTER);
		frame.pack();
		frame.setVisible(true);
		Dimension dim= Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width/2-frame.getSize().width/2,dim.height/2-frame.getSize().height/2);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(exit)) {
			System.exit(0);
		}
		if(e.getSource().equals(restart)) {
			frame.dispose();
			controller.dispose();
			controller.newGame();
		}

	}
}
