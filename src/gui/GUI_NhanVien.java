package gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.EtchedBorder;

public class GUI_NhanVien extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private DefaultTableModel tableModelNV;
	private JTable tableNV;

	/**
	 * Create the panel.
	 */
	public GUI_NhanVien() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nhập mã số nhân viên:");
		lblNewLabel.setBounds(70, 22, 260, 21);
		panel.setBounds(30,0,1000,70);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(272, 16, 587, 31);
		panel.add(textField);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setColumns(30);
		
		JButton btnNewButton = new JButton("Tra cứu");
		btnNewButton.setBounds(878, 16, 116, 33);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u00F4ng tin nh\u00E2n vi\u00EAn", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(30, 100, 1011, 633);
		add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrPaneKH = new JScrollPane();
		scrPaneKH.setBounds(15, 20, 970, 300);
		panel_1.add(scrPaneKH);

        tableModelNV = new DefaultTableModel(new String[] {"Mã nhân viên", "Tên nhân viên", "Địa chỉ","Số điện thoại"},0);
        tableNV = new JTable(tableModelNV);
        ((JTable) tableNV).setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableNV.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
        scrPaneKH.setViewportView(tableNV);
        ((JComponent) tableNV).setToolTipText("");
	}

}
