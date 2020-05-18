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

	// private JButton[][] icetables;

	private JPanel[][] icetables;
	String field;

	public GameArea(Map m) {
		frame.setSize(new Dimension(1360, 768));
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
				System.out.println(data);
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
					JLabel l = new JLabel();
					l.setBackground(Color.blue);
					map.add(l);
					System.out.println("l");
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

		grid.add(move);
		grid.add(flare);
		// -----
		move.setBackground(new Color(69, 143, 152));
		move.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
		flare.setBackground(new Color(179, 228, 233));
		// -----
		grid.add(dig);
		grid.add(shovel);
		// -----
		dig.setBackground(new Color(69, 143, 152));
		dig.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
		shovel.setOpaque(true);
		shovel.setBackground(new Color(179, 228, 233));
		// -----
		grid.add(skill);
		grid.add(rope);
		// -----
		skill.setBackground(new Color(69, 143, 152));
		skill.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
		rope.setBackground(new Color(179, 228, 233));
		// -----
		grid.add(pickUp);
		grid.add(tent);
		// -----
		pickUp.setBackground(new Color(69, 143, 152));
		pickUp.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
		tent.setBackground(new Color(179, 228, 233));
		// -----
		grid.add(endTurn);
		grid.add(scuba);
		// -----
		endTurn.setBackground(new Color(69, 143, 152));
		endTurn.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
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
						button.setIcon(null);
						button.setBackground(Color.WHITE);
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

		Map currentState = (Map) modell;
		int count = 0;

		for (int i = 0; i < currentState.getHeight(); i++) {
			for (int j = 0; j < currentState.getWidth(); j++) {
				if (field.charAt(i * currentState.getWidth() + j) == '1') {
					int buttonNumber = 0;
					for (Player player : currentState.getIceField().getIceTables().get(count).getPlayersOnTable()) {
						if (player.getClass() == Eskimo.class) {
							JButton b = (JButton)icetables[i][j].getComponent(buttonNumber);
							ImageIcon image = new ImageIcon("kepek_jatekba/eskimo.png");
							b.setIcon(image);
							buttonNumber++;
						}
						else if (player.getClass() == Scientist.class) {
							JButton b = (JButton)icetables[i][j].getComponent(buttonNumber);
							ImageIcon image = new ImageIcon("kepek_jatekba/scient.png");
							b.setIcon(image);							
							buttonNumber++;
						}
						
					}
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
	}
}
