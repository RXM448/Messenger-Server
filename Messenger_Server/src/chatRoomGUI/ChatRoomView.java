package chatRoomGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
/** 
 * @author rxm448
 * the ChatRoomView class is for the creation of the chat room gui, 
 * it allows the sending of messages to anyone else in the chat and the addition of new users to the chat
 */

public class ChatRoomView {
	private JButton send, add, close, emoji1, emoji2, emoji3, emoji4;
	private JTextField global, entry, list;
	private JLabel lobby, chat;
	private JList users;
	private ActionListener sent, started;
	private String message;
	private JMenuBar bar;
	private JMenu options, styles;
	private JMenuItem ChatHistories, base, dark, disco;
	private Color baseColor, random;

	//constructor 
	public ChatRoomView(String group, String[] UsersPresent){
		JFrame gui = new JFrame(group);
		JPanel panel = new JPanel();

		gui.setSize(700, 450);

		//creation of text fields 
		global = new JTextField();
		global.setBounds(10, 40, 550, 280);
		global.setEditable(false); 

		entry = new JTextField();
		entry.setBounds(10, 360, 450, 30);

		//creation of labels
		chat = new JLabel("Chat:");
		chat.setBounds(250, -20, 200, 100);

		lobby = new JLabel("Users Present:");
		lobby.setBounds(595, -20, 200, 100);

		//creation of buttons 
		send = new JButton("Send");
		send.setBounds(460, 360, 100, 30);
	
		

		add = new JButton("Add User");
		add.setBounds(580, 290, 100, 30);
		
		close = new JButton("Close Chat");
		close.setBounds(580, 360, 100, 30);
		
		//creation of the menu bar
		bar = new JMenuBar();

		options = new JMenu("Options");
		styles = new JMenu("Styles");

		ChatHistories = new JMenuItem("Chat histories");
		base = new JMenuItem("Base");
		dark = new JMenuItem("Dark");
		disco = new JMenuItem("Disco!");

		//creation of the list which displays users in the chat 
		users = new JList();

		users.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		users.setVisibleRowCount(-1);
		JScrollPane listScroller = new JScrollPane(users);
		listScroller.setBounds(580, 40, 100, 250);


		//additon of components to the panel
		panel.add(global);	panel.add(entry); //panel.add(list);
		panel.add(chat)	;panel.add(lobby);	panel.add(send);
		panel.add(add); panel.add(listScroller); panel.add(close);

		//addition of components to the menu
		bar.add(options); options.add(ChatHistories); options.add(styles);
		styles.add(base); styles.add(dark); styles.add(disco);

		gui.setJMenuBar(bar);

		//ActionListner for the buttons add, send and close 
		ActionListener button = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == add ) {
					new AddUserView();
				}else if (e.getSource() == send) {
					/*
					 * send the message to the server 
					 */
				}else if (e.getSource() == close) {
					gui.dispose();
				}
				
			}

		};
		
		//ActionListner for the options in the styles sub-menu in the options menu 
		ActionListener styles = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == dark) {
					panel.setBackground(Color.BLACK);
					
					send.setBackground(Color.DARK_GRAY);
					add.setBackground(Color.DARK_GRAY);
					close.setBackground(Color.DARK_GRAY);
					
					global.setBackground(Color.GRAY);
					entry.setBackground(Color.GRAY);
					users.setBackground(Color.GRAY);
					
					chat.setForeground(Color.WHITE);
					lobby.setForeground(Color.WHITE);
					
				} else if (e.getSource() == base) {
					panel.setBackground(baseColor);
					
					send.setBackground(baseColor);
					add.setBackground(baseColor);
					close.setBackground(baseColor);
					
					global.setBackground(Color.WHITE);
					entry.setBackground(Color.WHITE);
					users.setBackground(Color.WHITE);
					
					chat.setForeground(baseColor);
					lobby.setForeground(baseColor);
					
				}else if (e.getSource() == disco) {
					Random gen = new Random(256);
	
					panel.setBackground(random = new Color(gen.nextInt(256), gen.nextInt(256), gen.nextInt(256)));
					
					send.setBackground(random = new Color(gen.nextInt(256), gen.nextInt(256), gen.nextInt(256)));
					add.setBackground(random = new Color(gen.nextInt(256), gen.nextInt(256), gen.nextInt(256)));
					close.setBackground(random = new Color(gen.nextInt(256), gen.nextInt(256), gen.nextInt(256)));
					
					global.setBackground(random = new Color(gen.nextInt(256), gen.nextInt(256), gen.nextInt(256)));
					entry.setBackground(random = new Color(gen.nextInt(256), gen.nextInt(256), gen.nextInt(256)));
					users.setBackground(random = new Color(gen.nextInt(256), gen.nextInt(256), gen.nextInt(256)));
					
					chat.setForeground(random = new Color(gen.nextInt(256), gen.nextInt(256), gen.nextInt(256)));
					lobby.setForeground(random = new Color(gen.nextInt(256), gen.nextInt(256), gen.nextInt(256)));
					
				}
			}

		};
		
		//linking actionListners to buttons 
		add.addActionListener(button);
		close.addActionListener(button);
		send.addActionListener(button);
		
		dark.addActionListener(styles);
		base.addActionListener(styles);
		disco.addActionListener(styles);

		//formatting 
		panel.setLayout(null);
		gui.setResizable(false);
		gui.add(panel, BorderLayout.CENTER);
		gui.setLocationRelativeTo(null);
		gui.setVisible(true);
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	//main method 
	public static void main(String[] args) throws Exception {
		javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
		String[] users = new String[1];
		
		new ChatRoomView("Chat Room", users);

	}

}
