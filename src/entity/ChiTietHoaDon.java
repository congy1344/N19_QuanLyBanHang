package entity;

public class ChiTietHoaDon {

	private SanPham sanPham;
	private int soLuongSP;
	
	public ChiTietHoaDon(SanPham sanPham, int soLuongSP) {
		this.sanPham = sanPham;
		this.soLuongSP = soLuongSP;
	}

	public SanPham getSanPham() {
		return sanPham;
	}

	public void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
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
		return "ChiTietHoaDon [sanPham=" + sanPham + ", soLuongSP=" + soLuongSP + ", getTienThue()=" + getTienThue()
				+ ", getThanhTien()=" + getThanhTien() + "]";
	}
	
	

}