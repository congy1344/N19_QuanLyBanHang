package entity;

public class NhanVien {

	private String maNV;
	private String tenNV;
	private String diaChi;
	private String sdt;
	
	public NhanVien(String maNV, String tenNV, String diaChi, String sdt) {
		this.maNV = maNV;
		this.tenNV = tenNV;
		this.diaChi = diaChi;
		this.sdt = sdt;
	}


	public String getMaNV() {
		return maNV;
	}


	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}


	public String getTenNV() {
		return tenNV;
	}


	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}


	public String getDiaChi() {
		return diaChi;
	}


	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}


	public String getSdt() {
		return sdt;
	}


	public void setSdt(String sdt) {
		this.sdt = sdt;
	}


	@Override
	public String toString() {
		return "NhanVien [maNV=" + maNV + ", tenNV=" + tenNV + ", diaChi=" + diaChi + ", sdt=" + sdt + "]";
	}
}