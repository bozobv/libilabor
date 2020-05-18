package Graphics;
import Controller.*;
import Modell.*;

import javax.swing.*;

import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GameArea implements ActionListener
{
	private JFrame frame = new JFrame("jatszas");
	private JMenuBar menuBar = new JMenuBar();
	private JMenu menu = new JMenu("Menu");
	private JMenuItem saveItem = new JMenuItem("Save");
	private JMenuItem quitItem = new JMenuItem("Quit");
	private Container grid = new Container();
	private JButton move = new JButton("Move");
	private JButton dig = new JButton("Dig");
	private JButton skill = new JButton("Skill");
	private JButton pickUp = new JButton("Pick up");
	private JButton endTurn = new JButton("End turn");
	private JLabel thp = new JLabel("THP:");
	private JLabel work = new JLabel("Work:");
	private JButton flare = new JButton();
	private JLabel shovel = new JLabel();
	private JButton rope = new JButton();
	private JButton tent = new JButton();
	private JLabel scuba = new JLabel();
	private JLabel name = new JLabel("Lakatos Dzsesszpero");
	private JPanel panel = new JPanel();
	private Container map = new Container();
	private JButton[][] icetables;


	public GameArea(Map m){
		frame.setSize(new Dimension(1360,768));
		frame.setLayout(new BorderLayout());
		frame.getContentPane().setBackground(new Color(28,102,222));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setJMenuBar(menuBar);
        JPanel panelka=new JPanel();
        panelka.setLayout(new BoxLayout(panelka,BoxLayout.X_AXIS));
        panelka.add(Box.createRigidArea(new Dimension(40,0)));
        panel.add(grid);
        panelka.add(panel);
        frame.add(panelka, BorderLayout.LINE_END);
        panelka.setBackground(new Color(28,102,222));
		panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
		panel.setBackground(new Color(28,102,222));
		grid.setLayout(new GridLayout(6,2,10,10));
		menu.add(saveItem);
		menu.add(quitItem);
		menuBar.add(menu);
		frame.add(map);
	    panel.add(name);
	    panel.add(Box.createRigidArea(new Dimension(0,10)));
	    
	    
		//maga a map (en?)
        icetables = new JButton[m.getHeight()][m.getWidth()];
        map.setLayout(new GridLayout(m.getHeight(),m.getWidth(),30,30));
        
        String field = "";
        try 
        {
            File myObj = new File("kirajz");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) 
            {
              String data = myReader.nextLine();
              field += data;
              System.out.println(data);
            }
            myReader.close();
         }        
        catch (FileNotFoundException e) 
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        
        //PALYAELEMEK KIRAJZOLASA
        //soronkent toltodik, balrol jobbra
        for (int i = 0;i < m.getHeight(); i++)
        {
            for (int j = 0;j < m.getWidth(); j++)
            {
            	if (field.charAt(i * m.getWidth() + j )  == '1')
            	{
            		JButton b = new JButton();
            		b.setBackground(new Color(255,255,255));
            		map.add(b);
                    System.out.println("b");
            	}
            	else
            	{
            		JLabel l = new JLabel();
            		l.setBackground(Color.blue);
            		map.add(l);
                    System.out.println("l");
            	}
            }

        }
        
       
       //NEV JOBB FELUL
        name.setFont(new Font(Font.MONOSPACED,Font.BOLD,20));
        name.setSize(new Dimension(200,40));
        name.setAlignmentX(Component.CENTER_ALIGNMENT);
        name.setOpaque(true);
        name.setBackground(new Color(179,228,233));

        
        //GOMBOK JOBB OLDALT
        //--------------------------------------------------------------
		grid.add(thp);
		grid.add(work);
		//-----
        thp.setPreferredSize(new Dimension(100,100));
        thp.setFont(new Font(Font.MONOSPACED,Font.BOLD,20));
        thp.setOpaque(true);
        thp.setBackground(new Color(179,228,233));
        work.setFont(new Font(Font.MONOSPACED,Font.BOLD,20));
        work.setOpaque(true);
        work.setBackground(new Color(179,228,233));
        //-----

        grid.add(move);
        grid.add(flare);
        //-----
        move.setBackground(new Color(69, 143, 152));
        move.setFont(new Font(Font.MONOSPACED,Font.BOLD,20));
        flare.setBackground(new Color(179,228,233));
        //-----
        grid.add(dig);
        grid.add(shovel);
        //-----
        dig.setBackground(new Color(69, 143, 152));
        dig.setFont(new Font(Font.MONOSPACED,Font.BOLD,20));
        shovel.setOpaque(true);
        shovel.setBackground(new Color(179,228,233));
        //-----
        grid.add(skill);
        grid.add(rope);
        //-----
        skill.setBackground(new Color(69, 143, 152));
        skill.setFont(new Font(Font.MONOSPACED,Font.BOLD,20));
        rope.setBackground(new Color(179,228,233));
        //-----
        grid.add(pickUp);
        grid.add(tent);
        //-----
        pickUp.setBackground(new Color(69, 143, 152));
        pickUp.setFont(new Font(Font.MONOSPACED,Font.BOLD,20));
        tent.setBackground(new Color(179,228,233));
        //-----
        grid.add(endTurn);
        grid.add(scuba);
        //-----
        endTurn.setBackground(new Color(69, 143, 152));
        endTurn.setFont(new Font(Font.MONOSPACED,Font.BOLD,20));
        scuba.setOpaque(true);
        scuba.setBackground(new Color(179,228,233));
        //-----
        saveItem.addActionListener(this);
        quitItem.addActionListener(this);
        //--------------------------------------------------------------------

	}
	
	public void clearMapView() {
		for (JButton[] jButton : icetables) {
			for (JButton jButton2 : jButton) {
				jButton2.setBackground(new Color(255,255,255));
			}
		}
		
		name.setBackground(new Color(179,228,233));
		name.setText("");
		
		flare.setBackground(new Color(179,228,233));
		shovel.setBackground(new Color(179,228,233));
	 	rope.setBackground(new Color(179,228,233));
		tent.setBackground(new Color(179,228,233));
		scuba.setBackground(new Color(179,228,233));
	}
	
	
	
	public void refresh(IModell modell) {
		this.clearMapView();
		
		//ide kene az ujrarajzolas 0-rol
		
		
	}

	
	
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource().equals(quitItem)){
            System.exit(0);
        }
    }
}
