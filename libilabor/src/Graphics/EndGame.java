package Graphics;
import java.awt.Color;
import java.awt.Dimension;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class EndGame implements ActionListener
{
	private JFrame frame  = new JFrame("Game Over");
	private Container things = new Container();
	private JButton restart = new JButton();
	private JButton exit = new JButton();
	private JLabel title = new JLabel();
	void initialize()
	{
		frame.setSize(new Dimension(300,300));
		restart.setText("Restart");
		exit.setText("Exit");
		things.add(title);
		things.add(restart);
		things.add(exit);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	if(e.getSource().equals(exit)) {		
		frame.dispose();
	}
	}
}
		