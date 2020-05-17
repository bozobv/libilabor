package Graphics;
import javax.swing.*;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Menu extends JFrame implements MouseListener{
	private Container container;
	private JButton newGame, loadGame, exit;
	public Menu() {
		//Frame
		super("Welecome to Eskibros game!");			
		JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.weightx = 1;
        c.weighty = .25;
        c.insets = new Insets(5, 0, 5, 0);
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.fill = GridBagConstraints.BOTH;
        
        
      //New Game Button
      		newGame=new JButton("New Game");
      		newGame.setPreferredSize(new Dimension(100,50));
      		newGame.setBackground(new Color(69, 143, 152));
      		this.addMouseListener(this);
      		panel.add(newGame, c);
        
      //Load Game Button
      		loadGame=new JButton("Load Game");
      		loadGame.setPreferredSize(new Dimension(100,50));
      		loadGame.setBackground(new Color(69, 143, 152));
      		this.addMouseListener(this);
      		panel.add(loadGame, c);
        
        
        
      //Exit Button
      		exit=new JButton("Exit");
      		exit.setPreferredSize(new Dimension(100,50));
      		exit.setBackground(new Color(69, 143, 152));
      		this.addMouseListener(this);
        panel.add(exit, c);
        this.add(panel);
        this.pack();
        this.setVisible(true);
        this.getContentPane().setBackground(new Color(179, 228, 233));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		if (SwingUtilities.isLeftMouseButton((MouseEvent) e)) {
			if (e.getSource() == newGame) {
				//TODO new game gombra lett kattintva
				
			} else if (e.getSource() == loadGame) {
				//TODO load game gombra lett kattintva
				
			} else if (e.getSource() == exit) {
				//nem m�k�dik ez a szar
				this.dispose();
			}
		}
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}

