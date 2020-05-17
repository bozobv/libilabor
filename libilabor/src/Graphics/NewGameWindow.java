package Graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class NewGameWindow extends JFrame
{
	private final JComboBox  jcbItems, jcbSnow, jcbEs, jcbSc, jcbPb;
	private final JPanel p1, p2, p3 ,p4 ,p5, p6;
	private final JLabel lItems/*, lSnow, lEs, lSc, lPb*/;
	private final JButton  bStart;
	
	private boolean decode = false;
	
	public NewGameWindow() throws HeadlessException {
		super("Új játék, fijam");
//		this.setTitle("SwingLab");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(400, 700);
		GridLayout lm = new GridLayout();
		lm.setRows(5); //plusz a gomb ?
		lm.setColumns(2);
		this.setLayout(lm);
				
		//felső panel
		p1 = new JPanel(new FlowLayout());
		p2 = new JPanel(new FlowLayout());
		p3 = new JPanel(new FlowLayout());
		p4 = new JPanel(new FlowLayout());
		p5 = new JPanel(new FlowLayout());
		p6 = new JPanel(new FlowLayout());

	
		add(p1);
		add(p2);
		add(p3);
		add(p4);
		add(p5);
		add(p6);

		Object player[]=new Object[10];
		for (int i = 0; i < 10; i++)
			player[i] = i;
		
		//hó
		Object snow[]=new Object[6];
		for (int i = 0; i < 6; i++)
			snow[i] = i;
		
		//itemdrop
		Object itemDrop[]=new Object[10];
		for (int i = 0; i < 10; i++)
			itemDrop[i] = i + 1;
		
		jcbItems = new JComboBox(itemDrop);
		lItems = new JLabel("KUKI", JLabel.LEFT);
		lItems.setBackground(new Color(69, 143, 152));
		p1.add(lItems);
		p1.add(jcbItems);
		
		jcbSnow = new JComboBox(snow);
		p2.add(jcbSnow);

		jcbEs =  new JComboBox(player);
		p3.add(jcbEs);

		jcbSc =  new JComboBox(player);
		p4.add(jcbSc);

		jcbPb =  new JComboBox(player);
		p5.add(jcbPb);

					
		/*f1 = new JTextField(20); 
		f1.addFocusListener(new FocuseLoseListener(false));
		f1.setEnabled(true); 
		f1.getDocument().addDocumentListener(new InputKeyFieldListener()); 
		p1.add(f1);*/
		
		bStart = new JButton();
		bStart.setText("Kezdjunk testwer!");
		bStart.addActionListener(new OkButtonActionListener());
		
		p6.add(bStart);
		//------------------------------------------------
		
		//-----------------------------------------------
		
		setResizable(true);
		setVisible(true);
	}
	
	private class OkButtonActionListener implements ActionListener
	{		
		@Override
		public void actionPerformed(ActionEvent ae) {
			/*if(decode==true)
				f1.setText(CaesarCode.caesarDeCode(f2.getText(), (char)jcb.getSelectedItem()));
			else
				f2.setText(CaesarCode.caesarCode(f1.getText(), (char)jcb.getSelectedItem()));*/
		}
	}
	
	private class FocuseLoseListener implements FocusListener
	{
		private boolean dir;
		public FocuseLoseListener(boolean b)
		{
			dir=b;
		}
		
		@Override
		public void focusGained(FocusEvent fe) {
//			throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
		}

		@Override
		public void focusLost(FocusEvent fe) {
			decode=dir;
		}
		
	}
	
	private class InputKeyFieldListener implements DocumentListener
	{
		@Override
		public void insertUpdate(DocumentEvent de) 
		{
			//f2.setText(CaesarCode.caesarCode(f1.getText(), (char)jcb.getSelectedItem()));
		}

		@Override
		public void removeUpdate(DocumentEvent de) 
		{
			//f2.setText(CaesarCode.caesarCode(f1.getText(), (char)jcb.getSelectedItem()));
		}

		@Override
		public void changedUpdate(DocumentEvent de) 
		{
			//f2.setText(CaesarCode.caesarCode(f1.getText(), (char)jcb.getSelectedItem()));
		}
	}
}

