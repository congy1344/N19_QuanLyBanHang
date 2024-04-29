package entity;

import java.time.LocalDate;
import java.util.Objects;

public class HoaDon {

	private String maNhanVien;
	private String maHD;
	private LocalDate ngayLapHoaDon;
	private PTThanhToan ptThanhToan;
	private double tienKhachDua;
	
	
	public HoaDon(String maNhanVien, String maHD, LocalDate ngayLapHoaDon, PTThanhToan ptThanhToan, double tienKhachDua) {
		this.maNhanVien = maNhanVien;
		this.maHD = maHD;
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
		this.maHD = maHD;
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
		return "HoaDon [maNhanVien=" + maNhanVien + ", maHD=" + maHD + ", ngayLapHoaDon=" + ngayLapHoaDon + ", ptThanhToan="
				+ ptThanhToan + ", tienKhachDua=" + tienKhachDua + ", getTongTien()=" + getTongTien()
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