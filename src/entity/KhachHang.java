package entity;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import dao.KhachHangTheoSDT_DAO;

public class KhachHang {

	private String maKH;
	private String tenKH;
	private String sdt;
	
	private String auto_IDKhachHang() {
		KhachHangTheoSDT_DAO khdao = null;
	    // Tạo định dạng cho số thứ tự
	    DecimalFormat df = new DecimalFormat("00000");

	    // Lấy danh sách khách hàng của ngày hiện tại
	    LocalDate ngayHienTai = LocalDate.now();
	    ArrayList<KhachHang> khachHangOfCurrentDate = null;
	    try {
	        // Sử dụng phương thức tương ứng của DAO để lấy danh sách khách hàng
	        khachHangOfCurrentDate = khdao.getAllKhachHang();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    // Nếu danh sách khách hàng là null, tức là không có khách hàng nào tồn tại
	    // thì số thứ tự sẽ bắt đầu từ 1
	    int length = (khachHangOfCurrentDate != null) ? khachHangOfCurrentDate.size() + 1 : 1;

	    String finalId = "KH" + df.format(length);

	    return finalId;
	}

	
	public KhachHang(String maKH, String tenKH, String sdt) {
		this.maKH = auto_IDKhachHang();
		this.tenKH = tenKH;
		this.sdt = sdt;
	}


	public String getMaKH() {
		return maKH;
	}


	public void setMaKH(String maKH) {
		this.maKH = auto_IDKhachHang();
	}


	public String getTenKH() {
		return tenKH;
	}


	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}


	public String getSdt() {
		return sdt;
	}


	public void setSdt(String sdt) {
		this.sdt = sdt;
	}


	@Override
	public String toString() {
		return "KhachHang [maKH=" + maKH + ", tenKH=" + tenKH + ", sdt=" + sdt + "]";
	}

}