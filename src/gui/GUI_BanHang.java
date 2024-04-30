package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class GUI_BanHang extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField_4;
	private JTextField textField_3;
	private Component textField_2;
	private Component textField_1;
	private JTextArea TextArea;
	private DefaultTableModel tableModelKH;
	private JTable tableKH;
	LocalDate ngayHT = LocalDate.now();

	/**
	 * Create the panel.
	 */
	public GUI_BanHang() {
		setLayout(null);
		
		JPanel p_ThongTinGioHang = new JPanel();
		p_ThongTinGioHang.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Thông tin giỏ hàng", TitledBorder.LEFT, TitledBorder.TOP, null,
				new Color(64, 128, 128)));
		p_ThongTinGioHang.setBounds(0, 70, 1000, 700);
		add(p_ThongTinGioHang);
		p_ThongTinGioHang.setLayout(null);
		
		JScrollPane scrPaneKH = new JScrollPane();
		scrPaneKH.setBounds(6, 15, 985, 675);
		p_ThongTinGioHang.add(scrPaneKH);

		tableModelKH = new DefaultTableModel(new String[] {"STT","Mã sản phẩm", "Tên sản phẩm", "Số lượng", "Giá bán", "Thuế", "Thành tiền", ""},0);
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
		p_ThongTinSanPham.setBounds(1005, 25, 535, 750);
		add(p_ThongTinSanPham);
		p_ThongTinSanPham.setLayout(null);
		
		
		JPanel p_NhapSanPham = new JPanel();
		p_NhapSanPham.setBorder(new LineBorder(new Color(0, 0, 0)));
		p_NhapSanPham.setBounds(5, 15, 520, 130);
		p_ThongTinSanPham.add(p_NhapSanPham);
		p_NhapSanPham.setLayout(null);
		
		JLabel lb_MaSanPham = new JLabel("Nhập mã sản phẩm: ");
		lb_MaSanPham.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lb_MaSanPham.setBounds(10, 0, 200, 25);
		p_NhapSanPham.add(lb_MaSanPham);
		
		TextArea = new JTextArea();
		TextArea.setBounds(10, 25, 500, 40);
		p_NhapSanPham.add(TextArea);
		TextArea.setColumns(10);
		
		JLabel lblNhpSLng = new JLabel("Nhập số lượng: ");
		lblNhpSLng.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNhpSLng.setBounds(10, 77, 130, 25);
		p_NhapSanPham.add(lblNhpSLng);
		
		textField_1 = new JTextField();
		textField_1.setBounds(150, 77, 100, 30);
		p_NhapSanPham.add(textField_1);
		
		JButton btnNewButton = new JButton("Thêm sản phẩm");
		btnNewButton.setBackground(new Color(204, 51, 51));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(270, 72, 240, 45);
		p_NhapSanPham.add(btnNewButton);
		
		JPanel p_ThanhToan = new JPanel();
		p_ThanhToan.setBorder(new LineBorder(new Color(0, 0, 0)));
		p_ThanhToan.setBounds(5, 220, 520, 425);
//		p_ThongTinSanPham.add(p_ThanhToan);
		p_ThanhToan.setLayout(null);
//		p_ThanhToan.setPreferredSize( new Dimension(520, 425));
		
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
//		textField_2.setText("aaaaaaaaaaaaaaaa");
//		textField_2.disable();
		textField_2.setBounds(270, 110, 240, 30);
		p_ThanhToan.add(textField_2);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Click c\u00E1c n\u00FAt \u0111\u1EC3 th\u00EAm gi\u00E1 tr\u1ECB v\u00E0o \u00F4 ti\u1EC1n nh\u1EADn", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 153, 255)));
		panel.setBounds(10, 150, 500, 94);
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
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Tiền thối: ");
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_2_1_1.setBounds(10, 254, 100, 25);
		p_ThanhToan.add(lblNewLabel_1_2_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("0 VNĐ");
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1_1_1.setBounds(360, 254, 150, 25);
		p_ThanhToan.add(lblNewLabel_1_1_1_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(160, 160, 160), new Color(160, 160, 160)), "S\u1ED1 t\u1EDD \u1EE9ng v\u1EDBi m\u1EC7nh gi\u00E1", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 153, 255)));
		panel_1.setBounds(10, 289, 500, 130);
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
		btnNewButton_2.setBounds(15, 660, 500, 40);
		p_ThongTinSanPham.add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("Lưu tạm");
		btnNewButton_2_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_2_1.setBounds(15, 710, 500, 30);
		p_ThongTinSanPham.add(btnNewButton_2_1);
		
		JLabel lb_PTTT = new JLabel("Chọn phương thức thanh toán");
		lb_PTTT.setFont(new Font("Tahoma", Font.BOLD, 20));
		lb_PTTT.setBounds(5, 150, 350, 30);
		p_ThongTinSanPham.add(lb_PTTT);
		
		JPanel p_ThanhToanTTuyen = new JPanel();
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setSelectedIndex(-1);
		tabbedPane.setBounds(5, 185, 520, 450);
		p_ThongTinSanPham.add(tabbedPane);
		
		tabbedPane.addTab("Thanh toán trực tiếp", p_ThanhToan);
		tabbedPane.addTab("Thanh toán toán gián tiếp", p_ThanhToanTTuyen);
		
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(5, 5, 535, 65);
		add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lb_tenKhachHang = new JLabel("Tên khách hàng:");
		lb_tenKhachHang.setBounds(5, 10, 120, 20);
		lb_tenKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_2.add(lb_tenKhachHang);
		
		textField_3 = new JTextField();
		textField_3.setBounds(135, 10, 390, 20);
		panel_2.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lb_soDienThoaiKH = new JLabel("Số điện thoại: ");
		lb_soDienThoaiKH.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lb_soDienThoaiKH.setBounds(5, 35, 120, 20);
		panel_2.add(lb_soDienThoaiKH);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(135, 35, 390, 20);
		panel_2.add(textField_4);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBounds(545, 5, 450, 65);
		add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lb_tenKhachHang_1 = new JLabel("Mã hóa đơn: ");
		lb_tenKhachHang_1.setBounds(5, 10, 200, 20);
		lb_tenKhachHang_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_3.add(lb_tenKhachHang_1);
		
		JLabel lb_tenKhachHang_1_1 = new JLabel("XXXX-XXXX-XXXX");
		lb_tenKhachHang_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lb_tenKhachHang_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lb_tenKhachHang_1_1.setBounds(240, 10, 200, 20);
		panel_3.add(lb_tenKhachHang_1_1);
		
		JLabel lb_tenKhachHang_1_2 = new JLabel("Ngày lập hóa đơn:");
		lb_tenKhachHang_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lb_tenKhachHang_1_2.setBounds(5, 40, 200, 20);
		panel_3.add(lb_tenKhachHang_1_2);
		
		JLabel lb_tenKhachHang_1_1_1 = new JLabel("DD/MM/YYYY");
		lb_tenKhachHang_1_1_1.setText(ngayHT.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		lb_tenKhachHang_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lb_tenKhachHang_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lb_tenKhachHang_1_1_1.setBounds(240, 40, 200, 20);
		panel_3.add(lb_tenKhachHang_1_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nguyen Van A -XXXXXXXX");
		lblNewLabel_2.setForeground(Color.BLUE);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(1275, 5, 250, 20);
		add(lblNewLabel_2);
	}

}
