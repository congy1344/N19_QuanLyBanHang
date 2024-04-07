package entity;

public class KhachHang {

	private String maKH;
	private String tenKH;
	private String sdt;
	
	public KhachHang(String maKH, String tenKH, String sdt) {
		this.maKH = maKH;
		this.tenKH = tenKH;
		this.sdt = sdt;
	}


	public String getMaKH() {
		return maKH;
	}


	public void setMaKH(String maKH) {
		this.maKH = maKH;
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