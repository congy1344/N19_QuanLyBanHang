package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JCheckBox;
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

import File.File;
import dao.NhanVien_DAO;
import dao.SanPham_DAO;
import entity.NhanVien;
import entity.SanPham;

public class GUI_BanHang extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JTextField txt_SoDienThaoi;
	private JTextField txt_TenKH;
	private Component txt_TienNhan;
	private JTextField txt_NhapSoLuong;
	private DefaultTableModel tableModelKH;
	private JTable tableKH;
	LocalDate ngayHT = LocalDate.now();
	private SanPham_DAO sanPham_dao;
	private JButton btn_ThemSanPham;
	private JTextField txt_SP;
	private File f = new File();
	private NhanVien_DAO nhanVien_dao;
	private JLabel lb_Ma;
	private JLabel lb_NhanVien;

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
		
		txt_SP = new JTextField();
		txt_SP.setBounds(10, 25, 500, 40);
		p_NhapSanPham.add(txt_SP);
		txt_SP.setColumns(10);

		JLabel lb_NhapSoLuong = new JLabel("Nhập số lượng: ");
		lb_NhapSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lb_NhapSoLuong.setBounds(10, 77, 130, 25);
		p_NhapSanPham.add(lb_NhapSoLuong);
		
		txt_NhapSoLuong = new JTextField();
		txt_NhapSoLuong.setBounds(150, 77, 100, 30);
		p_NhapSanPham.add(txt_NhapSoLuong);
		
		btn_ThemSanPham = new JButton("Thêm sản phẩm");
		btn_ThemSanPham.setBackground(new Color(204, 51, 51));
		btn_ThemSanPham.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn_ThemSanPham.setBounds(270, 72, 240, 45);
		p_NhapSanPham.add(btn_ThemSanPham);
		
		JPanel p_ThanhToan = new JPanel();
		p_ThanhToan.setBorder(new LineBorder(new Color(0, 0, 0)));
		p_ThanhToan.setBounds(5, 220, 520, 425);
//		p_ThongTinSanPham.add(p_ThanhToan);
		p_ThanhToan.setLayout(null);
//		p_ThanhToan.setPreferredSize( new Dimension(520, 425));
		
		JLabel lb_TTTT = new JLabel("Thanh toán trực tiếp: ");
		lb_TTTT.setFont(new Font("Tahoma", Font.BOLD, 24));
		lb_TTTT.setBounds(10, 10, 300, 30);
		p_ThanhToan.add(lb_TTTT);
		
		JLabel lb_TongTien = new JLabel("Tổng tiền hàng:");
		lb_TongTien.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lb_TongTien.setBounds(10, 50, 150, 25);
		p_ThanhToan.add(lb_TongTien);
		
		JLabel lb_valueTongTien = new JLabel("0 VNĐ");
		lb_valueTongTien.setHorizontalAlignment(SwingConstants.RIGHT);
		lb_valueTongTien.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lb_valueTongTien.setBounds(360, 50, 150, 25);
		p_ThanhToan.add(lb_valueTongTien);
		
		JLabel lb_valueTienGiam = new JLabel("0 VNĐ");
		lb_valueTienGiam.setHorizontalAlignment(SwingConstants.RIGHT);
		lb_valueTienGiam.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lb_valueTienGiam.setBounds(360, 80, 150, 25);
		p_ThanhToan.add(lb_valueTienGiam);
		
		JLabel lb_TienGiam = new JLabel("Tiền đã giảm: ");
		lb_TienGiam.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lb_TienGiam.setBounds(10, 80, 150, 25);
		p_ThanhToan.add(lb_TienGiam);
		
		JLabel lb_TienNhan = new JLabel("Tiền nhận: ");
		lb_TienNhan.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lb_TienNhan.setBounds(10, 110, 100, 25);
		p_ThanhToan.add(lb_TienNhan);
		
		txt_TienNhan = new JTextField();
