package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import javax.swing.DropMode;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;

public class GUI_KhachHang extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private DefaultTableModel tableModelKH;
	private JTable tableKH;

	/**
	 * Create the panel.
	 */
	public GUI_KhachHang() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nhập số điện thoại khách hàng:");
		lblNewLabel.setBounds(50, 25, 260, 21);
		panel.setBounds(350,10,800,70);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(320, 20, 300, 31);
		panel.add(textField);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setColumns(30);
		
		JButton btnNewButton = new JButton("Tìm");
		btnNewButton.setBounds(650, 20, 80, 33);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Th\u00F4ng tin kh\u00E1ch h\u00E0ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(350, 90, 800, 600);
		add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrPaneKH = new JScrollPane();
		scrPaneKH.setBounds(20, 20, 760, 570);
		panel_1.add(scrPaneKH);

        tableModelKH = new DefaultTableModel(new String[] {"Số điện thoại", "Mã khách hàng", "Tên khách hàng"},0);
        tableKH = new JTable(tableModelKH);
        ((JTable) tableKH).setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableKH.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
        scrPaneKH.setViewportView(tableKH);
        ((JComponent) tableKH).setToolTipText("");
	}
}

