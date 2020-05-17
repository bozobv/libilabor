package Graphics;
import Controller.*;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class GameArea 
{
	private JFrame frame=new JFrame("jatszas");
	private JMenuBar menuBar=new JMenuBar();
	private JMenu menu=new JMenu("Menu");
	private JMenuItem saveItem=new JMenuItem("Save");
	private JMenuItem quitItem=new JMenuItem("Quit");
	private Container grid = new Container();
	private JButton move=new JButton();
	private JButton dig=new JButton();
	private JButton skill=new JButton();
	private JButton pickUp=new JButton();
	private JButton endTurn=new JButton();
	private JLabel thp=new JLabel();
	private JLabel work=new JLabel();
	private JLabel flare=new JLabel();
	private JLabel shovel=new JLabel();
	private JLabel rope=new JLabel();
	private JLabel tent=new JLabel();
	private JLabel scuba=new JLabel();


	public GameArea(){
		frame.setSize(new Dimension(800,800));
		frame.setLayout(new BorderLayout());
		grid.setLayout(new GridLayout(5,2,10,10));
		menu.add(saveItem);
		menu.add(quitItem);
		menuBar.add(menu);
		frame.setJMenuBar(menuBar);
		grid.add(move);
		grid.add(dig);
		grid.add(skill);
		grid.add(pickUp);
		grid.add(endTurn);
		frame.add(grid, BorderLayout.LINE_END);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false);

	}
	public void refresh(IModell modell) {
		
	}
}
