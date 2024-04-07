package entity;

public class KhoHang {

	private SanPham SanPham;
	private DonViTinh donViTinh;
	private int soLuongTonKho;
	
	public KhoHang(entity.SanPham sanPham, DonViTinh donViTinh, int soLuongTonKho) {
		SanPham = sanPham;
		this.donViTinh = donViTinh;
		this.soLuongTonKho = soLuongTonKho;
	}


	public SanPham getSanPham() {
		return SanPham;
	}


	public void setSanPham(SanPham sanPham) {
		SanPham = sanPham;
	}


	public DonViTinh getDonViTinh() {
		return donViTinh;
	}


	public void setDonViTinh(DonViTinh donViTinh) {
		this.donViTinh = donViTinh;
	}


	public int getSoLuongTonKho() {
		return soLuongTonKho;
	}


	public void setSoLuongTonKho(int soLuongTonKho) {
		this.soLuongTonKho = soLuongTonKho;
	}


	/**
	 * 
	 * @param maSP
	 */
	public boolean capNhatSoLuongTonKho(String maSP) {
		// TODO - implement KhoHang.capNhatSoLuongTonKho
		throw new UnsupportedOperationException();
	}


	@Override
	public String toString() {
		return "KhoHang [SanPham=" + SanPham + ", donViTinh=" + donViTinh + ", soLuongTonKho=" + soLuongTonKho + "]";
	}
	
	

}