package Graphics;
import Controller.Controller;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu  implements ActionListener {
	/**
	 * a menuelemeket tartalmazo kontener
	 */
	private Container container;
	/**
	 * Az uj jatek, jatek betoltese es kilepes gombok a menuben
	 */
	private JButton newGame, loadGame, exit;
	/**
	 * A Menu ablak
	 */
	private JFrame frame=new JFrame("Welcome to Eskibros game!");
	/**
	 * A Controller amely a nezetet kezeli
	 */
	private Controller controller;
	
	/**
	 * A menu konstruktora, amely a kinezetet osszerakja es inicializalja a valtozokat
	 * @param _controller a controller amely ot kezeli
	 */
	public Menu(Controller _controller)
	{
	    controller=_controller;
		frame.setPreferredSize(new Dimension(500,500));
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
			newGame.setFont(new Font(Font.MONOSPACED,Font.BOLD,40));
      		newGame.setPreferredSize(new Dimension(100,50));
      		newGame.setBackground(new Color(69, 143, 152));
      		newGame.addActionListener(this);
      		panel.add(newGame, c);
        
      //Load Game Button
      		loadGame=new JButton("Load Game");
      		loadGame.setFont(new Font(Font.MONOSPACED,Font.BOLD,40));
      		loadGame.setPreferredSize(new Dimension(100,50));
      		loadGame.setBackground(new Color(69, 143, 152));
      		loadGame.addActionListener(this);
      		panel.add(loadGame, c);
        
        
        
      //Exit Button
      		exit=new JButton("Exit");
      		exit.setFont(new Font(Font.MONOSPACED,Font.BOLD,40));
      		exit.setPreferredSize(new Dimension(100,50));
      		exit.setBackground(new Color(69, 143, 152));
      		exit.addActionListener(this);
        panel.add(exit, c);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
        frame.getContentPane().setBackground(new Color(179, 228, 233));
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setResizable(false);
	}
	
	/**
	 * A menu gombjaihoz rendelt action listener, hogy a kattintásukat le lehessen kezelni
	 */
	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		if(actionEvent.getSource().equals(exit)){
			frame.dispose();
		}
		else if(actionEvent.getSource().equals(newGame)){

			controller.newGame();
			
			//kisbirtok nagybirtok ciganyokkal nem birtok
			frame.dispose();
		}
		else if(actionEvent.getSource().equals(loadGame))
		{
			controller.loadGame();
			
		}

	}
}
