package gui;


import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;


public class GUI_BanHang extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private DefaultTableModel tableModelKH;
	private Component tableKH;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_BanHang frame = new GUI_BanHang();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI_BanHang() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(1800, 1000));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		add(contentPane);		
		JLabel lbTitle = new JLabel("QUẢN LÝ BÁN HÀNG");
		lbTitle.setForeground(new Color(64, 128, 128));
		lbTitle.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lbTitle.setBounds(0, 0, 1540, 60);
		contentPane.add(lbTitle);
		
		JPanel p_ThongTinGioHang = new JPanel();
		p_ThongTinGioHang.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Thông tin giỏ hàng", TitledBorder.LEFT, TitledBorder.TOP, null,
				new Color(64, 128, 128)));
		p_ThongTinGioHang.setBounds(0, 70, 1000, 750);
		contentPane.add(p_ThongTinGioHang);
		p_ThongTinGioHang.setLayout(null);
		
		JScrollPane scrPaneKH = new JScrollPane();
		scrPaneKH.setBounds(6, 15, 985, 725);
		p_ThongTinGioHang.add(scrPaneKH);

		tableModelKH = new DefaultTableModel(new String[] {"Mã sản phẩm", "Tên sản phẩm", "Số lượng", "Giá bán", "Thuế"},0);
		tableKH = new JTable(tableModelKH);
		((JTable) tableKH).setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableKH.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		scrPaneKH.setViewportView(tableKH);
		((JComponent) tableKH).setToolTipText("");
		
		
		JPanel p_ThongTinSanPham = new JPanel();
		p_ThongTinSanPham.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Thông tin sản phẩm", TitledBorder.CENTER, TitledBorder.TOP, null,
				new Color(64, 128, 128)));
		p_ThongTinSanPham.setBounds(1005, 70, 535, 750);
		contentPane.add(p_ThongTinSanPham);
		p_ThongTinSanPham.setLayout(null);
		
		
		JPanel p_NhapSanPham = new JPanel();
		p_NhapSanPham.setBorder(null);
		p_NhapSanPham.setBounds(5, 15, 520, 150);
		p_ThongTinSanPham.add(p_NhapSanPham);
		p_NhapSanPham.setLayout(null);
		
		JLabel lb_MaSanPham = new JLabel("Nhập mã sản phẩm: ");
		lb_MaSanPham.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lb_MaSanPham.setBounds(10, 0, 200, 25);
		p_NhapSanPham.add(lb_MaSanPham);
		
		textField = new JTextField();
		textField.setBounds(10, 25, 500, 70);
		p_NhapSanPham.add(textField);
		textField.setColumns(10);
		
		JLabel lblNhpSLng = new JLabel("Nhập số lượng: ");
		lblNhpSLng.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNhpSLng.setBounds(10, 105, 130, 25);
		p_NhapSanPham.add(lblNhpSLng);
		
		textField_1 = new JTextField();
		textField_1.setBounds(150, 105, 100, 30);
		p_NhapSanPham.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Thêm sản phẩm");
		btnNewButton.setBackground(new Color(204, 51, 51));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(270, 100, 240, 45);
		p_NhapSanPham.add(btnNewButton);
		
		JPanel p_ThanhToan = new JPanel();
		p_ThanhToan.setBorder(null);
		p_ThanhToan.setBounds(5, 170, 520, 450);
		p_ThongTinSanPham.add(p_ThanhToan);
		p_ThanhToan.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Thanh toán trực tiếp: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(10, 10, 300, 30);
		p_ThanhToan.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tổng tiền hàng:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(10, 50, 150, 25);
		p_ThanhToan.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("0 VNĐ");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(360, 50, 150, 25);
		p_ThanhToan.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("0 VNĐ");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1_1.setBounds(360, 80, 150, 25);
		p_ThanhToan.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Tiền đã giảm: ");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_2.setBounds(10, 80, 150, 25);
		p_ThanhToan.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Tiền nhận: ");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_2_1.setBounds(10, 110, 100, 25);
		p_ThanhToan.add(lblNewLabel_1_2_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(270, 110, 240, 30);
		p_ThanhToan.add(textField_2);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Click c\u00E1c n\u00FAt \u0111\u1EC3 th\u00EAm gi\u00E1 tr\u1ECB v\u00E0o \u00F4 ti\u1EC1n nh\u1EADn", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 153, 255)));
		panel.setBounds(10, 150, 500, 130);
		p_ThanhToan.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("1.000");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1.setBounds(10, 20, 140, 30);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("5.000");
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1_1.setBounds(350, 20, 140, 30);
		panel.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("2.000");
		btnNewButton_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1_2.setBounds(180, 20, 140, 30);
		panel.add(btnNewButton_1_2);
		
		JButton btnNewButton_1_1_1 = new JButton("50.000");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1_1_1.setBounds(350, 55, 140, 30);
		panel.add(btnNewButton_1_1_1);
		
		JButton btnNewButton_1_2_1 = new JButton("20.000");
		btnNewButton_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1_2_1.setBounds(180, 55, 140, 30);
		panel.add(btnNewButton_1_2_1);
		
		JButton btnNewButton_1_3 = new JButton("10.000");
		btnNewButton_1_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1_3.setBounds(10, 55, 140, 30);
		panel.add(btnNewButton_1_3);
		
		JButton btnNewButton_1_1_2 = new JButton("500.000");
		btnNewButton_1_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1_1_2.setBounds(350, 90, 140, 30);
		panel.add(btnNewButton_1_1_2);
		
		JButton btnNewButton_1_2_2 = new JButton("200.000");
		btnNewButton_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1_2_2.setBounds(180, 90, 140, 30);
		panel.add(btnNewButton_1_2_2);
		
		JButton btnNewButton_1_4 = new JButton("100.000");
		btnNewButton_1_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1_4.setBounds(10, 90, 140, 30);
		panel.add(btnNewButton_1_4);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Tiền thối: ");
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_2_1_1.setBounds(10, 286, 100, 25);
		p_ThanhToan.add(lblNewLabel_1_2_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("0 VNĐ");
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1_1_1.setBounds(360, 286, 150, 25);
		p_ThanhToan.add(lblNewLabel_1_1_1_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(160, 160, 160), new Color(160, 160, 160)), "S\u1ED1 t\u1EDD \u1EE9ng v\u1EDBi m\u1EC7nh gi\u00E1", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 153, 255)));
		panel_1.setBounds(10, 321, 500, 130);
		p_ThanhToan.add(panel_1);
		
		JButton btnNewButton_1_5 = new JButton("1.000 (0)");
		btnNewButton_1_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1_5.setBounds(10, 20, 140, 30);
		panel_1.add(btnNewButton_1_5);
		
		JButton btnNewButton_1_1_3 = new JButton("5.000 (0)");
		btnNewButton_1_1_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1_1_3.setBounds(350, 20, 140, 30);
		panel_1.add(btnNewButton_1_1_3);
		
		JButton btnNewButton_1_2_3 = new JButton("2.000 (0)");
		btnNewButton_1_2_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1_2_3.setBounds(180, 20, 140, 30);
		panel_1.add(btnNewButton_1_2_3);
		
		JButton btnNewButton_1_1_1_1 = new JButton("50.000 (0)");
		btnNewButton_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1_1_1_1.setBounds(350, 55, 140, 30);
		panel_1.add(btnNewButton_1_1_1_1);
		
		JButton btnNewButton_1_2_1_1 = new JButton("20.000 (0)");
		btnNewButton_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1_2_1_1.setBounds(180, 55, 140, 30);
		panel_1.add(btnNewButton_1_2_1_1);
		
		JButton btnNewButton_1_3_1 = new JButton("10.000 (0)");
		btnNewButton_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1_3_1.setBounds(10, 55, 140, 30);
		panel_1.add(btnNewButton_1_3_1);
		
		JButton btnNewButton_1_1_2_1 = new JButton("500.000 (0)");
		btnNewButton_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1_1_2_1.setBounds(350, 90, 140, 30);
		panel_1.add(btnNewButton_1_1_2_1);
		
		JButton btnNewButton_1_2_2_1 = new JButton("200.000 (0)");
		btnNewButton_1_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1_2_2_1.setBounds(180, 90, 140, 30);
		panel_1.add(btnNewButton_1_2_2_1);
		
		JButton btnNewButton_1_4_1 = new JButton("100.000 (0)");
		btnNewButton_1_4_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1_4_1.setBounds(10, 90, 140, 30);
		panel_1.add(btnNewButton_1_4_1);
		
		JButton btnNewButton_2 = new JButton("Xuất hoá đơn");
		btnNewButton_2.setForeground(new Color(0, 0, 255));
		btnNewButton_2.setBackground(new Color(0, 51, 153));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_2.setBounds(15, 630, 500, 40);
		p_ThongTinSanPham.add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("Lưu tạm");
		btnNewButton_2_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_2_1.setBounds(15, 678, 500, 30);
		p_ThongTinSanPham.add(btnNewButton_2_1);
	}
}
