package Graphics;

import Controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * A gyozelem utan felugro ablak megjelenitesere szolgal. 
 * Implementalja az ActionListenert.
 * 
 * 
 *
 */
public class Win implements ActionListener {
    /**az ablak jframeje*/
	private JFrame frame;
    /**kontroller*/
	private Controller controller;
    /**az exit, restart gombok*/
    private JButton restart, exit;
    /**A gratulalo szovegnek*/
    private JLabel title;
    /**panel*/
    private JPanel p;

    public Win(Controller _controller) {
        controller=_controller;
        
        
        frame = new JFrame("Congratulations!");
        frame.setPreferredSize(new Dimension(300, 300));

        restart = new JButton();
        restart.setBackground(new Color(69, 143, 152));
        restart.setFont(new Font(Font.MONOSPACED,Font.BOLD,40));
        restart.setText("Restart");
        restart.addActionListener(this);

        exit = new JButton();
        exit.setBackground(new Color(69, 143, 152));
        exit.addActionListener(this);
        exit.setFont(new Font(Font.MONOSPACED,Font.BOLD,40));
        exit.setText("Exit");

        title = new JLabel("You won!");
        title.setFont(new Font(Font.MONOSPACED,Font.BOLD,40));
        title.setHorizontalAlignment(JLabel.CENTER);

        p= new JPanel();
        p.setLayout(new GridLayout(3,1, 30,30 ));
        p.add(title);
        p.add(restart);
        p.add(exit);

        frame.setLayout(new BorderLayout());
        frame.add(p,BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
        Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width/2-frame.getSize().width/2,dim.height/2-frame.getSize().height/2);

    }

    /**
     * A bizonyos gombok megnyomasainak hatasaira.
     * @param actionEvent 
     */
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource().equals(exit)) {
            System.exit(0);
        }
        if(actionEvent.getSource().equals(restart)) {
            frame.dispose();
            controller.dispose();
            controller.newGame();
        }
    }
}
