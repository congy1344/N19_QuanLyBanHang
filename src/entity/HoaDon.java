package entity;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Objects;

import dao.HoaDon_DAO;

public class HoaDon {

	private String maNhanVien;
	private String maHD;
	private LocalDate ngayLapHoaDon;
	private PTThanhToan ptThanhToan;
	private double tienKhachDua;
	
	private String auto_IDHoaDon() {
	    // Tạo định dạng cho số thứ tự
	    DecimalFormat df = new DecimalFormat("00000");

	    // Lấy danh sách hóa đơn của ngày hiện tại
	    LocalDate ngayHienTai = LocalDate.now();
	    ArrayList<HoaDon> hoaDonOfCurrentDate = null;
		try {
			hoaDonOfCurrentDate = HoaDon_DAO.getAllHoaDon();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    // Kiểm tra xem ngày hiện tại đã tạo hóa đơn trước đó chưa
	    boolean isNewDate = hoaDonOfCurrentDate.stream().anyMatch(hd -> hd.getNgayLapHoaDon().equals(ngayHienTai));

	    // Nếu là ngày mới, reset số thứ tự về 1
	    if (!isNewDate) {
	        hoaDonOfCurrentDate.clear(); // Xóa danh sách hóa đơn cũ
	    }

	    int length = hoaDonOfCurrentDate.size() + 1; // Tăng số thứ tự lên 1

	    String formattedDate = ngayHienTai.format(DateTimeFormatter.ofPattern("ddMMyy"));
	    String finalId = "HD" + formattedDate + df.format(length);

	    return finalId;
	}

	public HoaDon(String maNhanVien, String maHD, LocalDate ngayLapHoaDon, PTThanhToan ptThanhToan, double tienKhachDua) {
		this.maNhanVien = maNhanVien;
		this.maHD = auto_IDHoaDon();
		this.ngayLapHoaDon = ngayLapHoaDon;
		this.ptThanhToan = ptThanhToan;
		this.tienKhachDua = tienKhachDua;
	}

	
	public String getMaNhanVien() {
		return maNhanVien;
	}


	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}


	public String getMaHD() {
		return maHD;
	}


	public void setMaHD(String maHD) {
		this.maHD = auto_IDHoaDon();
	}


	public LocalDate getNgayLapHoaDon() {
		return ngayLapHoaDon;
	}


	public void setNgayLapHoaDon(LocalDate ngayLapHoaDon) {
		this.ngayLapHoaDon = ngayLapHoaDon;
	}


	public PTThanhToan getPtThanhToan() {
		return ptThanhToan;
	}


	public void setPtThanhToan(PTThanhToan ptThanhToan) {
		this.ptThanhToan = ptThanhToan;
	}


	public double getTienKhachDua() {
		return tienKhachDua;
	}


	public void setTienKhachDua(double tienKhachDua) {
		this.tienKhachDua = tienKhachDua;
	}


	public double getTongTien() {
		// TODO - implement HoaDon.getTongTien
		throw new UnsupportedOperationException();
	}

	public double getTienThua() {
		// TODO - implement HoaDon.getTienThua
		throw new UnsupportedOperationException();
	}


	@Override
	public String toString() {
		return "HoaDon [maNhanVien=" + maNhanVien + ", maHD=" + maHD + ", ngayLapHoaDon=" + ngayLapHoaDon
				+ ", ptThanhToan=" + ptThanhToan + ", tienKhachDua=" + tienKhachDua + ", getTongTien()=" + getTongTien()
				+ ", getTienThua()=" + getTienThua() + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maHD == null) ? 0 : maHD.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HoaDon other = (HoaDon) obj;
		return Objects.equals(maHD, other.maHD);
	}
}