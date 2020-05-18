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

public class GameArea implements ActionListener {
	private String name, thp, work;
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
	private JLabel lthp = new JLabel("thp: " + thp);
	private JLabel lwork = new JLabel("work:" + work);
	private JButton flare = new JButton();
	private JLabel shovel = new JLabel();
	private JButton rope = new JButton();
	private JButton tent = new JButton();
	private JLabel scuba = new JLabel();
	private JLabel lname = new JLabel("Name: " + name);
	private JPanel panel = new JPanel();
	private Container map = new Container();
	private Map m;
	// private JButton[][] icetables;

	private JPanel[][] icetables;
	String field;

	public GameArea(Map _m) {
		m=_m;
		frame.setSize(new Dimension(1600, 900));
		frame.setLayout(new BorderLayout());
		frame.getContentPane().setBackground(new Color(28, 102, 222));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setJMenuBar(menuBar);
		JPanel panelka = new JPanel();
		panelka.setLayout(new BoxLayout(panelka, BoxLayout.X_AXIS));
		panelka.add(Box.createRigidArea(new Dimension(40, 0)));
		panel.add(grid);
		panelka.add(panel);
		frame.add(panelka, BorderLayout.LINE_END);
		panelka.setBackground(new Color(28, 102, 222));
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBackground(new Color(28, 102, 222));
		grid.setLayout(new GridLayout(6, 2, 10, 10));
		menu.add(saveItem);
		menu.add(quitItem);
		menuBar.add(menu);
		frame.add(map);
		panel.add(lname);
		panel.add(Box.createRigidArea(new Dimension(0, 10)));

		// maga a map (en?)
		icetables = new JPanel[m.getHeight()][m.getWidth()];
		map.setLayout(new GridLayout(m.getHeight(), m.getWidth(), 30, 30));

		field = "";
		try {
			File myObj = new File("kirajz");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				field += data;
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		// PALYAELEMEK KIRAJZOLASA
		// soronkent toltodik, balrol jobbra
		for (int i = 0; i < m.getHeight(); i++) {
			for (int j = 0; j < m.getWidth(); j++) {
				if (field.charAt(i * m.getWidth() + j) == '1') {
					/*
					 * JButton b = new JButton(); b.setBackground(new Color(255,255,255));
					 * map.add(b); System.out.println("b");
					 */
					JPanel panelka2 = new JPanel();
					panelka2.setLayout(new GridLayout(3, 3));
					JButton buttons[] = new JButton[9];
					for (int k = 0; k < 9; k++) {
						buttons[k] = new JButton();
						buttons[k].setBackground(Color.WHITE);
						panelka2.add(buttons[k]);
					}
					map.add(panelka2);
					icetables[i][j] = panelka2;
					panelka2.setVisible(true);
				} else {
					icetables[i][j] = null;
					JLabel l = new JLabel();
					l.setBackground(Color.blue);
					map.add(l);
				}
			}

		}

		// NEV JOBB FELUL
		lname.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
		lname.setSize(new Dimension(200, 40));
		lname.setAlignmentX(Component.CENTER_ALIGNMENT);
		lname.setOpaque(true);
		lname.setBackground(new Color(179, 228, 233));

		// GOMBOK JOBB OLDALT
		// --------------------------------------------------------------
		grid.add(lthp);
		grid.add(lwork);
		// -----
		lthp.setPreferredSize(new Dimension(100, 100));
		lthp.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
		lthp.setOpaque(true);
		lthp.setBackground(new Color(179, 228, 233));
		lwork.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
		lwork.setOpaque(true);
		lwork.setBackground(new Color(179, 228, 233));

		// -----
		move.setBackground(new Color(69, 143, 152));
		move.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
		move.addActionListener(this);
		flare.setBackground(new Color(179, 228, 233));
		// -----
		grid.add(move);
		grid.add(flare);
		// -----
		grid.add(dig);
		grid.add(shovel);
		// -----
		dig.setBackground(new Color(69, 143, 152));
		dig.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
		dig.addActionListener(this);
		shovel.setOpaque(true);
		shovel.setBackground(new Color(179, 228, 233));
		// -----
		grid.add(skill);
		grid.add(rope);
		// -----
		skill.setBackground(new Color(69, 143, 152));
		skill.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
		skill.addActionListener(this);
		rope.setBackground(new Color(179, 228, 233));
		// -----
		grid.add(pickUp);
		grid.add(tent);
		// -----
		pickUp.setBackground(new Color(69, 143, 152));
		pickUp.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
		pickUp.addActionListener(this);
		tent.setBackground(new Color(179, 228, 233));
		// -----
		grid.add(endTurn);
		grid.add(scuba);
		// -----
		endTurn.setBackground(new Color(69, 143, 152));
		endTurn.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
		endTurn.addActionListener(this);
		scuba.setOpaque(true);
		scuba.setBackground(new Color(179, 228, 233));
		// -----
		saveItem.addActionListener(this);
		quitItem.addActionListener(this);
		// --------------------------------------------------------------------
		refresh(m);
	}

	public void clearMapView() {
		for (JPanel[] jButton : icetables) {
			for (JPanel jButton2 : jButton) {
				if (jButton2 != null) {
					jButton2.setBackground(new Color(255, 255, 255));
					for (int i = 0; i < 9; i++) {
						JButton button = (JButton) jButton2.getComponent(i);
						button.setText("");
						button.setIcon(null);
						button.setBackground(Color.WHITE);
						button.setText("");
					}
				}
			}
		}

		lname.setBackground(new Color(179, 228, 233));
		lname.setText("");

		flare.setBackground(new Color(179, 228, 233));
		shovel.setBackground(new Color(179, 228, 233));
		rope.setBackground(new Color(179, 228, 233));
		tent.setBackground(new Color(179, 228, 233));
		scuba.setBackground(new Color(179, 228, 233));
	}

	public void refresh(IModell modell) {
		this.clearMapView();
		String path = System.getProperty("user.dir") +"\\kepek_jatekba";		//ez a windows
		//String path = System.getProperty("user.dir") +"/kepek_jatekba";			//ez a linuxos
		
		name = m.getCurrentPlayer().getName();
		thp = String.valueOf(m.getCurrentPlayer().getThp());
		work = String.valueOf(m.getCurrentPlayer().getWork()); 
		lname.setText("name: " + name);
		lthp.setText("thp: " + thp);
		lwork.setText("work: " + work);
		
		Map currentState = (Map) modell;
		int count = 0;

		for (int i = 0; i < currentState.getHeight(); i++) {
			for (int j = 0; j < currentState.getWidth(); j++) {
				if (field.charAt(i * currentState.getWidth() + j) == '1') {
					int buttonNumber = 0;
					for (Player player : currentState.getIceField().getIceTables().get(count).getPlayersOnTable()) {
						if (player.getClass() == Eskimo.class) {
							JButton b = (JButton)icetables[i][j].getComponent(buttonNumber);
							ImageIcon image = new ImageIcon(path+"/eskimo.png");
							b.setIcon(image);
							buttonNumber++;
						}
						else if (player.getClass() == Scientist.class) {
							JButton b = (JButton)icetables[i][j].getComponent(buttonNumber);
							ImageIcon image = new ImageIcon(path+"/scient.png");
							b.setIcon(image);							
							buttonNumber++;
						}						
					}
					for(PolarBear polarBear : currentState.getIceField().getIceTables().get(count).getAnimalsOnTable()) {
						JButton b = (JButton)icetables[i][j].getComponent(buttonNumber);
						ImageIcon image = new ImageIcon(path+"/polarbear.png");
						b.setIcon(image);
						buttonNumber++;
					}
					if(currentState.getIceField().getIceTables().get(count).getFrozenItem() != null && currentState.getIceField().getIceTables().get(count).getSnowHeight() == 0) {
						JButton b = (JButton)icetables[i][j].getComponent(buttonNumber);
						ImageIcon image;
						switch(currentState.getIceField().getIceTables().get(count).getFrozenItem().getId()) 
						{
						
							case 0: image = new ImageIcon(path+"/flaregun.png");
									b.setIcon(image);
									buttonNumber++;
									break;
							case 1: image = new ImageIcon(path+"/rope.png");
									b.setIcon(image);
									buttonNumber++;
									break;
							case 2: image = new ImageIcon(path+"/scuba.png");
									b.setIcon(image);
									buttonNumber++;
									break;
							case 3: if(currentState.getIceField().getIceTables().get(count).getFrozenItem().getClass() == Shovel.class) 
									{
										image = new ImageIcon(path+"/shovel.png");
										b.setIcon(image);
										buttonNumber++;
										break;
									}
									else 
									{
										image = new ImageIcon(path+"/weakshovel.png");
										b.setIcon(image);
										buttonNumber++;
										break;
									}
							case 4: image = new ImageIcon(path+"/tent.png");
									b.setIcon(image);
									buttonNumber++;
									break;
							case 5: image = new ImageIcon(path+"/adrenalin.png");
									b.setIcon(image);
									buttonNumber++;
									break;
							case 6: image = new ImageIcon(path+"/food.png");
									b.setIcon(image);
									buttonNumber++;
									break;
							case 7: image = new ImageIcon(path+"/whiskey.png");
									b.setIcon(image);
									buttonNumber++;
									break;
							default: break;						
						}
					}
					if(currentState.getIceField().getIceTables().get(count).getConstruction()!=null){
						if(currentState.getIceField().getIceTables().get(count).getConstruction().getClass()==Tent.class){
							JButton b = (JButton)icetables[i][j].getComponent(buttonNumber);
							ImageIcon image = new ImageIcon(path+"/tent.png");
							b.setIcon(image);
							buttonNumber++;
						}
						else if(currentState.getIceField().getIceTables().get(count).getConstruction().getClass()==Igloo.class){
							JButton b = (JButton)icetables[i][j].getComponent(buttonNumber);
							ImageIcon image = new ImageIcon(path+"/iglu.png");
							b.setIcon(image);
							buttonNumber++;
						}
					}

					JButton b = (JButton)icetables[i][j].getComponent(buttonNumber);
					int snowHeight=currentState.getIceField().getIceTables().get(count).getSnowHeight();
					b.setText(snowHeight>0? Integer.toString(snowHeight):"");
					if(snowHeight == 0) {
						for (Component comps: b.getParent().getComponents()) {
							comps.setBackground(new Color(179, 228, 233));
						}
						
					}
					buttonNumber++;

					count++;
				}

			}

		}

	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		if (actionEvent.getSource().equals(quitItem)) {
			System.exit(0);
		}
		if(actionEvent.getSource().equals(saveItem)){
			//TODO mentesfuggveny
		}
		if(actionEvent.getSource().equals(dig)){
			m.dig(m.getCurrentPlayer().getName());
			refresh(m);
		}
		if(actionEvent.getSource().equals(pickUp)) {
			m.getCurrentPlayer().pickUp();
			refresh(m);
		}
		if(actionEvent.getSource().equals(skill)){
		    m.getCurrentPlayer().useSkill(m.getCurrentPlayer().getCurrentTable());
		    refresh(m);
        }
		if(actionEvent.getSource().equals(move)){

			
			ActionListener secondClickListener= new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					int index=0;
					JPanel iceField= (JPanel)((JButton)e.getSource()).getParent();
					 outerloop:
					for (int i = 0; i < m.getWidth(); i++) {
						for (int j = 0; j < m.getHeight(); j++) {
							if(icetables[i][j]!=null) {
								if(icetables[i][j]!=iceField) {	
									System.out.println("baktalo");
									index++;
								}
								else {
									String name=m.getCurrentPlayer().getName();
									m.movePlayer(name, index);
									refresh(m);
									break outerloop;
								}
							}
						}
					}
					
					
				}
			};
		    for (JPanel[] jPanels : icetables) {
				for (JPanel jPanel : jPanels) {
					if(jPanel!=null) {
						for (int i = 0; i < 9; i++) {
							JButton b= (JButton)jPanel.getComponent(i);
							b.addActionListener(secondClickListener);
						}
					}
				}
			}
		    
        }
		if(actionEvent.getSource().equals(endTurn)){
		    m.nextPlayer();
		    refresh(m);
        }
	}
}
