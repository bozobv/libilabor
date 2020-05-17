package Graphics;

import Controller.Controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class NewGameWindow extends JFrame implements ActionListener
{
	private final JComboBox  jcbItems, jcbSnow, jcbEs, jcbSc, jcbPb;
	//private final JPanel p1Left, p2Left, p3Left ,p4Left ,p5Left, p6Left, p1Right, p2Right, p3Right ,p4Right ,p5Right;
	private final JLabel lItems, lSnow, lEs, lSc, lPb;
	private final JButton  bStart;
	Color ourgreen = new Color(69, 143, 152), textBlue = new Color(200,200,255);
	//private Container grid = new Container();
	private Controller controller;

	private boolean decode = false;
	
	public NewGameWindow(Controller _controller)  {
		super("new game");

		controller=_controller;
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(600, 700);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(179,228,233));
		panel.setLayout(new GridLayout(6,2,10,10));
		//setLayout(new GridLayout(6,2,10,10));

        GridBagConstraints c = new GridBagConstraints();

		/*GridLayout lm = new GridLayout();
		lm.setRows(6); //plusz a gomb ?
		lm.setColumns(1);
		this.setLayout(lm);
		this.getContentPane().setBackground(new Color(28,102,222));*/

        c.weightx = 1;
        c.weighty = .25;
        c.insets = new Insets(5, 0, 5, 0);
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.fill = GridBagConstraints.BOTH;
		
      //karakterek
      	Object player[]=new Object[10];
      	for (int i = 0; i < 10; i++)
      		player[i] = i;
      		
      	//hoooo
      	Object snow[]=new Object[6];
      	for (int i = 0; i < 6; i++)
      		snow[i] = i;
      		
      	//itemdrop
      	Object itemDrop[]=new Object[10];
      	for (int i = 0; i < 10; i++)
      		itemDrop[i] = i + 1;
      		
      	//dolgok

		jcbItems = new JComboBox(itemDrop);
		jcbItems.setFont(new Font(Font.MONOSPACED,Font.BOLD,40));
		jcbItems.setBackground(ourgreen);
		lItems = new JLabel("Item drop frequency ", JLabel.LEFT);
		lItems.setOpaque(true);
		lItems.setBackground(textBlue);
		lItems.setFont(new Font(Font.MONOSPACED,Font.BOLD,40));
        
  		panel.add(lItems, c);
  		panel.add(jcbItems, c);
  		
  			
  			//hav
  			//legordulo hav
  			jcbSnow = new JComboBox(snow);
  			jcbSnow.setFont(new Font(Font.MONOSPACED,Font.BOLD,40));
  			jcbSnow.setBackground(new Color(69, 143, 152));
  			//hav kiirasa
  			lSnow = new JLabel("snow height", JLabel.LEFT);
  			lSnow.setOpaque(true);
  			lSnow.setBackground(textBlue);
  			lSnow.setFont(new Font(Font.MONOSPACED,Font.BOLD,40));
  			//panelhez adas
  			panel.add(lSnow, c);
  	  		panel.add(jcbSnow, c);
  	  		

  			
  			//eszkimow
  			//legordulo fos
  			jcbEs =  new JComboBox(player);
  			jcbEs.setFont(new Font(Font.MONOSPACED,Font.BOLD,40));
  			jcbEs.setBackground(new Color(69, 143, 152));
  			//szoveg
  			lEs = new JLabel("Eskimoes", JLabel.LEFT);
  			lEs.setOpaque(true);
  			lEs.setBackground(textBlue);
  			lEs.setFont(new Font(Font.MONOSPACED,Font.BOLD,40));
  			//panel
  			panel.add(lEs, c);
  	  		panel.add(jcbEs, c);
  	  		

  			//kuttatok
  			//legordulo fos
  			jcbSc =  new JComboBox(player);
  			jcbSc.setFont(new Font(Font.MONOSPACED,Font.BOLD,40));
  			jcbSc.setBackground(new Color(69, 143, 152));
  			//szoveg
  			lSc = new JLabel("Scientists", JLabel.LEFT);
  			lSc.setOpaque(true);
  			lSc.setBackground(textBlue);
  			lSc.setFont(new Font(Font.MONOSPACED,Font.BOLD,40));
  			
  			panel.add(lSc, c);
  	  		panel.add(jcbSc, c);
  	  		

  			//medv		
  			//legordulo fos
  			jcbPb =  new JComboBox(player);
  			jcbPb.setFont(new Font(Font.MONOSPACED,Font.BOLD,40));
  			jcbPb.setBackground(new Color(69, 143, 152));
  			//szoveg
  			lPb = new JLabel("Polar Bears", JLabel.LEFT);
  			lPb.setOpaque(true);
  			lPb.setBackground(textBlue);
   			lPb.setFont(new Font(Font.MONOSPACED,Font.BOLD,40));
  			//panel
  			panel.add(lPb, c);
  	  		panel.add(jcbPb, c);
  	  		
  	  bStart=new JButton("ZSAAAAA");
  	  bStart.setFont(new Font(Font.MONOSPACED,Font.BOLD,40));
  	  bStart.setPreferredSize(new Dimension(100,50));
  	  bStart.setBackground(new Color(69, 143, 152));
  	  bStart.addActionListener(this);

  	  panel.add(bStart, c);
    
  	  add(panel);
  	  pack();
		setResizable(true);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		if(actionEvent.getSource().equals(bStart)){
			controller.initializeMap(5,5,jcbItems.getSelectedIndex()+1,jcbSnow.getSelectedIndex()+1);
			controller.startGame();
			this.dispose();
		}
		

	}
	
	
}