//		textField_2.setText("aaaaaaaaaaaaaaaa");
//		textField_2.disable();
		txt_TienNhan.setBounds(270, 110, 240, 30);
		p_ThanhToan.add(txt_TienNhan);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Click c\u00E1c n\u00FAt \u0111\u1EC3 th\u00EAm gi\u00E1 tr\u1ECB v\u00E0o \u00F4 ti\u1EC1n nh\u1EADn", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 153, 255)));
		panel.setBounds(10, 150, 500, 94);
		p_ThanhToan.add(panel);
		panel.setLayout(null);
		
		JButton btb1 = new JButton("1.000");
		btb1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btb1.setBounds(10, 20, 140, 30);
		panel.add(btb1);
		
		JButton btn3 = new JButton("5.000");
		btn3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn3.setBounds(350, 20, 140, 30);
		panel.add(btn3);
		
		JButton btb2 = new JButton("2.000");
		btb2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btb2.setBounds(180, 20, 140, 30);
		panel.add(btb2);
		
		JButton btn6 = new JButton("50.000");
		btn6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn6.setBounds(350, 55, 140, 30);
		panel.add(btn6);
		
		JButton btn5 = new JButton("20.000");
		btn5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn5.setBounds(180, 55, 140, 30);
		panel.add(btn5);
		
		JButton btn4 = new JButton("10.000");
		btn4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn4.setBounds(10, 55, 140, 30);
		panel.add(btn4);
		
		JLabel lb_TienThoi = new JLabel("Tiền thối: ");
		lb_TienThoi.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lb_TienThoi.setBounds(10, 254, 100, 25);
		p_ThanhToan.add(lb_TienThoi);
		
		JLabel lb_valueTienThoi = new JLabel("0 VNĐ");
		lb_valueTienThoi.setHorizontalAlignment(SwingConstants.RIGHT);
		lb_valueTienThoi.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lb_valueTienThoi.setBounds(360, 254, 150, 25);
		p_ThanhToan.add(lb_valueTienThoi);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(160, 160, 160), new Color(160, 160, 160)), "S\u1ED1 t\u1EDD \u1EE9ng v\u1EDBi m\u1EC7nh gi\u00E1", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 153, 255)));
		panel_1.setBounds(10, 289, 500, 130);
		p_ThanhToan.add(panel_1);
		
		JButton btn_TT1 = new JButton("1.000 (0)");
		btn_TT1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_TT1.setBounds(10, 20, 140, 30);
		panel_1.add(btn_TT1);
		
		JButton btn_TT3 = new JButton("5.000 (0)");
		btn_TT3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_TT3.setBounds(350, 20, 140, 30);
		panel_1.add(btn_TT3);
		
		JButton btn_TT2 = new JButton("2.000 (0)");
		btn_TT2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_TT2.setBounds(180, 20, 140, 30);
		panel_1.add(btn_TT2);
		
		JButton btn_TT6 = new JButton("50.000 (0)");
		btn_TT6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_TT6.setBounds(350, 55, 140, 30);
		panel_1.add(btn_TT6);
		
		JButton btn_TT5 = new JButton("20.000 (0)");
		btn_TT5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_TT5.setBounds(180, 55, 140, 30);
		panel_1.add(btn_TT5);
		
		JButton btn_TT4 = new JButton("10.000 (0)");
		btn_TT4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_TT4.setBounds(10, 55, 140, 30);
		panel_1.add(btn_TT4);
		
		JButton btn_TT9 = new JButton("500.000 (0)");
		btn_TT9.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_TT9.setBounds(350, 90, 140, 30);
		panel_1.add(btn_TT9);
		
		JButton btn_TT8 = new JButton("200.000 (0)");
		btn_TT8.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_TT8.setBounds(180, 90, 140, 30);
		panel_1.add(btn_TT8);
		
		JButton btn_TT7 = new JButton("100.000 (0)");
		btn_TT7.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_TT7.setBounds(10, 90, 140, 30);
		panel_1.add(btn_TT7);
		
		JButton btn_XuatHoaDon = new JButton("Xuất hoá đơn");
		btn_XuatHoaDon.setForeground(new Color(0, 0, 255));
		btn_XuatHoaDon.setBackground(new Color(0, 51, 153));
		btn_XuatHoaDon.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn_XuatHoaDon.setBounds(15, 660, 500, 40);
		p_ThongTinSanPham.add(btn_XuatHoaDon);
		
		JButton btn_LuuTam = new JButton("Lưu tạm");
		btn_LuuTam.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn_LuuTam.setBounds(15, 710, 500, 30);
		p_ThongTinSanPham.add(btn_LuuTam);
		
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
		
		txt_TenKH = new JTextField();
		txt_TenKH.setBounds(135, 10, 390, 20);
		panel_2.add(txt_TenKH);
		txt_TenKH.setColumns(10);
		
		JLabel lb_soDienThoaiKH = new JLabel("Số điện thoại: ");
		lb_soDienThoaiKH.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lb_soDienThoaiKH.setBounds(5, 35, 120, 20);
		panel_2.add(lb_soDienThoaiKH);
		
		txt_SoDienThaoi = new JTextField();
		txt_SoDienThaoi.setColumns(10);
		txt_SoDienThaoi.setBounds(135, 35, 390, 20);
		panel_2.add(txt_SoDienThaoi);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBounds(545, 5, 450, 65);
		add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lb_MaHD = new JLabel("Mã hóa đơn: ");
		lb_MaHD.setBounds(5, 10, 200, 20);
		lb_MaHD.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_3.add(lb_MaHD);
		
		lb_Ma = new JLabel("XXXX-XXXX-XXXX");
		lb_Ma.setHorizontalAlignment(SwingConstants.RIGHT);
		lb_Ma.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lb_Ma.setBounds(240, 10, 200, 20);
		panel_3.add(lb_Ma);
		
		
		JLabel lb_NgayLapHD = new JLabel("Ngày lập hóa đơn:");
		lb_NgayLapHD.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lb_NgayLapHD.setBounds(5, 40, 200, 20);
		panel_3.add(lb_NgayLapHD);
		
		JLabel lb_Ngay = new JLabel("DD/MM/YYYY");
		lb_Ngay.setText(ngayHT.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		lb_Ngay.setHorizontalAlignment(SwingConstants.RIGHT);
		lb_Ngay.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lb_Ngay.setBounds(240, 40, 200, 20);
		panel_3.add(lb_Ngay);
		
		lb_NhanVien = new JLabel("Nguyen Van A -XXXXXXXX");
		lb_NhanVien.setForeground(Color.BLUE);
		lb_NhanVien.setHorizontalAlignment(SwingConstants.RIGHT);
		lb_NhanVien.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lb_NhanVien.setBounds(1275, 5, 250, 20);
		add(lb_NhanVien);
		
		btn_ThemSanPham.addActionListener(this);
		btn_XuatHoaDon.addActionListener(this);
		btn_LuuTam.addActionListener(this);
		
		sanPham_dao = new SanPham_DAO();
		nhanVien_dao = new NhanVien_DAO();
		setNhanVienDangNhap();
		loadLenModel();
	}
	//Phuong thuc nay test thoi
	public void loadLenModel() {
		int i = 0;
		sanPham_dao.getAllSanPham().forEach(sp-> {
			String maSP = sp.getMaSP();
			String tenSP = sp.getTenSP();
			double giaBan = sp.getGiaBan();
			float thue = (float) sp.getThue();
			tableModelKH.addRow(new Object[] {tableModelKH.getRowCount(), maSP, tenSP, 5, giaBan, thue, 5, new JCheckBox()});
		});
	}
	
	public void setNhanVienDangNhap() {
		String ma = f.DocTuFile();
		NhanVien nv = nhanVien_dao.getNhanVienTheoMa(ma);
		lb_NhanVien.setText(nv.getTenNV() +"-" + nv.getMaNV());
	}
	public void themVaoGioHang() {
		String maSP = txt_SP.getText().toString();
		SanPham sp = new SanPham_DAO().getSanPhamTheoMa(maSP);
		int soluong = Integer.parseInt(txt_NhapSoLuong.getText());
		float thue = (float) sp.getThue();
		float thanhTien = (float) (sp.getGiaBan() * soluong + (sp.getGiaBan() * soluong)*thue);
		tableModelKH.addRow(new Object[] {tableModelKH.getRowCount(), maSP, sp.getTenSP(), soluong, sp.getGiaBan(), thue, thanhTien, new JCheckBox()});
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btn_ThemSanPham)) {
			themVaoGioHang();
		}
	}
}