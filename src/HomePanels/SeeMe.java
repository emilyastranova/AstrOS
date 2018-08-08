package HomePanels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Commands.Commands;
import Main.MenuItemButton;
import Vars.Vars;

public class SeeMe {

	public static JFrame frame = new JFrame();
	private JLayeredPane lpane = new JLayeredPane();
	private JPanel panel = new JPanel();
	public static JTextField input = new JTextField();
	public static MenuItemButton submit = new MenuItemButton(Color.GREEN, Color.BLACK);

	public SeeMe() {
		frame.setPreferredSize(new Dimension(Vars.dimensionFullScreen.width - 300, Vars.dimensionFullScreen.height - 300));
		frame.setLayout(null);
		frame.add(lpane, BorderLayout.CENTER);
		lpane.setBounds(0, 0, Vars.dimensionFullScreen.width - 300, Vars.dimensionFullScreen.height - 150);
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);
		panel.setBounds(0, 0, Vars.dimensionFullScreen.width - 300, Vars.dimensionFullScreen.height - 150);
		panel.setOpaque(true);
		JTextField text = new JTextField("See Me Reason: ");
		text.setEditable(false);
		text.setLocation(0, 0);
		text.setSize(new Dimension(Vars.dimensionFullScreen.width - 300, 100));
		text.setFont(Vars.fontDefault);
		text.setHorizontalAlignment(JTextField.CENTER);

		input.setSize(new Dimension(panel.getWidth()-40, 100));
		input.setLocation(10, 125);
		input.setFont(Vars.fontDefault);
		input.setHorizontalAlignment(JTextField.CENTER);

		submit.setLocation(panel.getWidth()/2-100, 250);
		submit.setSize(200, 100);
		submit.setFont(Vars.fontDefault);
		submit.setText("Submit");
		submit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Commands.closeKeyboard();
				if(!input.getText().equals(""))
				Commands.addToTicket(Commands.ticketSpacing(input.getText(), Double.parseDouble("0.00"), true), Double.parseDouble("0.00"));
				frame.dispose();
			}
		});
		
		panel.add(text);
		panel.add(submit);
		panel.add(input);
		
		input.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					Commands.closeKeyboard();
					if(!input.getText().equals(""))
					Commands.addToTicket(Commands.ticketSpacing(input.getText(), Double.parseDouble("0.00"), true), Double.parseDouble("0.00"));
					System.out.println("Submit button pressed");
					frame.dispose();
				}
			}
		});
		
		frame.addWindowListener( new WindowAdapter() {
		    public void windowOpened( WindowEvent e ){
		        input.requestFocus();
		    }
		}); 
		
		lpane.add(panel, new Integer(0), 0);
		lpane.setLayout(null);
		frame.pack();
		frame.setVisible(true);
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
		frame.setLocation(x, y - 100);
		frame.setTitle("Input \"See Me\" Reason");
		
		
	}

}
