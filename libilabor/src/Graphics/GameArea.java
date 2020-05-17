package Graphics;
import Controller.*;

import javax.swing.*;

import java.awt.*;

public class GameArea 
{
	private JFrame frame=new JFrame("játszás");
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

	public GameArea(){
		frame.setPreferredSize(new Dimension(1920,1080));
		frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		grid.setLayout(new GridLayout(5,5));
		menu.add(saveItem);
		menu.add(quitItem);
		menuBar.add(menu);
		grid.add(move);
		grid.add(dig);
		grid.add(skill);
		grid.add(pickUp);
		grid.add(endTurn);

	}
	public void refresh(IModell modell) {
		
	}
}
