package chatRoomGUI;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * @author rxm448
 * The AddUserView class is for adding users to an existing group chat, it is very similar to CreateGroupView
 */

public class AddUserView {

	
	//construstor 
	public AddUserView(){
		JFrame gui = new JFrame("Add Users");
		JPanel panel = new JPanel();
		
		gui.setSize(330, 400);
		
		//creation of labels 
		JLabel friendsLabel = new JLabel("Friends online:");
		friendsLabel.setBounds(210,5,200,50);
		
		JLabel usersLabel = new JLabel("Users online:");
		usersLabel.setBounds(40, 5, 200, 50);
		
		//creation of list of friends 
		JList friendsList = new JList();
		friendsList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		friendsList.setVisibleRowCount(-1);
		JScrollPane friendsScroller = new JScrollPane(friendsList);
		friendsScroller.setBounds(10, 41, 140, 250);
		
		//creation of list of online users 
		JList usersList = new JList();
		usersList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		usersList.setVisibleRowCount(-1);
		JScrollPane usersScroller = new JScrollPane(usersList);
		usersScroller.setBounds(180, 41, 140, 250);
		
		//creation of buttons 
		JButton add = new JButton("Add Selected");
		add.setBounds(200, 300, 100, 50);
		
		JButton cancel = new JButton("Cancel");
		cancel.setBounds(30, 300, 100, 50);
		
		//adding components to panel
		panel.add(friendsLabel); panel.add(usersLabel); panel.add(friendsScroller);
		panel.add(usersScroller); panel.add(add); panel.add(cancel);
		
		//ActionListner for buttons 
		ActionListener button = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == cancel) {
				gui.dispose();
				 
				} else if (e.getSource() == add) {
					/*
					 * adds user to current group chat 
					 */
				}
			}




		};
		
		//linking ActionListner to buttons 
		cancel.addActionListener(button);
		add.addActionListener(button);
		
		//formatting 
		panel.setLayout(null);
		gui.setResizable(false);
		gui.add(panel, BorderLayout.CENTER);
		gui.setLocationRelativeTo(null);
		gui.setVisible(true);
		gui.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}
	
	//main method 
	public static void main(String[] args) throws Exception {
		javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());

		new AddUserView();

	}
}
