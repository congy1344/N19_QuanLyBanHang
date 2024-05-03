package entity;

public class ChiTietHoaDon {

	private SanPham sanPham;
	private String maHoaDon;
	private int soLuongSP;
	
	public ChiTietHoaDon(SanPham sanPham, String maHoaDon, int soLuongSP) {
		this.sanPham = sanPham;
		this.maHoaDon = maHoaDon;
		this.soLuongSP = soLuongSP;
	}

	public SanPham getSanPham() {
		return sanPham;
	}

	public void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
	}
	

	public String getMaHoaDon() {
		return maHoaDon;
	}

	public void setMaHoaDon(String maHoaDon) {
		this.maHoaDon = maHoaDon;
	}

	public int getSoLuongSP() {
		return soLuongSP;
	}

	public void setSoLuongSP(int soLuongSP) {
		this.soLuongSP = soLuongSP;
	}

	public double getTienThue() {
		// TODO - implement ChiTietHoaDon.getTienThue
		throw new UnsupportedOperationException();
	}

	public double getThanhTien() {
		// TODO - implement ChiTietHoaDon.getThanhTien
		throw new UnsupportedOperationException();
	}

	@Override
	public String toString() {
		return "ChiTietHoaDon [sanPham=" + sanPham + ", maHoaDon=" + maHoaDon + ", soLuongSP=" + soLuongSP
				+ ", getTienThue()=" + getTienThue() + ", getThanhTien()=" + getThanhTien() + "]";
	}
}