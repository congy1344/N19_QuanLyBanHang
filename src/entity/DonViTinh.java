package entity;

public enum DonViTinh {
	KG,
	GOI,
	THUNG,
	CHAI,
	LOC,
	KHAC;

	private String donViTinh;
	
	private DonViTinh() {
		this("");
	}
	
	private DonViTinh(String donViTinh) {
		this.donViTinh = donViTinh;
	}
	
	public String getDonViTinh() {
		return donViTinh;
	}
	
	@Override
	public String toString() {
		return donViTinh;
	}
}