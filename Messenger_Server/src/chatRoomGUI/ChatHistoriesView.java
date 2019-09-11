package chatRoomGUI;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class ChatHistoriesView {

	public ChatHistoriesView() {
		JFrame gui = new JFrame("Chat Histories");
		JPanel panel = new JPanel();
		gui.setSize(700, 450);
		
		JTextField display = new JTextField();
		display.setBounds(10, 40, 550, 280);
		display.setEditable(false); 
		
		JLabel history = new JLabel("History:");
		history.setBounds(250, -20, 200, 100);
		
		panel.add(display); panel.add(history);
		
		panel.setLayout(null);
		gui.setResizable(false);
		gui.add(panel, BorderLayout.CENTER);
		gui.setLocationRelativeTo(null);
		gui.setVisible(true);
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	public static void main(String[] args) throws Exception {
		javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());

		new ChatHistoriesView();

	}
}
