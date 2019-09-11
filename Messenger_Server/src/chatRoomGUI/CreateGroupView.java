package chatRoomGUI;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;


import chatRoomGUI.ChatRoomView;
/**
 * @author rxm448
 * The CreateGroupView class allows a user to create a group chat, from any number of users selected from two lists,
 * a list of all users currently online  and a list of the current users friends, it also allows them to name the group chat 
 */
//currently has then names of users hard-coded into the lists for testing 

public class CreateGroupView {
	
	// constructor 
	public CreateGroupView(){
	JFrame gui = new JFrame("Add Users");
	JPanel panel = new JPanel();
	
	gui.setSize(330, 380);
	
	//creation of jLabels 
	JLabel friendsLabel = new JLabel("Friends online");
	friendsLabel.setBounds(210,5,200,50);
	
	JLabel usersLabel = new JLabel("Users online");
	usersLabel.setBounds(40, 5, 200, 50);
	
	JLabel groupNameLabel = new JLabel("Group name:");
	groupNameLabel.setBounds(30, 280, 200, 50);
	
	//creation of the users/friends lists
	DefaultListModel<String> l1 = new DefaultListModel<>(); 
	/*
	 * List is created from a list of currently online users who are friends of this user  
	 */
	l1.addElement("Chris");
	l1.addElement("Charile");
	l1.addElement("Shanie");
	JList<String> friendsList = new JList<String>(l1);

	JScrollPane friendsScroller = new JScrollPane();
	friendsScroller.setViewportView(friendsList);
	friendsScroller.setBounds(180, 41, 140, 250);
	
	DefaultListModel<String> l2 = new DefaultListModel<>();  
	/*
	 * List is created from a list of currently online users 
	 */

	l2.addElement("Chris");
	l2.addElement("Charile");
	l2.addElement("Shanie");
	JList<String> usersList = new JList<String>(l2);
	usersList.setVisibleRowCount(-1);
	JScrollPane usersScroller = new JScrollPane(usersList);
	usersScroller.setBounds(10, 41, 140, 250);
	
	//creation of buttons 
	JButton create = new JButton("Create group");
	create.setBounds(120, 315, 100, 20);
	
	JButton cancel = new JButton("Cancel");
	cancel.setBounds(220, 315, 100, 20);
	
	//creation of text field for group name 
	JTextField groupName = new JTextField();
	groupName.setBounds(10, 315, 110, 20);
	
 
	
	panel.add(friendsLabel); panel.add(usersLabel); panel.add(friendsScroller);
	panel.add(usersScroller); panel.add(create); panel.add(cancel); panel.add(groupName);
	panel.add(groupNameLabel);
	
	//closes the panel if cancel is clicked, creates a new group-chat otherwise (create group was clicked )
	ActionListener button = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == cancel){
				gui.dispose();
			} else {
				// currently only functioning for the friends list, creates an array of the selected users 
				int[] selectedIx = friendsList.getSelectedIndices();
				String[] selectedUsers= new String[selectedIx.length];
				 for (int i = 0; i < selectedIx.length; i++) {
					 selectedUsers[i] = friendsList.getModel().getElementAt(selectedIx[i]);
				    }
				 
				new ChatRoomView(groupName.getText(), selectedUsers);
				
				gui.dispose();
			}
			
		}




	};
	
	cancel.addActionListener(button);
	create.addActionListener(button);
	
	//formatting 
	panel.setLayout(null);
	gui.setResizable(false);
	gui.add(panel, BorderLayout.CENTER);
	gui.setLocationRelativeTo(null);
	gui.setVisible(true);
	gui.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	
}

public static void main(String[] args) throws Exception {
	javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());

	new CreateGroupView();

}

}
