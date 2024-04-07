package entity;

public enum LoaiHang {
	THUC_PHAM,
	DO_DUNG,
	VAN_PHONG_PHAM,
	KHAC;

	private String loaiHang;
	
	private LoaiHang() {
		this("");
	}
	
	private LoaiHang(String loaiHang) {
		this.loaiHang = loaiHang;
	}
	
	public String getLoaiHang() {
		return loaiHang;
	}
	
	@Override
	public String toString() {
		return loaiHang;
	}

}