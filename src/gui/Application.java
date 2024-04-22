package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;


public class Application {
private JFrame frame;
	
	public JFrame getFrame() {
		return frame;
	}
	public static void main(String[] args) {
		Application ap = new Application();
		new LoginDialog(ap.frame).setVisible(true);
	}
	public Application() {
		initialize();		
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setSize(1200, 700);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		mnFile.add(mntmExit);
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(tabbedPane, BorderLayout.CENTER);
		tabbedPane.addTab("Bán xe", new GUI_BanHang());
		frame.getContentPane().add(panel);
		
	}

}
